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

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class FindIdPw extends JPanel implements ItemListener, ActionListener {
	private JTextField tfFindIdEmail;
	private JTextField tfFindIdEmailDetail;
	private JRadioButton rdFindId;
	private JRadioButton rdFindPw;
	private JPanel p2;
	private JPanel p3;
	private JButton btnFind;
	private LblTfComp pFindPwUserId;
	private LblTfComp pFindPwUserEmail;
	private JPanel pFindPwUserPhone;
	private LblTfComp pUserName;
	private JButton btnExit;
	private JComboBox<String> cmbFindIdChooseEmail;

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
		pUserName.setBounds(75, 21, 310, 30);
		p2.add(pUserName);

		JLabel lblFindIdEmail = new JLabel("이메일");
		lblFindIdEmail.setBounds(75, 64, 66, 30);
		p2.add(lblFindIdEmail);

		tfFindIdEmail = new JTextField();
		tfFindIdEmail.setBounds(132, 65, 150, 30);
		p2.add(tfFindIdEmail);
		tfFindIdEmail.setColumns(10);

		tfFindIdEmailDetail = new JTextField();
		tfFindIdEmailDetail.setBounds(305, 65, 150, 30);
		tfFindIdEmailDetail.setColumns(10);
		p2.add(tfFindIdEmailDetail);

		JLabel lbl = new JLabel("@");
		lbl.setBounds(284, 66, 20, 27);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lbl);

		String[] arrEmail = new String[] {"직접입력", "naver.com", "gmail.com", "daum.net"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(arrEmail);
		cmbFindIdChooseEmail = new JComboBox<>(model);
		cmbFindIdChooseEmail.setBounds(467, 64, 100, 30);
		cmbFindIdChooseEmail.addItemListener(this);
		p2.add(cmbFindIdChooseEmail);

		p3 = new JPanel();
		add(p3, BorderLayout.CENTER);
		p3.setLayout(null);

		pFindPwUserId = new LblTfComp((String) "아이디");
		pFindPwUserId.setBounds(75, 21, 310, 30);
		p3.add(pFindPwUserId);
		pFindPwUserId.setLayout(new BoxLayout(pFindPwUserId, BoxLayout.X_AXIS));

		pFindPwUserEmail = new LblTfComp((String) "이메일");
		pFindPwUserEmail.setBounds(75, 61, 310, 30);
		p3.add(pFindPwUserEmail);

		pFindPwUserPhone = new LblTfComp((String) "전화번호");
		pFindPwUserPhone.setBounds(75, 101, 310, 30);
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
			getTopLevelAncestor().setBounds(getTopLevelAncestor().getX(), getTopLevelAncestor().getY(), 450, 350);
		}
	}

	protected void itemStateChangedRdFindId(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			remove(p3);
			revalidate();
			repaint();
			add(p2, BorderLayout.CENTER);
			btnFind.setText("아이디찾기");
			if (getTopLevelAncestor() != null) {
				getTopLevelAncestor().setBounds(getTopLevelAncestor().getX(), getTopLevelAncestor().getY(), 650, 350);
			}
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
			JOptionPane.showMessageDialog(null, e.getActionCommand());
		}
	}
	
	private void cleanfindIdComponent() {
		pUserName.setTfText("");
		tfFindIdEmail.setText("");
		tfFindIdEmailDetail.setText("");
		cmbFindIdChooseEmail.setSelectedIndex(0);
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
