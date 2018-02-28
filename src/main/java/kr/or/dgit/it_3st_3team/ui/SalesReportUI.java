package kr.or.dgit.it_3st_3team.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnComboReportSearchComp;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesReportUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	protected JRadioButton rdReport;
	protected JRadioButton rdTransaction;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnReport;
	private JComboBox<String> cmbString;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesReportUI frame = new SalesReportUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SalesReportUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("판매보고서");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(5, 5, 774, 40);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel lblReport = new JLabel("판매보고서");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setBounds(345, 10, 84, 15);
		p1.add(lblReport);
		
		JPanel p2 = new JPanel();
		p2.setBounds(5, 49, 281, 40);
		contentPane.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));
		
		ButtonGroup btnG = new ButtonGroup();
		
		
		rdReport = new JRadioButton("보고서");
	
		p2.add(rdReport);
		
		rdTransaction = new JRadioButton("거래명세서");
		p2.add(rdTransaction);
		btnG.add(rdReport);
		btnG.add(rdTransaction);
		
		StartAndEndDate p3 = new StartAndEndDate();
		p3.setBounds(321, 46, 458, 43);
		contentPane.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setBounds(5, 92, 758, 30);
		contentPane.add(p4);
		p4.setLayout(null);
		
		
		
		JPanel p4_1 = new JPanel();
		p4_1.setBounds(0, 0, 544, 30);
		p4.add(p4_1);
		p4_1.setLayout(null);
		
		cmbString = new JComboBox<>();
		cmbString.setBounds(0, 0, 125, 30);
		p4_1.add(cmbString);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(137, 0, 326, 30);
		p4_1.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(475, 0, 60, 30);
		p4_1.add(btnSearch);
		
		btnReport = new JButton("보고서");
		btnReport.addActionListener(this);
		btnReport.setBounds(658, 0, 100, 30);
		p4.add(btnReport);
		
		//보고서가 기본으로 선택되어 나옴
		rdReport.setSelected(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReport) {
			actionPerformedBtnReport(arg0);
		}
	}
	protected void actionPerformedBtnReport(ActionEvent arg0) {
		JFrame jf = new SalesReportDetailsUI();
		jf.setVisible(true);
	}
}
