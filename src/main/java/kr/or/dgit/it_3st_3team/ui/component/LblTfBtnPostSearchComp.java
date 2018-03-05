package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;

import kr.or.dgit.it_3st_3team.ui.SearchPostUI;

@SuppressWarnings("serial")
public class LblTfBtnPostSearchComp extends AbstractLblTfBtnComp {
	private LblAddressComp pInputAddress;
	
	public LblTfBtnPostSearchComp(String title, String btnName) {
		super(title, btnName);
	}

	@Override
	protected void actionPerformedBtn(ActionEvent e) {
		SearchPostUI frame = new SearchPostUI();
		frame.setVisible(true);
	}

	public void setPanelAddress(LblAddressComp pInputAddress) {
		this.pInputAddress = pInputAddress;
	}

	public LblAddressComp getpInputAddress() {
		return pInputAddress;
	}

}
