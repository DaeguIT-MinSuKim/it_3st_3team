package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;

public class TfBtnSearchPrintComp extends JPanel {
	private JTextField tfSearchItem;

	
	public TfBtnSearchPrintComp() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		tfSearchItem = new JTextField();
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JPanel pStatusSearch = new JPanel();
		pStatusSearch.setBackground(new Color(255, 255, 255));
		pStatusSearch.setBorder(new EmptyBorder(0, 20, 0, 400));
		add(pStatusSearch);
		pStatusSearch.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnStatusSearch = new JButton("검색");
		pStatusSearch.add(btnStatusSearch);
		
		JPanel pStatusReport = new JPanel();
		add(pStatusReport);
		pStatusReport.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnStatusReport = new JButton("판매보고서");
		pStatusReport.add(btnStatusReport);
	}

}

