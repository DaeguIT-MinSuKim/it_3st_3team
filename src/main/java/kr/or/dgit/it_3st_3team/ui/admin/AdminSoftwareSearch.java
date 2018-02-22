package kr.or.dgit.it_3st_3team.ui.admin;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.it_3st_3team.ui.component.SearchSoftwareCombobox;
import kr.or.dgit.it_3st_3team.ui.component.SearchUserCmbComponent;

public class AdminSoftwareSearch extends JPanel {
	private JTextField tfSearch;

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
		
		tfSearch = new JTextField();
		tfSearch.setBounds(407, 9, 683, 21);
		pSWSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(1101, 8, 57, 23);
		pSWSearch.add(btnSearch);
		
		SearchUserCmbComponent pSearchSW = new SearchUserCmbComponent();
		pSearchSW.setBounds(220, 8, 175, 23);
		pSWSearch.add(pSearchSW);
		
		SearchSoftwareCombobox panel = new SearchSoftwareCombobox();
		panel.setBounds(24, 8, 175, 23);
		pSWSearch.add(panel);
	}

}
