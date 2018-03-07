package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class AdminGroupContent extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnOK;
	private JButton btnCalcel;

	public AdminGroupContent() {
		initComponents();
	}

	private void initComponents() {
		setTitle("직책 등록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pLayout = new JPanel();
		pLayout.setLayout(null);
		contentPane.add(pLayout, BorderLayout.CENTER);

		LblTfComp pAdmGroupTitle = new LblTfComp("직책");
		pAdmGroupTitle.setBounds(41, 38, 172, 30);
		pLayout.add(pAdmGroupTitle);

		String[] admAuthDatas = { "관리자", "영업" };
		LblCmbStringComp pAdmGroupAuth = new LblCmbStringComp("권한");
		pAdmGroupAuth.setBounds(253, 38, 165, 30);
		pAdmGroupAuth.loadData(admAuthDatas);
		pLayout.add(pAdmGroupAuth);

		btnOK = new JButton("등록");
		btnOK.addActionListener(this);
		btnOK.setBounds(115, 103, 97, 30);
		pLayout.add(btnOK);

		btnCalcel = new JButton("취소");
		btnCalcel.addActionListener(this);
		btnCalcel.setBounds(253, 103, 97, 30);
		pLayout.add(btnCalcel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcel) {
			actionPerformedBtnCalcel(e);
		}
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
	}

	protected void actionPerformedBtnOK(ActionEvent e) {
	}

	protected void actionPerformedBtnCalcel(ActionEvent e) {
	}
}
