package kr.or.dgit.it_3st_3team.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.admin.software.AdminSoftwareRegister;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnSGRegisterComp;
import kr.or.dgit.it_3st_3team.ui.table.AdminSoftwareGroupTable;

@SuppressWarnings("serial")
public class SoftwareGroupUI extends JFrame {

	private JPanel contentPane;
	private AdminSoftwareGroupTable pSgTable;
	private AdminSoftwareRegister parentUi;
	private LblTfBtnSGRegisterComp pInput;

	public SoftwareGroupUI() {
		initComponents();
	}

	private void initComponents() {
		setTitle("분류등록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pSgTable = new AdminSoftwareGroupTable();
		pSgTable.setBackground(new Color(240, 240, 240));
		pSgTable.setBounds(12, 50, 410, 201);
		pSgTable.setUI(this);
		contentPane.add(pSgTable);

		pInput = new LblTfBtnSGRegisterComp("분류 명", "등록");
		pInput.setUI(this);
		pInput.setBounds(12, 10, 410, 30);

		contentPane.add(pInput);

		reFreshList();
	}
	
	public void reFreshList() {
		pSgTable.loadTableDatas(SoftwareGroupService.getInstance().selectSoftwareGroupByAll());
	}
	
	public void reFreshSoftwareGroup() {
		parentUi.reFreshSoftwareGroup();
	}

	public LblTfBtnSGRegisterComp getpInput() {
		return pInput;
	}

	public AdminSoftwareGroupTable getpSgTable() {
		return pSgTable;
	}

	public AdminSoftwareRegister getParentUi() {
		return parentUi;
	}

	public void setParentUI(AdminSoftwareRegister ui) {
		this.parentUi = ui;
	}
}
