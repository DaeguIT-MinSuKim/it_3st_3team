package kr.or.dgit.it_3st_3team.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ImageContent extends JPanel {

	private JLabel lblImage;
	public ImageContent() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pImageArea = new JPanel();
		add(pImageArea, BorderLayout.CENTER);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("D:\\workspaces\\workspace_java\\it_3st_3team\\DataImg\\mcdonalds.png"));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		pImageArea.add(lblImage);
		
		JPanel pBtnArea = new JPanel();
		add(pBtnArea, BorderLayout.SOUTH);
		
		JButton btnImageOK = new JButton("이미지 등록");
		pBtnArea.add(btnImageOK);
	}

}
