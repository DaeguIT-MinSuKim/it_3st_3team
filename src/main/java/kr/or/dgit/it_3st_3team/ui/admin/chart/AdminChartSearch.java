package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.AdminService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminChartSearch extends JPanel implements ActionListener {
	protected JTextField tfSearch;
	protected DefaultComboBoxModel<SoftwareGroup> dcbm;
	private SoftwareGroupService swgService;
	private AdminService adService;
	private JComboBox<Admin> cmbAdmin;
	private Admin admin;
	private User user;
	private List<SoftwareGroup> swg;
	private JPanel p1;
	private JButton btnType;
	private JButton btnPayment;
	private JPanel p2;
	private AdminChartContent parent;

	public AdminChartSearch(Object who) {
		setUsingUser(who);
		swgService = SoftwareGroupService.getInstance();
		adService = AdminService.getInstance();

		initComponents();
	}

	// get & set 메소드
	public void setCmbAdGroup() {
		// 관리자 콤보박스 넣는 코드
		List<Admin> ad = new ArrayList<>();
		ad = adService.listAdminAll();
		Admin[] items = new Admin[ad.size()];
		ad.toArray(items);
		DefaultComboBoxModel<Admin> dcbm = new DefaultComboBoxModel<>(items);
		cmbAdmin.setModel(dcbm);
	}

	
	
	public Admin getSelectedAdmin() {
		return (Admin) cmbAdmin.getSelectedItem();
	}

	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		p1 = new JPanel();
		p1.setBorder(new EmptyBorder(0, 10, 0, 0));
		add(p1);
		p1.setLayout(null);
		
		p2 = new JPanel();
		p2.setBorder(new EmptyBorder(0, 0, 0, 20));
		add(p2);
		p2.setLayout(null);
		
		btnType = new JButton("품목별 판매개수현황");
		btnType.addActionListener(this);
		btnType.setBounds(150, 0, 200, 30);
		p1.add(btnType);
		
		
		
		if (admin != null) {
			System.out.println(admin);
			// 관리자
			
			btnPayment = new JButton("결제타입별 사용현황");
			btnPayment.addActionListener(this);
			btnPayment.setBounds(365, 0, 200, 30);
			p1.add(btnPayment);
			if (admin.getAdminGroup().getAgNo() == 1) {
				// 총관리자
				cmbAdmin = new JComboBox<>();
				cmbAdmin.setBounds(10, 0, 125, 30);
				p1.add(cmbAdmin);
				setCmbAdGroup();
				
				
			}else {
				btnType.setBounds(10, 0, 200, 30);
				btnPayment.setBounds(225, 0, 200, 30);
			}
			
		} else {
			if (user.getUserGroup().getValue() == 1) {
				// 고객
				btnType.setBounds(10, 0, 200, 30);
				btnType.setText("품목별 구매개수현황");
			} else {
				// 공급회사
				btnType.setBounds(10, 0, 200, 30);
			}
		}
		
		
	}

	public void setParent(AdminChartContent parent) {
		this.parent = parent;
	}
	
	// 초기화
	public void clearItem() {
		if (admin != null) {
			// 관리자
			if (admin.getAdminGroup().getAgNo() == 1) {
				cmbAdmin.setSelectedIndex(0);
			} else {
		
			}
		} else {
			// 사용자
			if (user.getUserGroup().getValue() == 1) {
		
			} else {
			
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnType) {
			actionPerformedBtnType(arg0);
		}
		if (arg0.getSource() == btnPayment) {
			actionPerformedBtnPayment(arg0);
		}
	}
	
	private void actionPerformedBtnPayment(ActionEvent arg0) {
		if (admin != null) {
			// 관리자
			if (admin.getAdminGroup().getAgNo() == 1) {
				Admin who = (Admin) cmbAdmin.getSelectedItem();
				parent.createChartByPayment(who);
			} else {
				//영업사원
				parent.createChartByPayment(admin);
			}
		}
		
	}

	//버튼을 누르면 
	protected void actionPerformedBtnType(ActionEvent arg0) {
		if (admin != null) {
			// 관리자
			if (admin.getAdminGroup().getAgNo() == 1) {
				Admin who = (Admin) cmbAdmin.getSelectedItem();
				parent.createChartByType(who);
			} else {
				//영업사원
				parent.createChartByType(admin);
			}
		} else {
			// 사용자
			parent.createChartByType(user);
		}
	}
}
