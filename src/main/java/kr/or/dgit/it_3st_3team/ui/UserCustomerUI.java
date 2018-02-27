package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kr.or.dgit.it_3st_3team.dto.User;


import kr.or.dgit.it_3st_3team.ui.admin.report.UserStatusContent;

import kr.or.dgit.it_3st_3team.ui.user.CustomerOrderContent;
import kr.or.dgit.it_3st_3team.ui.user.UserModifyContent;

@SuppressWarnings("serial")
public class UserCustomerUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnSWRegister;
	private JPanel pContent;
	private JPanel pMain;
	private JButton btnModify;
	private JButton btnSupplyStatusGraph;
	private JButton btnSupplyStatus;
	private User user;
	
	public UserCustomerUI(User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {
		setTitle("고객 - 소프트웨어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel pImg = new JPanel();
		pImg.setLayout(null);
		pImg.setBackground(new Color(51, 153, 204));
		pImg.setBounds(0, 0, 300, 231);
		contentPane.add(pImg);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("C:\\Users\\SCARLETT\\Desktop\\ppt이용 이미지\\pg IMg\\add-user-interface-outlined-symbol.png"));
		lblImg.setBounds(85, 38, 128, 128);
		pImg.add(lblImg);
		
		JLabel lblName = new JLabel(String.format("%s님 환영합니다.", user.getName()));
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
		
		btnSWRegister = new JButton("소프트웨어 주문");
		btnSWRegister.setBounds(0, 105, 298, 105);
		btnSWRegister.addActionListener(this);
		btnSWRegister.setForeground(Color.DARK_GRAY);
		btnSWRegister.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		btnSWRegister.setBackground(new Color(51, 153, 204));
		pMenu.add(btnSWRegister);
		
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSupplyStatus) {
			actionPerformedBtnSupplyStatus(e);
		}
		if (e.getSource() == btnSupplyStatusGraph) {
			actionPerformedBtnSupplyStatusGraph(e);
		}
		if (e.getSource() == btnSWRegister) {
			actionPerformedbtnSWRegister(e);
		}
		if(e.getSource()== btnModify) {
			actionPerformedbtnModify(e);
		}
	}
	
	protected void actionPerformedbtnSWRegister(ActionEvent e) {
		CustomerOrderContent pMain = new CustomerOrderContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}
	
	protected void actionPerformedbtnModify(ActionEvent e) {
		UserModifyContent pMain = new UserModifyContent();
		pMain.setBounds(0, 0, 1186, 861);
		
		changeMainPanel(pMain);
	}
	
	private void changeMainPanel(JPanel pMain) {
		pContent.removeAll();
		pContent.add(pMain);
		pContent.revalidate();
		pContent.repaint();
	}
	protected void actionPerformedBtnSupplyStatusGraph(ActionEvent e) {
		
		
	}
	protected void actionPerformedBtnSupplyStatus(ActionEvent e) {
		UserStatusContent pMain = new UserStatusContent();
		pMain.setBounds(0, 0, 1186, 861);
		changeMainPanel(pMain);
	}
}
