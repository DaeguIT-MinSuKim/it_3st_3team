package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class CmbStringComp extends AbstractComboboxComp<String> {

	public CmbStringComp() {

	}

	@Override
	public void loadData(String[] data) {
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>(data);
		comboBox.setModel(dcbm);
	}


}
