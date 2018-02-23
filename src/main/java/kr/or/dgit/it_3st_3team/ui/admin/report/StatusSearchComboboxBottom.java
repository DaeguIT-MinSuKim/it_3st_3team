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

public class StatusSearchComboboxBottom extends JPanel implements ActionListener {
	private JTextField tfSearchItem;
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp panel_1;
	private JButton btnReceipt;
	private JButton btnStatusReport;

	
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
		
		btnReceipt = new JButton("거래명세서");
		btnReceipt.addActionListener(this);
		btnReceipt.setBounds(934, 0, 110, 30);
		add(btnReceipt);
		
		btnStatusReport = new JButton("보고서");
		btnStatusReport.addActionListener(this);
		btnStatusReport.setBounds(1056, 0, 80, 30);
		add(btnStatusReport);
	}

	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		panel_1.loadData(strings);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStatusReport) {
			actionPerformedBtnStatusReport(e);
		}
		if (e.getSource() == btnReceipt) {
			actionPerformedBtnReceipt(e);
		}
	}
	protected void actionPerformedBtnReceipt(ActionEvent e) {
	}
	protected void actionPerformedBtnStatusReport(ActionEvent e) {
	}
}

