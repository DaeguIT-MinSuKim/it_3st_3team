package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class AdminManagementContent extends JPanel {

	public AdminManagementContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1180, 850);

		AdminManagementRegister pInputArea = new AdminManagementRegister();
		//pInputArea.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		pInputArea.setBounds(10, 10, 1160, 235);
		add(pInputArea);
		pInputArea.setLayout(null);

		AdminManagementSearch pSearchArea = new AdminManagementSearch();
		pSearchArea.setBounds(10, 250, 1158, 50);
		add(pSearchArea);
		pSearchArea.setLayout(null);

		JPanel pDataArea = new JPanel();
		pDataArea.setBounds(10, 310, 1158, 530);
		add(pDataArea);
	}

}
