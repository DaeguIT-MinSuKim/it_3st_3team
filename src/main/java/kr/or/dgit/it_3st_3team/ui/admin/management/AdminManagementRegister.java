package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

import kr.or.dgit.it_3st_3team.ui.component.ImageComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelInputBtnComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelPwdFieldComponent;
import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.component.AdminGroupComboComponent;

@SuppressWarnings("serial")
public class AdminManagementRegister extends JPanel {

	public AdminManagementRegister() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		ImageComponent pImg = new ImageComponent();
		pImg.setBounds(12, 10, 188, 230);
		add(pImg);

		JPanel pInput = new JPanel();
		pInput.setBackground(Color.WHITE);
		pInput.setLayout(null);
		pInput.setBounds(212, 10, 552, 230);
		add(pInput);

		LabelInputBtnComponent pAdminId = new LabelInputBtnComponent("아이디", "중복확인");
		pAdminId.setBounds(36, 10, 312, 30);
		pInput.add(pAdminId);
		
		LabelPwdFieldComponent pAdminPwd = new LabelPwdFieldComponent("비밀번호");
		pAdminPwd.setBounds(24, 50, 222, 30);
		pInput.add(pAdminPwd);
		
		LabelPwdFieldComponent pAdminPwdChk = new LabelPwdFieldComponent("비밀번호 확인");
		pAdminPwdChk.setBounds(292, 50, 240, 30);
		pInput.add(pAdminPwdChk);
		
		LabelTextFieldComponent pAdminName = new LabelTextFieldComponent("이름");
		pAdminName.setBounds(48, 88, 198, 30);
		pInput.add(pAdminName);
		
		LabelTextFieldComponent pAdminPhone = new LabelTextFieldComponent("전화번호");
		pAdminPhone.setBounds(320, 89, 210, 30);
		pInput.add(pAdminPhone);
		
		AdminGroup[] agDatas = {new AdminGroup(1, "관리자", AdminGroupAuth.ADMINISTRATOR), new AdminGroup(2, "영업", AdminGroupAuth.SALESMAN)};
		AdminGroupComboComponent pAdminGroup = new AdminGroupComboComponent("직책");
		pAdminGroup.loadData(agDatas);
		pAdminGroup.setBounds(48, 138, 198, 30);
		pInput.add(pAdminGroup);
		
		JButton btnAdminGroup = new JButton("등록");
		btnAdminGroup.setBounds(320, 192, 97, 30);
		pInput.add(btnAdminGroup);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(429, 192, 97, 30);
		pInput.add(btnCancel);
		
		JButton btnOK = new JButton("직책등록");
		btnOK.setBounds(266, 138, 80, 30);
		pInput.add(btnOK);
	}
	
	
}
