package kr.or.dgit.it_3st_3team.ui.admin.software;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class AdminSoftware extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminSoftware() {

		initComponents();
	}
	private void initComponents() {
		setBounds(new Rectangle(0, 0, 900, 500));
		setLayout(null);
		
		AdminSoftwareRegister pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(12, 10, 877, 183);
		add(pRegister);
		
		AdminSoftwareSearch pSearch = new AdminSoftwareSearch();
		pSearch.setBounds(12, 198, 877, 39);
		add(pSearch);
		
		AdminSoftwareTable pTable = new AdminSoftwareTable();
		pTable.setBounds(12, 243, 877, 268);
		add(pTable);
	}
}
