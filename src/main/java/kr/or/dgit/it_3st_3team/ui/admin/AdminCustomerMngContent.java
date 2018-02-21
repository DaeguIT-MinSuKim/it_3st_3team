package kr.or.dgit.it_3st_3team.ui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageContent;

@SuppressWarnings("serial")
public class AdminCustomerMngContent extends JPanel {

	public AdminCustomerMngContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pInputData = new JPanel();
		add(pInputData, BorderLayout.NORTH);
		pInputData.setBounds(0, 0, 180, 180);
		pInputData.setLayout(new BorderLayout(0, 0));
		
		ImageContent panel = new ImageContent();
		pInputData.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		pInputData.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel panel_2 = new JPanel();
		pInputData.add(panel_2, BorderLayout.EAST);
		
		JPanel pListData = new JPanel();
		add(pListData, BorderLayout.CENTER);
	}

}
