package kr.or.dgit.it_3st_3team.component;

import javax.swing.DefaultComboBoxModel;

public class StringCombobox extends AbstractCombobox<String> {

	
	public StringCombobox() {

	}

	@Override
	public void loadData(String[] data) {
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(data);
		comboBox.setModel(dcbm);
		
	}

}
