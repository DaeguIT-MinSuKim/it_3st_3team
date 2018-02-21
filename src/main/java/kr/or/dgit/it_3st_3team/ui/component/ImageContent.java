package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class ImageContent extends JPanel {
	private String imgPath = System.getProperty("user.dir") + "/DataImg/";
	private JLabel lblImage;
	
	public ImageContent() {
		initComponents();
	}
	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 209, 225);
		
		JPanel pImageArea = new JPanel();
		pImageArea.setBackground(Color.WHITE);
		add(pImageArea, BorderLayout.CENTER);
		
		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		pImageArea.add(lblImage);
		setImagesIcon("nobody.png");
		
		JPanel pBtnArea = new JPanel();
		pBtnArea.setBackground(Color.WHITE);
		add(pBtnArea, BorderLayout.SOUTH);
		
		JButton btnImageOK = new JButton("사진 등록");
		btnImageOK.setPreferredSize(new Dimension(100, 30));
		pBtnArea.add(btnImageOK);
	}

	public void setImagesIcon(String imgFileName) {
		lblImage.setIcon(new ImageIcon(imgPath + imgFileName));
	}
}
