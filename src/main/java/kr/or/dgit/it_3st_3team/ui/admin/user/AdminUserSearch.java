package kr.or.dgit.it_3st_3team.ui.admin.user;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminUserSearch extends JPanel {
	private JTextField textField;

	public AdminUserSearch() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1178, 50);
		
		String[] arrSearch = {"아이디", "상호명", "전화번호"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(arrSearch);
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(dcbm);

		comboBox.setBounds(208, 10, 118, 30);

		comboBox.setBounds(12, 10, 150, 30);

		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);

		textField.setBounds(338, 11, 510, 30);

		textField.setBounds(174, 11, 880, 30);

		add(textField);
		
		JButton button = new JButton("검색");

		button.setBounds(863, 10, 97, 30);

		button.setBounds(1069, 10, 97, 30);

		add(button);
	}

}
