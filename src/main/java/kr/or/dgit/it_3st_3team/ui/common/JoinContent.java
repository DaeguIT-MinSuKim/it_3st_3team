package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.user.UserInfoContent;

@SuppressWarnings("serial")
public class JoinContent extends JFrame {
	private JPanel contentPane;
	private JRadioButton rdbtnCompany;
	private JRadioButton rdbtnUser;
	private UserInfoContent panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public JoinContent() {
		initComponents();
	}

	private void initComponents() {
		setTitle("회 원 가 입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pInput = new JPanel();
		pInput.setBackground(Color.WHITE);
		contentPane.add(pInput, BorderLayout.CENTER);
		pInput.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(214, 24, 300, 50);
		pInput.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUserGroup = new JLabel("회원 구분");
		lblUserGroup.setBounds(9, 10, 70, 30);
		panel_1.add(lblUserGroup);
		lblUserGroup.setHorizontalAlignment(SwingConstants.RIGHT);

		ButtonGroup group = new ButtonGroup();
		
		rdbtnCompany = new JRadioButton("공급회사");
		rdbtnCompany.setBackground(Color.WHITE);
		rdbtnCompany.setBounds(202, 14, 80, 23);
		panel_1.add(rdbtnCompany);
		rdbtnCompany.setHorizontalAlignment(SwingConstants.LEFT);
		group.add(rdbtnCompany);

		rdbtnUser = new JRadioButton("일반회원");
		rdbtnUser.setBackground(Color.WHITE);
		rdbtnUser.setBounds(101, 14, 80, 23);
		panel_1.add(rdbtnUser);
		rdbtnUser.setHorizontalAlignment(SwingConstants.LEFT);
		group.add(rdbtnUser);

		panel = new UserInfoContent();
		panel.setBounds(12, 66, 610, 419);
		pInput.add(panel);
		
		btnNewButton = new JButton("가입");
		btnNewButton.setBounds(210, 497, 97, 30);
		pInput.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(353, 497, 97, 30);
		pInput.add(btnNewButton_1);
	}
}
