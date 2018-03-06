package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.common.LoginContent;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	private JPanel contentPane;

	public LoginUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("로그인 - 소프트웨어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		LoginContent pLogin = new LoginContent();
		contentPane.add(pLogin, BorderLayout.CENTER);
	}

}
