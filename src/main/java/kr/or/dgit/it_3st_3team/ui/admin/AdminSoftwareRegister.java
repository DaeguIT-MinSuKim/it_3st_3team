package kr.or.dgit.it_3st_3team.ui.admin;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.SoftwareSortCombobox;
import kr.or.dgit.it_3st_3team.ui.component.UserLabelComboxComponent;

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
		
		JButton btnSubmitCF = new JButton("분류 등록");
		btnSubmitCF.setBounds(820, 27, 97, 23);
		pRegister.add(btnSubmitCF);
		
		UserLabelComboxComponent panel = new UserLabelComboxComponent("공급 회사");
		panel.setBorder(null);
		panel.setBounds(274, 23, 243, 30);
		pRegister.add(panel);
		
		ImageComponent panel_3 = new ImageComponent();
		panel_3.setBounds(0, 0, 205, 183);
		panel_3.setImagesIcon("nobody.png");
		pRegister.add(panel_3);
		
		SoftwareSortCombobox panel_1 = new SoftwareSortCombobox("분류");
		panel_1.setBounds(603, 23, 205, 30);
		pRegister.add(panel_1);
		
		LabelTextFieldComponent panel_2 = new LabelTextFieldComponent("공급 가격");
		panel_2.setBounds(274, 74, 243, 30);
		pRegister.add(panel_2);
		
		LabelTextFieldComponent panel_4 = new LabelTextFieldComponent("판매 가격");
		panel_4.setBounds(274, 124, 243, 30);
		pRegister.add(panel_4);
		
		LabelTextFieldComponent panel_5 = new LabelTextFieldComponent("품목명");
		panel_5.setBounds(590, 74, 327, 30);
		pRegister.add(panel_5);
	}

}
