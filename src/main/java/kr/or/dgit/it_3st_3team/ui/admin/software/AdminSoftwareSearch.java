package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.ui.component.SearchSoftwareCombobox;
import kr.or.dgit.it_3st_3team.ui.component.SearchUserCmbComponent;
import kr.or.dgit.it_3st_3team.ui.component.UserLabelComboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.UserComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.StringCombobox;
import kr.or.dgit.it_3st_3team.ui.component.OnlySearchBottom;

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
		
		StringCombobox pSWNamePCName = new StringCombobox();
		pSWNamePCName.setBounds(148, 9, 137, 25);
		pSWSearch.add(pSWNamePCName);
		
		OnlySearchBottom pSearch = new OnlySearchBottom();
		pSearch.setBounds(375, 9, 628, 25);
		pSWSearch.add(pSearch);
	}

}
