package kr.or.dgit.it_3st_3team.ui.admin.customer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import kr.or.dgit.it_3st_3team.ui.component.ImageContent;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminCustomerRegister extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public AdminCustomerRegister() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		ImageContent pImgArea = new ImageContent();
		pImgArea.setBounds(12, 10, 188, 230);
		add(pImgArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(212, 10, 552, 230);
		panel_2.setLayout(null);
		add(panel_2);

		JLabel label = new JLabel("아이디");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(44, 12, 48, 15);
		panel_2.add(label);

		textField = new JTextField(20);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(104, 7, 146, 25);
		panel_2.add(textField);

		JLabel label_1 = new JLabel("비밀번호");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 42, 80, 15);
		panel_2.add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 37, 146, 25);
		panel_2.add(passwordField);

		JLabel label_2 = new JLabel("비밀번호 확인");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(280, 42, 90, 15);
		panel_2.add(label_2);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(382, 37, 146, 25);
		panel_2.add(passwordField_1);

		JLabel label_3 = new JLabel("상호명");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(44, 72, 48, 15);
		panel_2.add(label_3);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(104, 67, 146, 25);
		panel_2.add(textField_1);

		JLabel label_4 = new JLabel("전화번호");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(322, 72, 48, 15);
		panel_2.add(label_4);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(382, 67, 146, 25);
		panel_2.add(textField_2);

		JLabel label_5 = new JLabel("우편번호");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(44, 100, 48, 15);
		panel_2.add(label_5);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(104, 97, 146, 25);
		panel_2.add(textField_3);

		JLabel label_6 = new JLabel("주소");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(44, 130, 48, 15);
		panel_2.add(label_6);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(104, 127, 340, 25);
		panel_2.add(textField_4);

		JButton button = new JButton("중복확인");
		button.setBounds(262, 7, 80, 25);
		panel_2.add(button);

		JButton button_1 = new JButton("검색");
		button_1.setBounds(262, 97, 80, 25);
		panel_2.add(button_1);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(104, 157, 340, 25);
		panel_2.add(textField_5);

		JButton button_2 = new JButton("등록");
		button_2.setBounds(322, 197, 97, 30);
		panel_2.add(button_2);

		JButton button_3 = new JButton("취소");
		button_3.setBounds(431, 197, 97, 30);
		panel_2.add(button_3);
	}

}
