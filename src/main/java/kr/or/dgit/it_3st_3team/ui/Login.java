package kr.or.dgit.it_3st_3team.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class Login extends JPanel {
	private JTextField tfLgnUserId;
	private JTextField tfLgnUserPwd;

	/**
	 * Create the panel.
	 */
	public Login() {

		initComponents();
	}
	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setBorder(null);
		setToolTipText("login");
		setForeground(Color.BLACK);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.DARK_GRAY);
		p3.setBounds(334, 527, 351, 33);
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		btnFindIdPwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnFindIdPwd.setBackground(Color.DARK_GRAY);
		p3.add(btnFindIdPwd);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnJoin.setBackground(Color.DARK_GRAY);
		p3.add(btnJoin);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.DARK_GRAY);
		p2.setBounds(383, 484, 255, 33);
		FlowLayout flowLayout = (FlowLayout) p2.getLayout();
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.DARK_GRAY);
		p2.add(btnLogin);
		
		JCheckBox chkAdmin = new JCheckBox("관리자 로그인");
		chkAdmin.setBackground(Color.DARK_GRAY);
		chkAdmin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		p2.add(chkAdmin);
		
		JLabel lblLgnUSerPwd = new JLabel("비밀번호");
		lblLgnUSerPwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblLgnUSerPwd.setBounds(395, 436, 59, 28);
		lblLgnUSerPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfLgnUserPwd = new JTextField();
		tfLgnUserPwd.setBounds(466, 436, 172, 30);
		tfLgnUserPwd.setColumns(10);
		
		tfLgnUserId = new JTextField();
		tfLgnUserId.setBounds(466, 395, 172, 31);
		tfLgnUserId.setColumns(10);
		
		JLabel lblLgnUserId = new JLabel("아이디");
		lblLgnUserId.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblLgnUserId.setBounds(396, 396, 58, 28);
		lblLgnUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		setLayout(null);
		
		JLabel lblTitle = new JLabel("DGIT s/w sales program");
		lblTitle.setBounds(313, 189, 432, 46);
		lblTitle.setFont(new Font("나눔바른고딕", Font.BOLD, 39));
		lblTitle.setForeground(new Color(0, 0, 0));
		add(lblTitle);
		add(lblLgnUSerPwd);
		add(lblLgnUserId);
		add(tfLgnUserId);
		add(tfLgnUserPwd);
		add(p2);
		add(p3);
	}

}
