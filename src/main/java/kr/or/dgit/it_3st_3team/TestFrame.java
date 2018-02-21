package kr.or.dgit.it_3st_3team;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.Login;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TestFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRPC;

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
		pMain.setBackground(new Color(51, 153, 204));
		pMain.setBounds(0, 0, 274, 961);
		contentPane.add(pMain);
		pMain.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblempty = new JLabel("");
		pMain.add(lblempty);
		
		JLabel lblempty_1 = new JLabel("");
		pMain.add(lblempty_1);
		
		btnRPC = new JButton("공급회사 등록");
		
		btnRPC.setBackground(new Color(51, 153, 204));
		btnRPC.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRPC.setForeground(Color.DARK_GRAY);
		btnRPC.addActionListener(this);
		pMain.add(btnRPC);
		
		JButton btnRSW = new JButton("소프트웨어 등록");
		btnRSW.setForeground(Color.DARK_GRAY);
		btnRSW.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRSW.setBackground(new Color(51, 153, 204));
		pMain.add(btnRSW);
		
		JButton btnMSW = new JButton("소프트웨어 주문 관리");
		btnMSW.setForeground(Color.DARK_GRAY);
		btnMSW.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMSW.setBackground(new Color(51, 153, 204));
		pMain.add(btnMSW);
		
		JButton btnCspsl = new JButton("공급 · 판매 현황");
		btnCspsl.setForeground(Color.DARK_GRAY);
		btnCspsl.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCspsl.setBackground(new Color(51, 153, 204));
		pMain.add(btnCspsl);
		
		JButton btnCspslGraph = new JButton("공급 · 판매 현황(그래프)");
		btnCspslGraph.setForeground(Color.DARK_GRAY);
		btnCspslGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCspslGraph.setBackground(new Color(51, 153, 204));
		pMain.add(btnCspslGraph);
		
		JButton btnMCon = new JButton("고객 관리");
		btnMCon.setForeground(Color.DARK_GRAY);
		btnMCon.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMCon.setBackground(new Color(51, 153, 204));
		pMain.add(btnMCon);
		
		JButton btnMEmp = new JButton("직원 관리");
		btnMEmp.setForeground(Color.DARK_GRAY);
		btnMEmp.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMEmp.setBackground(new Color(51, 153, 204));
		pMain.add(btnMEmp);
		
		JLabel lblempty_2 = new JLabel("");
		pMain.add(lblempty_2);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRPC) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		btnRPC.setBackground(new Color(102, 204, 255));
	}
}
