package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;

@SuppressWarnings("serial")
public class LblCmbSoftwareGroupComp extends AbstractLabelComboBox<SoftwareGroup>{

	public LblCmbSoftwareGroupComp(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void loadData(SoftwareGroup[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
		
	}

	
	
}
