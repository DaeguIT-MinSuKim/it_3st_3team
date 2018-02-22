package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;

public class AdminSoftwareSearch extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminSoftwareSearch() {

		initComponents();
	}
	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel pSWSearch = new JPanel();
		pSWSearch.setBackground(Color.WHITE);
		pSWSearch.setBounds(0, 0, 1170, 42);
		add(pSWSearch);
		pSWSearch.setLayout(null);
		
		CmbStringComp pSWNamePCName = new CmbStringComp();
		pSWNamePCName.setBounds(148, 9, 137, 25);
		pSWSearch.add(pSWNamePCName);
		
		TfBtnSearchComp pSearch = new TfBtnSearchComp();
		pSearch.setBounds(375, 9, 628, 25);
		pSWSearch.add(pSearch);
	}

}
