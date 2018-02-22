package kr.or.dgit.it_3st_3team.ui;

import java.awt.EventQueue;

import kr.or.dgit.it_3st_3team.ui.common.JoinContent;

public class UserJoinUI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinContent frame = new JoinContent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
