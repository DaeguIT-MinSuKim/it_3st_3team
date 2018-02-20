package kr.or.dgit.it_3st_3team.ui;

import java.awt.EventQueue;

import kr.or.dgit.it_3st_3team.ui.company.UserJoinContent;

public class UserJoinUI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserJoinContent frame = new UserJoinContent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
