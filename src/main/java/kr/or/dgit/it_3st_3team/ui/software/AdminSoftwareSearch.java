package kr.or.dgit.it_3st_3team.ui.software;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

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
		pSWSearch.setBounds(0, 0, 877, 42);
		add(pSWSearch);
		pSWSearch.setLayout(null);
		
		JComboBox cmbSearch1 = new JComboBox();
		cmbSearch1.setBounds(12, 6, 116, 26);
		pSWSearch.add(cmbSearch1);
		
		JComboBox cmbSearch2 = new JComboBox();
		cmbSearch2.setBounds(145, 6, 124, 26);
		pSWSearch.add(cmbSearch2);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(281, 9, 502, 21);
		pSWSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(795, 8, 57, 23);
		pSWSearch.add(btnSearch);
	}

}
