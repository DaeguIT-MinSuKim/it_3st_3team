package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;

@SuppressWarnings("serial")
public class AdminCustomerOrderContent extends JPanel {

	public AdminCustomerOrderContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 850);
		
		JPanel pSearchArea = new JPanel();
		pSearchArea.setBounds(12, 204, 1176, 60);
		add(pSearchArea);
		pSearchArea.setLayout(null);
		
		CmbSoftwareGroupComp pSwGroupCmb = new CmbSoftwareGroupComp();
		pSwGroupCmb.setBounds(12, 10, 200, 40);
		pSearchArea.add(pSwGroupCmb);
		
		CmbUserComp pUserCmb = new CmbUserComp();
		pUserCmb.setBounds(233, 10, 200, 40);
		pSearchArea.add(pUserCmb);
		
		TfBtnSearchComp pSearchTfBtn = new TfBtnSearchComp("검색");
		pSearchTfBtn.setBounds(447, 10, 717, 41);
		pSearchArea.add(pSearchTfBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 1176, 184);
		add(panel);
	}
}
