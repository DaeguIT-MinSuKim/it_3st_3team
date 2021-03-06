package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LblPwdTfComp extends JPanel {
	private JLabel lblTitle;
	private JPasswordField pwdField;

	public LblPwdTfComp(String title) {
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

		pwdField = new JPasswordField();
		pwdField.setHorizontalAlignment(SwingConstants.LEFT);
		add(pwdField);
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}

	public void setTfText(String text) {
		pwdField.setText(text);
	}

	public String getTfText() {
		return new String(pwdField.getPassword());
	}

	public void requestTfFocus() {
		pwdField.requestFocus();
	}

	public boolean isTfEmpty(String message) {
		if (new String(pwdField.getPassword()).trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, message);
			pwdField.setText("");
			pwdField.requestFocus();
			return true;
		}
		return false;
	}

	public void setTfEnable(boolean enable) {
		pwdField.setEnabled(enable);
	}
}
