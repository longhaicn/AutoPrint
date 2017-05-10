package com.newrocktech.autoprint.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.entity.NewrockDeliverEntity;
import com.newrocktech.autoprint.impl.LabelImpl;
import com.newrocktech.autoprint.impl.MacCheckRecordImpl;
import com.newrocktech.autoprint.impl.NewrockDeliverImpl;
import com.newrocktech.autoprint.impl.PrintImpl;
import com.newrocktech.autoprint.logfile.LabelLogAutoUpdate;
import com.newrocktech.autoprint.logfile.LabelLogManualUpdate;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Main Frame
 * @author Lenhart
 */
public class MainFrame extends BaseFrame {
	public JButton btnPrint, btnStartScan;
	public JLabel lblTop, lblTips;
	public JComboBox cbxSelectModel;
	public JTable table;
	public ButtonGroup mGroup;
	public List<LabelEntity> lists = new ArrayList<LabelEntity>();
	public List<LabelEntity> listReprint = new ArrayList<LabelEntity>();
	public List<NewrockDeliverEntity> list = new ArrayList<NewrockDeliverEntity>();
	List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
	public int row;
	public int tabelSum = 0 ;
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	private JTextField txtHandle;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("A");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame(String workid) {
		getContentPane().setBackground(Color.WHITE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panelNewrockDeliver = new JPanel();
		panelNewrockDeliver.setToolTipText("\u8FC5\u65F6\u51FA\u8D27");
		tabbedPane.addTab("\u8FC5\u65F6\u51FA\u8D27", null, panelNewrockDeliver, null);
		panelNewrockDeliver.setLayout(null);

		lblTop = new JLabel("*\u5F00\u59CB\u6253\u5370\u6807\u7B7E\u5427\uFF01");
		lblTop.setForeground(Color.RED);
		lblTop.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblTop.setBackground(Color.WHITE);
		lblTop.setBounds(10, 0, 280, 30);
		panelNewrockDeliver.add(lblTop);

		JLabel lblSelect = new JLabel("\u9009\u62E9\u6A21\u677F\uFF1A");
		lblSelect.setForeground(Color.BLUE);
		lblSelect.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblSelect.setBounds(10, 30, 60, 30);
		panelNewrockDeliver.add(lblSelect);

		cbxSelectModel = new JComboBox();
		cbxSelectModel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		cbxSelectModel.setBackground(Color.WHITE);
		cbxSelectModel.setBounds(70, 30, 450, 30);
		panelNewrockDeliver.add(cbxSelectModel);

		btnPrint = new JButton("\u786E\u5B9A\u6253\u5370");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnPrint.setBackground(Color.RED);
		btnPrint.setBounds(580, 30, 130, 30);
		panelNewrockDeliver.add(btnPrint);
		
		JLabel lblTableSum = new JLabel("\u83B7\u5F97\u517124\u6761\u8BB0\u5F55");
		lblTableSum.setForeground(Color.RED);
		lblTableSum.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 25));
		lblTableSum.setBounds(750, 5, 160, 60);
		panelNewrockDeliver.add(lblTableSum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 700, 430);
		panelNewrockDeliver.add(scrollPane);
		
		final DefaultTableModel dtmTable = new DefaultTableModel();
		dtmTable.setDataVector(getTableRows(lists), getTableColumn());
		lblTableSum.setText("*»ñµÃ"+lists.size()+"Ìõ¼ÇÂ¼");
		table = new JTable();
		table.setModel(dtmTable);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setRowHeight(26);
		scrollPane.setViewportView(table);

		btnStartScan = new JButton("\u626B\u63CF\u8BBE\u5907");
		btnStartScan.setBackground(Color.ORANGE);
		btnStartScan.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btnStartScan.setBounds(750, 460, 200, 40);
		panelNewrockDeliver.add(btnStartScan);

		lblTips = new JLabel("*\u63D0\u793A");
		lblTips.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblTips.setBounds(720, 380, 200, 30);
		panelNewrockDeliver.add(lblTips);

		JCheckBox ckbHandle = new JCheckBox("");
		ckbHandle.setForeground(Color.RED);
		ckbHandle.setBackground(Color.WHITE);
		ckbHandle.setBounds(530, 30, 30, 30);
		ckbHandle.setVisible(false);
		panelNewrockDeliver.add(ckbHandle);

		txtHandle = new JTextField();
		txtHandle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		txtHandle.setEditable(false);
		txtHandle.setVisible(false);
		txtHandle.setBounds(70, 30, 450, 30);
		panelNewrockDeliver.add(txtHandle);
		txtHandle.setColumns(10);

		JPanel panelFore = new JPanel();
		panelFore.setBounds(720, 70, 260, 300);
		panelNewrockDeliver.add(panelFore);
		panelFore.setLayout(null);

		JLabel lblUpdateModel = new JLabel("*\u5347\u7EA7\u6A21\u5F0F");
		lblUpdateModel.setBounds(0, 0, 77, 17);
		panelFore.add(lblUpdateModel);
		lblUpdateModel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		JComboBox cbxUpdateModel = new JComboBox();
		cbxUpdateModel.setBounds(30, 40, 200, 30);
		panelFore.add(cbxUpdateModel);
		cbxUpdateModel.setBackground(Color.WHITE);
		cbxUpdateModel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		cbxUpdateModel.setModel(new DefaultComboBoxModel(
				new String[] { "\u81EA\u52A8\u5347\u7EA7\u6A21\u5F0F", "\u624B\u52A8\u5347\u7EA7\u6A21\u5F0F" }));
		
		JLabel lblPrintModel = new JLabel("*\u6253\u5370\u6A21\u5F0F");
		lblPrintModel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblPrintModel.setBounds(0, 112, 77, 17);
		panelFore.add(lblPrintModel);
		
		JComboBox cbxPrintModel = new JComboBox();
		cbxPrintModel.setModel(new DefaultComboBoxModel(new String[] {"AAA\u578B", "ABA\u578B", "ABB\u578B"}));
		cbxPrintModel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		cbxPrintModel.setBackground(Color.WHITE);
		cbxPrintModel.setBounds(30, 152, 200, 30);
		panelFore.add(cbxPrintModel);

		JPanel panelMacCheck = new JPanel();
		panelMacCheck.setVisible(false);
		panelMacCheck.setBackground(UIManager.getColor("Button.background"));
		panelMacCheck.setBounds(720, 70, 260, 300);
		panelNewrockDeliver.add(panelMacCheck);
		panelMacCheck.setLayout(null);

		JLabel lblMac = new JLabel("MAC\u5730\u5740\uFF1A");
		lblMac.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		lblMac.setBounds(30, 70, 65, 30);
		panelMacCheck.add(lblMac);

		JLabel lblMacAddress = new JLabel("00:0E:A9:41:F2:DD");
		lblMacAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMacAddress.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblMacAddress.setBounds(95, 70, 130, 30);
		panelMacCheck.add(lblMacAddress);

		JLabel label = new JLabel("\u662F\u5426\u91CD\u6253\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		label.setBounds(30, 110, 65, 30);
		panelMacCheck.add(label);

		JComboBox cbxCheck = new JComboBox();
		cbxCheck.setModel(new DefaultComboBoxModel(new String[] { "\u4E0D\u6253\u5370",
				"\u5DF2\u4F7F\u7528MAC\u91CD\u6253", "\u6807\u7B7E\u635F\u574F\u91CD\u6253",
				"\u751F\u4EA7\u8BA1\u5212\u53D8\u66F4\u91CD\u6253", "\u5176\u4ED6\u539F\u56E0\u91CD\u6253" }));
		cbxCheck.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		cbxCheck.setBounds(95, 110, 130, 30);
		panelMacCheck.add(cbxCheck);

		JButton btnMacComfirm = new JButton("\u786E\u5B9A");
		btnMacComfirm.setForeground(Color.WHITE);
		btnMacComfirm.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnMacComfirm.setBackground(Color.RED);
		btnMacComfirm.setBounds(30, 180, 200, 35);
		panelMacCheck.add(btnMacComfirm);

		JLabel lblMac_1 = new JLabel("MAC\u68C0\u6D4B\u5904\u7406");
		lblMac_1.setBackground(Color.LIGHT_GRAY);
		lblMac_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMac_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblMac_1.setBounds(30, 20, 200, 30);
		panelMacCheck.add(lblMac_1);

		JButton btnAllCheck = new JButton("\u4E00\u952E\u5904\u7406");
		btnAllCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(row);

				checkAllMacAddress(lists, cbxCheck.getSelectedItem().toString().trim());

				dtmTable.setDataVector(getTableRows(lists), getTableColumn());
				table.updateUI();
				lblTableSum.setText("*»ñµÃ"+lists.size()+"Ìõ¼ÇÂ¼");
				panelFore.setVisible(true);
				panelMacCheck.setVisible(false);

			}
		});
		btnAllCheck.setForeground(Color.BLACK);
		btnAllCheck.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnAllCheck.setBackground(Color.LIGHT_GRAY);
		btnAllCheck.setBounds(30, 225, 200, 35);
		panelMacCheck.add(btnAllCheck);

		JPanel panelReprint = new JPanel();
		panelReprint.setBounds(720, 70, 260, 300);
		panelReprint.setVisible(false);
		panelNewrockDeliver.add(panelReprint);
		panelReprint.setLayout(null);

		JLabel label_1 = new JLabel("MAC\u5730\u5740\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		label_1.setBounds(30, 70, 65, 30);
		panelReprint.add(label_1);

		JLabel lblMacReprint = new JLabel("00:0E:A9:41:F2:DD");
		lblMacReprint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMacReprint.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblMacReprint.setBounds(90, 70, 130, 30);
		panelReprint.add(lblMacReprint);

		JLabel lblReprint = new JLabel("\u53CA\u65F6\u91CD\u6253");
		lblReprint.setHorizontalAlignment(SwingConstants.CENTER);
		lblReprint.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblReprint.setBackground(Color.LIGHT_GRAY);
		lblReprint.setBounds(30, 25, 200, 30);
		panelReprint.add(lblReprint);

		JButton btnReprint = new JButton("\u786E\u5B9A\u91CD\u6253");
		btnReprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFore.setVisible(true);
				panelMacCheck.setVisible(false);
				panelReprint.setVisible(false);
				
				;
				
				listReprint = new ArrayList<LabelEntity>();
				String mac = lblMacReprint.getText().trim();
				for (LabelEntity entity : lists) {
					if (mac.equals(entity.MAC)) {
						listReprint.add(entity);
					}
				}

				if (null != listReprint && checkMacPass(listReprint)) {
					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							if (ckbHandle.isSelected()) {

								PrintImpl.sendToPrint(workid + "," + txtHandle.getText(), listReprint,cbxPrintModel.getSelectedIndex(),cbxUpdateModel.getSelectedIndex());

							} else {

								PrintImpl.sendToPrint(workid + "," + cbxSelectModel.getSelectedItem(), listReprint,cbxPrintModel.getSelectedIndex(),cbxUpdateModel.getSelectedIndex());

							}

						}
					}).start();
				} else {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "Çë´¦ÀíÎ´Í¨¹ýMACÊÂ¼þ", "¾¯¸æ£¡", JOptionPane.INFORMATION_MESSAGE);
				}
				// reprint
			}
		});
		btnReprint.setForeground(Color.WHITE);
		btnReprint.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnReprint.setBackground(Color.RED);
		btnReprint.setBounds(30, 178, 200, 35);
		panelReprint.add(btnReprint);
		
		JButton btnCancelReprint = new JButton("\u53D6\u6D88");
		btnCancelReprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFore.setVisible(true);
				panelMacCheck.setVisible(false);
				panelReprint.setVisible(false);
			}
		});
		btnCancelReprint.setForeground(Color.WHITE);
		btnCancelReprint.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnCancelReprint.setBackground(Color.DARK_GRAY);
		btnCancelReprint.setBounds(30, 138, 200, 35);
		panelReprint.add(btnCancelReprint);
		
		JButton btnAppCheck = new JButton("WEB\u68C0\u6D4B");
		btnAppCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable() {
					public void run() {
						try {
							listMap = LabelLogAutoUpdate.checkAllEquipmentLabel(workid.charAt(0));
							
							dtmTable.setDataVector(getTableRowsIP(listMap), getTableColumnIP());
							lblTableSum.setText("*»ñµÃ"+listMap.size()+"Ìõ¼ÇÂ¼");
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		btnAppCheck.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btnAppCheck.setBackground(Color.GREEN);
		btnAppCheck.setBounds(750, 410, 200, 40);
		panelNewrockDeliver.add(btnAppCheck);
		
		
		cbxUpdateModel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ckbHandle.setSelected(false);
				cbxSelectModel.setVisible(true);
				txtHandle.setVisible(false);
				cbxUpdateModel.getSelectedItem();
				System.out.println(cbxUpdateModel.getSelectedItem() + "" + cbxUpdateModel.getSelectedIndex());
			}
		});

		ckbHandle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ckbHandle.isSelected()) {
					txtHandle.setText(cbxSelectModel.getSelectedItem().toString());
					cbxSelectModel.setVisible(false);
					txtHandle.setVisible(true);
				} else {
					cbxSelectModel.setVisible(true);
					txtHandle.setVisible(false);
				}
			}
		});
		
		JLabel lblBlank = new JLabel("");
		getContentPane().add(lblBlank, BorderLayout.NORTH);

		JLabel lblRights = new JLabel("\u7248\u6743\u6240\u6709");
		lblRights.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblRights.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRights, BorderLayout.SOUTH);
		setTitle("±êÇ©´òÓ¡ÖÐ¼ä¼þ-¹¤Î»£º" + workid);
		btnStartScan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				new Thread(new Runnable() {
					public void run() {
						ckbHandle.setVisible(true);
						if (0 == cbxUpdateModel.getSelectedIndex()) {
							lists = LabelLogAutoUpdate.getAllEquipmentLabel(workid.charAt(0));
						} else if (1 == cbxUpdateModel.getSelectedIndex()) {
							lists = LabelLogManualUpdate.getOneEquipmentLabel();
						}
						dtmTable.setDataVector(getTableRows(lists), getTableColumn());
						table.updateUI();
						lblTableSum.setText("*»ñµÃ"+lists.size()+"Ìõ¼ÇÂ¼");
						if (0 != lists.size()) {
							List<NewrockDeliverEntity> list = NewrockDeliverImpl.queryAllGoods(lists.get(0).bin);
							String select = "";
							for (NewrockDeliverEntity entity : list) {
								select += entity.toSelect() + "=";
							}
							cbxSelectModel.setModel(new DefaultComboBoxModel(select.split("=")));
						}
					}
				}).start();
			}
		});
		btnMacComfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkMacAddress(lists, lblMacAddress.getText().toString().trim(),
						cbxCheck.getSelectedItem().toString().trim());
				dtmTable.setDataVector(getTableRows(lists), getTableColumn());
				table.updateUI();
				lblTableSum.setText("*»ñµÃ"+lists.size()+"Ìõ¼ÇÂ¼");
				panelFore.setVisible(true);
				panelMacCheck.setVisible(false);
				panelReprint.setVisible(false);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				row = table.getSelectedRow();
				int colum = table.getColumnCount();
				System.out.println(colum);
				if(colum < 3)
					return;
				String check = table.getModel().getValueAt(row, 4).toString();
				if ("Î´Í¨¹ý".equals(check)) {
					String mac = table.getModel().getValueAt(row, 1).toString();
					lblMacAddress.setText(mac);
					panelFore.setVisible(false);
					panelReprint.setVisible(false);
					panelMacCheck.setVisible(true);
				} else {
					String mac = table.getModel().getValueAt(row, 1).toString();
					lblMacReprint.setText(mac);
					panelFore.setVisible(false);
					panelMacCheck.setVisible(false);
					panelReprint.setVisible(true);
				}

			}
		});
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (null != lists && checkMacPass(lists)) {
					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							if (ckbHandle.isSelected()) {
								lists = PrintImpl.sendToPrint(workid + "," + txtHandle.getText(), lists,cbxPrintModel.getSelectedIndex(),cbxUpdateModel.getSelectedIndex());
							} else {
								lists = PrintImpl.sendToPrint(workid + "," + cbxSelectModel.getSelectedItem(), lists,cbxPrintModel.getSelectedIndex(),cbxUpdateModel.getSelectedIndex());

							}

						}
					}).start();
				} else {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "Çë´¦ÀíÎ´Í¨¹ýMACÊÂ¼þ", "¾¯¸æ£¡", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	public void checkAllMacAddress(List<LabelEntity> lists, String reason) {
		int j = lists.size();
		if ("²»´òÓ¡".equals(reason)) {
			for (int i = 0; i < j; i++) {
				if ("Î´Í¨¹ý".equals(lists.get(i).macChecked)) {
					MacCheckRecordImpl.insertRecord(lists.get(i).MAC, "²»´òÓ¡", reason);
					lists.remove(i);
					j--;
					i--;
				}
			}

		} else {
			for (int i = 0; i < j; i++) {
				if ("Î´Í¨¹ý".equals(lists.get(i).macChecked)) {
					lists.get(i).macChecked = "Í¨¹ý";
					MacCheckRecordImpl.insertRecord(lists.get(i).MAC, "´òÓ¡", reason);
				}
			}

		}
		return;
	}


	public void checkMacAddress(List<LabelEntity> lists, String mac, String reason) {
		int j = lists.size();
		if ("²»´òÓ¡".equals(reason)) {
			for (int i = 0; i < j; i++) {
				if (mac.equals(lists.get(i).MAC)) {
					lists.remove(i);
					System.out.println();
					break;
				}
			}
			MacCheckRecordImpl.insertRecord(mac, "²»´òÓ¡", reason);
		} else {
			for (int i = 0; i < j; i++) {
				if (mac.equals(lists.get(i).MAC)) {
					lists.get(i).macChecked = "Í¨¹ý";
				}
			}
			MacCheckRecordImpl.insertRecord(mac, "´òÓ¡", reason);
		}
		return;
	}

	public boolean checkMacPass(List<LabelEntity> lists) {
		int j = lists.size();
		for (int i = 0; i < j; i++) {
			if ("Í¨¹ý".equals(lists.get(i).macChecked)) {

			} else {
				return false;
			}
		}
		return true;

	}
	private Vector<String> getTableColumn() {
		Vector<String> v = new Vector<String>();
		v.add("ÐÍºÅ");
		v.add("MAC");
		v.add("bin");
		v.add("±àºÅ");
		v.add("MAC¼ì²â");
		return v;
	}
	
	private Vector<String> getTableColumnIP() {
		Vector<String> v = new Vector<String>();
		v.add("IP");
		v.add("WEB¼ì²â");
		return v;
	}
	private Vector<Vector<Object>> getTableRowsIP(List<Map<String,String>>  list) {
		Vector<Vector<Object>> temp = new Vector<Vector<Object>>();
		if (list != null && list.size() > 0) {
			for (Map<String, String> map2 : list) {
				Vector<Object> v = new Vector<>();
				v.add(map2.get("ip") );
				v.add(map2.get("app"));
				temp.add(v);
			}
		}
		return temp;
	}

	private Vector<Vector<Object>> getTableRows(List<LabelEntity> lists) {
		return LabelImpl.toVector(lists);
	}
}
