package kr.or.dgit.it_3st_3team.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class Login extends JPanel {
	private JTextField pLgnUserId;
	private JTextField pLgnUserPwd;

	/**
	 * Create the panel.
	 */
	public Login() {

		initComponents();
	}
	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setBorder(null);
		setToolTipText("login\r\n");
		setForeground(Color.BLACK);
		
		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(1, 1, 1, 1));
		
		JLabel lblTitle = new JLabel("DGIT s/w sales program");
		lblTitle.setFont(new Font("나눔바른고딕", Font.BOLD, 39));
		lblTitle.setForeground(new Color(0, 0, 0));
		GroupLayout gl_p1 = new GroupLayout(p1);
		gl_p1.setHorizontalGroup(
			gl_p1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_p1.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(lblTitle)
					.addGap(150))
		);
		gl_p1.setVerticalGroup(
			gl_p1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_p1.createSequentialGroup()
					.addGap(46)
					.addComponent(lblTitle)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		p1.setLayout(gl_p1);
		
		JPanel p3 = new JPanel();
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		btnFindIdPwd.setBackground(Color.DARK_GRAY);
		p3.add(btnFindIdPwd);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBackground(Color.DARK_GRAY);
		p3.add(btnJoin);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p2.getLayout();
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.DARK_GRAY);
		p2.add(btnLogin);
		
		JCheckBox chkAdmin = new JCheckBox("관리자 로그인");
		p2.add(chkAdmin);
		
		JLabel lblLgnUSerPwd = new JLabel("비밀번호");
		lblLgnUSerPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		pLgnUserPwd = new JTextField();
		pLgnUserPwd.setColumns(10);
		
		pLgnUserId = new JTextField();
		pLgnUserId.setColumns(10);
		
		JLabel lblLgnUserId = new JLabel("아이디");
		lblLgnUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(271)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLgnUSerPwd, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLgnUserId, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pLgnUserId)
								.addComponent(pLgnUserPwd, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(255)
							.addComponent(p2, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(p3, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(170)
							.addComponent(p1, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(p1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLgnUserId, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(pLgnUserId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLgnUSerPwd, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(pLgnUserPwd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(p2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(p3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

}
