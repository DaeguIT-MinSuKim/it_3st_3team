package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.SalesReportUI;


public class TfBtnComboSearchComp extends JPanel implements ActionListener {
	private CmbStringComp pUserSwNameCombo;
	private CmbStringComp p1;
	private JButton btnStatusReport;

	
	public TfBtnComboSearchComp() {

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
		
		TfBtnSearchComp panel = new TfBtnSearchComp((String) "검색");
		panel.setBounds(144, 0, 637, 30);
		add(panel);
		
		btnStatusReport = new JButton("판매보고서");
		btnStatusReport.addActionListener(this);
		btnStatusReport.setBounds(1026, 0, 110, 30);
		add(btnStatusReport);
	}

	public void setStringData() {
		String[] strings = {"상품명", "고객명","공급회사명"};
		p1.loadData(strings);
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

