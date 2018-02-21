package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class ImageComponent extends JPanel {
	private String imgPath = System.getProperty("user.dir") + "\\DataImg\\";
	
	public ImageComponent() {
		System.out.println(imgPath);
		initComponents();
	}
	private void initComponents() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 249, 269);
		setImagesIcon("nobody.png");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(imgPath + "nobody.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		add(panel_1);
		
		JButton btnNewButton = new JButton("사진 등록");
		panel_1.add(btnNewButton);
	}

	public void setImagesIcon(String imgFileName) {
	}
}
