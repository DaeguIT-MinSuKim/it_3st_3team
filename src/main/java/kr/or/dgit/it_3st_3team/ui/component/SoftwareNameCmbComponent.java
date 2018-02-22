package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.Software;

@SuppressWarnings("serial")
public class SoftwareNameCmbComponent extends AbstractLabelComboBox<Software> {

	public SoftwareNameCmbComponent(String label) {
		super(label);
	}
	@Override
	public void loadData(Software[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
		
	}

}
