package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.StringLabelComboxComp;

public class AdminSoftwareRegister extends JPanel {
	private JFileChooser chooser;

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
		pRegister.setBounds(0, 0, 1200, 183);
		add(pRegister);
		pRegister.setLayout(null);
		
		JButton btnSubmitSW = new JButton("등록");
		btnSubmitSW.setBounds(965, 154, 97, 23);
		pRegister.add(btnSubmitSW);
		
		JButton btnCancelSW = new JButton("취소");
		btnCancelSW.setBounds(1068, 154, 97, 23);
		pRegister.add(btnCancelSW);
		
		JButton btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.setBounds(779, 29, 97, 23);
		pRegister.add(btnSubmitCF);
		
		StringLabelComboxComp pCompany = new StringLabelComboxComp("공급회사");
		pCompany.setBorder(null);
		pCompany.setBounds(238, 27, 243, 30);
		pRegister.add(pCompany);
		
		StringLabelComboxComp pSWsort = new StringLabelComboxComp("분류 회사");
		pSWsort.setBounds(528, 26, 243, 30);
		pRegister.add(pSWsort);
		
		ImageComponent pRegisterImg = new ImageComponent();
		pRegisterImg.setBounds(0, 0, 196, 183);
		pRegister.add(pRegisterImg);
		
		LabelTextFieldComponent pSWName = new LabelTextFieldComponent("품목 명");
		pSWName.setBounds(538, 66, 340, 30);
		pRegister.add(pSWName);
		
		LabelTextFieldComponent pSupplyPrice = new LabelTextFieldComponent("공급 가격");
		pSupplyPrice.setBounds(239, 120, 242, 30);
		pRegister.add(pSupplyPrice);
		
		LabelTextFieldComponent pSalePrice = new LabelTextFieldComponent("판매 가격");
		pSalePrice.setBounds(238, 73, 243, 30);
		pRegister.add(pSalePrice);
	}

	
}
