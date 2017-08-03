package com.newrocktech.autoprint.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.newrocktech.autoprint.entity.MacAddressEntity;
import com.newrocktech.autoprint.impl.MacManageImpl;
import com.newrocktech.autoprint.utils.ExcelUtil;

/**
 * Manager Frame
 * 
 * @author Lenhart
 */
public class ManageFrame extends BaseFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JTable table;
	// public List<Object> lists = new ArrayList<Object>();
	Vector<Vector<Object>> temp = new Vector<Vector<Object>>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageFrame frame = new ManageFrame("Manager");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManageFrame(String account) {
		setTitle("标签自动打印系统-工位：" + account);

		JPanel panel = new JPanel();
		getContentPane().add(panel, null);
		panel.setLayout(null);

		JLabel lblSort = new JLabel("\u6761\u4EF6\u67E5\u8BE2\uFF1A");
		lblSort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSort.setForeground(Color.BLUE);
		lblSort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSort.setBounds(10, 20, 60, 30);
		panel.add(lblSort);

		JComboBox cbxSort = new JComboBox();
		cbxSort.setModel(new DefaultComboBoxModel(new String[] { "\u67E5\u8BE2\u6240\u6709\u91CD\u6253MAC\u4FE1\u606F",
				"\u67E5\u8BE2\u6240\u6709\u672A\u6253MAC\u4FE1\u606F",
				"\u67E5\u8BE2\u6240\u6709\u5DF2\u6253MAC\u4FE1\u606F" }));
		cbxSort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		cbxSort.setBackground(Color.WHITE);
		cbxSort.setBounds(80, 20, 170, 30);
		panel.add(cbxSort);

		JLabel lblSearch = new JLabel("搜索：");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setForeground(Color.BLUE);
		lblSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setBounds(290, 20, 40, 30);
		panel.add(lblSearch);

		txtSearch = new JTextField();
		txtSearch.setText("\u8BF7\u8F93\u5165MAC\u5730\u5740/\u65F6\u95F4(19991231)");
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setForeground(Color.GRAY);
		txtSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtSearch.setColumns(10);
		txtSearch.setBounds(340, 20, 250, 30);
		panel.add(txtSearch);
		txtSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if ("".equals(txtSearch.getText())) {
					txtSearch.setText("\u8BF7\u8F93\u5165MAC\u5730\u5740/\u65F6\u95F4(19991231)");
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if ("请输入MAC地址/时间(19991231)".equals(txtSearch.getText())) {
					txtSearch.setText("");
				}
			}
		});

		JButton btnSearch = new JButton("搜索");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnSearch.setBackground(Color.RED);
		btnSearch.setBounds(610, 20, 100, 30);
		panel.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 1180, 545);
		panel.add(scrollPane);

		final DefaultTableModel dtmTable = new DefaultTableModel();
		dtmTable.setDataVector(getTableRows(cbxSort.getSelectedIndex()), getTableColumn());
		table = new JTable();
		table.setModel(dtmTable);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setRowHeight(26);

		scrollPane.setViewportView(table);

		JButton btnImportMacFile = new JButton("\u5BFC\u5165MAC\u5730\u5740");
		btnImportMacFile.setBackground(Color.ORANGE);
		btnImportMacFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnImportMacFile.setBounds(860, 20, 150, 30);
		panel.add(btnImportMacFile);

		JButton btnOutput = new JButton("\u5BFC\u51FA\u8868\u683C\u5185\u5BB9");
		btnOutput.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnOutput.setBackground(Color.ORANGE);
		btnOutput.setBounds(1030, 20, 150, 30);
		panel.add(btnOutput);

		JLabel lblNewLabel = new JLabel("\u00A9\u7248\u6743\u6240\u6709");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel, BorderLayout.SOUTH);

		JProgressBar proBarImport = new JProgressBar();
		proBarImport.setBackground(Color.yellow);
		proBarImport.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		proBarImport.setBounds(860, 20, 150, 30);
		proBarImport.setIndeterminate(true);
		proBarImport.setStringPainted(true);
		proBarImport.setString("导入MAC地址");

		JProgressBar proBarExport = new JProgressBar();
		proBarExport.setBackground(Color.WHITE);
		proBarExport.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		proBarExport.setBounds(1030, 20, 150, 30);
		proBarExport.setIndeterminate(true);
		proBarExport.setStringPainted(true);
		proBarExport.setString("导出MAC地址");
		proBarExport.setMaximum(100);
		proBarExport.setMinimum(0);
		Runnable run = new Runnable() {
			@Override
			public void run() {
				JFileChooser jfc = new JFileChooser();
				jfc.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				jfc.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return ".csv";
					}

					@Override
					public boolean accept(File f) {
						if (f.isDirectory())
							return true;
						return f.getName().endsWith(".csv");
					}
				});
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int select = jfc.showDialog(new JLabel(), "选择");
				if (0 == select) {
					File file = jfc.getSelectedFile();
					if (file.isDirectory()) {
						// System.out.println("文件夹:"+file.getAbsolutePath());
					} else if (file.isFile()) {
						// System.out.println("文件:"+file.getAbsolutePath());
						proBarImport.setVisible(true);
						btnImportMacFile.setVisible(false);
						panel.add(proBarImport);
						File inFile = new File(file.getAbsolutePath()); // 读取的CSV文件
						String inString = "";
						try {
							String en[];
							BufferedReader reader = new BufferedReader(new FileReader(inFile));
							while ((inString = reader.readLine()) != null) {
								en = inString.split(",");
								MacManageImpl.insertMacAddress(new MacAddressEntity(en[0], en[1], en[2]));
							}
							reader.close();
						} catch (FileNotFoundException ex) {
							System.out.println("没找到文件！");
						} catch (IOException ex) {
							System.out.println("读写文件出错！");
						}
						proBarImport.setVisible(false);
						btnImportMacFile.setVisible(true);
					}
				}
			}
		};

		Runnable runExport = new Runnable() {

			@Override
			public void run() {
				proBarExport.setVisible(true);
				btnOutput.setVisible(false);
				panel.add(proBarExport);
				int size = temp.size();
				String title[] = { "序号", "MAC", "相关信息", "相关信息", "时间" };
				String[][] values = new String[size][];
				for (int i = 0; i < size; i++) {
					values[i] = new String[title.length];
					values[i][0] = temp.get(i).get(0).toString();
					values[i][1] = temp.get(i).get(1).toString();
					values[i][2] = temp.get(i).get(2).toString();
					values[i][3] = temp.get(i).get(3).toString();
					values[i][4] = temp.get(i).get(4).toString();
				}
				String sheetName = "MACinfo";
				String fileName = "MAC" + System.currentTimeMillis() + ".xls"; // 文件名
				HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
				// 将文件存到指定位置
				try {
					fileName = new String(fileName.getBytes(), "ISO8859-1");
					OutputStream os = new FileOutputStream("D:\\NewRockPrint\\" + fileName);
					wb.write(os);
					os.flush();
					os.close();
					proBarExport.setString("导出完成！");
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				proBarExport.setVisible(false);
				btnOutput.setVisible(true);
			}
		};
		btnImportMacFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(run).start();
			}
		});

		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(runExport).start();
			}
		});

		cbxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dtmTable.setDataVector(getTableRows(cbxSort.getSelectedIndex()), getTableColumn());
				table.setModel(dtmTable);

			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ("请输入MAC地址/时间(19991231)".equals(txtSearch.getText())) {
					return;
				} else {

					dtmTable.setDataVector(getTableRowsByCondition(txtSearch.getText()), getTableColumn());
					table.setModel(dtmTable);
				}

			}
		});
	}

	private Vector<String> getTableColumn() {
		Vector<String> v = new Vector<String>();
		v.add("序号");
		v.add("MAC");
		v.add("相关信息");
		v.add("相关信息");
		v.add("时间");
		return v;
	}

	private Vector<Vector<Object>> getTableRows(int queryType) {
		temp = MacManageImpl.queryMacInfo(queryType);
		return temp;
	}

	private Vector<Vector<Object>> getTableRowsByCondition(String condition) {
		temp = MacManageImpl.queryMacInfoByCondition(condition);
		return temp;
	}
}
