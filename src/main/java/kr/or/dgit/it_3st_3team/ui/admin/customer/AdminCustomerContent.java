package kr.or.dgit.it_3st_3team.ui.admin.customer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AdminCustomerContent extends JPanel {

	public AdminCustomerContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		AdminCustomerRegister pInputArea = new AdminCustomerRegister();
		pInputArea.setBounds(12, 10, 776, 250);
		add(pInputArea);

		AdminCustomerSearch pSearchArea = new AdminCustomerSearch();
		pSearchArea.setBounds(12, 270, 776, 50);
		add(pSearchArea);

		AdminCustmerList pTableArea = new AdminCustmerList();
		pTableArea.setBounds(12, 330, 776, 360);
		add(pTableArea);

		JPanel panel = new JPanel();
		panel.setBounds(12, 700, 776, 50);
		add(panel);
	}
}
