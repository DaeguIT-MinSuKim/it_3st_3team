package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;

import kr.or.dgit.it_3st_3team.ui.SearchPostUI;

@SuppressWarnings("serial")
public class LblTfBtnPostSearchComp extends AbstractLblTfBtnComp {

	/**
	 * Create the panel.
	 */
	public LblTfBtnPostSearchComp(String title, String btnName) {
		super(title, btnName);
	}

	@Override
	protected void actionPerformedBtn(ActionEvent e) {
		SearchPostUI frame = new SearchPostUI();
		frame.setVisible(true);
	}

}
