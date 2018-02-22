package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminGroupComp;


@SuppressWarnings("serial")
public class AdminManagementRegister extends JPanel {

	public AdminManagementRegister() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		ImageComp pImg = new ImageComp();
		pImg.setBounds(12, 10, 188, 230);
		add(pImg);

		JPanel pInput = new JPanel();
		pInput.setBackground(Color.WHITE);
		pInput.setLayout(null);
		pInput.setBounds(212, 10, 552, 230);
		add(pInput);

		LblTfBtnComp pAdminId = new LblTfBtnComp("아이디", "중복확인");
		pAdminId.setBounds(36, 10, 312, 30);
		pInput.add(pAdminId);
		
		LblPwdTfComp pAdminPwd = new LblPwdTfComp("비밀번호");
		pAdminPwd.setBounds(24, 50, 222, 30);
		pInput.add(pAdminPwd);
		
		LblPwdTfComp pAdminPwdChk = new LblPwdTfComp("비밀번호 확인");
		pAdminPwdChk.setBounds(292, 50, 240, 30);
		pInput.add(pAdminPwdChk);
		
		LblTfComp pAdminName = new LblTfComp("이름");
		pAdminName.setBounds(48, 88, 198, 30);
		pInput.add(pAdminName);
		
		LblTfComp pAdminPhone = new LblTfComp("전화번호");
		pAdminPhone.setBounds(320, 89, 210, 30);
		pInput.add(pAdminPhone);
		

		AdminGroup[] agDatas = {new AdminGroup(1, "관리자", AdminGroupAuth.ADMINISTRATOR), new AdminGroup(2, "영업", AdminGroupAuth.SALESMAN)};

		LblCmbAdminGroupComp pAdminGroup = new LblCmbAdminGroupComp("직책");
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
