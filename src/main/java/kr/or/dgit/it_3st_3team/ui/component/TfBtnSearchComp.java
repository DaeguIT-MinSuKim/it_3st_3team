package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TfBtnSearchComp extends JPanel {
	private JTextField tfSearchItem;
	private JButton btnSearch;

	
	public TfBtnSearchComp(String btnName) {
		btnSearch = new JButton(btnName);
		initComponents();
	}
	private void initComponents() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		tfSearchItem = new JTextField();
		tfSearchItem.setColumns(10);
		add(tfSearchItem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 20, 0, 0));
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel.add(btnSearch);
	}

}

