package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ImageComponent extends JPanel {
	private String imgPath = System.getProperty("user.dir") + "/DataImg/";
	private JLabel lblImg;

	public ImageComponent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 249, 269);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pImgArea = new JPanel();
		pImgArea.setBackground(Color.WHITE);
		pImgArea.setBorder(new EmptyBorder(10, 10, 10, 10));
		pImgArea.setLayout(new GridLayout(0, 1, 0, 0));
		add(pImgArea);

		lblImg = new JLabel("");
		setImagesIcon("nobody.png");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pImgArea.add(lblImg);

		JPanel pBtnArea = new JPanel();
		pBtnArea.setBackground(Color.WHITE);
		pBtnArea.setBorder(new EmptyBorder(10, 20, 10, 20));
		pBtnArea.setLayout(new GridLayout(0, 1, 0, 0));
		add(pBtnArea);

		JButton btnImgOK = new JButton("사진 등록");
		pBtnArea.add(btnImgOK);
	}

	public void setImagesIcon(String imgFileName) {
		lblImg.setIcon(new ImageIcon(imgPath + imgFileName));
	}
}
