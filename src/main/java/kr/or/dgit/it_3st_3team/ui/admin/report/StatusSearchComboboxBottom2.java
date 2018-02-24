package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;

import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatusSearchComboboxBottom2 extends JPanel implements ActionListener {
	private JTextField tfSearchItem;
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp p1;
	private JButton btnStatusReport;

	
	public StatusSearchComboboxBottom2() {

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
		tfSearchItem.setBounds(137, 0, 593, 30);
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JButton btnStatusSearch = new JButton("검색");
		btnStatusSearch.setBounds(746, 0, 70, 30);
		add(btnStatusSearch);
		
		btnStatusReport = new JButton("판매보고서");
		btnStatusReport.addActionListener(this);
		btnStatusReport.setBounds(1026, 0, 110, 30);
		add(btnStatusReport);
	}

	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		p1.loadData(strings);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStatusReport) {
			actionPerformedBtnStatusReport(e);
		}
	}
	protected void actionPerformedBtnStatusReport(ActionEvent e) {
	}
}

