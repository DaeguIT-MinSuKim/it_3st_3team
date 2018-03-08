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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.ui.admin.chart.AdminChartContent;
import kr.or.dgit.it_3st_3team.ui.admin.report.AdminStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;
import kr.or.dgit.it_3st_3team.ui.user.CustomerOrderContent;
import kr.or.dgit.it_3st_3team.ui.user.UserModifyContent;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

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

	public UserUI(User user) {
		setUser(user);
		initComponents();
		setUserNameAndAvatar();
	}

	private void initComponents() {
		setTitle("사용자 - 소프트웨어");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pImg = new JPanel();
		pImg.setLayout(null);
		pImg.setBackground(new Color(51, 153, 204));
		pImg.setBounds(0, 0, 300, 231);
		contentPane.add(pImg);

		lblImg = new JLabel("");
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);

		lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblName.setBounds(30, 188, 228, 33);
		pImg.add(lblName);

		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(51, 153, 204));
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
		btnModify.setForeground(Color.DARK_GRAY);
		btnModify.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnModify.setBackground(new Color(51, 153, 204));
		pMenu.add(btnModify);

		pContent = new JPanel();
		pContent.setBounds(298, 0, 1186, 861);
		contentPane.add(pContent);
		pContent.setLayout(null);

		pMain = new JPanel();
		pMain.setBounds(0, 0, 1186, 861);
		pContent.add(pMain);
	}

	private void displayCompanyMenu(JPanel pMenu) {
		btnSWRegister = new JButton("소프트웨어 등록");
		btnSWRegister.setBounds(0, 105, 298, 105);
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(Color.DARK_GRAY);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSWRegister.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSWRegister);

		btnSupplyStatus = new JButton("소프트웨어 공급현황");
		btnSupplyStatus.setBounds(0, 210, 298, 105);
		btnSupplyStatus.addActionListener(this);
		btnSupplyStatus.setForeground(Color.DARK_GRAY);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatus.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatus);

		btnSupplyStatusGraph = new JButton("소프트웨어 공급현황(그래프)");
		btnSupplyStatusGraph.addActionListener(this);
		btnSupplyStatusGraph.setBounds(0, 315, 298, 105);
		btnSupplyStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatusGraph.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatusGraph);
	}

	private void displayCustomerMenu(JPanel pMenu) {
		btnSWOrder = new JButton("소프트웨어 주문");
		btnSWOrder.setBounds(0, 105, 298, 105);
		btnSWOrder.addActionListener(this);
		btnSWOrder.setForeground(Color.DARK_GRAY);
		btnSWOrder.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSWOrder.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSWOrder);

		btnSupplyStatus = new JButton("소프트웨어 주문현황");
		btnSupplyStatus.addActionListener(this);
		btnSupplyStatus.setBounds(0, 210, 298, 105);
		btnSupplyStatus.setForeground(Color.DARK_GRAY);
		btnSupplyStatus.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatus.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatus);

		btnSupplyStatusGraph = new JButton("소프트웨어 주문현황(그래프)");
		btnSupplyStatusGraph.addActionListener(this);
		btnSupplyStatusGraph.setBounds(0, 315, 298, 105);
		btnSupplyStatusGraph.setForeground(Color.DARK_GRAY);
		btnSupplyStatusGraph.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSupplyStatusGraph.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSupplyStatusGraph);
	}

	public void actionPerformed(ActionEvent e) {
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
		System.out.println(user);
	}

	public User getUser() {
		return user;
	}

	public void setUserNameAndAvatar() {
		if (user.getAvatar() == null || user.getAvatar().equals("")) {
			user.setAvatar(DefineUtil.DEFAULT_USER_IMG);
		}
		lblImg.setIcon(new ImageIcon(DefineUtil.IMG_PATH + user.getAvatar()));

		lblName.setText(String.format("%s님 환영합니다.", user.getName()));
	}

	protected void actionPerformedbtnSWOrder(ActionEvent e) {
		CustomerOrderContent pMain = new CustomerOrderContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}

	protected void actionPerformedBtnSWRegister(ActionEvent e) {
		AdminSoftwareContent pMain = new AdminSoftwareContent();
		pMain.setBounds(0, 0, 1186, 861);

		changeMainPanel(pMain);
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
}
