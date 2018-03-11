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
import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartContent;
import kr.or.dgit.it_3st_3team.ui.admin.management.AdminManagementContent;
import kr.or.dgit.it_3st_3team.ui.admin.order.AdminOrderContent;
import kr.or.dgit.it_3st_3team.ui.admin.report.AdminStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;
import kr.or.dgit.it_3st_3team.ui.admin.user.AdminUserContent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class AdminUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnUserManager;
	private JButton btnSWRegister;
	private JPanel pContent;
	private JPanel pMain;
	private JButton btnOrderManagement;
	private JButton btnSupplySaleStatus;
	private JButton btnEmpManagement;
	private Admin admin;
	private JButton btnDbSetting;
	private JButton btnSupplySaleStatusGraph;

	public AdminUI(Admin admin) {
		this.admin = admin;
		initComponents();
	}

	private void initComponents() {
		setTitle("관리자 - 소프트웨어");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		pAdminMenu.setBackground(new Color(59, 89, 152));
		pAdminMenu.setBounds(0, 0, 300, 861);
		contentPane.add(pAdminMenu);
		pAdminMenu.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel lblEmpty = new JLabel("");
		pAdminMenu.add(lblEmpty);

		JLabel lblEmpty_2 = new JLabel("");
		pAdminMenu.add(lblEmpty_2);

		btnUserManager = new JButton("사용자 관리");
		btnUserManager.addActionListener(this);
		btnUserManager.setForeground(SystemColor.window);
		btnUserManager.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnUserManager.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnUserManager);

		btnSWRegister = new JButton("소프트웨어 등록");
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(SystemColor.window);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSWRegister.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnSWRegister);

		btnOrderManagement = new JButton("소프트웨어 주문 관리");
		btnOrderManagement.addActionListener(this);
		btnOrderManagement.setForeground(SystemColor.window);
		btnOrderManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnOrderManagement.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnOrderManagement);

		btnSupplySaleStatus = new JButton("공급 · 판매 현황");
		btnSupplySaleStatus.addActionListener(this);
		btnSupplySaleStatus.setForeground(SystemColor.window);
		btnSupplySaleStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplySaleStatus.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnSupplySaleStatus);

		btnSupplySaleStatusGraph = new JButton("공급 · 판매 현황(그래프)");
		btnSupplySaleStatusGraph.addActionListener(this);
		btnSupplySaleStatusGraph.setForeground(SystemColor.window);
		btnSupplySaleStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplySaleStatusGraph.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnSupplySaleStatusGraph);

		btnEmpManagement = new JButton("직원 관리");
		btnEmpManagement.addActionListener(this);
		btnEmpManagement.setForeground(SystemColor.window);
		btnEmpManagement.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnEmpManagement.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnEmpManagement);

		btnDbSetting = new JButton("설정");
		btnDbSetting.addActionListener(this);
		btnDbSetting.setForeground(SystemColor.window);
		btnDbSetting.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnDbSetting.setBackground(new Color(59, 89, 152));
		pAdminMenu.add(btnDbSetting);

		JLabel lblEmpty_1 = new JLabel("");
		pAdminMenu.add(lblEmpty_1);

		displayFirstView();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSupplySaleStatusGraph) {
			actionPerformedBtnSupplySaleStatusGraph(e);
		}
		if (e.getSource() == btnDbSetting) {
			actionPerformedBtnDbSetting(e);
		}
		if (e.getSource() == btnEmpManagement) {
			actionPerformedBtnEmpManagement(e);
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
		if (e.getSource() == btnUserManager) {
			actionPerformedBtnUserManager(e);
		}
	}

	// 처음에 기본적으로 주문관리 보여줌
	private void displayFirstView() {
		AdminOrderContent pMain = new AdminOrderContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnUserManager(ActionEvent e) {
		AdminUserContent pMain = new AdminUserContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSWRegister(ActionEvent e) {
		AdminSoftwareContent pMain = new AdminSoftwareContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnOrderManagement(ActionEvent e) {
		displayFirstView();
	}

	protected void actionPerformedBtnSupplySaleStatus(ActionEvent e) {
		AdminStatusContent pMain = new AdminStatusContent(admin);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnEmpManagement(ActionEvent e) {
		AdminManagementContent pMain = new AdminManagementContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnDbSetting(ActionEvent e) {
	}

	private void changeMainPanel(JPanel pMain) {
		pContent.removeAll();
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
	}

	protected void actionPerformedBtnSupplySaleStatusGraph(ActionEvent e) {
		AdminChartContent pMain = new AdminChartContent(admin);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}
}
