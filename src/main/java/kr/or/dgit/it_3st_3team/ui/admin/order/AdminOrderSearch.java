package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CmbAdminGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;

@SuppressWarnings("serial")
public class AdminOrderSearch extends JPanel {

	public AdminOrderSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pOrderSearch = new JPanel();
		pOrderSearch.setBackground(Color.WHITE);
		pOrderSearch.setBounds(0, 0, 1200, 94);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);

		CmbSoftwareGroupComp pSearchSoftwareSort = new CmbSoftwareGroupComp();
		pSearchSoftwareSort.setBounds(168, 34, 120, 30);
		pOrderSearch.add(pSearchSoftwareSort);

		CmbAdminGroupComp pAdminGroup = new CmbAdminGroupComp();
		pAdminGroup.setBounds(325, 34, 120, 30);
		pOrderSearch.add(pAdminGroup);

		StartAndEndDate pDate = new StartAndEndDate();
		pDate.setBackground(Color.WHITE);
		pDate.setBounds(488, 10, 690, 43);
		pOrderSearch.add(pDate);

		CmbStringComp pSortUserNameSWName = new CmbStringComp();
		pSortUserNameSWName.setBounds(493, 54, 120, 30);
		pOrderSearch.add(pSortUserNameSWName);

		TfBtnSearchComp pSearch = new TfBtnSearchComp("검색");
		pSearch.setBounds(638, 54, 540, 30);
		pOrderSearch.add(pSearch);
	}

}
