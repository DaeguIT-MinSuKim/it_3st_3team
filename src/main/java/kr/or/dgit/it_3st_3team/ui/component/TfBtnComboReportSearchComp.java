package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TfBtnComboReportSearchComp extends JPanel {
	private JTextField tfSearchItem;
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp p1;

	
	public TfBtnComboReportSearchComp() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		
		p1 = new CmbStringComp();
		p1.setBounds(0, 0, 125, 30);
		p1.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(p1);
		setStringData();
		
		
		
		
		tfSearchItem = new JTextField();
		tfSearchItem.setBounds(137, 0, 540, 30);
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JButton btnStatusSearch = new JButton("검색");
		btnStatusSearch.setBounds(689, 0, 70, 30);
		add(btnStatusSearch);
	}

	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		p1.loadData(strings);
	}
	
}

