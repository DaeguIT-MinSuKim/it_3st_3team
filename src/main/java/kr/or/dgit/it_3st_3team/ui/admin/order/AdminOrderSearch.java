package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CmbAdminGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminOrderSearch extends JPanel {
	private JTextField textField;

	public AdminOrderSearch() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pOrderSearch = new JPanel();
		pOrderSearch.setBackground(Color.WHITE);
		pOrderSearch.setBounds(0, 0, 1060, 50);
		add(pOrderSearch);
		pOrderSearch.setLayout(null);

		CmbSoftwareGroupComp pSearchSoftwareSort = new CmbSoftwareGroupComp();
		pSearchSoftwareSort.setBounds(12, 10, 120, 30);
		pOrderSearch.add(pSearchSoftwareSort);

		CmbAdminGroupComp pAdminGroup = new CmbAdminGroupComp();
		pAdminGroup.setBounds(144, 10, 120, 30);
		pOrderSearch.add(pAdminGroup);

		StartAndEndDate pDate = new StartAndEndDate();
		pDate.setBackground(new Color(240, 240, 240));
		pDate.setBounds(402, 0, 434, 43);
		pOrderSearch.add(pDate);

		CmbStringComp pSortUserNameSWName = new CmbStringComp();
		pSortUserNameSWName.setBounds(276, 10, 120, 30);
		pOrderSearch.add(pSortUserNameSWName);
		
		textField = new JTextField();
		textField.setBounds(836, 10, 224, 30);
		pOrderSearch.add(textField);
		textField.setColumns(10);
	}

}
