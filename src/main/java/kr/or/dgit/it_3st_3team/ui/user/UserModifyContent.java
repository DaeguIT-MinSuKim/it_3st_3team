package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.UserUI;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;

@SuppressWarnings("serial")
public class UserModifyContent extends JPanel implements ActionListener {

	private UserInfoContent pUserInfo;
	private JButton btnModifyUserInfo;
	private JButton btnModifyPwdOK;
	private UserUI userUI;
	private LblPwdTfComp currentPwd;
	private LblPwdTfComp newPwd;
	private LblPwdTfComp newPwdChk;

	public UserModifyContent(UserUI userUI) {
		this.userUI = userUI;
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pUserInfo = new UserInfoContent();
		pUserInfo.setLayout(null);
		pUserInfo.setBounds(204, 79, 686, 420);
		add(pUserInfo);

		btnModifyUserInfo = new JButton("수정");
		btnModifyUserInfo.addActionListener(this);
		btnModifyUserInfo.setBounds(252, 380, 150, 30);
		pUserInfo.add(btnModifyUserInfo);

		JPanel pModifyPassword = new JPanel();
		pModifyPassword.setLayout(null);
		pModifyPassword.setBounds(204, 509, 686, 236);
		add(pModifyPassword);

		currentPwd = new LblPwdTfComp("현재 비밀번호");
		currentPwd.setBounds(178, 29, 280, 38);
		pModifyPassword.add(currentPwd);
		
		newPwd = new LblPwdTfComp("새 비밀번호");
		newPwd.setBounds(178, 77, 280, 38);
		pModifyPassword.add(newPwd);

		newPwdChk = new LblPwdTfComp("새 비밀번호 확인");
		newPwdChk.setBounds(150, 125, 308, 38);
		pModifyPassword.add(newPwdChk);

		

		btnModifyPwdOK = new JButton("수정");
		btnModifyPwdOK.addActionListener(this);
		btnModifyPwdOK.setBounds(254, 196, 150, 30);
		pModifyPassword.add(btnModifyPwdOK);
	}

	public UserInfoContent getUserPanel() {
		return pUserInfo;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModifyPwdOK) {
			actionPerformedBtnModifyPwdOK(e);
		}
		if (e.getSource() == btnModifyUserInfo) {
			actionPerformedBtnModifyUserInfo(e);
		}
	}

	// 개인정보 수정 버튼
	protected void actionPerformedBtnModifyUserInfo(ActionEvent e) {
		User modifyUser = pUserInfo.getUserInfo();
		String imgFullPath = modifyUser.getAvatar();
		String imgName = CommonUtil.getInstance().createRndImgName(imgFullPath, modifyUser.getUserId());
		modifyUser.setAvatar(imgName);
		
		if (UserService.getInstance().modifyUser(modifyUser) != 1) {
			JOptionPane.showMessageDialog(null, "회원정보 수정에 실패했습니다.");
			return;
		}
		CommonUtil.getInstance().userImgSave(imgFullPath, imgName);
		
		User changedUser = UserService.getInstance().findUserById(modifyUser);
		userUI.setUser(changedUser);
		userUI.setUserNameAndAvatar();
		JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
	}

	// 비밀번호 수정 버튼
	protected void actionPerformedBtnModifyPwdOK(ActionEvent e) {
		if (currentPwd.isTfEmpty("현재 비밀번호를 입력해주세요.")) {
			return;
		}
		if (newPwd.isTfEmpty("바꿀 비밀번호를 입력해주세요.")) {
			return;
		}
		if (newPwdChk.isTfEmpty("바꿀 비밀번호를 한번 더 입력해주세요.")) {
			return;
		}
		
		if ( ! newPwd.getTfText().equals(newPwdChk.getTfText())) {
			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
			newPwd.setTfText("");
			newPwd.requestTfFocus();
			return;
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("userId", userUI.getUser().getUserId());
		map.put("userPwd", currentPwd.getTfText());
		map.put("newPwd", newPwd.getTfText());
		if (UserService.getInstance().modifyUserPassword(map) != 1) {
			JOptionPane.showMessageDialog(null, "비밀번호를 갱신하지 못했습니다.");
			return;
		}
		JOptionPane.showMessageDialog(null, "비밀번호를 갱신하였습니다.");
	}
	
}
