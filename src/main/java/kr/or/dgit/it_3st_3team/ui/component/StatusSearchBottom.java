package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class StatusSearchBottom extends JPanel {
	private JTextField tfSearchItem;

	
	public StatusSearchBottom() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		tfSearchItem = new JTextField();
		add(tfSearchItem);
		tfSearchItem.setColumns(10);
		
		JPanel pStatusSearch = new JPanel();
		pStatusSearch.setBorder(new EmptyBorder(0, 20, 0, 400));
		add(pStatusSearch);
		pStatusSearch.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnStatusSearch = new JButton("검색");
		pStatusSearch.add(btnStatusSearch);
		
		JPanel pReceipt = new JPanel();
		pReceipt.setBorder(new EmptyBorder(0, 0, 0, 20));
		add(pReceipt);
		pReceipt.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnReceipt = new JButton("거래명세서");
		pReceipt.add(btnReceipt);
		
		JPanel pStatusReport = new JPanel();
		add(pStatusReport);
		pStatusReport.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnStatusReport = new JButton("보고서");
		pStatusReport.add(btnStatusReport);
	}

}

