package com.newrocktech.autoprint.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.impl.LabelImpl;
import com.newrocktech.autoprint.impl.MacManageImpl;
import com.newrocktech.autoprint.utils.ExcelImportUtils;

public class ManagerFrame extends BaseFrame{
	private JTextField txtSearch;
	private JTable table;
	public List<Object> lists = new ArrayList<Object>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame("Manager");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ManagerFrame(String account){
		setTitle("标签打印中间件-工位：" + account);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u6570\u636E\u5E93\u7BA1\u7406\u5458", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblSort = new JLabel("\u6761\u4EF6\u67E5\u8BE2\uFF1A");
		lblSort.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSort.setForeground(Color.BLUE);
		lblSort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSort.setBounds(10, 30, 60, 30);
		panel.add(lblSort);
		
		JComboBox cbxSort = new JComboBox();
		cbxSort.setModel(new DefaultComboBoxModel(new String[] {"\u67E5\u8BE2\u6240\u6709\u91CD\u6253MAC\u4FE1\u606F", "\u67E5\u8BE2\u6240\u6709\u672A\u6253MAC\u4FE1\u606F"}));
		cbxSort.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		cbxSort.setBackground(Color.WHITE);
		cbxSort.setBounds(80, 30, 170, 30); 
		panel.add(cbxSort);
		
		JLabel lblSearch = new JLabel("搜索：");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setForeground(Color.BLUE);
		lblSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblSearch.setBackground(Color.WHITE);
		lblSearch.setBounds(290, 30, 40, 30);
		panel.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.setText("\u8BF7\u8F93\u5165MAC\u5730\u5740/\u5DE5\u4F4D\u53F7");
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setForeground(Color.GRAY);
		txtSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		txtSearch.setColumns(10);
		txtSearch.setBounds(340, 30, 250, 30);
		panel.add(txtSearch);
		
		JButton btnSearch = new JButton("搜索");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnSearch.setBackground(Color.RED);
		btnSearch.setBounds(610, 30, 100, 30);
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 700, 430);
		panel.add(scrollPane);
		
		
		final DefaultTableModel dtmTable = new DefaultTableModel();
		dtmTable.setDataVector(getTableRows(cbxSort.getSelectedIndex()), getTableColumn());
		table = new JTable();
		table.setModel(dtmTable);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setRowHeight(26);
		
		scrollPane.setViewportView(table);
		
		JLabel lblTip = new JLabel("*\u5F00\u59CB\u7BA1\u7406\u6570\u636E\u5E93\u5427\uFF01");
		lblTip.setForeground(Color.RED);
		lblTip.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblTip.setBackground(Color.WHITE);
		lblTip.setBounds(10, 0, 280, 30);
		panel.add(lblTip);
		
		JLabel lblTips = new JLabel("*\u70B9\u51FB\u6309\u94AE\u5BFC\u5165");
		lblTips.setForeground(Color.RED);
		lblTips.setBounds(750, 150, 200, 30);
		panel.add(lblTips);
		
		JButton btnImportMacFile = new JButton("\u5BFC\u5165MAC\u5730\u5740");
		btnImportMacFile.setBackground(Color.LIGHT_GRAY);
		btnImportMacFile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnImportMacFile.setBounds(750, 200, 200, 60);
		panel.add(btnImportMacFile);

		JLabel lblNewLabel = new JLabel("\u7248\u6743\u6240\u6709");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		
		btnImportMacFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc=new JFileChooser();  
				jfc.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				jfc.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return ".csv";
					}
					@Override
					public boolean accept(File f) {
						// TODO Auto-generated method stub
						if (f.isDirectory())return true;
					    return f.getName().endsWith(".csv");
					}
				});
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        int select  = jfc.showDialog(new JLabel(), "选择");  
		        if (0 == select) {
		        	 File file=jfc.getSelectedFile();  
				        if(file.isDirectory()){  
//				            System.out.println("文件夹:"+file.getAbsolutePath());  
				        	lblTips.setText("*导入失败，请选择.csv文件");
				        }else if(file.isFile()){  
//				            System.out.println("文件:"+file.getAbsolutePath());
				            JProgressBar pb = new JProgressBar();
				            pb.setVisible(true);
				            panel.add(pb);
				            ExcelImportUtils.readCSV(file.getAbsolutePath());
				            lblTips.setText("*导入成功！");
				        }  
//				        System.out.println(jfc.getSelectedFile().getName()); 
				}
			}
		});
		cbxSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MacManageImpl.queryMacInfo(cbxSort.getSelectedIndex());
				dtmTable.setDataVector(getTableRows(cbxSort.getSelectedIndex()), getTableColumn());
				table.setModel(dtmTable);
				
			}
		});
	}
	private Vector<String> getTableColumn() {
		Vector<String> v = new Vector<String>();
		v.add("MAC");
		v.add("相关信息");
		v.add("相关信息");
		v.add("时间");
		return v;
	}

	private Vector<Vector<Object>> getTableRows(int queryType) {
		return MacManageImpl.queryMacInfo(queryType);
	}
}





















