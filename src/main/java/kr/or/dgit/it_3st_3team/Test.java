package kr.or.dgit.it_3st_3team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartBySwgType;
import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartBySwgTypeFullYear;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		AdminChartBySwgTypeFullYear ss = new AdminChartBySwgTypeFullYear(new Object());
		ss.setBorder(new EmptyBorder(30, 0, 0, 0));
		setContentPane(ss);
	}

}
