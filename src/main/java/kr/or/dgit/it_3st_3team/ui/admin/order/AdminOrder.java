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
		pCorrection.setBounds(0, 0, 1200, 176);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		AdminOrderSearch pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBounds(0, 174, 1200, 94);
		add(pOrderSearch);
		
		AdminOrderTable pOrderTable = new AdminOrderTable();
		pOrderTable.setBounds(0, 268, 1200, 582);
		add(pOrderTable);
	}

}
