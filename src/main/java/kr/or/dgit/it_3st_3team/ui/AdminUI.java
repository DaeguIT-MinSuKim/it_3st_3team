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

import kr.or.dgit.it_3st_3team.ui.admin.customer.AdminCustomerContent;
import kr.or.dgit.it_3st_3team.ui.admin.order.AdminOrder;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftware;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSupplyRegister;
	private JButton btnSWRegister;
	private JPanel pContent;
	private JPanel pMain;
	private JButton btnOrderManagement;


	
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
		
		pContent = new JPanel();
		pContent.setBounds(300, 0, 1184, 861);
		contentPane.add(pContent);
		pContent.setLayout(null);
		
		pMain = new JPanel();
		pMain.setBounds(0, 0, 1184, 861);
		pContent.add(pMain);
		
		JPanel pAdminMenu = new JPanel();
		pAdminMenu.setBackground(new Color(51, 153, 204));
		pAdminMenu.setBounds(0, 0, 300, 861);
		contentPane.add(pAdminMenu);
		pAdminMenu.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblEmpty = new JLabel("");
		pAdminMenu.add(lblEmpty);
		
		JLabel lblEmpty_2 = new JLabel("");
		pAdminMenu.add(lblEmpty_2);
		
		btnSupplyRegister = new JButton("공급회사 등록");
		btnSupplyRegister.addActionListener(this);
		btnSupplyRegister.setForeground(Color.DARK_GRAY);
		btnSupplyRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyRegister.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSupplyRegister);
		
		btnSWRegister = new JButton("소프트웨어 등록");
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(Color.DARK_GRAY);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSWRegister.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSWRegister);
		
		btnOrderManagement = new JButton("소프트웨어 주문 관리");
		btnOrderManagement.addActionListener(this);
		btnOrderManagement.setForeground(Color.DARK_GRAY);
		btnOrderManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnOrderManagement.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnOrderManagement);
		
		JButton btnSupplySaleStatus = new JButton("공급 · 판매 현황");
		btnSupplySaleStatus.setForeground(Color.DARK_GRAY);
		btnSupplySaleStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplySaleStatus.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSupplySaleStatus);
		
		JButton btnSupplySaleStatusGraph = new JButton("공급 · 판매 현황(그래프)");
		btnSupplySaleStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplySaleStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplySaleStatusGraph.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSupplySaleStatusGraph);
		
		JButton btnCustomerManagement = new JButton("고객 관리");
		btnCustomerManagement.setForeground(Color.DARK_GRAY);
		btnCustomerManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCustomerManagement.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnCustomerManagement);
		
		JButton btnEmpManagement = new JButton("직원 관리");
		btnEmpManagement.setForeground(Color.DARK_GRAY);
		btnEmpManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnEmpManagement.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnEmpManagement);
		
		JLabel lblEmpty_1 = new JLabel("");
		pAdminMenu.add(lblEmpty_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOrderManagement) {
			actionPerformedBtnOrderManagement(e);
		}
		if (e.getSource() == btnSWRegister) {
			actionPerformedButton_1(e);
		}
		if (e.getSource() == btnSupplyRegister) {
			actionPerformedButton(e);
		}
	}
	protected void actionPerformedButton(ActionEvent e) {
		pContent.removeAll();
		
		
	}
	protected void actionPerformedButton_1(ActionEvent e) {
		pContent.removeAll();
		AdminSoftware pMain = new AdminSoftware();
		pMain.setBounds(0, 0, 1186, 861);
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
		
	}
	protected void actionPerformedBtnOrderManagement(ActionEvent e) {
		pContent.removeAll();
		AdminOrder pMain = new AdminOrder();
		pMain.setBounds(0, 0, 1186, 861);
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
		
	}
}
