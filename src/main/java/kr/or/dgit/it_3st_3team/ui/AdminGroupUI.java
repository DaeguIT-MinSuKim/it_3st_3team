package kr.or.dgit.it_3st_3team.ui;

import java.awt.EventQueue;

import kr.or.dgit.it_3st_3team.ui.admin.management.AdminGroupContent;

public class AdminGroupUI {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGroupContent frame = new AdminGroupContent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
