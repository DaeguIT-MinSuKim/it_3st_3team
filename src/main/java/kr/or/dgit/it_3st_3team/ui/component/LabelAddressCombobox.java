package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.Address;

@SuppressWarnings("serial")
public class LabelAddressCombobox extends AbstractLabelComboBox<Address>{

	public LabelAddressCombobox(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void loadData(Address[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
		
	}

	
	
}
