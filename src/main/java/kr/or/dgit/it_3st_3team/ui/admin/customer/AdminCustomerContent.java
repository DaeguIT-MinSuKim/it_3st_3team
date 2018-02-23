package kr.or.dgit.it_3st_3team.ui.admin.customer;

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
		setBounds(0, 0, 1200, 850);

		AdminCustomerRegister pInputArea = new AdminCustomerRegister();

		pInputArea.setBounds(0, 0, 1165, 250);

		pInputArea.setBackground(new Color(255, 255, 255));
		pInputArea.setBounds(10, 10, 1178, 250);

		add(pInputArea);

		AdminCustomerSearch pSearchArea = new AdminCustomerSearch();

		pSearchArea.setBounds(0, 249, 1165, 50);

		pSearchArea.setBounds(12, 270, 1176, 50);

		add(pSearchArea);

		PagingComp panel = new PagingComp();
		panel.setBounds(10, 800, 1176, 40);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 330, 1174, 460);
		add(panel_1);
	}
}
