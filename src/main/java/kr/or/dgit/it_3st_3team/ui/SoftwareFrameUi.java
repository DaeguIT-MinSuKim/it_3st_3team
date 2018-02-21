package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.panel.StatusManagement;
import kr.or.dgit.it_3st_3team.panel.SupplyingCompany;



public class SoftwareFrameUi extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoftwareFrameUi frame = new SoftwareFrameUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SoftwareFrameUi() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel p1 = new JPanel();
		contentPane.add(p1, BorderLayout.NORTH);
		
	//	JLabel lblNewLabel = new JLabel("공급회사등록");
		JLabel lblNewLabel = new JLabel("현황관리");
		p1.add(lblNewLabel);
		
		
		
	//	SupplyingCompany panel = new SupplyingCompany();
		StatusManagement panel = new StatusManagement();
	//	StatusSalesTeam panel = new StatusSalesTeam();
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
