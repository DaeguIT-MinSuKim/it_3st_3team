package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.User;

@SuppressWarnings("serial")
public class LblCmbUserComp extends AbstractLabelComboBoxComp<User> {

	public LblCmbUserComp(String title) {
		super(title);
	}

	@Override
	public void loadData(User[] data) {
		
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
	}

	
}
