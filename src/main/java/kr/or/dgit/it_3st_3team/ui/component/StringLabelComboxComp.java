package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class StringLabelComboxComp extends AbstractLabelComboBox<String> {

	public StringLabelComboxComp(String title) {
		super(title);
	}

	@Override
	public void loadData(String[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
	}

	
}
