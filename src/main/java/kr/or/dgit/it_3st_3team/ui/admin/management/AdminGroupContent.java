package kr.or.dgit.it_3st_3team.ui.admin.management;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;

@SuppressWarnings("serial")
public class AdminGroupContent extends JFrame {
	private JPanel contentPane;

	public AdminGroupContent() {
		initComponents();
	}
	private void initComponents() {
		setTitle("직책 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 216);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pLayout = new JPanel();
		pLayout.setBackground(Color.WHITE);
		pLayout.setLayout(null);
		contentPane.add(pLayout, BorderLayout.CENTER);
		
		LabelTextFieldComponent pAdmGroupTitle = new LabelTextFieldComponent("직책");
		pAdmGroupTitle.setBounds(41, 38, 172, 30);
		pLayout.add(pAdmGroupTitle);
		
		String[] admAuthDatas = {"관리자", "영업"};
		StringLblCmbComponent pAdmGroupAuth = new StringLblCmbComponent("권한");
		pAdmGroupAuth.setBounds(253, 38, 165, 30);
		pAdmGroupAuth.loadData(admAuthDatas);
		pLayout.add(pAdmGroupAuth);
		
		JButton btnOK = new JButton("등록");
		btnOK.setBounds(115, 103, 97, 30);
		pLayout.add(btnOK);
		
		JButton btnCalcel = new JButton("취소");
		btnCalcel.setBounds(253, 103, 97, 30);
		pLayout.add(btnCalcel);
	}
}
