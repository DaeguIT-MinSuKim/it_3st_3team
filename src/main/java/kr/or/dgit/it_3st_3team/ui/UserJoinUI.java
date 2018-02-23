package kr.or.dgit.it_3st_3team.ui;

import java.awt.EventQueue;

public class UserJoinUI {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinUI frame = new JoinUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
