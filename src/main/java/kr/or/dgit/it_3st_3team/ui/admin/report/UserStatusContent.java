package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.PagingComp;
import kr.or.dgit.it_3st_3team.ui.table.UserStatusLists;

@SuppressWarnings("serial")
public class UserStatusContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserStatusContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		UserStatusSearch panel = new UserStatusSearch();
		panel.setBounds(12, 10, 1178, 96);
		add(panel);

		UserStatusLists panel_1 = new UserStatusLists();
		panel_1.setBounds(12, 116, 1176, 418);
		add(panel_1);

		PagingComp panel_2 = new PagingComp();
		panel_2.setBounds(12, 544, 1176, 40);
		add(panel_2);
	}

}
