package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.SalesReportUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TfBtnComboReportSearchComp extends JPanel implements ActionListener {
	private JTextField tfSearchItem;
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp p1;
	private JButton btnStatusSearch;
	private SalesReportUI ss;

	
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
		
		btnStatusSearch = new JButton("검색");
		btnStatusSearch.addActionListener(this);
		btnStatusSearch.setBounds(689, 0, 70, 30);
		add(btnStatusSearch);
	}

	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		p1.loadData(strings);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStatusSearch) {
			actionPerformedBtnStatusSearch(e);
		}
	}
	protected void actionPerformedBtnStatusSearch(ActionEvent e) {
		ss = new SalesReportUI();
		
	}
}

