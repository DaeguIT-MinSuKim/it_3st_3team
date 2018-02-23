package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.common.FindIdPw;

public class FindIdPwUI extends JFrame {

	private JPanel contentPane;

	public FindIdPwUI() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		FindIdPw pIdPw = new FindIdPw();
		contentPane.add(pIdPw, BorderLayout.CENTER);
	}

}
