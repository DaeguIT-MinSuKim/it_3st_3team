package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;

public class AdminOrder extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminOrder() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		AdminOrderRegister pCorrection = new AdminOrderRegister();
		pCorrection.setBackground(Color.WHITE);
		pCorrection.setBounds(12, 10, 877, 166);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		AdminOrderSearch pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBounds(12, 179, 877, 41);
		add(pOrderSearch);
		
		AdminOrderTable pOrderTable = new AdminOrderTable();
		pOrderTable.setBounds(12, 225, 877, 265);
		add(pOrderTable);
	}

}