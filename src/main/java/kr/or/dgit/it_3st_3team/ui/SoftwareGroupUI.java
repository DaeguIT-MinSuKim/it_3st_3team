package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.component.AbstractLblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnSGRegisterComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareGroupTable;

@SuppressWarnings("serial")
public class SoftwareGroupUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoftwareGroupUI frame = new SoftwareGroupUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SoftwareGroupUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("분류등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AdminSoftwareGroupTable panel = new AdminSoftwareGroupTable();
		panel.setBackground(new Color(240, 240, 240));
		panel.loadTableDatas(SoftwareGroupService.getInstance().selectSoftwareGroupByAll());
		panel.setBounds(12, 50, 410, 201);
		contentPane.add(panel);
		
		
		LblTfBtnSGRegisterComp panel_1 = new LblTfBtnSGRegisterComp("분류 명", "등록");
		panel_1.setBounds(12, 10, 410, 30);
		
		contentPane.add(panel_1);
		
	}

}
