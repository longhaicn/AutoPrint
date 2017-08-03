package com.newrocktech.autoprint.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.newrocktech.autoprint.impl.WorkerListImpl;

/**
 * Login Frame
 * 
 * @author Lenhart
 */
public class LoginFrame extends BaseFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accountField;
	private JPasswordField passwordField;
	private JLabel lblPrompt;
	private boolean clearLblPrompt = false;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u6807\u7B7E\u81EA\u52A8\u6253\u5370\u7CFB\u7EDF-\u767B\u5F55");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		contentPane.add(panelMain, BorderLayout.WEST);
		panelMain.setLayout(new BorderLayout(0, 0));

		JLabel lblLeft = new JLabel("");
		lblLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft.setIcon(new ImageIcon("picture\\autoprint.png"));
		panelMain.add(lblLeft);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		contentPane.add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(null);

		JLabel lblTitile = new JLabel(
				"\u6B22\u8FCE\u767B\u5F55-\u6807\u7B7E\u81EA\u52A8\u6253\u5370\u7CFB\u7EDF\uFF01");
		lblTitile.setForeground(new Color(0, 0, 128));
		lblTitile.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblTitile.setBounds(97, 85, 271, 30);
		panelLogin.add(lblTitile);

		JLabel lblAccount = new JLabel("µÇÂ¼ÕË»§£º");
		lblAccount.setForeground(new Color(0, 0, 128));
		lblAccount.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblAccount.setBounds(100, 200, 70, 30);
		panelLogin.add(lblAccount);

		accountField = new JTextField();
		accountField.setBounds(0, 0, 0, 0);
		accountField.setEditable(false);
		accountField.setText("WORKER");
		accountField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				super.keyTyped(arg0);
				if (clearLblPrompt) {
					lblPrompt.setText("");
					clearLblPrompt = false;
				}
			}
		});
		panelLogin.add(accountField);

		lblPrompt = new JLabel("");
		lblPrompt.setBackground(Color.WHITE);
		lblPrompt.setForeground(Color.RED);
		lblPrompt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblPrompt.setBounds(169, 80, 200, 30);
		panelLogin.add(lblPrompt);

		JLabel lblPassword = new JLabel("ÕË»§ÃÜÂë£º");
		lblPassword.setForeground(new Color(0, 0, 128));
		lblPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblPassword.setBounds(100, 240, 70, 30);
		panelLogin.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setText("password");
		passwordField.setBounds(175, 240, 200, 30);
		passwordField.addKeyListener(new KeyAdapter() {
		});
		panelLogin.add(passwordField);

		JComboBox cbx = new JComboBox();
		cbx.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "Manager" }));
		cbx.setBounds(175, 200, 200, 30);
		panelLogin.add(cbx);

		JButton btnLogin = new JButton("µÇÂ¼");
		btnLogin.setFont(new Font("»ªÎÄÏ¸ºÚ", Font.PLAIN, 20));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 0, 139));
		btnLogin.setBounds(175, 300, 200, 37);
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// String account =
							// ConfigUtils.get("NEWROCK_ACCOUNT");
							String account = cbx.getSelectedItem().toString();
							if ("W".equals(WorkerListImpl.loginWorker(account))) {
								MainFrame frame = new MainFrame(account);
								frame.setVisible(true);
							} else if ("M".equals(WorkerListImpl.loginWorker(account))) {
								ManagerFrame frame = new ManagerFrame(account);
								frame.setVisible(true);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		panelLogin.add(btnLogin);

		JLabel lblButtom = new JLabel(
				"\u00A9\u7248\u6743\u6240\u6709  \u4E0A\u6D77\u8FC5\u65F6\u901A\u4FE1\u8BBE\u5907\u6709\u9650\u516C\u53F8 2017");
		lblButtom.setForeground(new Color(0, 0, 128));
		lblButtom.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblButtom, BorderLayout.SOUTH);
		lblButtom.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblButtom.setBackground(Color.WHITE);
		JLabel lblTop = new JLabel("\u6807\u7B7E\u81EA\u52A8\u6253\u5370\u7CFB\u7EDF");
		lblTop.setForeground(new Color(0, 0, 128));
		lblTop.setFont(new Font("»ªÎÄÁ¥Êé", Font.BOLD, 80));
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTop, BorderLayout.NORTH);
		lblTop.setBackground(Color.WHITE);
	}
}
