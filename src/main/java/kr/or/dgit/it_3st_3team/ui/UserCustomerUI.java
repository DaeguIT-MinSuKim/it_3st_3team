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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		
		JPanel pContent = new JPanel();
		pContent.setBounds(298, 0, 1186, 861);
		contentPane.add(pContent);
		
		JPanel pImg = new JPanel();
		pImg.setLayout(null);
		pImg.setBackground(new Color(51, 153, 204));
		pImg.setBounds(0, 0, 300, 231);
		contentPane.add(pImg);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\add-user-interface-outlined-symbol.png"));
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);
		
		JLabel lblName = new JLabel("재밌는 게임방님 환영합니다.");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblName.setBounds(30, 188, 228, 33);
		pImg.add(lblName);
		
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(51, 153, 204));
		pMenu.setBounds(0, 230, 300, 631);
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblEmpty = new JLabel("");
		pMenu.add(lblEmpty);
		
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
		
		JButton btnUserModify = new JButton("회원정보 수정");
		btnUserModify.setForeground(Color.DARK_GRAY);
		btnUserModify.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnUserModify.setBackground(new Color(51, 153, 204));
		pMenu.add(btnUserModify);
	}
}
