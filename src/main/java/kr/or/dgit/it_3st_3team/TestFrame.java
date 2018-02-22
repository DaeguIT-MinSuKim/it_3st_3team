package kr.or.dgit.it_3st_3team;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TestFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		initComponents();
	}
	private void initComponents() {
		setTitle("관리자로 로그인 하셨습니다.");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 102, 255)));
		setContentPane(contentPane);
		/*
		Login panel = new Login();
		contentPane.add(panel, BorderLayout.CENTER);*/
		contentPane.setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1484, 961);
		contentPane.add(pMain);
	}
	public void actionPerformed(ActionEvent e) {
	}
}
