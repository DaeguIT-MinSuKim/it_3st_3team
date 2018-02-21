package kr.or.dgit.it_3st_3team;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.ImageContent;

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
		
		ImageContent panel = new ImageContent();
		panel.setImagesIcon("nobody.png");
		contentPane.add(panel, BorderLayout.NORTH);
	}

}
