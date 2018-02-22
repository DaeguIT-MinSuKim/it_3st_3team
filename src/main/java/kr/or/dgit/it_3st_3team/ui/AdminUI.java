package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.common.LoginComponent;



@SuppressWarnings("serial")
public class AdminUI extends JFrame {
	private LoginComponent contentPane;

	public AdminUI() {
		
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 617);
		contentPane = new LoginComponent();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
	}

}
