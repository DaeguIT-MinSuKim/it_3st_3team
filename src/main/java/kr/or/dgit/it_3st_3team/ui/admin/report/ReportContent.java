package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import kr.or.dgit.it_3st_3team.ui.table.ReceiptLists;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;

public class ReportContent extends JPanel {
	private JTextField tfSearch;
	private CmbStringComp pCmb;

	/**
	 * Create the panel.
	 */
	public ReportContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pTitle = new JPanel();
		pTitle.setBounds(0, 0, 900, 42);
		add(pTitle);
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("판매보고서");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pTitle.add(lblNewLabel);
		
		JPanel pRadio = new JPanel();
		pRadio.setBounds(0, 52, 248, 30);
		add(pRadio);
		pRadio.setLayout(null);
		
		JRadioButton rdReport = new JRadioButton("보고서");
		rdReport.setBounds(15, 3, 98, 23);
		pRadio.add(rdReport);
		
		JRadioButton rdReceipt = new JRadioButton("거래명세서");
		rdReceipt.setBounds(131, 3, 119, 23);
		pRadio.add(rdReceipt);
		
		StartAndEndDate pCalendar = new StartAndEndDate();
		pCalendar.setBounds(435, 45, 469, 42);
		add(pCalendar);
		
		JPanel pSearch = new JPanel();
		pSearch.setBounds(0, 92, 888, 30);
		add(pSearch);
		pSearch.setLayout(null);
		
		pCmb = new CmbStringComp();
		pCmb.setBounds(17, 0, 125, 30);
		pSearch.add(pCmb);
		setStringData();
		
		
		tfSearch = new JTextField();
		tfSearch.setBounds(154, 0, 592, 30);
		pSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(815, 0, 70, 30);
		pSearch.add(btnSearch);
	}
	public void setStringData() {
		String[] strings = {"상품명", "상호명"};
		pCmb.loadData(strings);
	}
}
