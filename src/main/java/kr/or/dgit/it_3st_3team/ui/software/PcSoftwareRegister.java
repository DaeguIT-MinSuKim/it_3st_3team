package kr.or.dgit.it_3st_3team.ui.software;

import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PcSoftwareRegister extends JPanel implements ActionListener {
	private JTextField tfSWName;
	private JTextField tfSupplyPrice;
	private JTextField tfSalePrice;
	private JTextField tfPCName;
	private JTextField tfSearch;
	private JTable PCswTable;
	private JButton btnSWImgUp;
	private JFileChooser chooser;
	private JLabel lblSWImg;

	/**
	 * Create the panel.
	 */
	public PcSoftwareRegister() {

		initComponents();
	}
	private void initComponents() {
		setBounds(new Rectangle(0, 0, 900, 500));
		setLayout(null);
		
		JPanel pPcRegister = new JPanel();
		pPcRegister.setLayout(null);
		pPcRegister.setBackground(Color.WHITE);
		pPcRegister.setBounds(12, 10, 897, 183);
		add(pPcRegister);
		
		lblSWImg = new JLabel("");
		lblSWImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSWImg.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSWImg.setBounds(22, 10, 143, 134);
		pPcRegister.add(lblSWImg);
		
		btnSWImgUp = new JButton("이미지 등록");
		btnSWImgUp.addActionListener(this);
		btnSWImgUp.setBounds(48, 154, 97, 23);
		pPcRegister.add(btnSWImgUp);
		
		JLabel lblPCName = new JLabel("공급회사");
		lblPCName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPCName.setBounds(217, 25, 57, 15);
		pPcRegister.add(lblPCName);
		
		JLabel lblCalssify = new JLabel("분류");
		lblCalssify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalssify.setBounds(440, 25, 57, 15);
		pPcRegister.add(lblCalssify);
		
		JComboBox cmbCF = new JComboBox();
		cmbCF.setBounds(523, 18, 97, 29);
		pPcRegister.add(cmbCF);
		
		JLabel lblSWName = new JLabel("품목명");
		lblSWName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSWName.setBounds(217, 66, 57, 15);
		pPcRegister.add(lblSWName);
		
		tfSWName = new JTextField();
		tfSWName.setColumns(10);
		tfSWName.setBounds(299, 57, 134, 29);
		pPcRegister.add(tfSWName);
		
		JLabel lblSupplyPrice = new JLabel("공급가격");
		lblSupplyPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSupplyPrice.setBounds(217, 142, 57, 15);
		pPcRegister.add(lblSupplyPrice);
		
		tfSupplyPrice = new JTextField();
		tfSupplyPrice.setColumns(10);
		tfSupplyPrice.setBounds(299, 135, 120, 29);
		pPcRegister.add(tfSupplyPrice);
		
		JLabel lblSalePrice = new JLabel("판매가격");
		lblSalePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalePrice.setBounds(217, 103, 57, 15);
		pPcRegister.add(lblSalePrice);
		
		tfSalePrice = new JTextField();
		tfSalePrice.setColumns(10);
		tfSalePrice.setBounds(299, 96, 120, 29);
		pPcRegister.add(tfSalePrice);
		
		JButton btnSubmitSW = new JButton("등록");
		btnSubmitSW.setBounds(679, 154, 97, 23);
		pPcRegister.add(btnSubmitSW);
		
		JButton btnCancelSW = new JButton("취소");
		btnCancelSW.setBounds(788, 154, 97, 23);
		pPcRegister.add(btnCancelSW);
		
		JButton btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.setBounds(632, 21, 97, 23);
		pPcRegister.add(btnSubmitCF);
		
		tfPCName = new JTextField();
		tfPCName.setColumns(10);
		tfPCName.setBounds(299, 18, 134, 29);
		pPcRegister.add(tfPCName);
		
		JPanel pPcSearch = new JPanel();
		pPcSearch.setBackground(Color.WHITE);
		pPcSearch.setBounds(12, 197, 897, 33);
		add(pPcSearch);
		pPcSearch.setLayout(null);
		
		JComboBox cmbSearch1 = new JComboBox();
		cmbSearch1.setBounds(12, 4, 124, 23);
		pPcSearch.add(cmbSearch1);
		
		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(148, 5, 668, 21);
		pPcSearch.add(tfSearch);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(828, 5, 57, 23);
		pPcSearch.add(btnSearch);
		
		JPanel pPCswTable = new JPanel();
		pPCswTable.setBackground(Color.WHITE);
		pPCswTable.setBounds(12, 236, 897, 276);
		add(pPCswTable);
		pPCswTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 873, 256);
		pPCswTable.add(scrollPane);
		
		PCswTable = new JTable();
		PCswTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uD488\uBAA9\uBC88\uD638", "\uBD84\uB958", "\uD488\uBAA9\uBA85", "\uACF5\uAE09\uAC00\uACA9", "\uD310\uB9E4\uAC00\uACA9", "\uC218\uC815/\uC0AD\uC81C"
			}
		));
		scrollPane.setViewportView(PCswTable);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSWImgUp) {
			chooser = new JFileChooser();
			actionPerformedBtnSWImgUp(e);
		}
	}
	protected void actionPerformedBtnSWImgUp(ActionEvent e) {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg","png");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		lblSWImg.setIcon(new ImageIcon(filePath));
		
	}
}
