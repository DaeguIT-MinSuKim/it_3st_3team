package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftware;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class UserCustomerUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCustomerUI frame = new UserCustomerUI();
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
	public UserCustomerUI() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(51, 153, 204));
		pMenu.setBounds(0, 0, 300, 861);
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblEmty = new JLabel("");
		pMenu.add(lblEmty);
		
		JLabel lblEmty_1 = new JLabel("");
		pMenu.add(lblEmty_1);
		
		JButton btnOrder = new JButton("소프트웨어 주문");
		btnOrder.setForeground(Color.DARK_GRAY);
		btnOrder.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnOrder.setBackground(new Color(51, 153, 204));
		pMenu.add(btnOrder);
		
		JButton btnOrderStatus = new JButton("소프트웨어 주문현황");
		btnOrderStatus.setForeground(Color.DARK_GRAY);
		btnOrderStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnOrderStatus.setBackground(new Color(51, 153, 204));
		pMenu.add(btnOrderStatus);
		
		JButton btnOrderStatusGraph = new JButton("소프트웨어 주문현황(그래프)");
		btnOrderStatusGraph.setForeground(Color.DARK_GRAY);
		btnOrderStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnOrderStatusGraph.setBackground(new Color(51, 153, 204));
		pMenu.add(btnOrderStatusGraph);
		
		JButton btnInfoRewrite = new JButton("회원정보 수정");
		btnInfoRewrite.setForeground(Color.DARK_GRAY);
		btnInfoRewrite.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnInfoRewrite.setBackground(new Color(51, 153, 204));
		pMenu.add(btnInfoRewrite);
		
		JLabel lblEmty_2 = new JLabel("");
		pMenu.add(lblEmty_2);
		
		JLabel lblEmty_2_1 = new JLabel("");
		pMenu.add(lblEmty_2_1);
		
		JLabel lblEmty_2_2 = new JLabel("");
		pMenu.add(lblEmty_2_2);
		
		JLabel lblEmty_2_3 = new JLabel("");
		pMenu.add(lblEmty_2_3);
		
		JPanel pContent = new JPanel();
		pContent.setBounds(298, 0, 1186, 861);
		contentPane.add(pContent);
	}
}
