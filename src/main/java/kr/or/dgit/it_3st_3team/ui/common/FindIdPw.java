package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.EmptyBorder;

public class FindIdPw extends JPanel implements ItemListener {
	private JTextField tfFindIdName;
	private JTextField tfFindIdEmail;
	private JTextField tfFindIdEmailDetail;
	private JTextField tfFindPwId;
	private JTextField tfFindPwEmail;
	private JTextField tfFindPwPhone;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JRadioButton rdFindId;
	private JRadioButton rdFindPw;
	private JPanel p2;
	private JPanel p3;
	private JButton btnLogIn;

	
	public FindIdPw() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JPanel p1 = new JPanel();
		add(p1, BorderLayout.NORTH);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		p2 = new JPanel();
		add(p2, BorderLayout.CENTER);
		p2.setLayout(null);
		
		JLabel lblFindIdName = new JLabel("상호명");
		lblFindIdName.setBounds(48, 38, 66, 15);
		p2.add(lblFindIdName);
		
		tfFindIdName = new JTextField();
		tfFindIdName.setBounds(126, 35, 116, 21);
		p2.add(tfFindIdName);
		tfFindIdName.setColumns(10);
		
		JLabel lblFindIdEmail = new JLabel("이메일");
		lblFindIdEmail.setBounds(48, 72, 66, 15);
		p2.add(lblFindIdEmail);
		
		tfFindIdEmail = new JTextField();
		tfFindIdEmail.setBounds(126, 69, 116, 21);
		p2.add(tfFindIdEmail);
		tfFindIdEmail.setColumns(10);
		
		tfFindIdEmailDetail = new JTextField();
		tfFindIdEmailDetail.setBounds(254, 69, 116, 21);
		tfFindIdEmailDetail.setColumns(10);
		p2.add(tfFindIdEmailDetail);
		
		JLabel lbl = new JLabel("@");
		lbl.setBounds(242, 72, 12, 15);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(lbl);
		
		JComboBox cmbFindIdChooseEmail = new JComboBox();
		cmbFindIdChooseEmail.setBounds(374, 69, 85, 21);
		p2.add(cmbFindIdChooseEmail);
		
		p3 = new JPanel();
		//add(p3, BorderLayout.CENTER);
		p3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(75, 24, 57, 15);
		p3.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 21, 136, 21);
		p3.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("이메일");
		label.setBounds(75, 66, 57, 15);
		p3.add(label);
		
		JLabel label_1 = new JLabel("전화번호");
		label_1.setBounds(75, 104, 57, 15);
		p3.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 63, 136, 21);
		p3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 101, 136, 21);
		p3.add(textField_2);
		
		ButtonGroup g = new ButtonGroup();
		
		rdFindId = new JRadioButton("아이디 찾기");
		rdFindId.addItemListener(this);
		//rdFindId.setSelected(true);
		p1.add(rdFindId);
		
		rdFindPw = new JRadioButton("비밀번호 찾기");
		rdFindPw.addItemListener(this);
		p1.add(rdFindPw);
		g.add(rdFindPw);
		g.add(rdFindId);
		
		
		
		
		JPanel p4 = new JPanel();
		add(p4, BorderLayout.SOUTH);
		
		btnLogIn = new JButton("아이디찾기");
		p4.add(btnLogIn);
		
		JButton btnExit = new JButton("나가기");
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
}
