package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.common.FindIdPw;

@SuppressWarnings("serial")
public class FindIdPwUI extends JFrame {

	private JPanel contentPane;

	public FindIdPwUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ID & PW 찾기 - 소프트웨어");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 480, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		FindIdPw pIdPw = new FindIdPw();
		contentPane.add(pIdPw, BorderLayout.CENTER);
	}

}
