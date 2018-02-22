package kr.or.dgit.it_3st_3team;

import java.awt.EventQueue;



public class TestMain {




	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// CustomerJoinUI frame = new CustomerJoinUI();
					// AdminUI frame = new AdminUI();
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



