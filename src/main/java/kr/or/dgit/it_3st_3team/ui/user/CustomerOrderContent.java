package kr.or.dgit.it_3st_3team.ui.user;

import javax.swing.JPanel;
import kr.or.dgit.it_3st_3team.ui.component.CmbSoftwareGroupComp;
import kr.or.dgit.it_3st_3team.ui.component.CmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import java.awt.Color;

@SuppressWarnings("serial")
public class CustomerOrderContent extends JPanel {

	public CustomerOrderContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		CustromerOrderRegister panel = new CustromerOrderRegister();
		panel.setBounds(12, 10, 1176, 166);
		add(panel);
		
		JPanel pSearchArea = new JPanel();
		pSearchArea.setBackground(new Color(255, 255, 255));
		pSearchArea.setBounds(12, 176, 1176, 50);
		add(pSearchArea);
		pSearchArea.setLayout(null);
		
		CmbSoftwareGroupComp pSwGroupCmb = new CmbSoftwareGroupComp();
		pSwGroupCmb.setBounds(12, 10, 200, 30);
		pSearchArea.add(pSwGroupCmb);
		
		CmbUserComp pUserCmb = new CmbUserComp();
		pUserCmb.setBounds(233, 10, 200, 30);
		pSearchArea.add(pUserCmb);
		
		TfBtnSearchComp pSearchTfBtn = new TfBtnSearchComp("검색");
		pSearchTfBtn.setBounds(447, 10, 717, 30);
		pSearchArea.add(pSearchTfBtn);
		
		JPanel pTable = new JPanel();
		pTable.setBounds(12, 226, 1176, 519);
		add(pTable);
		
		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 755, 1176, 45);
		add(pPaging);
	}
}
