package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.AdminUI;
import kr.or.dgit.it_3st_3team.ui.FindIdPwUI;
import kr.or.dgit.it_3st_3team.ui.JoinUI;
import kr.or.dgit.it_3st_3team.ui.UserUI;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class LoginContent extends JPanel implements ActionListener {
	private JButton btnSignIn;
	private LblTfComp pID;
	private LblPwdTfComp pPW;
	private JButton btnJoinIn;
	private JButton btnSearchIDPW;
	private JCheckBox chkManager;

	public LoginContent() {
		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 900, 500);
		setLayout(new BorderLayout(0, 0));

		JPanel pLogin = new JPanel();
		pLogin.setBounds(0, 0, 900, 500);
		add(pLogin);
		pLogin.setLayout(null);

		pID = new LblTfComp("userID");
		pID.setBounds(281, 154, 300, 45);
		pLogin.add(pID);
		pID.setFont(new Font("Gulim", Font.PLAIN, 12));

		pPW = new LblPwdTfComp("password");
		pPW.setBounds(261, 215, 320, 45);
		pLogin.add(pPW);

		JPanel pCheck = new JPanel();
		pCheck.setLayout(null);
		pCheck.setBounds(310, 286, 255, 40);
		pLogin.add(pCheck);

		btnSignIn = new JButton("로그인");
		btnSignIn.addActionListener(this);
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnSignIn.setBounds(28, 5, 78, 30);
		pCheck.add(btnSignIn);

		chkManager = new JCheckBox("관리자 로그인");
		chkManager.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		chkManager.setBounds(128, 5, 95, 30);
		pCheck.add(chkManager);

		JPanel pRegister = new JPanel();
		pRegister.setBounds(261, 353, 367, 56);
		pLogin.add(pRegister);
		pRegister.setLayout(null);

		btnJoinIn = new JButton("회원 가입");
		btnJoinIn.addActionListener(this);
		btnJoinIn.setBounds(34, 10, 114, 30);
		pRegister.add(btnJoinIn);

		btnSearchIDPW = new JButton("아이디/비밀번호 찾기");
		btnSearchIDPW.addActionListener(this);
		btnSearchIDPW.setBounds(173, 10, 159, 30);
		pRegister.add(btnSearchIDPW);

		JLabel lblSubject = new JLabel("DGIT SW sales program");
		lblSubject.setFont(new Font("다음_Regular", Font.PLAIN, 43));
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setBounds(54, 23, 781, 121);
		pLogin.add(lblSubject);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchIDPW) {
			actionPerformedBtnSearchIDPW(e);
		}
		if (e.getSource() == btnJoinIn) {
			actionPerformedBtnJoinIn(e);
		}
		if (e.getSource() == btnSignIn) {
			actionPerformedButton(e);
		}
	}

	protected void actionPerformedButton(ActionEvent e) {
		if (isEmpty(pID.getTfText()) && isEmpty(pPW.getTfText())) {
			JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 비었습니다.");
			return;
		}
		String id = pID.getTfText();
		String password = pPW.getTfText();

		Object loginUser = null;
		if (chkManager.isSelected()) {
			// 관리자
			loginUser = AdminService.getInstance().findAdminByLogin(new Admin(id, password));
		} else {
			// 사용자
			loginUser = UserService.getInstance().findUserByLogin(new User(id, password));
		}
		if (isLogin(loginUser)) {
			if (loginUser instanceof Admin) {
				AdminUI showUI = new AdminUI((Admin) loginUser);
				showUI.setVisible(true);
			} else {
				UserUI showUI = new UserUI((User) loginUser);
				showUI.setVisible(true);
			}
			
			getTopLevelAncestor().setVisible(false);
		}
	}

	private boolean isEmpty(String value) {
		if (value.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isLogin(Object user) {
		if (user == null) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 사용자입니다. 다시 확인해주십시오.");
			return false;
		}
		return true;
	}

	protected void actionPerformedBtnJoinIn(ActionEvent e) {
		JoinUI joinUI = new JoinUI();
		joinUI.setVisible(true);
	}

	protected void actionPerformedBtnSearchIDPW(ActionEvent e) {
		FindIdPwUI findIdPwUI = new FindIdPwUI();
		findIdPwUI.setVisible(true);
	}
}
