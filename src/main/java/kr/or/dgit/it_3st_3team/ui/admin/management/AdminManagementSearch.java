package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminManagementSearch extends JPanel implements ActionListener {
	private JTextField textField;
	private JButton button;

	public AdminManagementSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1160, 50);

		String[] items = { "아이디", "이름", "직책" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(items);
		JComboBox<String> comboBox = new JComboBox<>(dcbm);
		comboBox.setBounds(231, 9, 125, 30);
		add(comboBox);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(392, 10, 500, 30);
		add(textField);

		button = new JButton("검색");
		button.addActionListener(this);
		button.setBounds(932, 9, 97, 30);
		add(button);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
	}

	protected void actionPerformedButton(ActionEvent e) {
	}
}
