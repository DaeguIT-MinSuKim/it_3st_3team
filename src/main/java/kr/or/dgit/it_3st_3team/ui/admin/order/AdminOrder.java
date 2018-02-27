package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.table.AdminOrderTable;

import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminOrder extends JPanel {

	public AdminOrder() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		AdminOrderRegister pCorrection = new AdminOrderRegister();
		pCorrection.setBackground(new Color(240, 240, 240));
		pCorrection.setBounds(0, 0, 962, 176);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		AdminOrderSearch pOrderSearch = new AdminOrderSearch();
		pOrderSearch.setBackground(new Color(240, 240, 240));
		pOrderSearch.setBounds(0, 176, 1060, 50);
		add(pOrderSearch);
		
		AdminOrderTable pOrderTable = new AdminOrderTable();
		pOrderTable.setBackground(new Color(240, 240, 24));
		pOrderTable.setBounds(0, 226, 1200, 600);
		add(pOrderTable);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(1072, 193, 97, 23);
		add(btnSearch);
		
		JButton btnRewrite = new JButton("수정");
		btnRewrite.setBounds(981, 143, 97, 23);
		add(btnRewrite);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(1090, 143, 97, 23);
		add(btnCancel);
	}

}
