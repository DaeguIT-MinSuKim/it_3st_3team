package kr.or.dgit.it_3st_3team.ui.customer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CustomerJoinContent extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_3;
	private JTextField textField_8;

	public CustomerJoinContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pHeader = new JPanel();
		add(pHeader, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		pHeader.add(lblNewLabel);
		
		JPanel pLabel = new JPanel();
		pLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(pLabel, BorderLayout.WEST);
		pLabel.setLayout(new GridLayout(9, 1, 5, 5));
		
		JLabel label_2 = new JLabel("아이디");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_2);
		
		JLabel label_3 = new JLabel("비밀번호");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_3);
		
		JLabel label_4 = new JLabel("비밀번호 확인");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_4);
		
		JLabel label_5 = new JLabel("상호명(이름)");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_5);
		
		JLabel label_6 = new JLabel("전화번호");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_6);
		
		JLabel label_7 = new JLabel("이메일");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_7);
		
		JLabel label_8 = new JLabel("우편번호");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_8);
		
		JLabel label_9 = new JLabel("주소");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.add(label_9);
		
		JLabel lblNewLabel_1 = new JLabel("");
		pLabel.add(lblNewLabel_1);
		
		JPanel pInput = new JPanel();
		pInput.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(pInput, BorderLayout.CENTER);
		pInput.setLayout(new GridLayout(9, 1, 5, 5));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		pInput.add(panel);
		
		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(6, 31));
		textField_3.setMargin(new Insets(0, 2, 0, 2));
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textField_3);
		textField_3.setColumns(12);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton.setPreferredSize(new Dimension(70, 26));
		panel.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		pInput.add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		pInput.add(textField_4);
		
		textField = new JTextField();
		pInput.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		pInput.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		pInput.add(textField_2);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pInput.add(panel_5);
		
		textField_8 = new JTextField();
		textField_8.setPreferredSize(new Dimension(6, 31));
		textField_8.setMargin(new Insets(0, 2, 0, 2));
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(12);
		panel_5.add(textField_8);
		
		JButton btnSchZipCode = new JButton("검색");
		btnSchZipCode.setPreferredSize(new Dimension(70, 26));
		btnSchZipCode.setMargin(new Insets(2, 5, 2, 5));
		btnSchZipCode.setForeground(Color.WHITE);
		btnSchZipCode.setBackground(new Color(51, 153, 255));
		panel_5.add(btnSchZipCode);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		pInput.add(textField_6);
		
		textField_7 = new JTextField();
		pInput.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel pImg = new JPanel();
		pImg.setPreferredSize(new Dimension(138, 138));
		pImg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(pImg, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel_4.setPreferredSize(new Dimension(138, 140));
		panel_4.setMinimumSize(new Dimension(128, 128));
		pImg.add(panel_4);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(128, 128));
		lblImage.setIcon(new ImageIcon("D:\\workspaces\\workspace_java\\it_3st_3team\\DataImg\\apple.png"));
		panel_4.add(lblImage);
		
		JPanel panel_1 = new JPanel();
		pImg.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("등록");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setMaximumSize(new Dimension(50, 23));
		btnNewButton_1.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_1.setMinimumSize(new Dimension(50, 23));
		btnNewButton_1.setPreferredSize(new Dimension(70, 30));
		
		JPanel pBtn = new JPanel();
		pBtn.setPreferredSize(new Dimension(10, 50));
		add(pBtn, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(300, 40));
		pBtn.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("가입");
		panel_2.add(btnNewButton_2);
		btnNewButton_2.setPreferredSize(new Dimension(97, 30));
		
		JButton btnNewButton_3 = new JButton("취소");
		panel_2.add(btnNewButton_3);
		btnNewButton_3.setPreferredSize(new Dimension(97, 30));
	}

}
