package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		pOrderSearch.setBounds(0, 0, 877, 39);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);
		
		JComboBox cmbSeach1 = new JComboBox();
		cmbSeach1.setBounds(12, 7, 92, 26);
		pOrderSearch.add(cmbSeach1);
		
		JComboBox cmbSeach2 = new JComboBox();
		cmbSeach2.setBounds(108, 7, 124, 26);
		pOrderSearch.add(cmbSeach2);
		
		JComboBox cmbSeach3 = new JComboBox();
		cmbSeach3.setBounds(236, 7, 124, 26);
		pOrderSearch.add(cmbSeach3);
		
		JComboBox cmbSeach4 = new JComboBox();
		cmbSeach4.setBounds(364, 7, 92, 26);
		pOrderSearch.add(cmbSeach4);
		
		JComboBox cmbSeach5 = new JComboBox();
		cmbSeach5.setBounds(484, 7, 92, 26);
		pOrderSearch.add(cmbSeach5);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(588, 9, 208, 21);
		pOrderSearch.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(808, 8, 57, 23);
		pOrderSearch.add(btnSearch);
		
		JLabel lbldash = new JLabel("-");
		lbldash.setHorizontalAlignment(SwingConstants.CENTER);
		lbldash.setBounds(442, 13, 57, 15);
		pOrderSearch.add(lbldash);
	}

}
