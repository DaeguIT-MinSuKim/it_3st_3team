package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
import kr.or.dgit.it_3st_3team.service.AdminGroupService;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

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
	private AdminManagementContent parent;

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

		pAdminGroup = new LblCmbAdminGroupComp("직책");
		pAdminGroup.setBounds(82, 169, 198, 35);
		pInput.add(pAdminGroup);
		reFreshAdminGroupList();

		btnOK = new JButton("등록");
		btnOK.addActionListener(this);
		btnOK.setBounds(688, 167, 90, 45);
		pInput.add(btnOK);

		btnAdminGroup = new JButton("직책등록");
		btnAdminGroup.addActionListener(this);
		btnAdminGroup.setBounds(292, 169, 90, 35);
		// pInput.add(btnAdminGroup);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(812, 167, 90, 45);
		pInput.add(btnCancel);

	}

	public void reFreshAdminGroupList() {
		List<AdminGroup> list = AdminGroupService.getInstance().listAdminGroupByAll();
		AdminGroup[] agDatas = list.toArray(new AdminGroup[list.size()]);
		pAdminGroup.loadData(agDatas);
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
		String adminId = pAdminId.getTfText().trim();
		if (adminId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
			pAdminId.setTfText("");
			pAdminId.requestTfFocus();
			return;
		}
		if (!checkDupId) {
			JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
			return;
		}
		if (pAdminPwd.isVisible() && pAdminPwd.isTfEmpty("비밀번호를 입력해주세요.")) {
			return;
		}
		if (pAdminPwdChk.isVisible() && pAdminPwdChk.isTfEmpty("비밀번호를 한번 더 입력해주세요.")) {
			return;
		}
		if (!CommonUtil.getInstance().checkPwd(pAdminPwd.getPwdField(), pAdminPwdChk.getPwdField())) {
			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
			pAdminPwd.setTfText("");
			pAdminPwd.requestTfFocus();
			return;
		}		
		if (pAdminName.isTfEmpty("이름을 입력해주세요.")) {
			return;
		}
		if (pAdminPhone.isTfEmpty("전화번호를 입력해주세요.")) {
			return;
		}
		
		String adminPhone = pAdminPhone.getTfText().trim();
		if (!Pattern.matches(DefineUtil.PATTERN_PHONE, adminPhone)) {
			JOptionPane.showMessageDialog(null, "전화번호 형식이 아닙니다. ex) 02-223-1123, 022231122");
			pAdminPhone.setTfText("");
			pAdminPhone.requestTfFocus();
			return;
		}
		adminPhone = CommonUtil.getInstance().phoneNumberHyphenAdd(adminPhone, false);
		
		String adminPwd = pAdminPwd.getTfText().trim();
		String adminName = pAdminName.getTfText().trim();
		AdminGroup adminGroup = (AdminGroup) pAdminGroup.getCmbSelectItem();
		
		Admin joinAdmin = new Admin();
		joinAdmin.setAdminId(adminId);
		joinAdmin.setAdminName(adminName);
		joinAdmin.setAdminPwd(adminPwd);
		joinAdmin.setPhone(new PhoneNumber(adminPhone));
		joinAdmin.setAdminGroup(adminGroup);
		
		String userImgFullPath = pImg.getImageIcon().toString();
		String imgName = CommonUtil.getInstance().createRndImgName(userImgFullPath, joinAdmin.getAdminId());
		boolean isChangeImg = false;
		if (!imgName.equals(DefineUtil.DEFAULT_USER_IMG)) {
			isChangeImg = true;
			joinAdmin.setAvatar(imgName);
		}
		
		String commandType = e.getActionCommand();
		String commandMessage = String.format("관리자 %s", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("%s을 하시겠습니까?", commandMessage), commandMessage,
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}
		
		if (commandType.equals("등록")) {
			result = AdminService.getInstance().addAdmin(joinAdmin);
		} else {
			result = AdminService.getInstance().modifyAdmin(joinAdmin);
		}
		if (result != 1) {
			JOptionPane.showMessageDialog(null, String.format("%s에 실패하였습니다.", commandMessage));
			return;
		}
		if (isChangeImg) {
			CommonUtil.getInstance().userImgSave(userImgFullPath, imgName);
		}
		
		JOptionPane.showMessageDialog(null, String.format("%s이 완료되었습니다.", commandMessage));

		parent.reFreshAdminList();
		resetData();
	}

	// 관리자 그룹 등록
	protected void actionPerformedBtnAdminGroup(ActionEvent e) {
		AdminGroupContent adminGroup = new AdminGroupContent();
		adminGroup.setVisible(true);
	}

	// 취소 ( 폼 리셋 )
	protected void actionPerformedBtnCancel(ActionEvent e) {
		resetData();
	}
	
	public void resetData() {
		pImg.setImageIcon("nobody.png");
		pAdminId.setTfText("");
		pAdminId.setTfEditable(true);
		checkDupId = false;
		pAdminPwd.setTfText("");
		pAdminPwdChk.setTfText("");
		btnDuplId.setVisible(true);
		pAdminPwd.setVisible(true);
		pAdminPwdChk.setVisible(true);
		pAdminName.setTfText("");
		pAdminPhone.setTfText("");
		pAdminGroup.setCmbSelectIndex(0);
		
		btnOK.setText("등록");
		btnCancel.setText("취소");
	}
	
	public void setParent(AdminManagementContent parent) {
		this.parent = parent;
	}

	public void setAdminData(Admin admin) {
		System.out.println(admin.getAvatar());
		if (admin.getAvatar() != null && !admin.getAvatar().equals("")) {
			pImg.setImageIcon(admin.getAvatar());
		} else {
			pImg.setImageIcon("nobody.png");
		}
		pAdminId.setTfText(admin.getAdminId());
		pAdminId.setTfEditable(false);
		checkDupId = true;
		btnDuplId.setVisible(false);
		pAdminPwd.setVisible(false);
		pAdminPwdChk.setVisible(false);
		pAdminName.setTfText(admin.getAdminName());
		pAdminPhone.setTfText(admin.getPhone().toString());
		pAdminGroup.setCmbSelectItem(admin.getAdminGroup());
		
		btnOK.setText("수정");
		btnCancel.setText("수정취소");
	}
}
