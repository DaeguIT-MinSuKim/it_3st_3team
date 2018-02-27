package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import kr.or.dgit.it_3st_3team.ui.component.StartAndEndDate;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Test extends JPanel {
	private JTextField textField;

	
	public Test() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		StartAndEndDate panel_4 = new StartAndEndDate();
		panel.add(panel_4, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_3.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_2.add(comboBox_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_6.add(btnNewButton_1);
	}

}
