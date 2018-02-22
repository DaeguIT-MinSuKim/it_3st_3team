package kr.or.dgit.it_3st_3team.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StatusSalesTeam extends JPanel {

	private JTextField tfSearch;
	private JButton btn1;
	private JTextField tf;
	private String [] option1 = {"관리자","영업1팀","영업2팀","영업3팀","영업4팀","영업5팀"};
	private String [] option2 = {"분류","게임","사무","그래픽"};
	private String [] option3 = {"상호명","재밌는 게임방","좋은 게임방","친구게임방","충청남도교육청","대전광역시교육청","아산시스템"};
	
	public StatusSalesTeam() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(5, 5, 883, 69);
		add(p1);
		p1.setLayout(null);
		
		JComboBox cmbOption1 = new JComboBox(option1);
		cmbOption1.setBounds(0, 6, 110, 21);
		p1.add(cmbOption1);
		
		JComboBox cmbOption2 = new JComboBox(option2);
		cmbOption2.setBounds(122, 6, 110, 21);
		p1.add(cmbOption2);
		
		JComboBox cmbOption3 = new JComboBox(option3);
		cmbOption3.setBounds(244, 6, 110, 21);
		p1.add(cmbOption3);
		
		JComboBox cmbDate1 = new JComboBox();
		cmbDate1.setBounds(373, 6, 110, 21);
		p1.add(cmbDate1);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.CENTER);
		tf.setText("~");
		tf.setColumns(10);
		tf.setBounds(483, 6, 22, 21);
		p1.add(tf);
		
		JComboBox cmbDate2 = new JComboBox();
		cmbDate2.setBounds(505, 6, 110, 21);
		p1.add(cmbDate2);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(637, 6, 172, 21);
		p1.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(811, 5, 60, 23);
		p1.add(btnSearch);
		
		JButton btnReceipt = new JButton("거래명세서");
		btnReceipt.setBounds(657, 37, 105, 23);
		p1.add(btnReceipt);
		
		JButton btnReport = new JButton("보고서");
		btnReport.setBounds(766, 37, 105, 23);
		p1.add(btnReport);
		
		JPanel p2 = new JPanel();
		p2.setBounds(5, 84, 883, 411);
		add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		JPanel pTable = new JPanel();
		p2.add(pTable, BorderLayout.CENTER);
		
		
		
		JPanel pPaging = new JPanel();
		p2.add(pPaging, BorderLayout.SOUTH);
		pPaging.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn1 = new JButton("<");
		pPaging.add(btn1);
		
		JButton btn2 = new JButton("1");
		pPaging.add(btn2);
		
		JButton btn3 = new JButton("2");
		
		pPaging.add(btn3);
		
		JButton btn4 = new JButton("3");
		pPaging.add(btn4);
		
		JButton btn5 = new JButton(">");
	
		pPaging.add(btn5);
	}

}
