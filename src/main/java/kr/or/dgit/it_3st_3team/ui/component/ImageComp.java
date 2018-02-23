package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ImageComp extends JPanel implements ActionListener {
	private String imgPath = System.getProperty("user.dir") + "/DataImg/";
	private JLabel lblImg;
	private JButton btnImgOK;

	public ImageComp() {
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

		btnImgOK = new JButton("사진 등록");
		btnImgOK.addActionListener(this);
		pBtnArea.add(btnImgOK);
	}

	public void setImagesIcon(String imgFileName) {
		lblImg.setIcon(new ImageIcon(imgPath + imgFileName));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImgOK) {
			actionPerformedBtnImgOK(e);
		}
	}
	protected void actionPerformedBtnImgOK(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png", "jpg","png");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "사진을 선택하지 않았습니다.");
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(imgPath));
		
	}
}
