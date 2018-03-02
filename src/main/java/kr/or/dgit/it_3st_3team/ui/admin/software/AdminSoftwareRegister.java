package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminSoftwareRegister extends JPanel implements ActionListener {
	private JFileChooser chooser;
	private JButton btnSubmitCF;
	private LblCmbSoftwareGroupComp pSWsort;
	private LblCmbUserComp pCompany;
	private LblTfComp pSWName;
	private LblTfComp pSupplyPrice;
	private LblTfComp pSalePrice;
	private LblTfComp pCount;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareRegister() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(new Color(240, 240, 240));
		pRegister.setBounds(0, 0, 1200, 191);
		add(pRegister);
		pRegister.setLayout(null);
		
		btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.addActionListener(this);
		btnSubmitCF.setBounds(779, 29, 97, 23);
		pRegister.add(btnSubmitCF);
		
		List<User> lists1 = UserService.getInstance().listUserAll();
		User[] usDatas = lists1.toArray(new User[lists1.size()]);
		
		pCompany = new LblCmbUserComp("공급회사");
		pCompany.setBorder(null);
		pCompany.setBounds(238, 27, 243, 30);
		pCompany.loadData(usDatas);
		pRegister.add(pCompany);
		
	
		
		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);
		
		pSWsort = new LblCmbSoftwareGroupComp("분류");
		pSWsort.setBounds(556, 27, 183, 30);
		pSWsort.loadData(sgDatas);
		pRegister.add(pSWsort);

		
		ImageComp pRegisterImg = new ImageComp();
		pRegisterImg.setBounds(0, 0, 205, 191);
		pRegister.add(pRegisterImg);
		
		pSWName = new LblTfComp("품목 명");
		pSWName.setBounds(541, 73, 340, 30);
		pRegister.add(pSWName);
		
		pSupplyPrice = new LblTfComp("공급 가격");
		pSupplyPrice.setBounds(239, 120, 242, 30);
		pRegister.add(pSupplyPrice);
		
		pSalePrice = new LblTfComp("판매 가격");
		pSalePrice.setBounds(238, 73, 243, 30);
		pRegister.add(pSalePrice);
		
		pCount = new LblTfComp("수량");
		pCount.setBounds(556, 120, 126, 30);
		pRegister.add(pCount);
	}
	
	
	
	
	public LblCmbUserComp getpCompany() {
		return pCompany;
	}
	public LblTfComp getpSWName() {
		return pSWName;
	}
	public LblTfComp getpSupplyPrice() {
		return pSupplyPrice;
	}
	public LblTfComp getpSalePrice() {
		return pSalePrice;
	}
	public LblTfComp getpCount() {
		return pCount;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmitCF) {
			actionPerformedBtnSubmitCF(e);
		}
	}
	protected void actionPerformedBtnSubmitCF(ActionEvent e) {
		SoftwareGroupUI softwareGroupUI = new SoftwareGroupUI();
		softwareGroupUI.setParentUI(this);
		softwareGroupUI.setVisible(true);
	}
	
	public LblCmbSoftwareGroupComp getpSWsort() {
		return pSWsort;
	}
	
	
}
