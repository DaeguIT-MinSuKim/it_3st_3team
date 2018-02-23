package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class TestCheckbox extends JPanel {

	
	public TestCheckbox() {

		initComponents();
	}
	private void initComponents() {
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("수정");
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("삭제");
		add(chckbxNewCheckBox_1);
	}

}
