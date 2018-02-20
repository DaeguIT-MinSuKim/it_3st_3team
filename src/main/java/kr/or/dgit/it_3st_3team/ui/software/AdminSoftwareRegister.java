package kr.or.dgit.it_3st_3team.ui.software;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSoftwareRegister extends JPanel implements ActionListener {
	private JTextField tfSWName;
	private JTextField tfSupplyPrice;
	private JTextField tfSalePrice;
	private JButton btnSWImgUp;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareRegister() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(Color.WHITE);
		pRegister.setBounds(0, 0, 877, 183);
		add(pRegister);
		pRegister.setLayout(null);
		
		JLabel lblSWImg = new JLabel("");
		lblSWImg.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSWImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSWImg.setBounds(22, 10, 143, 134);
		pRegister.add(lblSWImg);
		
		btnSWImgUp = new JButton("이미지 등록");
		btnSWImgUp.addActionListener(this);
		btnSWImgUp.setBounds(48, 154, 97, 23);
		pRegister.add(btnSWImgUp);
		
		JLabel lblPCName = new JLabel("공급회사");
		lblPCName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPCName.setBounds(217, 25, 57, 15);
		pRegister.add(lblPCName);
		
		JComboBox cmbSearchPC = new JComboBox();
		cmbSearchPC.setBounds(299, 18, 149, 29);
		pRegister.add(cmbSearchPC);
		
		JLabel lblCalssify = new JLabel("분류");
		lblCalssify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalssify.setBounds(440, 25, 57, 15);
		pRegister.add(lblCalssify);
		
		JComboBox cmbCF = new JComboBox();
		cmbCF.setBounds(523, 18, 97, 29);
		pRegister.add(cmbCF);
		
		JLabel lblSWName = new JLabel("품목명");
		lblSWName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSWName.setBounds(217, 66, 57, 15);
		pRegister.add(lblSWName);
		
		tfSWName = new JTextField();
		tfSWName.setBounds(299, 57, 134, 29);
		pRegister.add(tfSWName);
		tfSWName.setColumns(10);
		
		JLabel lblSupplyPrice = new JLabel("공급가격");
		lblSupplyPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSupplyPrice.setBounds(217, 142, 57, 15);
		pRegister.add(lblSupplyPrice);
		
		tfSupplyPrice = new JTextField();
		tfSupplyPrice.setColumns(10);
		tfSupplyPrice.setBounds(299, 135, 120, 29);
		pRegister.add(tfSupplyPrice);
		
		JLabel lblSalePrice = new JLabel("판매가격");
		lblSalePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalePrice.setBounds(217, 103, 57, 15);
		pRegister.add(lblSalePrice);
		
		tfSalePrice = new JTextField();
		tfSalePrice.setBounds(299, 96, 120, 29);
		pRegister.add(tfSalePrice);
		tfSalePrice.setColumns(10);
		
		JButton btnSubmitSW = new JButton("등록");
		btnSubmitSW.setBounds(665, 154, 97, 23);
		pRegister.add(btnSubmitSW);
		
		JButton btnCancelSW = new JButton("취소");
		btnCancelSW.setBounds(768, 154, 97, 23);
		pRegister.add(btnCancelSW);
		
		JButton btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.setBounds(632, 21, 97, 23);
		pRegister.add(btnSubmitCF);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSWImgUp) {
			actionPerformedBtnSWImgUp(e);
		}
	}
	protected void actionPerformedBtnSWImgUp(ActionEvent e) {
	}
}
