package kr.or.dgit.it_3st_3team;

import java.awt.EventQueue;

import kr.or.dgit.it_3st_3team.ui.LoginUI;

public class Client {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
