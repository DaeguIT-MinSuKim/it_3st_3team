package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public abstract class AbstractLabelAddress<T> extends JPanel {
	private JTextField tfAddress;
	private JTextField tfAddress_1;
	private JLabel lblAdd;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public AbstractLabelAddress(String label) {
		lblAdd = new JLabel(label);
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pAddress = new JPanel();
		pAddress.setBackground(new Color(255, 255, 255));
		add(pAddress, BorderLayout.CENTER);
		pAddress.setLayout(new BorderLayout(0, 0));
		
		JPanel pSpace = new JPanel();
		pSpace.setBackground(new Color(255, 255, 255));
		pAddress.add(pSpace, BorderLayout.CENTER);
		pSpace.setLayout(new GridLayout(2, 0, 5, 5));
		
		tfAddress = new JTextField();
		
		pSpace.add(tfAddress);
		tfAddress.setColumns(10);
		
		tfAddress_1 = new JTextField();
		pSpace.add(tfAddress_1);
		tfAddress_1.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 20));
		panel.setBackground(new Color(255, 255, 255));
		pAddress.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblAdd);
	}
	
	
}
