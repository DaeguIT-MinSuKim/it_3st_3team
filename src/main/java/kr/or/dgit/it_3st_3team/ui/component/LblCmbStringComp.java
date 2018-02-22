package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class LblCmbStringComp extends AbstractLabelComboBox<String> {

	public LblCmbStringComp(String title) {
		super(title);
	}

	@Override
	public void loadData(String[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
	}

	
}
