package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import kr.or.dgit.it_3st_3team.ui.component.SearchSoftwareCombobox;
import kr.or.dgit.it_3st_3team.ui.component.SoftwareComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.AdminGroupComboboxComponent;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.StringCombobox;
import kr.or.dgit.it_3st_3team.ui.component.StatusSearchBottom;
import kr.or.dgit.it_3st_3team.ui.component.OnlySearchBottom;

public class AdminOrderSearch extends JPanel {

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
		pOrderSearch.setBounds(0, 0, 1190, 94);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);
		
		SoftwareComboboxComponent pSearchSoftwareSort = new SoftwareComboboxComponent();
		pSearchSoftwareSort.setBounds(168, 34, 120, 30);
		pOrderSearch.add(pSearchSoftwareSort);
		
		AdminGroupComboboxComponent pAdminGroup = new AdminGroupComboboxComponent();
		pAdminGroup.setBounds(325, 34, 120, 30);
		pOrderSearch.add(pAdminGroup);
		
		StartAndEndDate pDate = new StartAndEndDate();
		pDate.setBackground(Color.WHITE);
		pDate.setBounds(488, 10, 690, 43);
		pOrderSearch.add(pDate);
		
		StringCombobox pSortUserNameSWName = new StringCombobox();
		pSortUserNameSWName.setBounds(493, 54, 120, 30);
		pOrderSearch.add(pSortUserNameSWName);
		
		OnlySearchBottom pSearch = new OnlySearchBottom();
		pSearch.setBounds(638, 54, 540, 30);
		pOrderSearch.add(pSearch);
	}

}
