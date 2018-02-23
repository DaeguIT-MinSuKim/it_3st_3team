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
		pInputArea.setBounds(0, 0, 1186, 263);
		add(pInputArea);
		pInputArea.setLayout(null);

		AdminManagementSearch pSearchArea = new AdminManagementSearch();
		pSearchArea.setBackground(Color.WHITE);
		pSearchArea.setBounds(0, 260, 1186, 50);
		add(pSearchArea);
		pSearchArea.setLayout(null);

		JPanel pDataArea = new JPanel();
		pDataArea.setBackground(Color.WHITE);
		pDataArea.setBounds(0, 309, 1186, 512);
		add(pDataArea);

		PagingComp pPaging = new PagingComp();
		pPaging.setBackground(Color.WHITE);
		pPaging.setBounds(0, 822, 1186, 44);
		add(pPaging);
	}

}
