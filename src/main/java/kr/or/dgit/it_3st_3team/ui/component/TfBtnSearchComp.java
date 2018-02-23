package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Rectangle;

public class TfBtnSearchComp extends JPanel {
	private JTextField tfSearchItem;

	
	public TfBtnSearchComp() {

		initComponents();
	}
	private void initComponents() {
		setBounds(new Rectangle(0, 0, 35, 0));
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		tfSearchItem = new JTextField();
		tfSearchItem.setBounds(new Rectangle(0, 0, 0, 30));
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JButton btnStatusSearch = new JButton("검색");
		add(btnStatusSearch);
	}

}

