package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.service.AddressService;
import kr.or.dgit.it_3st_3team.ui.component.LblAddressComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnPostSearchComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.table.PostTable;

@SuppressWarnings("serial")
public class SearchPostUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tfBNum1;
	private JTextField tfNum2;
	// private PostTable table;
	private JComboBox<String> cmbSiGungu;
	private JComboBox<String> cmbSido;
	private JButton btnSearch;
	private LblTfComp pDoro;
	private PostTable pPostTable;
	private JButton btnZipCodeOK;
	private List<Address> list;
	private LblAddressComp pInputAddr;
	private LblTfBtnPostSearchComp parent;

	public SearchPostUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("주소 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("주소 검색");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBNum = new JLabel("건물번호");
		lblBNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBNum.setBounds(39, 166, 48, 15);
		contentPane.add(lblBNum);

		tfBNum1 = new JTextField();
		tfBNum1.setColumns(10);
		tfBNum1.setBounds(107, 159, 91, 30);
		contentPane.add(tfBNum1);

		JLabel lblempty = new JLabel("-");
		lblempty.setHorizontalAlignment(SwingConstants.CENTER);
		lblempty.setBounds(200, 166, 27, 15);
		contentPane.add(lblempty);

		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(228, 159, 91, 30);
		contentPane.add(tfNum2);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(86, 200, 97, 23);
		contentPane.add(btnSearch);

		btnSearchCancel = new JButton("취소");
		btnSearchCancel.addActionListener(this);
		btnSearchCancel.setBounds(195, 200, 97, 23);
		contentPane.add(btnSearchCancel);

		btnZipCodeOK = new JButton("등록");
		btnZipCodeOK.addActionListener(this);
		btnZipCodeOK.setBounds(147, 529, 97, 23);
		contentPane.add(btnZipCodeOK);

		pPostTable = new PostTable(this);
		// pPostTable.setBackground(Color.WHITE);
		pPostTable.setBounds(12, 233, 358, 185);
		contentPane.add(pPostTable);
		//pPostTable.loadTableDatas(Collections.EMPTY_LIST);

		// pPostTable.setLayout(null);

		/*
		 * JScrollPane scrollPane = new JScrollPane();
		 * scrollPane.setBackground(Color.WHITE); scrollPane.setBounds(0, 0, 358, 185);
		 * pPostTable.add(scrollPane);
		 */

		// scrollPane.setViewportView(table);

		pDoro = new LblTfComp("도로 명");
		pDoro.setBounds(47, 119, 272, 30);
		contentPane.add(pDoro);

		cmbSido = new JComboBox<>();

		cmbSido.setBounds(107, 31, 106, 30);

		contentPane.add(cmbSido);
		JLabel label_1 = new JLabel("시/도");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(39, 40, 48, 15);
		contentPane.add(label_1);

		cmbSiGungu = new JComboBox<>();
		cmbSiGungu.setBounds(107, 77, 106, 30);
		contentPane.add(cmbSiGungu);

		JLabel label = new JLabel("시/군/구");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(39, 86, 48, 15);
		contentPane.add(label);

		loadSidoCmbData();
		cmbSido.addItemListener(sidoListener);
		cmbSido.setSelectedIndex(0);

		pInputAddr = new LblAddressComp("상세주소");

		pInputAddr.setBounds(12, 441, 358, 65);
		contentPane.add(pInputAddr);
	}

	ItemListener sidoListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				loadSigunguCmbData((String) cmbSido.getSelectedItem());
			}
		}
	};
	private JButton btnSearchCancel;

	public LblAddressComp getpInputAddr() {
		return pInputAddr;
	}

	protected void loadSigunguCmbData(String selectedSido) {
		List<Address> siGunguList = AddressService.getInstance().selcectAddressBySigungu(new Address(selectedSido));
		String[] addressArr = new String[siGunguList.size()];

		for (int i = 0; i < siGunguList.size(); i++) {
			addressArr[i] = siGunguList.get(i).getSigungu();
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(addressArr);
		cmbSiGungu.setModel(model);
	}

	private void loadSidoCmbData() {
		List<Address> sidoList = AddressService.getInstance().selcectAddressBySido();
		String[] addressArr = new String[sidoList.size()];

		for (int i = 0; i < sidoList.size(); i++) {
			addressArr[i] = sidoList.get(i).getSido();
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(addressArr);
		cmbSido.setModel(model);
		cmbSido.setSelectedIndex(-1);
	}

	public void settTfBNum1(String text) {
		tfBNum1.setText(text);
	}

	public String getTfBNum1() {
		return tfBNum1.getSelectedText();
	}

	public void settTfBNum2(String text) {
		tfBNum1.setText(text);
	}

	public String getTfBNum2() {
		return tfBNum1.getSelectedText();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchCancel) {
			actionPerformedBtnSearchCancel(e);
		}
		if (e.getSource() == btnZipCodeOK) {
			actionPerformedBtnZipCodeOK(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}

	protected void actionPerformedBtnSearch(ActionEvent e) {
		String sido = (String) cmbSido.getSelectedItem();
		String sigungu = (String) cmbSiGungu.getSelectedItem();
		String doro = pDoro.getTfText();
		int building1 = 0;
		if (!tfBNum1.getText().trim().isEmpty()) {
			building1 = Integer.parseInt(tfBNum1.getText());
		}
		int building2 = 0;
		if (!tfNum2.getText().trim().isEmpty()) {
			building2 = Integer.parseInt(tfNum2.getText());
		}

		Address address = new Address(sido, sigungu, doro, building1, building2);

		if (!doro.equals("")) {
			address.setDoro(doro);
		}

		list = AddressService.getInstance().selectAddressByDoro(address);

		pPostTable.loadTableDatas(list);

	}

	protected void actionPerformedBtnZipCodeOK(ActionEvent e) {
		Address address = new Address();

		String str1 = pInputAddr.getTfAddress1();
		String str2 = pInputAddr.getTfAddress2();

		if (!str1.trim().isEmpty()) {
			String[] addrs = pInputAddr.getTfAddress1().split(" ");
			addrs[0] = addrs[0].replace("[", "");
			addrs[0] = addrs[0].replace("]", "");

			address.setZipcode(addrs[0]);
			address.setSido(addrs[1]);
			address.setSigungu(addrs[2]);
			address.setDoro(addrs[3]);
		}

		parent.setTfText(address.getZipcode());// 우편번호;
		parent.getpInputAddress().setTfAddress1(address.getFirstAddress());
		parent.getpInputAddress().setTfAddress2(str2);
		SearchPostUI.this.dispose();
	}

	public void setPostSearch(LblTfBtnPostSearchComp postComp) {
		this.parent = postComp;
	}

	protected void actionPerformedBtnSearchCancel(ActionEvent e) {
		pDoro.setTfText("");
		tfBNum1.setText("");
		tfNum2.setText("");
	}
}
