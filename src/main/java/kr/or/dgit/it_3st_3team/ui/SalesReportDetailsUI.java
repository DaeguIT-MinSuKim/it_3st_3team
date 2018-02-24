package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;

public class SalesReportDetailsUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesReportDetailsUI frame = new SalesReportDetailsUI();
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
	public SalesReportDetailsUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("보고서");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);
		pTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTitleName = new JPanel();
		pTitle.add(pTitleName);
		
		JLabel lblReport = new JLabel("보고서");
		lblReport.setFont(new Font("굴림", Font.PLAIN, 18));
		pTitleName.add(lblReport);
		
		JPanel pSearchedLists = new JPanel();
		pTitle.add(pSearchedLists);
		
		JLabel lblNewLabel_1 = new JLabel("보고서");
		pSearchedLists.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2018-01-01");
		pSearchedLists.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2018-02-24");
		pSearchedLists.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("게임");
		pSearchedLists.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("오버워치");
		pSearchedLists.add(lblNewLabel_5);
		
		JPanel pLists = new JPanel();
		contentPane.add(pLists, BorderLayout.CENTER);
	}

}
