package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.Color;

@SuppressWarnings("serial")
public class AdminManagementContent extends JPanel {

	public AdminManagementContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		AdminManagementRegister pInputArea = new AdminManagementRegister();
		pInputArea.setBackground(Color.WHITE);
		pInputArea.setBounds(12, 10, 776, 253);
		add(pInputArea);
		pInputArea.setLayout(null);

		AdminManagementSearch pSearchArea = new AdminManagementSearch();
		pSearchArea.setBackground(Color.WHITE);
		pSearchArea.setBounds(12, 273, 776, 50);
		add(pSearchArea);
		pSearchArea.setLayout(null);

		JPanel pDataArea = new JPanel();
		pDataArea.setBackground(Color.WHITE);
		pDataArea.setBounds(12, 333, 776, 320);
		add(pDataArea);

		PagingComp pPaging = new PagingComp();
		pPaging.setBackground(Color.WHITE);
		pPaging.setBounds(12, 663, 776, 40);
		add(pPaging);
	}

}
