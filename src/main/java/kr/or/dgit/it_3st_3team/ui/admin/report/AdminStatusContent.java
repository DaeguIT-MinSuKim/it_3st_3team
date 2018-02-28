package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminStatusLists;
import javax.swing.JButton;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class AdminStatusContent extends JPanel {

	public AdminStatusContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		/*
		 관리자
		 if (관리자) {
		 	cmb1.호출메서드
		 	cmb2.호출메서드
		 	cmb3.호출메서드
		 }
		  */
		TestSearch pSearch = new TestSearch();
		pSearch.setBounds(12, 10, 1178, 96);
		add(pSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(471, 60, 80, 30);
		pSearch.add(btnSearch);
		
		JButton btnReport = new JButton("판매보고서");
		btnReport.setBounds(1070, 60, 100, 30);
		pSearch.add(btnReport);

		AdminStatusLists pListTable = new AdminStatusLists();
		pListTable.setBounds(12, 116, 1176, 418);
		add(pListTable);

		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 544, 1176, 40);
		add(pPaging);
	}
}
