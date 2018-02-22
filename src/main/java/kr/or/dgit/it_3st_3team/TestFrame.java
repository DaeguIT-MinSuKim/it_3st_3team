package kr.or.dgit.it_3st_3team;



import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {

	private JPanel contentPane;

	public TestFrame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/*
		Login panel = new Login();
		contentPane.add(panel, BorderLayout.CENTER);*/
		contentPane.setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 1484, 961);
		contentPane.add(pMain);

	}
}