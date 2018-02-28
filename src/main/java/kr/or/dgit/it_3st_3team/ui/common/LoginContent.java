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
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.AdminUI;
import kr.or.dgit.it_3st_3team.ui.FindIdPwUI;
import kr.or.dgit.it_3st_3team.ui.JoinUI;
import kr.or.dgit.it_3st_3team.ui.UserCompanyUI;
import kr.or.dgit.it_3st_3team.ui.UserCustomerUI;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class LoginContent extends JPanel implements ActionListener {
	private JButton btnSignIn;
	private LblTfComp pID;
	private LblPwdTfComp pPW;
	private JButton btnJoinIn;
	private JButton btnSearchIDPW;
	private JButton btnCompany;
	private JButton btnCustomer;

	private JCheckBox chkManager;


	public LoginContent() {
		initComponents();
	}

	private void initComponents() {
		setBounds(new Rectangle(0, 0, 1500, 900));
		setLayout(new BorderLayout(0, 0));

		JPanel pLogin = new JPanel();
		pLogin.setBackground(Color.WHITE);
		pLogin.setBounds(new Rectangle(0, 0, 1500, 900));
		add(pLogin);
		pLogin.setLayout(null);

		pID = new LblTfComp("userID");
		pID.setFont(new Font("Gulim", Font.PLAIN, 12));
		pID.setBounds(576, 409, 347, 51);
		pLogin.add(pID);

		pPW = new LblPwdTfComp("password");
		pPW.setBounds(556, 481, 367, 51);
		pLogin.add(pPW);

		JPanel pCheck = new JPanel();
		pCheck.setLayout(null);
		pCheck.setBackground(Color.WHITE);
		pCheck.setBounds(636, 557, 255, 33);
		pLogin.add(pCheck);

		btnSignIn = new JButton("로그인");
		btnSignIn.addActionListener(this);
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnSignIn.setBackground(Color.WHITE);
		btnSignIn.setBounds(28, 5, 78, 23);
		pCheck.add(btnSignIn);

		chkManager = new JCheckBox("관리자 로그인");
		chkManager.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		chkManager.setBackground(Color.WHITE);
		chkManager.setBounds(127, 5, 95, 23);
		pCheck.add(chkManager);

		JPanel pRegister = new JPanel();
		pRegister.setBackground(Color.WHITE);
		pRegister.setBounds(576, 612, 367, 56);
		pLogin.add(pRegister);
		pRegister.setLayout(null);

		btnJoinIn = new JButton("회원 가입");
		btnJoinIn.addActionListener(this);
		btnJoinIn.setBackground(Color.WHITE);
		btnJoinIn.setBounds(34, 10, 114, 23);
		pRegister.add(btnJoinIn);

		btnSearchIDPW = new JButton("아이디/비밀번호 찾기");
		btnSearchIDPW.addActionListener(this);
		btnSearchIDPW.setBackground(Color.WHITE);
		btnSearchIDPW.setBounds(173, 10, 159, 23);
		pRegister.add(btnSearchIDPW);

		JLabel lblSubject = new JLabel("DGIT SW sales program");
		lblSubject.setFont(new Font("다음_Regular", Font.PLAIN, 43));
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setBounds(333, 131, 781, 121);
		pLogin.add(lblSubject);


		btnCompany = new JButton("공급회사 로그인");
		btnCompany.addActionListener(this);
		btnCompany.setForeground(Color.BLACK);
		btnCompany.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnCompany.setBackground(Color.WHITE);
		btnCompany.setBounds(424, 557, 196, 23);
		pLogin.add(btnCompany);

		btnCustomer = new JButton("고객 로그인");
		btnCustomer.addActionListener(this);
		btnCustomer.setForeground(Color.BLACK);
		btnCustomer.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnCustomer.setBackground(Color.WHITE);
		btnCustomer.setBounds(348, 514, 196, 23);
		pLogin.add(btnCustomer);
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
		String id = pID.getTfText();
		String password = pPW.getTfText();

		if (chkManager.isSelected()) {
			// 관리자
			Admin loginUser = AdminService.getInstance().findAdminByLogin(new Admin(id, password));
			if (isLogin(loginUser)) {
				AdminUI Adminsw = new AdminUI(loginUser);
				Adminsw.setVisible(true);
			}
		} else {
			User loginUser = UserService.getInstance().findUserByLogin(new User(id, password));
			if (isLogin(loginUser)) {
				if (loginUser.getUserGroup().equals(UserGroup.CUSTOMER)) {
					// 고객
					UserCustomerUI userUI = new UserCustomerUI(loginUser);
					userUI.setVisible(true);
				} else {
					// 공급회사
					UserCompanyUI userUI = new UserCompanyUI(loginUser);
					userUI.setVisible(true);
				}
			}
		}

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
