package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import kr.or.dgit.it_3st_3team.ui.table.SalesTransactionLists;

public class SalesTransactionDetailsUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesTransactionDetailsUI frame = new SalesTransactionDetailsUI();
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
	public SalesTransactionDetailsUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("거래명세서");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);
		
		JLabel lblTransaction = new JLabel("거래명세서");
		lblTransaction.setFont(new Font("굴림", Font.PLAIN, 18));
		pTitle.add(lblTransaction);
		
		SalesTransactionLists pLists = new SalesTransactionLists();
		contentPane.add(pLists, BorderLayout.CENTER);
	}

}
