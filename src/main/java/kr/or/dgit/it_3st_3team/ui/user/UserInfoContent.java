package kr.or.dgit.it_3st_3team.ui.user;


import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.component.AbstractLblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblAddressComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnPostSearchComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

@SuppressWarnings("serial")
public class UserInfoContent extends JPanel {
	private ImageComp pImg;
	private LblTfComp pUserId;
	private LblTfComp pUserName;
	private LblTfComp pUserPhone;
	private AbstractLblTfBtnComp pZipcode;
	private LblAddressComp pAddress;
	private LblTfComp pUserEmail;

	public UserInfoContent() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pImg = new ImageComp();
		pImg.setBounds(12, 10, 180, 230);
		add(pImg);

		pUserId = new LblTfComp("아이디");
		pUserId.setBounds(244, 10, 239, 38);
		add(pUserId);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(245, 61, 240, 38);
		add(pUserName);
		
		pUserEmail = new LblTfComp("이메일");
		pUserEmail.setBounds(244, 111, 240, 38);
		add(pUserEmail);

		pUserPhone = new LblTfComp("전화번호");
		pUserPhone.setBounds(233, 161, 252, 38);
		add(pUserPhone);

		pZipcode = new LblTfBtnPostSearchComp("우편번호", "검색");
		pZipcode.setBounds(233, 211, 237, 38);
		pZipcode.setTfEnable(false);
		add(pZipcode);

		pAddress = new LblAddressComp("주소");
		pAddress.setBounds(256, 261, 333, 84);
		add(pAddress);
	}

	public void setUserInfo(User user) {
		// TODO Auto-generated method stub
		//pImg.setImagesIcon(avatar);
		pImg.setImageIcon(user.getAvatar());
		pUserId.setTfText(user.getUserId());
		pUserId.setTfEnable(false);
		pUserName.setTfText(user.getName());
		pUserEmail.setTfText(user.getEmail());
		pUserPhone.setTfText(user.getPhone().toString());
		pZipcode.setTfText(user.getZipcode());
		pAddress.setTfAddress1(user.getAddr1());
		pAddress.setTfAddress2(user.getAddr2());
	}
	
	public User getUserInfo() {
		
		if (pUserName.isTfEmpty("상호명을 입력해주세요.")) {
			return null;
		}
		if (pUserEmail.isTfEmpty("이메일을 입력해주세요.")) {
			return null;
		}
		if (pUserPhone.isTfEmpty("전화번호를 입력해주세요.")) {
			return null;
		}
		String id = pUserId.getTfText().trim();
		String name = pUserName.getTfText().trim();
		
		String email = pUserEmail.getTfText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_EMAIL, email)) {
			JOptionPane.showMessageDialog(null, "이메일 형식이 아닙니다. ex) aaa@test.com");
			pUserEmail.setTfText("");
			pUserEmail.requestTfFocus();
			return null;
		}
		
		String phone = pUserPhone.getTfText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_PHONE, phone)) {
			JOptionPane.showMessageDialog(null, "전화번호 형식이 아닙니다. ex) 02-223-1123, 022231122");
			pUserPhone.setTfText("");
			pUserPhone.requestTfFocus();
			return null;
		}
		phone = CommonUtil.getInstance().phoneNumberHyphenAdd(phone, false);
		
		String zipcode = pZipcode.getTfText().trim();
		String addr1 = pAddress.getTfAddress1().trim();
		String addr2 = pAddress.getTfAddress2().trim();
		String avatar = pImg.getImageIcon();
		
		return new User(id, name, email, new PhoneNumber(phone), zipcode, addr1, addr2, avatar);
	}
}
