package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class AdminManagementRegister extends JPanel implements ActionListener {
	private JButton btnAdminGroup;
	private JButton btnDuplId;
	private JButton btnCancel;
	private JButton btnOK;
	private ImageComp pImg;
	private LblTfComp pAdminId;
	private LblPwdTfComp pAdminPwd;
	private LblPwdTfComp pAdminPwdChk;
	private LblTfComp pAdminName;
	private LblTfComp pAdminPhone;
	private LblCmbAdminGroupComp pAdminGroup;
	
	private boolean checkDupId = false;

	public AdminManagementRegister() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1160, 250);

		pImg = new ImageComp();
		pImg.setBounds(12, 10, 180, 220);
		add(pImg);

		JPanel pInput = new JPanel();
		pInput.setLayout(null);
		pInput.setBounds(204, 10, 944, 220);
		add(pInput);

		pAdminId = new LblTfComp("아이디");
		pAdminId.setBounds(72, 16, 208, 35);
		pInput.add(pAdminId);

		btnDuplId = new JButton("중복확인");
		btnDuplId.addActionListener(this);
		btnDuplId.setBounds(292, 16, 90, 35);
		pInput.add(btnDuplId);

		pAdminPwd = new LblPwdTfComp("비밀번호");
		pAdminPwd.setBounds(58, 67, 280, 35);
		pInput.add(pAdminPwd);

		pAdminPwdChk = new LblPwdTfComp("비밀번호 확인");
		pAdminPwdChk.setBounds(439, 67, 300, 35);
		pInput.add(pAdminPwdChk);

		pAdminName = new LblTfComp("이름");
		pAdminName.setBounds(82, 118, 256, 35);
		pInput.add(pAdminName);

		pAdminPhone = new LblTfComp("전화번호");
		pAdminPhone.setBounds(469, 118, 270, 35);
		pInput.add(pAdminPhone);

		AdminGroup[] agDatas = { new AdminGroup(1, "관리자", AdminGroupAuth.ADMINISTRATOR),
				new AdminGroup(2, "영업", AdminGroupAuth.SALESMAN) };

		pAdminGroup = new LblCmbAdminGroupComp("직책");
		pAdminGroup.loadData(agDatas);

		pAdminGroup.setBounds(82, 169, 198, 35);
		pInput.add(pAdminGroup);

		btnOK = new JButton("직책등록");
		btnOK.addActionListener(this);
		btnOK.setBounds(688, 167, 90, 45);
		pInput.add(btnOK);

		btnAdminGroup = new JButton("등록");
		btnAdminGroup.addActionListener(this);
		btnAdminGroup.setBounds(292, 169, 90, 35);
		pInput.add(btnAdminGroup);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(812, 167, 90, 45);
		pInput.add(btnCancel);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
		if (e.getSource() == btnDuplId) {
			actionPerformedBtnDuplId(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdminGroup) {
			actionPerformedBtnAdminGroup(e);
		}
	}

	// 중복확인
	protected void actionPerformedBtnDuplId(ActionEvent e) {
		String id = pAdminId.getTfText().trim();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
			pAdminId.setTfText("");
			pAdminId.requestTfFocus();
			return;
		}
		Admin admin = new Admin();
		admin.setAdminId(id);
		Admin findAdmin = AdminService.getInstance().findAdminById(admin);
		System.out.println(findAdmin);
		if (findAdmin != null) {
			JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
			pAdminId.setTfText("");
			pAdminId.requestTfFocus();
			return;
		}
		checkDupId = true;
		JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
		pAdminPwd.requestTfFocus();
	}

	// 등록
	protected void actionPerformedBtnOK(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "등록");
	}

	// 관리자 그룹 등록
	protected void actionPerformedBtnAdminGroup(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "그룹등록");
	}

	// 취소 ( 폼 리셋 )
	protected void actionPerformedBtnCancel(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "취소");
	}
}
