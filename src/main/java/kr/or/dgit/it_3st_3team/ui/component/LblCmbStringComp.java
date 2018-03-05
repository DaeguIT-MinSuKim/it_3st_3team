package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class LblCmbStringComp extends AbstractLabelComboBoxComp<String> {

	public LblCmbStringComp(String title) {
		super(title);
	}

	@Override
	public void loadData(String[] list) {
		dcbm = new DefaultComboBoxModel<>(list);
		cmbBox.setModel(dcbm);
	}

}
