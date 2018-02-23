package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public abstract class AbstractLabelComboBoxComp<T> extends JPanel {
	protected DefaultComboBoxModel<T> dcbm;
	protected JComboBox<T> cmbBox;
	private JLabel lblName;
	
	public AbstractLabelComboBoxComp(String label) {
		lblName = new JLabel(label);
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JPanel pLC = new JPanel();
		pLC.setBackground(new Color(255, 255, 255));
		pLC.setLayout(new BorderLayout(0, 0));
		add(pLC);
		
		lblName.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pLC.add(lblName, BorderLayout.WEST);

		cmbBox = new JComboBox<>();
		pLC.add(cmbBox);
	}
	
	public void loadData(T[] data) {
		dcbm = new DefaultComboBoxModel<>(data);
		cmbBox.setModel(dcbm);
	}

}
