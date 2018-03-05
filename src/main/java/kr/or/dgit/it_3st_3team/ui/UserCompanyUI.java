package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
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
import kr.or.dgit.it_3st_3team.ui.admin.chart.CompanyStatusContent;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareContent;

@SuppressWarnings("serial")
public class UserCompanyUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnRegister;
	private JPanel pContent;
	private JButton btnSupplyStatus;
	private JButton btnSupplyStatusGraph;
	private JButton btnUserModify;
	private User user;

	public UserCompanyUI(User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {
		setTitle("공급회사 - 소프트웨어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pImg = new JPanel();
		pImg.setBackground(new Color(51, 153, 204));
		pImg.setBounds(0, 0, 300, 231);
		contentPane.add(pImg);
		pImg.setLayout(null);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(
				"C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\add-user-interface-outlined-symbol.png"));
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);

		JLabel lblName = new JLabel(String.format("%s님 환영합니다.", user.getName()));
		lblName.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(30, 188, 228, 33);
		pImg.add(lblName);

		JPanel pMenu = new JPanel();
		pMenu.setBounds(new Rectangle(0, 0, 425, 288));
		pMenu.setBackground(new Color(51, 153, 204));
		pMenu.setBounds(0, 230, 300, 631);
		contentPane.add(pMenu);
		pMenu.setLayout(null);

		JLabel lblEmty_2_3 = new JLabel("");
		lblEmty_2_3.setBounds(0, 0, 300, 105);
		pMenu.add(lblEmty_2_3);
		
		btnRegister = new JButton("소프트웨어 등록");
		btnRegister.setBounds(0, 105, 298, 105);
		btnRegister.addActionListener(this);
		btnRegister.setForeground(Color.DARK_GRAY);
		btnRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnRegister.setBackground(new Color(51, 153, 204));
		pMenu.add(btnRegister);

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

		btnUserModify = new JButton("회원정보 수정");
		btnUserModify.addActionListener(this);
		btnUserModify.setBounds(0, 420, 298, 105);
		btnUserModify.setForeground(Color.DARK_GRAY);
		btnUserModify.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnUserModify.setBackground(new Color(51, 153, 204));
		pMenu.add(btnUserModify);

		JLabel label = new JLabel("");
		label.setBounds(0, 525, 300, 105);
		pMenu.add(label);

		pContent = new JPanel();
		pContent.setBounds(298, 0, 1186, 861);
		contentPane.add(pContent);
		pContent.setLayout(null);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUserModify) {
			actionPerformedBtnUserModify(e);
		}
		if (e.getSource() == btnSupplyStatusGraph) {
			actionPerformedBtnSupplyStatusGraph(e);
		}
		if (e.getSource() == btnSupplyStatus) {
			actionPerformedBtnSupplyStatus(e);
		}
		if (e.getSource() == btnRegister) {
			actionPerformedBtnRegister(e);
		}
	}

	protected void actionPerformedBtnRegister(ActionEvent e) {
		pContent.removeAll();
		AdminSoftwareContent panel = new AdminSoftwareContent();
		panel.setBounds(0, 0, 1186, 861);
		pContent.add(panel);
		pContent.revalidate();
		pContent.repaint();
	}

	protected void actionPerformedBtnSupplyStatus(ActionEvent e) {
		pContent.removeAll();
		CompanyStatusContent panel = new CompanyStatusContent();
		panel.setBounds(0, 0, 1186, 861);
		pContent.add(panel);
		pContent.revalidate();
		pContent.repaint();
	}

	protected void actionPerformedBtnSupplyStatusGraph(ActionEvent e) {
		pContent.removeAll();
		CompanyStatusContent panel = new CompanyStatusContent();
		panel.setBounds(0, 0, 1186, 861);
		pContent.add(panel);
		pContent.revalidate();
		pContent.repaint();
	}

	protected void actionPerformedBtnUserModify(ActionEvent e) {
		/*pContent.removeAll();
		UserModifyContent panel = new UserModifyContent(this);
		panel.setBounds(0, 0, 1186, 861);
		pContent.add(panel);
		pContent.revalidate();
		pContent.repaint();*/
	}
}
