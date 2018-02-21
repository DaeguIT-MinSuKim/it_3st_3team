package kr.or.dgit.it_3st_3team;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.admin.management.AdminManagementContent;

@SuppressWarnings("serial")
public class TestFrame extends JFrame {
	private JPanel contentPane;

	public TestFrame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		AdminManagementContent panel = new AdminManagementContent();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
