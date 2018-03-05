package kr.or.dgit.it_3st_3team.ui.admin.software;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.TfBtnSearchComp;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdminSoftwareSearch extends JPanel {
	private JTextField tfSearch;
	private CmbStringComp pCmbSearch;

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

		pCmbSearch = new CmbStringComp();	//분류별,품목명
		pCmbSearch.setBounds(148, 9, 137, 25);
		pSWSearch.add(pCmbSearch);
		String[] st = { "공급회사명", "품목명","분류" };
		pCmbSearch.loadData(st);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(312, 7, 615, 27);
		pSWSearch.add(tfSearch);
		tfSearch.setColumns(10);
	}

	public String getTfSearch() {
		return tfSearch.getText().trim();
	}

	public void setTfSearch(String text) {
		tfSearch.setText(text);
	}
	
	public void requestTfFocus() {
		tfSearch.requestFocus();
	}
	
	
	
	public CmbStringComp getpCmbSearch() {
		return pCmbSearch;
	}



	public boolean isTfEmpty(String message) {
		if (tfSearch.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "검색어를 입력해주세요");
			tfSearch.setText("");
			tfSearch.requestFocus();
			return true;
		}
		return false;
	}

	
}
