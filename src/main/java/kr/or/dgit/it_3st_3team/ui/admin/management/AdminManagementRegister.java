package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.ui.component.ImageComponent;

@SuppressWarnings("serial")
public class AdminManagementRegister extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;

	public AdminManagementRegister() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		ImageComponent panel = new ImageComponent();
		panel.setBounds(12, 10, 188, 230);
		add(panel);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(212, 10, 552, 230);
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
		label_1.setBounds(12, 46, 80, 15);
		panel_2.add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 41, 146, 25);
		panel_2.add(passwordField);

		JLabel label_2 = new JLabel("비밀번호 확인");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(292, 46, 90, 15);
		panel_2.add(label_2);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(394, 41, 146, 25);
		panel_2.add(passwordField_1);

		JLabel label_3 = new JLabel("이름");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(44, 80, 48, 15);
		panel_2.add(label_3);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(104, 75, 146, 25);
		panel_2.add(textField_1);

		JLabel label_4 = new JLabel("전화번호");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(334, 80, 48, 15);
		panel_2.add(label_4);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(394, 75, 146, 25);
		panel_2.add(textField_2);

		JButton button = new JButton("중복확인");
		button.setBounds(262, 7, 80, 25);
		panel_2.add(button);

		JButton button_1 = new JButton("등록");
		button_1.setBounds(334, 192, 97, 30);
		panel_2.add(button_1);

		JButton button_2 = new JButton("취소");
		button_2.setBounds(443, 192, 97, 30);
		panel_2.add(button_2);

		JLabel label_5 = new JLabel("직책");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(44, 119, 48, 15);
		panel_2.add(label_5);

		JButton button_3 = new JButton("직책등록");
		button_3.setBounds(262, 114, 80, 25);
		panel_2.add(button_3);

		String[] items = { "총관리자", "영업1", "영업2" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(items);
		JComboBox<String> comboBox = new JComboBox<>(dcbm);
		comboBox.setBounds(104, 116, 120, 25);
		panel_2.add(comboBox);
	}

}
