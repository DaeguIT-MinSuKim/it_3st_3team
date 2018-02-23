package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelInputBtnComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelPwdFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.StringLabelAddressComp;

@SuppressWarnings("serial")
public class UserInfoContent extends JPanel {
	private ImageComponent pImg;
	private LabelTextFieldComponent pUserId;
	private LabelPwdFieldComponent pUserPwd;
	private LabelPwdFieldComponent pUserPwdChk;
	private LabelTextFieldComponent pUserName;
	private LabelTextFieldComponent pUserPhone;
	private LabelInputBtnComponent pZipcode;
	private StringLabelAddressComp pAddress;

	public UserInfoContent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		pImg = new ImageComponent();
		pImg.setBounds(12, 10, 181, 230);
		add(pImg);

		pUserId = new LabelTextFieldComponent("아이디");
		pUserId.setBounds(244, 10, 239, 38);
		add(pUserId);

		pUserPwd = new LabelPwdFieldComponent("비밀번호");
		pUserPwd.setBounds(232, 58, 251, 38);
		add(pUserPwd);

		pUserPwdChk = new LabelPwdFieldComponent("비밀번호 확인");
		pUserPwdChk.setBounds(204, 109, 280, 38);
		add(pUserPwdChk);

		pUserName = new LabelTextFieldComponent("상호명");
		pUserName.setBounds(243, 157, 240, 38);
		add(pUserName);

		pUserPhone = new LabelTextFieldComponent("전화번호");
		pUserPhone.setBounds(231, 208, 252, 38);
		add(pUserPhone);

		pZipcode = new LabelInputBtnComponent("우편번호", "검색");
		pZipcode.setBounds(231, 258, 237, 38);
		add(pZipcode);

		pAddress = new StringLabelAddressComp("주소");
		pAddress.setBounds(254, 306, 333, 84);
		add(pAddress);
	}

}
