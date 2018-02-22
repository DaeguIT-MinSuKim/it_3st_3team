package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftware;

public class AdminUI extends JFrame {

	private JPanel contentPane;


	
	public AdminUI() {
		
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AdminSoftware pContent = new AdminSoftware();
		pContent.setBounds(303, 0, 1181, 861);
		contentPane.add(pContent);
		
		JPanel pAdminMenu = new JPanel();
		pAdminMenu.setBackground(new Color(51, 153, 204));
		pAdminMenu.setBounds(0, 0, 300, 861);
		contentPane.add(pAdminMenu);
		pAdminMenu.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel label = new JLabel("");
		pAdminMenu.add(label);
		
		JLabel label_1 = new JLabel("");
		pAdminMenu.add(label_1);
		
		JButton button = new JButton("공급회사 등록");
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button);
		
		JButton button_1 = new JButton("소프트웨어 등록");
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_1.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_1);
		
		JButton button_2 = new JButton("소프트웨어 주문 관리");
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_2.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_2);
		
		JButton button_3 = new JButton("공급 · 판매 현황");
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_3.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_3);
		
		JButton button_4 = new JButton("공급 · 판매 현황(그래프)");
		button_4.setForeground(Color.DARK_GRAY);
		button_4.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_4.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_4);
		
		JButton button_5 = new JButton("고객 관리");
		button_5.setForeground(Color.DARK_GRAY);
		button_5.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_5.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_5);
		
		JButton button_6 = new JButton("직원 관리");
		button_6.setForeground(Color.DARK_GRAY);
		button_6.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		button_6.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(button_6);
		
		JLabel label_2 = new JLabel("");
		pAdminMenu.add(label_2);
	}

}
