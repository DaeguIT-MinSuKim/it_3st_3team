package kr.or.dgit.it_3st_3team.ui.component;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;

@SuppressWarnings("serial")
public class LblCmbStringComp extends AbstractLabelComboBoxComp<String> {

	public LblCmbStringComp(String title) {
		super(title);
	}

	@Override
	public void loadData(String[] data) {
		List<SoftwareGroup> sgList = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		data = new String[sgList.size()];
		for(int i=0; i<sgList.size(); i++) {
			data[i] = sgList.get(i).getSgName();
		}
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
	}

	
}
