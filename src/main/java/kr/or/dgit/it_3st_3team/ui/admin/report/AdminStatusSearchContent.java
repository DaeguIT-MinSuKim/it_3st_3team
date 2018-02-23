package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.table.SupplyingCompanyLists;
import java.awt.Color;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminStatusSearchContent extends JPanel {

	public AdminStatusSearchContent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		AdminStatusSearch panel = new AdminStatusSearch();
		panel.setBounds(0, 10, 1175, 106);
		add(panel);
		panel.setLayout(null);

		SupplyingCompanyLists panel_2 = new SupplyingCompanyLists();
		panel_2.setBounds(10, 120, 1165, 612);
		add(panel_2);

		PagingComp panel_1 = new PagingComp();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 734, 1163, 64);
		add(panel_1);
	}
}
