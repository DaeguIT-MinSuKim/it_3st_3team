package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.Software_group;

@SuppressWarnings("serial")
public class SoftwareSortCombobox extends AbstractLabelComboBox<Software_group>{

	public SoftwareSortCombobox(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void loadData(Software_group[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
		
	}

	
	
}
