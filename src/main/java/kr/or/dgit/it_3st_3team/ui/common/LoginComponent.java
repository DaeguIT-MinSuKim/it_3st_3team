package kr.or.dgit.it_3st_3team.ui.common;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;
import java.awt.Color;
import kr.or.dgit.it_3st_3team.ui.component.LabelPwdFieldComponent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginComponent extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoginComponent() {

		initComponents();
	}
	private void initComponents() {
		setBounds(new Rectangle(0, 0, 1500, 900));
		setLayout(new BorderLayout(0, 0));
		
		JPanel pLogin = new JPanel();
		pLogin.setBackground(Color.WHITE);
		pLogin.setBounds(new Rectangle(0, 0, 1500, 900));
		add(pLogin);
		pLogin.setLayout(null);
		
		LabelTextFieldComponent pID = new LabelTextFieldComponent("userId");
		pID.setFont(new Font("Gulim", Font.PLAIN, 12));
		pID.setTfText("userID");
		pID.setBounds(576, 409, 347, 51);
		pLogin.add(pID);
		
		LabelPwdFieldComponent pPW = new LabelPwdFieldComponent("password");
		pPW.setBounds(556, 481, 367, 51);
		pLogin.add(pPW);
		
		JPanel pCheck = new JPanel();
		pCheck.setLayout(null);
		pCheck.setBackground(Color.WHITE);
		pCheck.setBounds(616, 558, 255, 33);
		pLogin.add(pCheck);
		
		JButton button = new JButton("로그인");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		button.setBackground(Color.WHITE);
		button.setBounds(28, 5, 78, 23);
		pCheck.add(button);
		
		JCheckBox checkBox = new JCheckBox("관리자 로그인");
		checkBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(127, 5, 95, 23);
		pCheck.add(checkBox);
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(Color.WHITE);
		pRegister.setBounds(576, 612, 367, 56);
		pLogin.add(pRegister);
		pRegister.setLayout(null);
		
		JButton btnNewButton = new JButton("회원 가입");
		btnNewButton.setBounds(34, 10, 114, 23);
		pRegister.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("아이디/비밀번호 찾기");
		btnNewButton_1.setBounds(173, 10, 159, 23);
		pRegister.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("DGIT SW sales program");
		lblNewLabel.setFont(new Font("다음_Regular", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(333, 131, 781, 121);
		pLogin.add(lblNewLabel);
	}
}
