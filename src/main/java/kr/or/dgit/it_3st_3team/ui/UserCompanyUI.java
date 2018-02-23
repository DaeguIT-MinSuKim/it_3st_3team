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

@SuppressWarnings("serial")
public class UserCompanyUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCompanyUI frame = new UserCompanyUI();
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
	public UserCompanyUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("소프트웨어 - 공급회사");
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
		
		JButton btnRegister = new JButton("소프트웨어 등록");
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRegister.setBackground(new Color(51, 153, 204));
		pMenu.add(btnRegister);
		
		JButton btnSupplyStatus = new JButton("소프트웨어 공급현황");
		btnSupplyStatus.setForeground(Color.DARK_GRAY);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatus.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatus);
		
		JButton btnSupplyStatusGraph = new JButton("소프트웨어 공현황(그래프)");
		btnSupplyStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatusGraph.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatusGraph);
		
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
