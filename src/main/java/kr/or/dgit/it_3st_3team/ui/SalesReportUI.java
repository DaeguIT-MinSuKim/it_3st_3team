package kr.or.dgit.it_3st_3team.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import java.awt.Font;

public class SalesReportUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JRadioButton rdReport;
	private JRadioButton rdTransaction;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JComboBox<String> cmbString;
	private StartAndEndDate p3;
	private SaleOrderService soService;

	public SalesReportUI() {
		this.soService = SaleOrderService.getInstance();

		initComponents();
	}

	private void initComponents() {
		setTitle("판매보고서");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(5, 5, 774, 40);
		contentPane.add(p1);
		p1.setLayout(null);

		JLabel lblReport = new JLabel("판매보고서");
		lblReport.setFont(new Font("굴림", Font.PLAIN, 14));
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setBounds(345, 0, 84, 40);
		p1.add(lblReport);

		JPanel p2 = new JPanel();
		p2.setBounds(5, 49, 281, 40);
		contentPane.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));

		ButtonGroup btnG = new ButtonGroup();

		rdReport = new JRadioButton("보고서");

		p2.add(rdReport);

		rdTransaction = new JRadioButton("거래명세서");
		p2.add(rdTransaction);
		btnG.add(rdReport);
		btnG.add(rdTransaction);

		p3 = new StartAndEndDate();
		p3.setBounds(321, 46, 458, 43);
		contentPane.add(p3);

		JPanel p4 = new JPanel();
		p4.setBounds(5, 92, 758, 30);
		contentPane.add(p4);
		p4.setLayout(null);
		
		cmbString = new JComboBox<>();
		cmbString.setBounds(0, 0, 125, 30);
		p4.add(cmbString);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(138, 0, 320, 30);
		p4.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(468, 0, 66, 30);
		p4.add(btnSearch);
		btnSearch.addActionListener(this);
		setCmbString();

		// 보고서가 기본으로 선택되어 나옴
		rdReport.setSelected(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			actionPerformedBtnSearch(arg0);
		}
	}

	public void setCmbString() {
		// 검색필드 콤보박스 넣는 코드
		String[] st = { "고객명", "공급회사명", "품목명" };
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(st);
		cmbString.setModel(dcbm);
	}

	protected void actionPerformedBtnSearch(ActionEvent arg0) {
		String searchBy = (String) cmbString.getSelectedItem();
		if (searchBy.equals("고객명")) {
			searchBy = "customer";
		} else if (searchBy.equals("공급회사명")) {
			searchBy = "company";
		} else if (searchBy.equals("품목명")) {
			searchBy = "softwarename";
		}
		String name = tfSearch.getText().trim();
		String startDate = p3.getStartDate();
		String endDate = p3.getEndDate();
		System.out.println(String.format("%s %s %s", startDate, endDate, name));

		Map<String, String> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("searchBy", searchBy);
		map.put("name", name);

		rdReport(map);
	}

	private void rdReport(Map<String, String> map) {
		Boolean report = rdReport.isSelected();
		Boolean transaction = rdTransaction.isSelected();

		List<SaleOrder> list = soService.findSaleOrderWithAllBySearch(map);
		System.out.println(list);
		
		String lblTitle = String.format("%s %s %s", 
				map.get("startDate"), map.get("endDate"), map.get("name") );
		
		if (report) {
			JFrame jf = new SalesReportDetailsUI(lblTitle, list);
			jf.setVisible(true);

		}
		if (transaction) {
			JFrame jf = new SalesTransactionDetailsUI(list);
			jf.setVisible(true);
		}

	}

	public String getStartDate() {
		return p3.getStartDate();
	}

	public String getEndDate() {
		return p3.getEndDate();
	}

}
