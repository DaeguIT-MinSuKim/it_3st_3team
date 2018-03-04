package kr.or.dgit.it_3st_3team.ui.admin.user;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.SearchPostUI;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminComp;
import kr.or.dgit.it_3st_3team.ui.component.LblAddressComp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private LblCmbAdminComp pUsereAdmin;
	private LblPwdTfComp pZipcode;
	private LblAddressComp pAddress;
	
	private boolean checkDupId = false;

	public AdminUserRegister() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1178, 250);

		ImageComp pImgArea = new ImageComp();
		pImgArea.setBounds(12, 10, 200, 230);
		add(pImgArea);

		JPanel pInfo = new JPanel();
		pInfo.setBounds(235, 10, 931, 230);
		pInfo.setLayout(null);
		add(pInfo);

		pUserId = new LblTfComp("아이디");
		pUserId.setBounds(103, 10, 180, 30);
		pInfo.add(pUserId);
		
		btnDuplId = new JButton("중복확인");
		btnDuplId.addActionListener(this);
		btnDuplId.setBounds(295, 10, 90, 30);
		pInfo.add(btnDuplId);
		
		pUserPwd = new LblPwdTfComp("비밀번호");
		pUserPwd.setBounds(91, 50, 263, 30);
		pInfo.add(pUserPwd);

		pUserPwdChk = new LblPwdTfComp("비밀번호 확인");
		pUserPwdChk.setBounds(63, 90, 291, 30);
		pInfo.add(pUserPwdChk);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(103, 130, 288, 30);
		pInfo.add(pUserName);

		pUserPhone = new LblTfComp("전화번호");
		pUserPhone.setBounds(91, 170, 263, 30);
		pInfo.add(pUserPhone);

		pUsereAdmin = new LblCmbAdminComp("담당자");
		pUsereAdmin.setBackground(new Color(255, 255, 255));
		pUsereAdmin.setBounds(528, 10, 245, 30);
		pInfo.add(pUsereAdmin);

		// 담당자 콤보박스에 데이터 넣기
		List<Admin> aList = AdminService.getInstance().selectAdminAll();
		Admin[] arrAdmin = aList.toArray(new Admin[aList.size()]);
		pUsereAdmin.loadData(arrAdmin);

		pZipcode = new LblPwdTfComp("우편번호");
		pZipcode.setBounds(516, 50, 180, 30);
		pZipcode.setTfEnable(false);
		pInfo.add(pZipcode);

		pAddress = new LblAddressComp("상세주소");
		pAddress.setBounds(516, 90, 300, 70);
		pInfo.add(pAddress);

		btnZipcodeSearch = new JButton("검색");
		btnZipcodeSearch.addActionListener(this);
		btnZipcodeSearch.setBounds(708, 50, 80, 30);
		pInfo.add(btnZipcodeSearch);

		btnUserOK = new JButton("등록");
		btnUserOK.addActionListener(this);
		btnUserOK.setBounds(719, 190, 97, 30);
		pInfo.add(btnUserOK);
	}

	public void actionPerformed(ActionEvent e) {
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
		if ( ! checkDupId) {
			JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
			return;
		}
		if (pUserPwd.isTfEmpty("비밀번호를 입력해주세요.")) {
			return;
		}
		if (pUserPwdChk.isTfEmpty("비밀번호를 한번 더 입력해주세요.")) {
			return;
		}
		if (pUserName.isTfEmpty("상호명을 입력해주세요.")) {
			return;
		}
		if (pUserPhone.isTfEmpty("전화번호를 입력해주세요.")) {
			return;
		}
		JOptionPane.showMessageDialog(null, "등록 및 수정 버튼");
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
		postUI.setVisible(true);
	}
}
