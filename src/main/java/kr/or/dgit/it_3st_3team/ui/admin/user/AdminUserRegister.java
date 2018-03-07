package kr.or.dgit.it_3st_3team.ui.admin.user;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.SearchPostUI;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblAddressComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

@SuppressWarnings("serial")
public class AdminUserRegister extends JPanel implements ActionListener {
	private JButton btnUserOK;
	private JButton btnDuplId;
	private JButton btnZipcodeSearch;
	private LblTfComp pUserId;
	private LblPwdTfComp pUserPwd;
	private LblPwdTfComp pUserPwdChk;
	private LblTfComp pUserName;
	private LblTfComp pUserPhone;
	private LblCmbAdminComp pUserAdmin;
	private LblTfComp pZipcode;
	private LblAddressComp pAddress;

	private boolean checkDupId = false;
	private LblTfComp pUserEmail;
	private LblCmbStringComp pUserGroup;
	private ImageComp pImgArea;
	private JButton btnCancel;
	
	private AdminUserContent parent;

	public AdminUserRegister() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1178, 250);

		pImgArea = new ImageComp();
		pImgArea.setBounds(12, 10, 180, 230);
		add(pImgArea);

		JPanel pInfo = new JPanel();
		pInfo.setBounds(204, 10, 962, 230);
		pInfo.setLayout(null);
		add(pInfo);

		pUserId = new LblTfComp("아이디");
		pUserId.setBounds(65, 10, 180, 30);
		pInfo.add(pUserId);

		btnDuplId = new JButton("중복확인");
		btnDuplId.addActionListener(this);
		btnDuplId.setBounds(257, 10, 90, 30);
		pInfo.add(btnDuplId);

		pUserPwd = new LblPwdTfComp("비밀번호");
		pUserPwd.setBounds(53, 51, 263, 30);
		pInfo.add(pUserPwd);

		pUserPwdChk = new LblPwdTfComp("비밀번호 확인");
		pUserPwdChk.setBounds(387, 51, 291, 30);
		pInfo.add(pUserPwdChk);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(65, 131, 288, 30);
		pInfo.add(pUserName);

		pUserPhone = new LblTfComp("전화번호");
		pUserPhone.setBounds(53, 171, 263, 30);
		pInfo.add(pUserPhone);

		pUserAdmin = new LblCmbAdminComp("담당자");
		pUserAdmin.setBackground(new Color(255, 255, 255));
		pUserAdmin.setBounds(699, 10, 200, 30);
		pInfo.add(pUserAdmin);

		// 담당자 콤보박스에 데이터 넣기
		List<Admin> aList = AdminService.getInstance().selectAdminAll();
		Admin[] arrAdmin = aList.toArray(new Admin[aList.size()]);
		pUserAdmin.loadData(arrAdmin);

		pUserEmail = new LblTfComp("이메일");
		pUserEmail.setBounds(65, 91, 287, 30);
		pInfo.add(pUserEmail);

		pZipcode = new LblTfComp("우편번호");
		pZipcode.setBounds(416, 93, 180, 30);
		pZipcode.setTfEditable(false);
		pInfo.add(pZipcode);

		pAddress = new LblAddressComp("상세주소");
		pAddress.setBounds(416, 132, 300, 70);
		pInfo.add(pAddress);

		btnZipcodeSearch = new JButton("검색");
		btnZipcodeSearch.addActionListener(this);
		btnZipcodeSearch.setBounds(608, 93, 80, 30);
		pInfo.add(btnZipcodeSearch);

		btnUserOK = new JButton("등록");
		btnUserOK.addActionListener(this);
		btnUserOK.setBounds(742, 161, 90, 40);
		pInfo.add(btnUserOK);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(844, 161, 90, 40);
		pInfo.add(btnCancel);

		pUserGroup = new LblCmbStringComp("사용자 그룹");
		pUserGroup.setBounds(400, 10, 208, 30);
		pUserGroup.setCmbEventListener(uGroupItemListener);
		pInfo.add(pUserGroup);

		String[] arrUserGroup = new String[] { "공급회사", "일반회원" };
		pUserGroup.loadData(arrUserGroup);
	}

	private ItemListener uGroupItemListener = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem().equals("일반회원")) {
					pUserAdmin.setVisible(false);
				} else {
					pUserAdmin.setVisible(true);
				}
			}
		}
	};

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnZipcodeSearch) {
			actionPerformedBtnZipcodeSearch(e);
		}
		if (e.getSource() == btnDuplId) {
			actionPerformedBtnDuplId(e);
		}
		if (e.getSource() == btnUserOK) {
			actionPerformedBtnUserOK(e);
		}
	}

	// 사용자 등록 및 수정 버튼
	protected void actionPerformedBtnUserOK(ActionEvent e) {
		if (pUserId.isTfEmpty("아이디를 입력해주세요.")) {
			return;
		}
		if (!checkDupId) {
			JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
			return;
		}
		if (pUserPwd.isVisible() && pUserPwd.isTfEmpty("비밀번호를 입력해주세요.")) {
			return;
		}
		if (pUserPwdChk.isVisible() && pUserPwdChk.isTfEmpty("비밀번호를 한번 더 입력해주세요.")) {
			return;
		}
		if (!CommonUtil.getInstance().checkPwd(pUserPwd.getPwdField(), pUserPwd.getPwdField())) {
			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
			pUserPwd.setTfText("");
			pUserPwd.requestTfFocus();
			return;
		}

		String email = pUserEmail.getTfText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_EMAIL, email)) {
			JOptionPane.showMessageDialog(null, "이메일 형식이 아닙니다. ex) aaa@test.com");
			pUserEmail.setTfText("");
			pUserEmail.requestTfFocus();
			return;
		}
		
		if (pUserName.isTfEmpty("상호명을 입력해주세요.")) {
			return;
		}
		if (pUserPhone.isTfEmpty("전화번호를 입력해주세요.")) {
			return;
		}
		String phone = pUserPhone.getTfText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_PHONE, phone)) {
			JOptionPane.showMessageDialog(null, "전화번호 형식이 아닙니다. ex) 02-223-1123, 022231122");
			pUserPhone.setTfText("");
			pUserPhone.requestTfFocus();
			return;
		}
		System.out.println(phone);
		phone = CommonUtil.getInstance().phoneNumberHyphenAdd(phone, false);
		pUserPhone.setTfText(phone);
		System.out.println(phone);
		
		String id = pUserId.getTfText().trim();
		String pwd = pUserPwd.getTfText().trim();
		String name = pUserName.getTfText().trim();
		// 담당자가 보이면 공급회사고 공급회사는 담당자 선택에 의해 지정
		// 아니라면 일반회원이고 무조건 총관리자가 담당.
		Admin admin = new Admin(1);
		if (pUserAdmin.isVisible()) {
			admin = (Admin) pUserAdmin.getCmbSelectItem();
		}
		
		String zipcode = pZipcode.getTfText().trim();
		String addr1 = pAddress.getTfAddress1();
		String addr2 = "";
		if (!zipcode.equals("") && !addr1.equals("")) {
			addr2 = pAddress.getTfAddress2();
		}

		User user = new User();
		user.setUserId(id);
		user.setUserPwd(pwd);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(new PhoneNumber(phone));
		user.setZipcode(zipcode);
		user.setAddr1(addr1);
		user.setAddr2(addr2);
		user.setAdmin(admin);

		String uGroup = (String) pUserGroup.getCmbSelectItem();
		if (uGroup.equals("일반회원")) {
			user.setUserGroup(UserGroup.CUSTOMER);
		} else {
			user.setUserGroup(UserGroup.COMPANY);
		}

		String userImgFullPath = pImgArea.getImageIcon().toString();
		user.setAvatar(new File(userImgFullPath).getName());

		String commandType = e.getActionCommand();
		String commandMessage = String.format("사용자 %s", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("%s을 하시겠습니까?", commandMessage), commandMessage,
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}

		CommonUtil.getInstance().userImgSave(userImgFullPath);
		if (commandType.equals("등록")) {
			result = UserService.getInstance().addUser(user);
		} else {
			result = UserService.getInstance().modifyUser(user);
		}
		if (result != 1) {
			JOptionPane.showMessageDialog(null, String.format("%s에 실패하였습니다.", commandMessage));
			return;
		}
		JOptionPane.showMessageDialog(null, String.format("%s이 완료되었습니다.", commandMessage));

		parent.reFreshUserList();
		resetData();
	}

	public void resetData() {
		pImgArea.setImageIcon("nobody.png");
		pUserId.setTfText("");
		pUserId.setTfEditable(true);
		checkDupId = false;
		btnDuplId.setVisible(true);
		pUserPwd.setTfText("");
		pUserPwd.setVisible(true);
		pUserPwdChk.setTfText("");
		pUserPwdChk.setVisible(true);
		pUserName.setTfText("");
		pUserPhone.setTfText("");
		pUserEmail.setTfText("");
		pZipcode.setTfText("");
		pAddress.resetTfAddress();
		pUserAdmin.setCmbSelectIndex(0);
		pUserGroup.setCmbSelectIndex(0);
		btnUserOK.setText("등록");
		btnCancel.setText("취소");
	}

	public void setUserData(User user) {
		if (user.getAvatar() != null && !user.getAvatar().equals("")) {
			pImgArea.setImageIcon(user.getAvatar());
		} else {
			pImgArea.setImageIcon("nobody.png");
		}
		pUserId.setTfText(user.getUserId());
		pUserId.setTfEditable(false);
		checkDupId = true;
		btnDuplId.setVisible(false);
		pUserPwd.setVisible(false);
		pUserPwdChk.setVisible(false);
		pUserName.setTfText(user.getName());
		pUserPhone.setTfText(user.getPhone().toString());
		pUserEmail.setTfText(user.getEmail());
		pZipcode.setTfText(user.getZipcode());
		pAddress.setTfAddress1(user.getAddr1());
		pAddress.setTfAddress2(user.getAddr2());
		System.out.println(user.getAdmin());
		pUserAdmin.setCmbSelectItem(user.getAdmin());
		if (user.getUserGroup() == UserGroup.COMPANY) {
			pUserGroup.setCmbSelectIndex(0);
		} else {
			pUserGroup.setCmbSelectIndex(1);
		}
		btnUserOK.setText("수정");
		btnCancel.setText("수정취소");
	}

	// 중복아이디 체크
	protected void actionPerformedBtnDuplId(ActionEvent e) {
		if (pUserId.isTfEmpty("아이디를 입력해주세요.")) {
			return;
		}
		String joinId = pUserId.getTfText();
		if (UserService.getInstance().findUserById(new User(joinId)) != null) {
			checkDupId = false;
			JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
			pUserId.setTfText("");
			pUserId.requestTfFocus();
			return;
		} else {
			checkDupId = true;
			JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
			pUserPwd.requestTfFocus();
			return;
		}
	}

	// 우편번호 검색
	protected void actionPerformedBtnZipcodeSearch(ActionEvent e) {
		SearchPostUI postUI = new SearchPostUI();
		// 우편번호 필드, 주소 필드를 넘겨줌.
		postUI.setParentInComp(pZipcode, pAddress);
		postUI.setVisible(true);
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		resetData();
	}
	
	public void setParent(AdminUserContent adminUserContent) {
		this.parent = adminUserContent;
	}
}
