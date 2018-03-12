package kr.or.dgit.it_3st_3team.ui.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ProgramCloseAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "프로그램을 종료하시겠습니까?", "소프트웨어 종료", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			System.exit(0);
		}
	}
}
