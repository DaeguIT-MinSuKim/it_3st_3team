package kr.or.dgit.it_3st_3team.ui.component;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.it_3st_3team.utils.DefineUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ImageComp extends JPanel implements ActionListener {
	private JLabel lblImg;
	private JButton btnImgOK;

	public ImageComp() {
		initComponents();
	}

	private void initComponents() {
		setBounds(0, 0, 168, 220);
		setLayout(null);

		lblImg = new JLabel("");
		lblImg.setBounds(20, 20, 128, 128);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImg);

		btnImgOK = new JButton("사진 등록");
		btnImgOK.setBounds(40, 170, 90, 35);
		btnImgOK.addActionListener(this);
		add(btnImgOK);
		setImageIcon(DefineUtil.DEFAULT_USER_IMG);
	}

	public void setImageIcon(String imgFileName) {
		String imgPath = DefineUtil.DEFAULT_IMG_PATH;
		if (!imgFileName.equals(DefineUtil.DEFAULT_USER_IMG)) {
			imgPath = DefineUtil.USER_IMG_PATH;
		}
		lblImg.setIcon(new ImageIcon(imgPath + imgFileName));
	}
	
	public String getImageIcon() {
		return lblImg.getIcon().toString();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImgOK) {
			actionPerformedBtnImgOK(e);
		}
	}

	protected void actionPerformedBtnImgOK(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png", "jpg", "png");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "사진을 선택하지 않았습니다.");
			return;
		}
		String choosedImgPath = chooser.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(choosedImgPath));
	}
}
