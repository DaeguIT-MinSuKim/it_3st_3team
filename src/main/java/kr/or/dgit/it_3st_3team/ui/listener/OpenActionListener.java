package kr.or.dgit.it_3st_3team.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenActionListener implements ActionListener {
	private JFileChooser chooser;
	private JLabel imgLabel;

	public OpenActionListener(JLabel imgLabel) {
		this.imgLabel = imgLabel;
		chooser = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG & GIF Images", "png", "jpg", "gif");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			return;
		}
		
		File imgFile = chooser.getSelectedFile();
		imgLabel.setIcon(new ImageIcon(imgFile.getPath()));
	}

}
