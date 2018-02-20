package kr.or.dgit.it_3st_3team.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login extends JPanel implements ActionListener {
	private JTextField tfLgnUserId;
	private JPasswordField tfLgnUserPwd;
	private JButton btnLogin;
	private String imgPath = System.getProperty("user.dir")+"/DataImg/";
	private BufferedImage img=null;
	/**
	 * Create the panel.
	 */
	public Login() {

		initComponents();
	}
	
	public void img() {
		try {
			img = ImageIO.read(new File(imgPath+"loginTitle.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이미지 불러오기 실패");
		}
	}
	
	class ImgPanel extends JPanel{
        public void paint(Graphics g){
            g.drawImage(img, 0, 0, null);
        }
    }


	
	private void initComponents() {
		setBackground(Color.WHITE);
		setBorder(null);
		setToolTipText("login");
		setForeground(Color.BLACK);
		setLayout(null);
		
		JPanel pLogin = new JPanel();
		pLogin.setBounds(0, 0, 900, 500);
		add(pLogin);
		pLogin.setLayout(null);
		
		JLabel lblTitle = new JLabel("DGIT s/w sales program");
		lblTitle.setBounds(233, 104, 432, 46);
		pLogin.add(lblTitle);
		lblTitle.setFont(new Font("나눔바른고딕", Font.BOLD, 39));
		lblTitle.setForeground(new Color(0, 0, 0));
		
		JLabel lblLgnUSerPwd = new JLabel("비밀번호");
		lblLgnUSerPwd.setBounds(298, 285, 59, 28);
		pLogin.add(lblLgnUSerPwd);
		lblLgnUSerPwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblLgnUSerPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblLgnUserId = new JLabel("아이디");
		lblLgnUserId.setBounds(296, 244, 58, 28);
		pLogin.add(lblLgnUserId);
		lblLgnUserId.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		lblLgnUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfLgnUserId = new JTextField("UserId");
		tfLgnUserId.setBounds(378, 244, 172, 31);
		pLogin.add(tfLgnUserId);
		tfLgnUserId.setColumns(10);
		
		tfLgnUserPwd = new JPasswordField();
		tfLgnUserPwd.setBounds(378, 283, 172, 31);
		pLogin.add(tfLgnUserPwd);
		
		JPanel p2 = new JPanel();
		p2.setBounds(334, 323, 255, 33);
		pLogin.add(p2);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(28, 5, 78, 23);
		p2.add(btnLogin);
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);
		
		JCheckBox chkAdmin = new JCheckBox("관리자 로그인");
		chkAdmin.setBounds(127, 5, 95, 23);
		p2.add(chkAdmin);
		chkAdmin.setBackground(Color.WHITE);
		chkAdmin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		
		JPanel p3 = new JPanel();
		p3.setBounds(281, 364, 351, 33);
		pLogin.add(p3);
		p3.setBackground(Color.WHITE);
		p3.setLayout(null);
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		btnFindIdPwd.setBounds(143, 5, 172, 23);
		p3.add(btnFindIdPwd);
		btnFindIdPwd.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnFindIdPwd.setBackground(Color.WHITE);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(30, 5, 98, 23);
		p3.add(btnJoin);
		btnJoin.setForeground(Color.BLACK);
		btnJoin.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		btnJoin.setBackground(Color.WHITE);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent e) {
		String id = tfLgnUserId.getText();
		char[] pass=tfLgnUserPwd.getPassword();
		String password = new String(pass);
		if(id.equals("UserId") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디,비밀번호를 입력해주세요");
		}else {
			
		}
		
	}
}
