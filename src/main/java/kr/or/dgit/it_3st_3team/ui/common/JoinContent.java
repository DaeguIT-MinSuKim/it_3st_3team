package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class JoinContent extends JFrame {
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
	private JButton btnUserJoinOK;
	private JButton btnUserJoinCancel;

	public JoinContent() {
		initComponents();
	}

	private void initComponents() {
		setTitle("회 원 가 입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		rdbtnCompany.setBounds(144, 22, 85, 25);
		pInput.add(rdbtnCompany);

		rdbtnUser = new JRadioButton("일반회원");
		rdbtnUser.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnUser.setBounds(246, 22, 85, 25);
		pInput.add(rdbtnUser);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCompany);
		group.add(rdbtnUser);

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
		btnDuplId.setBounds(278, 63, 80, 30);
		pInput.add(btnDuplId);

		JPanel pImgArea = new JPanel();
		pImgArea.setBounds(392, 24, 128, 168);
		pInput.add(pImgArea);
		pImgArea.setLayout(null);

		JLabel lblUserImg = new JLabel("");
		lblUserImg.setIcon(
				new ImageIcon(System.getProperty("user.dir")+"\\DataImg\\nobody.png"));
		lblUserImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserImg.setBounds(0, 0, 128, 128);
		pImgArea.add(lblUserImg);

		JButton btnUerImgOK = new JButton("사진 등록");
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
		btnUserJoinOK.setBounds(166, 353, 100, 35);
		pInput.add(btnUserJoinOK);

		btnUserJoinCancel = new JButton("취소");
		btnUserJoinCancel.setBounds(307, 353, 100, 35);
		pInput.add(btnUserJoinCancel);
	}
}
