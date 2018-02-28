package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.admin.company.AdminCompanyContent;
import kr.or.dgit.it_3st_3team.ui.admin.customer.AdminCustomerContent;
import kr.or.dgit.it_3st_3team.ui.admin.management.AdminManagementContent;
import kr.or.dgit.it_3st_3team.ui.admin.order.AdminOrder;
import kr.or.dgit.it_3st_3team.ui.admin.report.AdminStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;

@SuppressWarnings("serial")
public class AdminUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnSupplyRegister;
	private JButton btnSWRegister;
	private JPanel pContent;
	private JPanel pMain;
	private JButton btnOrderManagement;
	private JButton btnSupplySaleStatus;
	private JButton btnCustomerManagement;
	private JButton btnEmpManagement;
	private Admin user;
	
	public AdminUI(Admin user) {
		this.user = user;
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

		btnSupplySaleStatus = new JButton("공급 · 판매 현황");
		btnSupplySaleStatus.addActionListener(this);
		btnSupplySaleStatus.setForeground(Color.DARK_GRAY);
		btnSupplySaleStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplySaleStatus.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSupplySaleStatus);

		JButton btnSupplySaleStatusGraph = new JButton("공급 · 판매 현황(그래프)");
		btnSupplySaleStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplySaleStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplySaleStatusGraph.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnSupplySaleStatusGraph);

		btnCustomerManagement = new JButton("고객 관리");
		btnCustomerManagement.addActionListener(this);
		btnCustomerManagement.setForeground(Color.DARK_GRAY);
		btnCustomerManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnCustomerManagement.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnCustomerManagement);

		btnEmpManagement = new JButton("직원 관리");
		btnEmpManagement.addActionListener(this);
		btnEmpManagement.setForeground(Color.DARK_GRAY);
		btnEmpManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnEmpManagement.setBackground(new Color(51, 153, 204));
		pAdminMenu.add(btnEmpManagement);

		JLabel lblEmpty_1 = new JLabel("");
		pAdminMenu.add(lblEmpty_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpManagement) {
			actionPerformedBtnEmpManagement(e);
		}
		if (e.getSource() == btnCustomerManagement) {
			actionPerformedBtnCustomerManagement(e);
		}
		if (e.getSource() == btnSupplySaleStatus) {
			actionPerformedBtnSupplySaleStatus(e);
		}
		if (e.getSource() == btnOrderManagement) {
			actionPerformedBtnOrderManagement(e);
		}
		if (e.getSource() == btnSWRegister) {
			actionPerformedBtnSWRegister(e);
		}
		if (e.getSource() == btnSupplyRegister) {
			actionPerformedBtnSupplyRegister(e);
		}
	}

	protected void actionPerformedBtnSupplyRegister(ActionEvent e) {
		AdminCompanyContent pMain = new AdminCompanyContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSWRegister(ActionEvent e) {
		AdminSoftwareContent pMain = new AdminSoftwareContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnOrderManagement(ActionEvent e) {
		AdminOrder pMain = new AdminOrder();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSupplySaleStatus(ActionEvent e) {
		AdminStatusContent pMain = new AdminStatusContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnCustomerManagement(ActionEvent e) {
		AdminCustomerContent pMain = new AdminCustomerContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnEmpManagement(ActionEvent e) {
		AdminManagementContent pMain = new AdminManagementContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}
	
	private void changeMainPanel(JPanel pMain) {
		pContent.removeAll();
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
	}
}
