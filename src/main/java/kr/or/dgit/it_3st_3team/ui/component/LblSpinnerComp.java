package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LblSpinnerComp extends JPanel {
	private JLabel lblName;
	private JSpinner spinner;
	
	
	public LblSpinnerComp(String label) {
		lblName = new JLabel(label);
		lblName.setBorder(new EmptyBorder(0, 0, 0, 20));
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pSpinner = new JPanel();
		add(pSpinner, BorderLayout.CENTER);
		pSpinner.setLayout(new BorderLayout(0, 0));
		
		spinner = new JSpinner();
		pSpinner.add(spinner);

		pSpinner.add(lblName, BorderLayout.WEST);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	
	
	public void setIntSpinner(int count,int min,int max,int step) {
		SpinnerNumberModel snmMin = new SpinnerNumberModel(count, min, max, step);
		spinner.setModel(snmMin);
	}
	
	public void setSpnValue(int value) {
		spinner.setValue(value);
	}
	public int getSpnValue() {
		return (int) spinner.getValue();
	}
	
	
	
	
	

}
