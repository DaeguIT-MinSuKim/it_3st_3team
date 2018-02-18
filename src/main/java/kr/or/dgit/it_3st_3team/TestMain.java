package kr.or.dgit.it_3st_3team;

import java.awt.EventQueue;

import kr.or.dgit.it_3st_3team.ui.user.CustomerJoinUI;

public class TestMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerJoinUI frame = new CustomerJoinUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
