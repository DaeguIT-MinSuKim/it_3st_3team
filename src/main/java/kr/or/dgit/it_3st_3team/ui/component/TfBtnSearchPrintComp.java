package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.SalesReportUI;

import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TfBtnSearchPrintComp extends JPanel implements ActionListener {
	private JTextField tfSearchItem;
	private JButton btnStatusReport;

	
	public TfBtnSearchPrintComp() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(240, 240, 240));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		tfSearchItem = new JTextField();
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JPanel pStatusSearch = new JPanel();
		pStatusSearch.setBackground(new Color(240, 240, 240));
		pStatusSearch.setBorder(new EmptyBorder(0, 20, 0, 400));
		add(pStatusSearch);
		pStatusSearch.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnStatusSearch = new JButton("검색");
		pStatusSearch.add(btnStatusSearch);
		
		JPanel pStatusReport = new JPanel();
		add(pStatusReport);
		pStatusReport.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnStatusReport = new JButton("판매보고서");
		btnStatusReport.addActionListener(this);
		pStatusReport.add(btnStatusReport);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStatusReport) {
			actionPerformedBtnStatusReport(e);
		}
	}
	protected void actionPerformedBtnStatusReport(ActionEvent e) {
		SalesReportUI salesR = new SalesReportUI();
		salesR.setVisible(true);
	}
}

