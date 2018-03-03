package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareTable;

@SuppressWarnings("serial")
public class AdminSoftwareContent extends JPanel implements ActionListener {

	private AdminSoftwareRegister pRegister;
	private AdminSoftwareSearch pSearch;
	private AdminSoftwareTable pTable;
	private JButton btnRegister;
	private JButton btnCancel;
	private JButton btnSearch;

	public AdminSoftwareContent() {

		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 1200, 850);
		setLayout(null);

		pRegister = new AdminSoftwareRegister();
		pRegister.setBounds(0, 0, 961, 195);
		add(pRegister);

		pSearch = new AdminSoftwareSearch();
		pSearch.setBackground(new Color(240, 240, 240));
		pSearch.setBounds(0, 194, 961, 50);
		add(pSearch);

		pTable = new AdminSoftwareTable();
		pTable.setBackground(new Color(240, 240, 240));
		pTable.setBounds(0, 244, 1190, 572);
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		add(pTable);

		PagingComp pPageing = new PagingComp();
		pPageing.setBackground(new Color(240, 240, 240));
		pPageing.setBounds(0, 814, 1190, 52);
		add(pPageing);

		btnRegister = new JButton("등록");
		btnRegister.addActionListener(this);

		btnRegister.setBounds(967, 162, 97, 23);
		add(btnRegister);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(1076, 162, 97, 23);
		add(btnCancel);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(985, 206, 97, 23);
		add(btnSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnRegister) {
			actionPerformedBtnRegister(e);
		}
	}

	// 등록버튼
	protected void actionPerformedBtnRegister(ActionEvent e) {
		String f = pRegister.getpCompany().getCmbBox();
		String a = pRegister.getpSWsort().getCmbBox();
		String b = pRegister.getpSWName().getTfText();
		String c = pRegister.getpSupplyPrice().getTfText();
		String d = pRegister.getpSalePrice().getTfText();
		System.out.println(f);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		if (b.equals("")) {
			JOptionPane.showMessageDialog(null, "입력해주세요");
			return;
		}

	}

	// 취소버튼
	protected void actionPerformedBtnCancel(ActionEvent e) {
	}

	// 검색버튼
	protected void actionPerformedBtnSearch(ActionEvent e) {
	}
}
