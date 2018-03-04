package kr.or.dgit.it_3st_3team.ui.admin.user;

import javax.swing.JPanel;
import java.awt.Color;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

@SuppressWarnings("serial")
public class AdminCustomerContent extends JPanel {

	public AdminCustomerContent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		AdminCustomerRegister pInputArea = new AdminCustomerRegister();
		pInputArea.setBounds(10, 10, 1178, 230);
		pInputArea.setBackground(new Color(255, 255, 255));
		add(pInputArea);

		AdminUserSearch pSearchArea = new AdminUserSearch();
		pSearchArea.setBounds(12, 250, 1176, 50);
		add(pSearchArea);
		
		JPanel pTable = new JPanel();
		pTable.setBounds(12, 310, 1174, 440);
		add(pTable);
		
				PagingComp pPaging = new PagingComp();
				pPaging.setBounds(10, 760, 1176, 40);
				add(pPaging);
	}
}