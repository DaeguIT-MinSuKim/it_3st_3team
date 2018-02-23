package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Component;

public class StatusSearchBottom extends JPanel {
	private JTextField textField;

	
	public StatusSearchBottom() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("                      ");
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("거래명세서");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("보고서");
		add(btnNewButton_2);
	}

}
