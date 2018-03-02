package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.CommonUtil;

@SuppressWarnings("serial")
public class FindIdPw extends JPanel implements ItemListener, ActionListener {
	private JRadioButton rdFindId;
	private JRadioButton rdFindPw;

	private JButton btnFind;
	private JButton btnExit;

	private JPanel p2;
	private LblTfComp pUserName;
	private JTextField tfFindIdEmail;
	private JTextField tfFindIdEmailDetail;
	private JComboBox<String> cmbFindIdChooseEmail;

	private JPanel p3;
	private LblTfComp pFindPwUserId;
	private LblTfComp pFindPwUserPhone;
	private JTextField tfFindPwEmail;
	private JTextField tfFindPwEmailDetail;
	private JComboBox<String> cmbFindPwChooseEmail;

	public FindIdPw() {

		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel p1 = new JPanel();
		add(p1, BorderLayout.NORTH);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);
		p2.setLayout(null);

		pUserName = new LblTfComp((String) "상호명");
		pUserName.setBounds(30, 23, 310, 30);
		p2.add(pUserName);

		JLabel lblFindIdEmail = new JLabel("이메일");
		lblFindIdEmail.setBounds(30, 66, 66, 30);
		p2.add(lblFindIdEmail);

		tfFindIdEmail = new JTextField();
		tfFindIdEmail.setBounds(87, 67, 100, 30);
		p2.add(tfFindIdEmail);
		tfFindIdEmail.setColumns(10);

		tfFindIdEmailDetail = new JTextField();
		tfFindIdEmailDetail.setBounds(211, 67, 100, 30);
		tfFindIdEmailDetail.setColumns(10);
		p2.add(tfFindIdEmailDetail);

		JLabel lbl = new JLabel("@");
		lbl.setBounds(188, 68, 20, 27);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lbl);

		String[] arrEmail = new String[] { "직접입력", "naver.com", "gmail.com", "daum.net" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(arrEmail);
		cmbFindIdChooseEmail = new JComboBox<>(model);
		cmbFindIdChooseEmail.setBounds(323, 66, 100, 30);
		cmbFindIdChooseEmail.addItemListener(this);
		p2.add(cmbFindIdChooseEmail);

		p3 = new JPanel();
		add(p3, BorderLayout.CENTER);
		p3.setLayout(null);

		pFindPwUserId = new LblTfComp((String) "아이디");
		pFindPwUserId.setBounds(42, 21, 270, 30);
		p3.add(pFindPwUserId);
		pFindPwUserId.setLayout(new BoxLayout(pFindPwUserId, BoxLayout.X_AXIS));

		JLabel lblFindPwEmail = new JLabel("이메일");
		lblFindPwEmail.setBounds(42, 101, 66, 30);
		p3.add(lblFindPwEmail);

		tfFindPwEmail = new JTextField();
		tfFindPwEmail.setBounds(101, 102, 100, 30);
		p3.add(tfFindPwEmail);
		tfFindPwEmail.setColumns(10);

		tfFindPwEmailDetail = new JTextField();
		tfFindPwEmailDetail.setBounds(223, 102, 100, 30);
		tfFindPwEmailDetail.setColumns(10);
		p3.add(tfFindPwEmailDetail);

		JLabel lbl2 = new JLabel("@");
		lbl2.setBounds(201, 103, 20, 27);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(lbl2);

		cmbFindPwChooseEmail = new JComboBox<>(model);
		cmbFindPwChooseEmail.setBounds(335, 101, 100, 30);
		cmbFindPwChooseEmail.addItemListener(this);
		p3.add(cmbFindPwChooseEmail);

		pFindPwUserPhone = new LblTfComp((String) "전화번호");
		pFindPwUserPhone.setBounds(30, 61, 281, 30);
		p3.add(pFindPwUserPhone);

		ButtonGroup btnG = new ButtonGroup();

		rdFindId = new JRadioButton("아이디 찾기");
		rdFindId.addItemListener(this);
		p1.add(rdFindId);

		rdFindPw = new JRadioButton("비밀번호 찾기");
		rdFindPw.addItemListener(this);
		p1.add(rdFindPw);
		btnG.add(rdFindPw);
		btnG.add(rdFindId);

		JPanel p4 = new JPanel();
		add(p4, BorderLayout.SOUTH);

		btnFind = new JButton("아이디찾기");
		btnFind.addActionListener(this);
		p4.add(btnFind);

		btnExit = new JButton("나가기");
		btnExit.addActionListener(this);
		p4.add(btnExit);

		rdFindId.setSelected(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbFindIdChooseEmail) {
			itemStateChangedCmbFindIdChooseEmail(e);
		}
		if (e.getSource() == rdFindId) {
			itemStateChangedRdFindId(e);
		}
		if (e.getSource() == rdFindPw) {
			itemStateChangedRdFindPw(e);
		}
	}

	// 이메일 선택 콤보박스
	protected void itemStateChangedCmbFindIdChooseEmail(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String item = e.getItem().toString();
			if (item.equals("직접입력")) {
				tfFindIdEmailDetail.setEditable(true);
				tfFindIdEmailDetail.setText("");
				tfFindIdEmailDetail.requestFocus();
			} else {
				tfFindIdEmailDetail.setEditable(false);
				tfFindIdEmailDetail.setText(item);
			}
		}
	}

	protected void itemStateChangedRdFindPw(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			cleanfindIdComponent();
			remove(p2);
			revalidate();
			repaint();
			add(p3, BorderLayout.CENTER);
			btnFind.setText("비밀번호찾기");
		}
	}

	protected void itemStateChangedRdFindId(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			cleanfindPwComponent();
			remove(p3);
			revalidate();
			repaint();
			add(p2, BorderLayout.CENTER);
			btnFind.setText("아이디찾기");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFind) {
			actionPerformedBtnFind(e);
		}
		if (e.getSource() == btnExit) {
			actionPerformedBtnExit(e);
		}
	}

	protected void actionPerformedBtnExit(ActionEvent e) {
		getTopLevelAncestor().setVisible(false);
	}

	protected void actionPerformedBtnFind(ActionEvent e) {
		if (e.getActionCommand() == "아이디찾기") {
			procFindUserId();
		} else if (e.getActionCommand() == "비밀번호찾기") {
			if (pFindPwUserId.getTfText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				pFindPwUserId.requestTfFocus();
				return;
			}
			if (pFindPwUserPhone.getTfText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요.");
				pFindPwUserPhone.requestTfFocus();
				return;
			}
			if (tfFindPwEmail.getText().trim().isEmpty() || tfFindPwEmailDetail.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.");
				tfFindPwEmail.requestFocus();
				return;
			}

			String userId = pFindPwUserId.getTfText().trim();
			String userPhone = CommonUtil.phoneNumberHyphenAdd(pFindPwUserPhone.getTfText().trim(), false);
			String userEmail = String.format("%s@%s", tfFindPwEmail.getText(), tfFindPwEmailDetail.getText());
			User findUser = new User();
			findUser.setUserId(userId);
			findUser.setPhone(new PhoneNumber(userPhone));
			findUser.setEmail(userEmail);

			User findedUser = UserService.getInstance().findUserByFindPw(findUser);
			if (findedUser == null) {
				JOptionPane.showMessageDialog(null, "입력한 정보의 유저가 존재하지 않습니다.");
				return;
			}
			System.out.println(findedUser);
		}
	}

	private void cleanfindIdComponent() {
		pUserName.setTfText("");
		tfFindIdEmail.setText("");
		tfFindIdEmailDetail.setText("");
		cmbFindIdChooseEmail.setSelectedIndex(0);
	}

	private void cleanfindPwComponent() {
		pFindPwUserId.setTfText("");
		pFindPwUserPhone.setTfText("");
		tfFindPwEmail.setText("");
		tfFindPwEmailDetail.setText("");
		cmbFindPwChooseEmail.setSelectedIndex(0);
	}

	// 아이디 찾기 기능
	private void procFindUserId() {
		if (pUserName.getTfText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "상호명을 입력해주세요.");
			pUserName.requestTfFocus();
			return;
		}
		if (tfFindIdEmail.getText().trim().isEmpty() || tfFindIdEmailDetail.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "이메일을 입력해주세요.");
			tfFindIdEmail.requestFocus();
			return;
		}
		String userName = pUserName.getTfText();
		String userEmail = String.format("%s@%s", tfFindIdEmail.getText(), tfFindIdEmailDetail.getText());

		User findUser = new User();
		findUser.setName(userName);
		findUser.setEmail(userEmail);

		User findedUser = UserService.getInstance().findUserByFindId(findUser);
		if (findedUser == null) {
			JOptionPane.showMessageDialog(null, "입력한 정보의 유저가 존재하지 않습니다.");
			return;
		}
		String message = String.format("찾으시는 아이디는 %s 입니다.", findedUser.getUserId());
		JOptionPane.showMessageDialog(null, message);
	}
}
