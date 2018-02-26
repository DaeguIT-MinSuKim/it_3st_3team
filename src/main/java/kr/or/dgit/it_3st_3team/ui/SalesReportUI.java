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

public class SalesReportUI extends JFrame {

	private JPanel contentPane;
	protected JRadioButton rdReport;
	protected JRadioButton rdTransaction;

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
		
		JLabel lblNewLabel = new JLabel("판매보고서");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(345, 10, 84, 15);
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		p2.setBounds(5, 49, 281, 40);
		contentPane.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdReport);
		btnG.add(rdTransaction);
		
		rdReport = new JRadioButton("보고서");
	
		p2.add(rdReport);
		
		rdTransaction = new JRadioButton("거래명세서");
		p2.add(rdTransaction);
		
		StartAndEndDate p3 = new StartAndEndDate();
		p3.setBounds(321, 46, 458, 43);
		contentPane.add(p3);
		
		TfBtnComboReportSearchComp p4 = new TfBtnComboReportSearchComp();
		p4.setBounds(5, 91, 774, 30);
		contentPane.add(p4);
		
		
	}
	
}
