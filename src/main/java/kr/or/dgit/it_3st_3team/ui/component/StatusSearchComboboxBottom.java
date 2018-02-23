package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class StatusSearchComboboxBottom extends JPanel {
	private JTextField tfSearchItem;
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp panel_1;

	
	public StatusSearchComboboxBottom() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		
		panel_1 = new CmbStringComp();
		panel_1.setBounds(0, 0, 125, 30);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_1);
		setStringData();
		
		
		
		
		tfSearchItem = new JTextField();
		tfSearchItem.setBounds(137, 0, 593, 30);
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JButton btnStatusSearch = new JButton("검색");
		btnStatusSearch.setBounds(746, 0, 70, 30);
		add(btnStatusSearch);
		
		JButton btnReceipt = new JButton("거래명세서");
		btnReceipt.setBounds(977, 0, 110, 30);
		add(btnReceipt);
		
		JButton btnStatusReport = new JButton("보고서");
		btnStatusReport.setBounds(1098, 0, 80, 30);
		add(btnStatusReport);
	}

	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		panel_1.loadData(strings);
	}
}

