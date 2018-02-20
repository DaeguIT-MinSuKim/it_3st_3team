package kr.or.dgit.it_3st_3team.ui.admin.customer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminCustomerSearch extends JPanel {
	private JTextField textField;

	public AdminCustomerSearch() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		String[] arrSearch = {"아이디", "상호명", "전화번호"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(arrSearch);
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(dcbm);
		comboBox.setBounds(12, 10, 118, 30);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(142, 11, 510, 30);
		add(textField);
		
		JButton button = new JButton("검색");
		button.setBounds(667, 10, 97, 30);
		add(button);
	}

}
