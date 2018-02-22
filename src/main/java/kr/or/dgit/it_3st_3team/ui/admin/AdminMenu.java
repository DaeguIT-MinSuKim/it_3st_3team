package kr.or.dgit.it_3st_3team.ui.admin;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class AdminMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminMenu() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel mMenu = new JPanel();
		mMenu.setBounds(141, 5, 250, 900);
		mMenu.setBackground(new Color(51, 153, 204));
		add(mMenu);
		mMenu.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblempty = new JLabel("");
		mMenu.add(lblempty);
		
		JLabel lblempty_1 = new JLabel("");
		mMenu.add(lblempty_1);
		
		JButton btnRPC = new JButton("공급회사 등록");
		btnRPC.setForeground(Color.DARK_GRAY);
		btnRPC.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRPC.setBackground(new Color(51, 153, 204));
		mMenu.add(btnRPC);
		
		JButton btnRSW = new JButton("소프트웨어 등록");
		btnRSW.setForeground(Color.DARK_GRAY);
		btnRSW.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRSW.setBackground(new Color(51, 153, 204));
		mMenu.add(btnRSW);
		
		JButton btnMSW = new JButton("소프트웨어 주문 관리");
		btnMSW.setForeground(Color.DARK_GRAY);
		btnMSW.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMSW.setBackground(new Color(51, 153, 204));
		mMenu.add(btnMSW);
		
		JButton btnCspsl = new JButton("공급 · 판매 현황");
		btnCspsl.setForeground(Color.DARK_GRAY);
		btnCspsl.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCspsl.setBackground(new Color(51, 153, 204));
		mMenu.add(btnCspsl);
		
		JButton btnCspslGraph = new JButton("공급 · 판매 현황(그래프)");
		btnCspslGraph.setForeground(Color.DARK_GRAY);
		btnCspslGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCspslGraph.setBackground(new Color(51, 153, 204));
		mMenu.add(btnCspslGraph);
		
		JButton btnMCon = new JButton("고객 관리");
		btnMCon.setForeground(Color.DARK_GRAY);
		btnMCon.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMCon.setBackground(new Color(51, 153, 204));
		mMenu.add(btnMCon);
		
		JButton btnMEmp = new JButton("직원 관리");
		btnMEmp.setForeground(Color.DARK_GRAY);
		btnMEmp.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnMEmp.setBackground(new Color(51, 153, 204));
		mMenu.add(btnMEmp);
		
		JLabel lblempty_2 = new JLabel("");
		mMenu.add(lblempty_2);
	}

}
