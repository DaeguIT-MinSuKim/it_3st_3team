package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.listener.OpenActionListener;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JoinUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tfUserId;
	private JPasswordField pfUserPwd;
	private JPasswordField pfUserPwdChk;
	private JTextField tfUserName;
	private JTextField tfUserEmail;
	private JTextField tfUserPhone;
	private JRadioButton rdbtnCompany;
	private JRadioButton rdbtnUser;
	private JButton btnDuplId;
	private boolean checkDupId = false;
	private JButton btnUserJoinOK;
	private JButton btnUserJoinCancel;
	private JButton btnUerImgOK;
	private ButtonGroup userGroup;
	private JLabel lblUserImg;

	public JoinUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("회 원 가 입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pInput = new JPanel();
		contentPane.add(pInput, BorderLayout.CENTER);
		pInput.setLayout(null);

		JLabel lblUserGroup = new JLabel("회원 구분");
		lblUserGroup.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserGroup.setBounds(41, 24, 70, 20);
		pInput.add(lblUserGroup);

		rdbtnCompany = new JRadioButton("공급회사");
		rdbtnCompany.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCompany.setBounds(246, 22, 85, 25);
		pInput.add(rdbtnCompany);

		rdbtnUser = new JRadioButton("일반회원");
		rdbtnUser.setSelected(true);
		rdbtnUser.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnUser.setBounds(144, 22, 85, 25);
		pInput.add(rdbtnUser);

		userGroup = new ButtonGroup();
		userGroup.add(rdbtnCompany);
		userGroup.add(rdbtnUser);

		JLabel lblUserId = new JLabel("아이디");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(54, 68, 57, 20);
		pInput.add(lblUserId);

		tfUserId = new JTextField();
		tfUserId.setHorizontalAlignment(SwingConstants.LEFT);
		tfUserId.setBounds(144, 64, 122, 30);
		pInput.add(tfUserId);
		tfUserId.setColumns(10);

		btnDuplId = new JButton("중복확인");
		btnDuplId.addActionListener(this);
		btnDuplId.setBounds(278, 63, 90, 30);
		pInput.add(btnDuplId);

		JPanel pImgArea = new JPanel();
		pImgArea.setBounds(392, 24, 128, 168);
		pInput.add(pImgArea);
		pImgArea.setLayout(null);

		lblUserImg = new JLabel("");
		lblUserImg.setIcon(new ImageIcon(DefineUtil.DEFAULT_IMG_PATH + DefineUtil.DEFAULT_USER_IMG));
		lblUserImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserImg.setBounds(0, 0, 128, 128);
		pImgArea.add(lblUserImg);

		btnUerImgOK = new JButton("사진 등록");
		btnUerImgOK.addActionListener(new OpenActionListener(lblUserImg));
		btnUerImgOK.setBounds(0, 138, 128, 30);
		pImgArea.add(btnUerImgOK);

		JLabel lblUserPwd = new JLabel("비밀번호");
		lblUserPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPwd.setBounds(54, 114, 57, 20);
		pInput.add(lblUserPwd);

		pfUserPwd = new JPasswordField();
		pfUserPwd.setHorizontalAlignment(SwingConstants.LEFT);
		pfUserPwd.setBounds(144, 110, 150, 30);
		pInput.add(pfUserPwd);

		JLabel lblUserPwdChk = new JLabel("비밀번호 확인");
		lblUserPwdChk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPwdChk.setBounds(26, 160, 85, 20);
		pInput.add(lblUserPwdChk);

		pfUserPwdChk = new JPasswordField();
		pfUserPwdChk.setHorizontalAlignment(SwingConstants.LEFT);
		pfUserPwdChk.setBounds(144, 156, 150, 30);
		pInput.add(pfUserPwdChk);

		JLabel lblUserName = new JLabel("이름");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setBounds(54, 207, 57, 20);
		pInput.add(lblUserName);

		tfUserName = new JTextField();
		tfUserName.setHorizontalAlignment(SwingConstants.LEFT);
		tfUserName.setColumns(10);
		tfUserName.setBounds(144, 203, 150, 30);
		pInput.add(tfUserName);

		JLabel lblUserEmail = new JLabel("이메일");
		lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserEmail.setBounds(54, 251, 57, 20);
		pInput.add(lblUserEmail);

		tfUserEmail = new JTextField();
		tfUserEmail.setHorizontalAlignment(SwingConstants.LEFT);
		tfUserEmail.setColumns(10);
		tfUserEmail.setBounds(144, 247, 200, 30);
		pInput.add(tfUserEmail);

		JLabel lblUserPhone = new JLabel("전화번호");
		lblUserPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPhone.setBounds(54, 296, 57, 20);
		pInput.add(lblUserPhone);

		tfUserPhone = new JTextField();
		tfUserPhone.setHorizontalAlignment(SwingConstants.LEFT);
		tfUserPhone.setColumns(10);
		tfUserPhone.setBounds(144, 292, 200, 30);
		pInput.add(tfUserPhone);

		btnUserJoinOK = new JButton("가입");
		btnUserJoinOK.addActionListener(this);
		btnUserJoinOK.setBounds(166, 353, 100, 35);
		pInput.add(btnUserJoinOK);

		btnUserJoinCancel = new JButton("취소");
		btnUserJoinCancel.addActionListener(this);
		btnUserJoinCancel.setBounds(307, 353, 100, 35);
		pInput.add(btnUserJoinCancel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUserJoinCancel) {
			actionPerformedBtnUserJoinCancel(e);
		}
		if (e.getSource() == btnUserJoinOK) {
			actionPerformedBtnUserJoinOK(e);
		}
		if (e.getSource() == btnDuplId) {
			actionPerformedBtnDuplId(e);
		}
	}

	// 아이디 중복체크 //
	protected void actionPerformedBtnDuplId(ActionEvent e) {
		if (isEmpty(tfUserId, "아이디가")) {
			return;
		}
		String joinId = tfUserId.getText();
		if (UserService.getInstance().findUserById(new User(joinId)) != null) {
			checkDupId = false;
			JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
			tfUserId.setText("");
			tfUserId.requestFocus();
		} else {
			checkDupId = true;
			JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
			pfUserPwd.requestFocus();
		}
	}

	// TextField, PasswordField 의 값이 비었는지 체크
	public boolean isEmpty(JComponent comp, String title) {
		String msg = "";
		if (comp instanceof JTextField) {
			msg = ((JTextField) comp).getText().trim();
		} else if (comp instanceof JPasswordField) {
			msg = new String(((JPasswordField) comp).getPassword()).trim();
		}
		if (msg.isEmpty()) {
			JOptionPane.showMessageDialog(null, String.format("%s 비었습니다.", title));
			comp.requestFocus();
			return true;
		}
		return false;
	}

	// 회원가입 버튼
	protected void actionPerformedBtnUserJoinOK(ActionEvent e) {
		joinUser();
	}

	// 회원가입 처리
	private void joinUser() {
		if (isEmpty(tfUserId, "아이디가")) {
			return;
		}
		if (!checkDupId) {
			JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
			return;
		}
		String id = tfUserId.getText().trim();

		if (isEmpty(pfUserPwd, "비밀번호가")) {
			return;
		}
		if (isEmpty(pfUserPwdChk, "비밀번호 확인이")) {
			return;
		}
		if ( ! CommonUtil.getInstance().checkPwd(pfUserPwd, pfUserPwdChk)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
			pfUserPwd.setText("");
			pfUserPwd.requestFocus();
			return;
		}
		String pwd = new String(pfUserPwd.getPassword()).trim();

		if (isEmpty(tfUserName, "이름이")) {
			return;
		}
		String name = tfUserName.getText().trim();

		if (isEmpty(tfUserEmail, "이메일이")) {
			return;
		}
		String email = tfUserEmail.getText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_EMAIL, email)) {
			JOptionPane.showMessageDialog(null, "이메일 형식이 아닙니다. ex) aaa@test.com");
			tfUserEmail.setText("");
			tfUserEmail.requestFocus();
			return;
		}

		if (isEmpty(tfUserPhone, "전화번호가")) {
			return;
		}
		String phone = tfUserPhone.getText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_PHONE, phone)) {
			JOptionPane.showMessageDialog(null, "전화번호 형식이 아닙니다. ex) 02-223-1123, 022231122");
			tfUserPhone.setText("");
			tfUserPhone.requestFocus();
			return;
		}
		phone = CommonUtil.getInstance().phoneNumberHyphenAdd(phone, false);

		String uGroup = getSelectedButtonText(userGroup);
		if (uGroup == null) {
			JOptionPane.showMessageDialog(null, "회원 구분을 선택해주세요.");
			return;
		}
		User joinUser = new User();
		joinUser.setUserId(id);
		joinUser.setUserPwd(pwd);
		joinUser.setName(name);
		joinUser.setEmail(email);
		joinUser.setPhone(new PhoneNumber(phone));
		if (uGroup == "일반회원") {
			joinUser.setUserGroup(UserGroup.CUSTOMER);
		} else if (uGroup == "공급회사") {
			joinUser.setUserGroup(UserGroup.COMPANY);
		} else {
			JOptionPane.showMessageDialog(null, "회원 구분을 선택해주세요.");
			return;
		}
		String userImgFullPath = lblUserImg.getIcon().toString();
		String imgName = CommonUtil.getInstance().createRndImgName(userImgFullPath, joinUser.getUserId());
		joinUser.setAvatar(imgName);
		
		// 일반회원은 기본적으로 총관리자가 관리
		joinUser.setAdmin(new Admin(1));

		int result = JOptionPane.showConfirmDialog(null, "회원가입 하시겠습니까?", "회원가입", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}

		CommonUtil.getInstance().userImgSave(userImgFullPath, imgName);
		if (UserService.getInstance().addUser(joinUser) != 1) {
			JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
			return;
		}
		JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		resetData();
		dispose();
	}

	private String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	protected void actionPerformedBtnUserJoinCancel(ActionEvent e) {
		resetData();
	}

	// (기본 셋팅으로 돌리기)
	private void resetData() {
		lblUserImg.setIcon(new ImageIcon(DefineUtil.DEFAULT_IMG_PATH + DefineUtil.DEFAULT_USER_IMG));
		tfUserId.setText("");
		pfUserPwd.setText("");
		pfUserPwdChk.setText("");
		tfUserName.setText("");
		tfUserEmail.setText("");
		tfUserPhone.setText("");
		rdbtnUser.setSelected(true);
		checkDupId = false;
	}
}
