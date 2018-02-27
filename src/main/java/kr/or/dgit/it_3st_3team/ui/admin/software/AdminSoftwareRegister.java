package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminSoftwareRegister extends JPanel implements ActionListener {
	private JFileChooser chooser;
	private JButton btnSubmitCF;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareRegister() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(new Color(240, 240, 240));
		pRegister.setBounds(0, 0, 1200, 191);
		add(pRegister);
		pRegister.setLayout(null);
		
		btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.addActionListener(this);
		btnSubmitCF.setBounds(779, 29, 97, 23);
		pRegister.add(btnSubmitCF);
		
		LblCmbStringComp pCompany = new LblCmbStringComp("공급회사");
		pCompany.setBorder(null);
		pCompany.setBounds(238, 27, 243, 30);
		pRegister.add(pCompany);

		LblCmbStringComp pSWsort = new LblCmbStringComp("분류");
		pSWsort.setBounds(556, 27, 183, 30);
		pRegister.add(pSWsort);

		
		ImageComp pRegisterImg = new ImageComp();
		pRegisterImg.setBounds(0, 0, 205, 191);
		pRegister.add(pRegisterImg);
		
		LblTfComp pSWName = new LblTfComp("품목 명");
		pSWName.setBounds(541, 73, 340, 30);
		pRegister.add(pSWName);
		
		LblTfComp pSupplyPrice = new LblTfComp("공급 가격");
		pSupplyPrice.setBounds(239, 120, 242, 30);
		pRegister.add(pSupplyPrice);
		
		LblTfComp pSalePrice = new LblTfComp("판매 가격");
		pSalePrice.setBounds(238, 73, 243, 30);
		pRegister.add(pSalePrice);
		
		LblTfComp panel = new LblTfComp("수량");
		panel.setBounds(556, 120, 126, 30);
		pRegister.add(panel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmitCF) {
			actionPerformedBtnSubmitCF(e);
		}
	}
	protected void actionPerformedBtnSubmitCF(ActionEvent e) {
		SoftwareGroupUI softwareGroupUI = new SoftwareGroupUI();
		softwareGroupUI.setVisible(true);
	}
}
