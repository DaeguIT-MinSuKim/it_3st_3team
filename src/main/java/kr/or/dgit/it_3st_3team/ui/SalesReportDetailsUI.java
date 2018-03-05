package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.List;
import java.awt.Font;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.ui.table.SalesReportDetailsLists;

@SuppressWarnings("serial")
public class SalesReportDetailsUI extends JFrame {
	private JPanel contentPane;
	private SalesReportDetailsLists pLists;
	
	
	public SalesReportDetailsUI(String lblTitle, List<SaleOrder> list) {
		initComponents(lblTitle, list);
	}
	private void initComponents(String lblTitle, List<SaleOrder> list) {
		setTitle("보고서");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTitleName = new JPanel();
		pTitle.add(pTitleName);
		
		JLabel lblReport = new JLabel("보고서");
		lblReport.setFont(new Font("굴림", Font.PLAIN, 18));
		pTitleName.add(lblReport);
		
		JPanel pSearchedLists = new JPanel();
		pTitle.add(pSearchedLists);
		
		JLabel lblSelected = new JLabel(lblTitle);
		pSearchedLists.add(lblSelected);
		
		pLists = new SalesReportDetailsLists();
		contentPane.add(pLists, BorderLayout.CENTER);
		
		pLists.loadTableDatas(list);
	}

}
