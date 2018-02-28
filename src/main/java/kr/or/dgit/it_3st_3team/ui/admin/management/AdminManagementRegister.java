package kr.or.dgit.it_3st_3team.ui.admin.management;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;


import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;

import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.AbstractLblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnIdChkComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminGroupComp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminManagementRegister extends JPanel implements ActionListener {
	private JButton btnAdminGroup;

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
		pInput.setBounds(212, 10, 900, 230);
		add(pInput);

		LblTfBtnIdChkComp pAdminId = new LblTfBtnIdChkComp("아이디", "중복확인");
		pAdminId.setBounds(72, 16, 312, 30);
		pInput.add(pAdminId);
		
		LblPwdTfComp pAdminPwd = new LblPwdTfComp("비밀번호");
		pAdminPwd.setBounds(58, 67, 222, 30);
		pInput.add(pAdminPwd);
		
		LblPwdTfComp pAdminPwdChk = new LblPwdTfComp("비밀번호 확인");
		pAdminPwdChk.setBounds(383, 67, 240, 30);
		pInput.add(pAdminPwdChk);
		
		LblTfComp pAdminName = new LblTfComp("이름");
		pAdminName.setBounds(82, 118, 198, 30);
		pInput.add(pAdminName);
		
		LblTfComp pAdminPhone = new LblTfComp("전화번호");
		pAdminPhone.setBounds(413, 118, 210, 30);
		pInput.add(pAdminPhone);

		AdminGroup[] agDatas = {new AdminGroup(1, "관리자", AdminGroupAuth.ADMINISTRATOR), new AdminGroup(2, "영업", AdminGroupAuth.SALESMAN)};


		LblCmbAdminGroupComp pAdminGroup = new LblCmbAdminGroupComp("직책");
		pAdminGroup.loadData(agDatas);

		pAdminGroup.setBounds(82, 167, 198, 30);
		pInput.add(pAdminGroup);
		
		btnAdminGroup = new JButton("등록");
		btnAdminGroup.addActionListener(this);
		btnAdminGroup.setBounds(658, 190, 97, 30);
		pInput.add(btnAdminGroup);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(767, 190, 97, 30);
		pInput.add(btnCancel);
		
		JButton btnOK = new JButton("직책등록");
		btnOK.setBounds(292, 167, 80, 30);
		pInput.add(btnOK);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdminGroup) {
			actionPerformedBtnAdminGroup(e);
		}
	}
	protected void actionPerformedBtnAdminGroup(ActionEvent e) {
	}
}
