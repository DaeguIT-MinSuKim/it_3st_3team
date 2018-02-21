package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AbstractLabelTf extends JPanel {
	private JTextField textField;
	private JLabel lblNewLabel;

	public AbstractLabelTf(String title) {
		lblNewLabel = new JLabel(title);
		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		lblNewLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(lblNewLabel);

		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

	public void setTfText(String text) {
		textField.setText(text);
	}

	public String getTfText() {
		return textField.getText();
	}
}
