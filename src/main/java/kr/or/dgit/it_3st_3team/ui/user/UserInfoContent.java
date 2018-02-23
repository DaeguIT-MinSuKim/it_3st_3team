package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLabelAddressComp;

@SuppressWarnings("serial")
public class UserInfoContent extends JPanel {
	private ImageComp pImg;
	private LblTfComp pUserId;
	private LblPwdTfComp pUserPwd;
	private LblPwdTfComp pUserPwdChk;
	private LblTfComp pUserName;
	private LblTfComp pUserPhone;
	private LblTfBtnComp pZipcode;
	private StringLabelAddressComp pAddress;

	public UserInfoContent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		pImg = new ImageComp();
		pImg.setBounds(12, 10, 181, 230);
		add(pImg);

		pUserId = new LblTfComp("아이디");
		pUserId.setBounds(244, 10, 239, 38);
		add(pUserId);

		pUserPwd = new LblPwdTfComp("비밀번호");
		pUserPwd.setBounds(232, 58, 251, 38);
		add(pUserPwd);

		pUserPwdChk = new LblPwdTfComp("비밀번호 확인");
		pUserPwdChk.setBounds(204, 109, 280, 38);
		add(pUserPwdChk);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(243, 157, 240, 38);
		add(pUserName);

		pUserPhone = new LblTfComp("전화번호");
		pUserPhone.setBounds(231, 208, 252, 38);
		add(pUserPhone);

		pZipcode = new LblTfBtnComp("우편번호", "검색");
		pZipcode.setBounds(231, 258, 237, 38);
		add(pZipcode);

		pAddress = new StringLabelAddressComp("주소");
		pAddress.setBounds(254, 306, 333, 84);
		add(pAddress);
	}

}
