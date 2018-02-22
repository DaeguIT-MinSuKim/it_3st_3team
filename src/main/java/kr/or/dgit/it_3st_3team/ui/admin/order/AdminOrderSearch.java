package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import kr.or.dgit.it_3st_3team.ui.component.SearchSoftwareCombobox;

public class AdminOrderSearch extends JPanel {
	private JTextField tfSearch;

	/**
	 * Create the panel.
	 */
	public AdminOrderSearch() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pOrderSearch = new JPanel();
		pOrderSearch.setBackground(Color.WHITE);
		pOrderSearch.setBounds(0, 0, 1190, 43);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(901, 7, 208, 30);
		pOrderSearch.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(1121, 8, 57, 23);
		pOrderSearch.add(btnSearch);
		
		SearchSoftwareCombobox pSearchSoftwareName = new SearchSoftwareCombobox();
		pSearchSoftwareName.setBounds(22, 7, 120, 30);
		pOrderSearch.add(pSearchSoftwareName);
		
		JPanel pSearchSoftwareSort = new JPanel();
		pSearchSoftwareSort.setBounds(154, 7, 120, 30);
		pOrderSearch.add(pSearchSoftwareSort);
	}

}
