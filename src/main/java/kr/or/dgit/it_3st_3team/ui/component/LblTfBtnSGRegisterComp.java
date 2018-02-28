package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;
import java.util.List;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;

@SuppressWarnings("serial")
public class LblTfBtnSGRegisterComp extends AbstractLblTfBtnComp {

	private List<SoftwareGroup> list;

	/**
	 * Create the panel.
	 */
	public LblTfBtnSGRegisterComp(String title, String btnName) {
		super(title, btnName);
	}

	@Override
	protected void actionPerformedBtn(ActionEvent e) {
		SoftwareGroup sg = new SoftwareGroup();
		String tfSgName = tfInput.getText();
		if(!tfSgName.equals("")) {
			sg.setSgName(tfSgName);
		}
		list = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		
		
		
		
		
	}

}
