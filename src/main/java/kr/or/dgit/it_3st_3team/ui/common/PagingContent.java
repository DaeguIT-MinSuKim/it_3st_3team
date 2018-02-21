package kr.or.dgit.it_3st_3team.ui.common;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class PagingContent extends JPanel {

	public PagingContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
		JButton button = new JButton("Prev");
		button.setPreferredSize(new Dimension(60, 30));
		add(button);
		
		JButton button_1 = new JButton("1");
		button_1.setPreferredSize(new Dimension(39, 30));
		add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setPreferredSize(new Dimension(39, 30));
		add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setPreferredSize(new Dimension(39, 30));
		add(button_3);
		
		JButton button_4 = new JButton("Next");
		button_4.setPreferredSize(new Dimension(60, 30));
		add(button_4);
	}

}
