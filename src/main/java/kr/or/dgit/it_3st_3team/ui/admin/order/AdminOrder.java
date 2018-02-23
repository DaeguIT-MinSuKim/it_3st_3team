package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminOrder extends JPanel {

	public AdminOrder() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		AdminOrderRegister pCorrection = new AdminOrderRegister();
		pCorrection.setBackground(new Color(255, 255, 255));
		pCorrection.setBounds(0, 0, 1200, 200);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		AdminOrderSearch pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(255, 255, 255));
		pOrderSearch.setBounds(0, 200, 1200, 54);
		add(pOrderSearch);
		
		AdminOrderTable pOrderTable = new AdminOrderTable();
		pOrderTable.setBackground(new Color(255, 255, 255));
		pOrderTable.setBounds(0, 250, 1200, 600);
		add(pOrderTable);
	}

}
