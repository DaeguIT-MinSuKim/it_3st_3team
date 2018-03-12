package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;
import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartContent;
import kr.or.dgit.it_3st_3team.ui.admin.management.AdminManagementContent;
import kr.or.dgit.it_3st_3team.ui.admin.order.AdminOrderContent;
import kr.or.dgit.it_3st_3team.ui.admin.report.AdminStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;
import kr.or.dgit.it_3st_3team.ui.admin.user.AdminUserContent;
import kr.or.dgit.it_3st_3team.ui.listener.ProgramCloseAdapter;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

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
	private JLabel lblImg;
	private JLabel lblName;
	private JButton button;

	public AdminUI(Admin admin) {
		setAdmin(admin);
		initComponents();
		setAdminNameAndAvatar();
	}

	private void initComponents() {
		setTitle("관리자 - 소프트웨어");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new ProgramCloseAdapter());
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

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(59, 89, 152));
		panel_1.setBounds(0, 0, 300, 270);
		contentPane.add(panel_1);

		lblImg = new JLabel("");
		lblImg.setBounds(85, 38, 128, 128);
		panel_1.add(lblImg);

		lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		lblName.setBounds(30, 188, 228, 33);
		panel_1.add(lblName);

		button = new JButton("로그아웃");
		button.addActionListener(this);
		button.setBounds(97, 237, 97, 23);
		panel_1.add(button);

		JPanel pAdminMenu = new JPanel();
		pAdminMenu.setBackground(new Color(59, 89, 152));
		pAdminMenu.setBounds(0, 270, 300, 591);
		contentPane.add(pAdminMenu);
		pAdminMenu.setLayout(new GridLayout(10, 1, 0, 0));

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

		if (admin.getAdminGroup().getAgAuth() == AdminGroupAuth.ADMINISTRATOR) {
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
		}

		displayFirstView();
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdminNameAndAvatar() {
		String imgPath = DefineUtil.DEFAULT_IMG_PATH;
		if (admin.getAvatar() == null || admin.getAvatar().equals("")) {
			admin.setAvatar(DefineUtil.DEFAULT_USER_IMG);
		}
		if (!admin.getAvatar().equals(DefineUtil.DEFAULT_USER_IMG)) {
			imgPath = DefineUtil.USER_IMG_PATH;
		}
		lblImg.setIcon(new ImageIcon(imgPath + admin.getAvatar()));

		lblName.setText(String.format("%s님 환영합니다.", admin.getAdminName()));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
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
		AdminOrderContent pMain = new AdminOrderContent(admin);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnUserManager(ActionEvent e) {
		AdminUserContent pMain = new AdminUserContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSWRegister(ActionEvent e) {
		AdminSoftwareContent pMain = new AdminSoftwareContent(admin);
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

	protected void actionPerformedButton(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "사용자 로그아웃", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			LoginUI loginUI = new LoginUI();
			loginUI.setVisible(true);
			dispose();
		}
	}
}
