package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class LblTfComp extends JPanel {
	private JTextField textField;
	private JLabel lblTitle;

	public LblTfComp(String title) {
		lblTitle = new JLabel(title);
		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel pTitleArea = new JPanel();
		pTitleArea.setBorder(new EmptyBorder(0, 0, 0, 20));
		pTitleArea.setLayout(new GridLayout(0, 1, 0, 0));
		pTitleArea.add(lblTitle);
		
		add(pTitleArea);

		textField = new JTextField();
		textField.setColumns(10);
		add(textField);
	}

	public void setTfText(String text) {
		textField.setText(text);
	}

	public String getTfText() {
		return textField.getText();
	}
	
	public void requestTfFocus() {
		textField.requestFocus();
	}
	
	public boolean isTfEmpty(String message) {
		if (textField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, message);
			textField.setText("");
			textField.requestFocus();
			return true;
		}
		return false;
	}
	
	public void setTfEnable(boolean enable) {
		textField.setEnabled(enable);
	}
}
