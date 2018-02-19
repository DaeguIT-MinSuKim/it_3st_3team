package kr.or.dgit.it_3st_3team.ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class AddSW extends JPanel {
	private JTextField tfSWName;
	private JTextField tfSupplyPrice;
	private JTextField tfSalePrice;
	private JTextField tfSearch;
	private JTable SWTable;

	/**
	 * Create the panel.
	 */
	public AddSW() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(Color.WHITE);
		pRegister.setBounds(0, -3, 850, 203);
		add(pRegister);
		pRegister.setLayout(null);
		
		JPanel pAddImg = new JPanel();
		pAddImg.setBorder(new LineBorder(new Color(0, 0, 0)));
		pAddImg.setBackground(Color.WHITE);
		pAddImg.setBounds(12, 15, 143, 143);
		pRegister.add(pAddImg);
		
		JButton btnSWImgUp = new JButton("이미지 등록");
		btnSWImgUp.setBounds(33, 168, 97, 23);
		pRegister.add(btnSWImgUp);
		
		JLabel lblPCName = new JLabel("공급회사");
		lblPCName.setBounds(178, 27, 48, 15);
		pRegister.add(lblPCName);
		
		JComboBox cmbSearchPC = new JComboBox();
		cmbSearchPC.setBounds(238, 24, 152, 21);
		pRegister.add(cmbSearchPC);
		
		JLabel lblCalssify = new JLabel("분류");
		lblCalssify.setBounds(202, 64, 24, 15);
		pRegister.add(lblCalssify);
		
		JComboBox cmbCF = new JComboBox();
		cmbCF.setBounds(238, 61, 152, 21);
		pRegister.add(cmbCF);
		
		JButton btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.setBounds(402, 60, 81, 23);
		pRegister.add(btnSubmitCF);
		
		JLabel lblSWName = new JLabel("품목명");
		lblSWName.setBounds(190, 102, 36, 15);
		pRegister.add(lblSWName);
		
		tfSWName = new JTextField();
		tfSWName.setColumns(10);
		tfSWName.setBounds(238, 99, 187, 21);
		pRegister.add(tfSWName);
		
		JLabel lblSupplyPrice = new JLabel("공급가격");
		lblSupplyPrice.setBounds(178, 140, 48, 15);
		pRegister.add(lblSupplyPrice);
		
		tfSupplyPrice = new JTextField();
		tfSupplyPrice.setColumns(10);
		tfSupplyPrice.setBounds(238, 137, 143, 21);
		pRegister.add(tfSupplyPrice);
		
		JLabel lblSalePrice = new JLabel("판매가격");
		lblSalePrice.setBounds(178, 176, 48, 15);
		pRegister.add(lblSalePrice);
		
		tfSalePrice = new JTextField();
		tfSalePrice.setColumns(10);
		tfSalePrice.setBounds(238, 172, 143, 21);
		pRegister.add(tfSalePrice);
		
		JButton btnSubmitSW = new JButton("등록");
		btnSubmitSW.setBounds(648, 168, 81, 23);
		pRegister.add(btnSubmitSW);
		
		JButton btnCancelSW = new JButton("취소");
		btnCancelSW.setBounds(741, 168, 81, 23);
		pRegister.add(btnCancelSW);
		
		JPanel pSWSearch = new JPanel();
		pSWSearch.setBackground(Color.WHITE);
		pSWSearch.setBounds(0, 210, 850, 41);
		add(pSWSearch);
		pSWSearch.setLayout(null);
		
		JComboBox cmbSearch1 = new JComboBox();
		cmbSearch1.setBounds(12, 10, 101, 21);
		pSWSearch.add(cmbSearch1);
		
		JComboBox cmbSearch2 = new JComboBox();
		cmbSearch2.setBounds(125, 10, 83, 21);
		pSWSearch.add(cmbSearch2);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(220, 10, 532, 21);
		pSWSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(764, 9, 81, 23);
		pSWSearch.add(btnSearch);
		
		JPanel pSWTable = new JPanel();
		pSWTable.setBackground(Color.WHITE);
		pSWTable.setBounds(0, 261, 850, 239);
		add(pSWTable);
		pSWTable.setLayout(null);
		
		SWTable = new JTable();
		SWTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"품목번호", "분류", "품목명", "공급가격", "판매가격", "공급회"
			}
		));
		SWTable.setBounds(12, 10, 826, 193);
		pSWTable.add(SWTable);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(355, 213, 41, 23);
		pSWTable.add(btnNewButton);
	}
}
