package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

public class FindIdPw extends JPanel implements ItemListener, ActionListener {
	private JTextField tfFindIdEmail;
	private JTextField tfFindIdEmailDetail;
	private JTextField tfFindPwId;
	private JTextField tfFindPwEmail;
	private JTextField tfFindPwPhone;
	private JRadioButton rdFindId;
	private JRadioButton rdFindPw;
	private JPanel p2;
	private JPanel p3;
	private JButton btnLogIn;
	private LblTfComp p3_1;
	private LblTfComp p3_2;
	private JPanel p3_3;
	private LblTfComp p2_1;
	private JButton btnExit;

	
	public FindIdPw() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		add(p1, BorderLayout.NORTH);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		add(p2, BorderLayout.CENTER);
		p2.setLayout(null);
		
		p2_1 = new LblTfComp((String) "상호명");
		p2_1.setBounds(75, 21, 310, 30);
		p2.add(p2_1);
		
		JLabel lblFindIdEmail = new JLabel("이메일");
		lblFindIdEmail.setBounds(75, 64, 66, 30);
		p2.add(lblFindIdEmail);
		
		tfFindIdEmail = new JTextField();
		tfFindIdEmail.setBounds(132, 65, 150, 30);
		p2.add(tfFindIdEmail);
		tfFindIdEmail.setColumns(10);
		
		tfFindIdEmailDetail = new JTextField();
		tfFindIdEmailDetail.setBounds(305, 65, 150, 30);
		tfFindIdEmailDetail.setColumns(10);
		p2.add(tfFindIdEmailDetail);
		
		JLabel lbl = new JLabel("@");
		lbl.setBounds(284, 66, 20, 27);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lbl);
		
		JComboBox cmbFindIdChooseEmail = new JComboBox();
		cmbFindIdChooseEmail.setBounds(467, 64, 100, 30);
		p2.add(cmbFindIdChooseEmail);
		
		p3 = new JPanel();
		//add(p3, BorderLayout.CENTER);
		p3.setLayout(null);
		
		p3_1 = new LblTfComp((String) "아이디");
		p3_1.setBounds(75, 21, 310, 30);
		p3.add(p3_1);
		p3_1.setLayout(new BoxLayout(p3_1, BoxLayout.X_AXIS));
		
		p3_2 = new LblTfComp((String) "이메일");
		p3_2.setBounds(75, 61, 310, 30);
		p3.add(p3_2);
		
		p3_3 = new LblTfComp((String) "전화번호");
		p3_3.setBounds(75, 101, 310, 30);
		p3.add(p3_3);
		
		ButtonGroup btnG = new ButtonGroup();
		
		rdFindId = new JRadioButton("아이디 찾기");
		rdFindId.setBackground(Color.WHITE);
		rdFindId.addItemListener(this);
		//rdFindId.setSelected(true);
		p1.add(rdFindId);
		
		rdFindPw = new JRadioButton("비밀번호 찾기");
		rdFindPw.setBackground(Color.WHITE);
		rdFindPw.addItemListener(this);
		p1.add(rdFindPw);
		btnG.add(rdFindPw);
		btnG.add(rdFindId);
		
		
		
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.WHITE);
		add(p4, BorderLayout.SOUTH);
		
		btnLogIn = new JButton("아이디찾기");
		p4.add(btnLogIn);
		
		btnExit = new JButton("나가기");
		btnExit.addActionListener(this);
		p4.add(btnExit);
		
		rdFindId.setSelected(true);
	}

	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdFindId) {
			itemStateChangedRdFindId(e);
		}
		if (e.getSource() == rdFindPw) {
			itemStateChangedRdFindPw(e);
		}
	}
	protected void itemStateChangedRdFindPw(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			remove(p2);
			revalidate();
			repaint();
			add(p3, BorderLayout.CENTER);
			btnLogIn.setText("비밀번호찾기");
					}
	}
	protected void itemStateChangedRdFindId(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			remove(p3);
			revalidate();
			repaint();
			add(p2, BorderLayout.CENTER);
			btnLogIn.setText("아이디찾기");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			actionPerformedBtnExit(e);
		}
	}
	protected void actionPerformedBtnExit(ActionEvent e) {
		
	}
}
