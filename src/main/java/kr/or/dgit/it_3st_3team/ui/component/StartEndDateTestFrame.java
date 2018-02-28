package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartEndDateTestFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private StartAndEndDate panel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartEndDateTestFrame frame = new StartEndDateTestFrame();
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
	public StartEndDateTestFrame() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new StartAndEndDate();
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		String start=panel.getStartDate();
		String end = panel.getEndDate();
		
		System.out.println(start + " : " + end);
	}
}
