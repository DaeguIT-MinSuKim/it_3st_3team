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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartContent;
import kr.or.dgit.it_3st_3team.ui.admin.report.AdminStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;
import kr.or.dgit.it_3st_3team.ui.listener.ProgramCloseAdapter;
import kr.or.dgit.it_3st_3team.ui.user.CustomerOrderContent;
import kr.or.dgit.it_3st_3team.ui.user.UserModifyContent;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class UserUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnSWOrder;
	private JPanel pContent;
	private JPanel pMain;
	private JButton btnModify;
	private JButton btnSupplyStatusGraph;
	private JButton btnSupplyStatus;
	private User user;
	private JButton btnSWRegister;
	private JLabel lblImg;
	private JLabel lblName;
	private JPanel pMenu;
	private JButton btnLogout;

	public UserUI(User user) {
		setUser(user);
		initComponents();
		setUserNameAndAvatar();
	}

	private void initComponents() {
		setTitle("사용자 - 소프트웨어");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		
		addWindowListener(new ProgramCloseAdapter());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel pImg = new JPanel();
		pImg.setLayout(null);
		pImg.setBackground(new Color(59, 89, 152));
		pImg.setBounds(0, 0, 300, 270);
		contentPane.add(pImg);

		lblImg = new JLabel("");
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);

		lblName = new JLabel("");
		lblName.setForeground(SystemColor.window);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
		lblName.setBounds(30, 188, 228, 33);
		pImg.add(lblName);

		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(this);
		btnLogout.setBounds(97, 237, 97, 23);
		pImg.add(btnLogout);

		pMenu = new JPanel();
		pMenu.setBackground(new Color(59, 89, 152));
		pMenu.setBounds(0, 230, 300, 631);
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(6, 1, 0, 0));

		JLabel lblEmpty = new JLabel("");
		pMenu.add(lblEmpty);

		if (user.getUserGroup() == UserGroup.CUSTOMER) {
			displayCustomerMenu(pMenu);
		} else {
			displayCompanyMenu(pMenu);
		}

		btnModify = new JButton("회원정보 수정");
		btnModify.setBounds(0, 420, 298, 105);
		btnModify.addActionListener(this);
		btnModify.setForeground(SystemColor.window);
		btnModify.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnModify.setBackground(new Color(59, 89, 152));
		pMenu.add(btnModify);

		pContent = new JPanel();
		pContent.setBounds(300, 0, 1186, 861);
		contentPane.add(pContent);
		pContent.setLayout(null);

		pMain = new JPanel();
		pMain.setBounds(0, 0, 1186, 861);
		pContent.add(pMain);

		displayFirstview();
	}

	private void displayFirstview() {
		if (user.getUserGroup() == UserGroup.CUSTOMER) {
			displayUserOrder();
		} else {
			displayAdminSoftware();
		}
	}
	
	private void displayUserOrder() {
		CustomerOrderContent pMain = new CustomerOrderContent(user);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}
	private void displayAdminSoftware() {
		AdminSoftwareContent pMain = new AdminSoftwareContent(user);
		pMain.setBounds(0, 0, 1186, 841);
		changeMainPanel(pMain);
	}

	private void displayCompanyMenu(JPanel pMenu) {
		btnSWRegister = new JButton("소프트웨어 등록");
		btnSWRegister.setBounds(0, 105, 298, 105);
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(SystemColor.window);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSWRegister.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSWRegister);

		btnSupplyStatus = new JButton("소프트웨어 공급현황");
		btnSupplyStatus.setBounds(0, 210, 298, 105);
		btnSupplyStatus.addActionListener(this);
		btnSupplyStatus.setForeground(SystemColor.window);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplyStatus.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSupplyStatus);

		btnSupplyStatusGraph = new JButton("소프트웨어 공급현황(그래프)");
		btnSupplyStatusGraph.addActionListener(this);
		btnSupplyStatusGraph.setBounds(0, 315, 298, 105);
		btnSupplyStatusGraph.setForeground(SystemColor.window);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplyStatusGraph.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSupplyStatusGraph);
	}

	private void displayCustomerMenu(JPanel pMenu) {
		btnSWOrder = new JButton("소프트웨어 주문");
		btnSWOrder.setBounds(0, 105, 298, 105);
		btnSWOrder.addActionListener(this);
		btnSWOrder.setForeground(SystemColor.window);
		btnSWOrder.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSWOrder.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSWOrder);

		btnSupplyStatus = new JButton("소프트웨어 주문현황");
		btnSupplyStatus.addActionListener(this);
		btnSupplyStatus.setBounds(0, 210, 298, 105);
		btnSupplyStatus.setForeground(SystemColor.window);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplyStatus.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSupplyStatus);

		btnSupplyStatusGraph = new JButton("소프트웨어 주문현황(그래프)");
		btnSupplyStatusGraph.addActionListener(this);
		btnSupplyStatusGraph.setBounds(0, 315, 298, 105);
		btnSupplyStatusGraph.setForeground(SystemColor.window);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		btnSupplyStatusGraph.setBackground(new Color(59, 89, 152));
		pMenu.add(btnSupplyStatusGraph);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogout) {
			actionPerformedBtnLogout(e);
		}
		if (e.getSource() == btnSupplyStatus) {
			actionPerformedBtnSupplyStatus(e);
		}
		if (e.getSource() == btnSupplyStatusGraph) {
			actionPerformedBtnSupplyStatusGraph(e);
		}
		if (e.getSource() == btnSWOrder) {
			actionPerformedbtnSWOrder(e);
		}
		if (e.getSource() == btnSWRegister) {
			actionPerformedBtnSWRegister(e);
		}
		if (e.getSource() == btnModify) {
			actionPerformedbtnModify(e);
		}
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUserNameAndAvatar() {
		String imgPath = DefineUtil.DEFAULT_IMG_PATH;
		if (user.getAvatar() == null || user.getAvatar().equals("")) {
			user.setAvatar(DefineUtil.DEFAULT_USER_IMG);
		}
		if (!user.getAvatar().equals(DefineUtil.DEFAULT_USER_IMG)) {
			imgPath = DefineUtil.USER_IMG_PATH;
		}
		lblImg.setIcon(new ImageIcon(imgPath + user.getAvatar()));

		lblName.setText(String.format("%s님 환영합니다.", user.getName()));
	}

	protected void actionPerformedbtnSWOrder(ActionEvent e) {
		displayUserOrder();
	}

	protected void actionPerformedBtnSWRegister(ActionEvent e) {
		displayAdminSoftware();
	}

	protected void actionPerformedbtnModify(ActionEvent e) {
		UserModifyContent pMain = new UserModifyContent(this);
		pMain.setBounds(0, 0, 1186, 861);
		pMain.getUserPanel().setUserInfo(this.user);

		changeMainPanel(pMain);
	}

	private void changeMainPanel(JPanel pMain) {
		pContent.removeAll();
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
	}

	protected void actionPerformedBtnSupplyStatusGraph(ActionEvent e) {
		AdminChartContent pMain = new AdminChartContent(user);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSupplyStatus(ActionEvent e) {
		AdminStatusContent pMain = new AdminStatusContent(user);
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnLogout(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "사용자 로그아웃", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			LoginUI loginUI = new LoginUI();
			loginUI.setVisible(true);
			dispose();
		}
	}
}
