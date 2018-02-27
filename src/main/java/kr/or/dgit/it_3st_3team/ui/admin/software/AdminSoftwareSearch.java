package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminSoftwareSearch extends JPanel {
	private JTextField textField;

	public AdminSoftwareSearch() {

		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel pSWSearch = new JPanel();
		pSWSearch.setBackground(new Color(244, 244, 244));
		pSWSearch.setBounds(0, 0, 939, 42);
		add(pSWSearch);
		pSWSearch.setLayout(null);

		CmbStringComp pSWNamePCName = new CmbStringComp();
		pSWNamePCName.setBounds(148, 9, 137, 25);
		pSWSearch.add(pSWNamePCName);
		
		textField = new JTextField();
		textField.setBounds(312, 7, 615, 27);
		pSWSearch.add(textField);
		textField.setColumns(10);
	}
}
