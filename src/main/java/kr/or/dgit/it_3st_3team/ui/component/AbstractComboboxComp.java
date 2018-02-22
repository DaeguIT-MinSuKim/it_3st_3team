package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public abstract class AbstractComboboxComp<T> extends JPanel {

	protected JComboBox<T> comboBox;

	protected DefaultComboBoxModel<T> dcbm;



	public AbstractComboboxComp() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		comboBox = new JComboBox<>();
		add(comboBox, BorderLayout.CENTER);
	}

	public void loadData(T[] data) {
		System.out.println(data);
		DefaultComboBoxModel<T> dcbm = new DefaultComboBoxModel<>(data);
		comboBox.setModel(dcbm);	

	}
}
