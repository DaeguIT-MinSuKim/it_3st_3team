package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminManagementSearch extends JPanel {
	private JTextField textField;

	public AdminManagementSearch() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);

		String[] items = {"이름", "직책"};
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(items);
		JComboBox<String> comboBox = new JComboBox<>(dcbm);
		comboBox.setBounds(12, 10, 125, 30);
		add(comboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(149, 11, 500, 30);
		add(textField);
		
		JButton button = new JButton("검색");
		button.setBounds(667, 10, 97, 30);
		add(button);
	}

}
