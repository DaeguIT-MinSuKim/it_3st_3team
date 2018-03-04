package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public abstract class AbstractLblTfBtnComp extends JPanel implements ActionListener {
	private JTextField tfInput;
	private JLabel lbltitle;
	private JButton btn;

	public AbstractLblTfBtnComp(String title, String btnName) {
		lbltitle = new JLabel(title);
		lbltitle.setHorizontalAlignment(SwingConstants.RIGHT);
		btn = new JButton(btnName);
		btn.addActionListener(this);

		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel pLabelArea = new JPanel();
		pLabelArea.setBorder(new EmptyBorder(0, 0, 0, 20));
		pLabelArea.setLayout(new GridLayout(0, 1, 0, 0));
		pLabelArea.add(lbltitle);
		add(pLabelArea);

		tfInput = new JTextField();
		tfInput.setColumns(10);
		add(tfInput);

		JPanel pBtnArea = new JPanel();
		pBtnArea.setBorder(new EmptyBorder(0, 20, 0, 0));
		pBtnArea.setLayout(new GridLayout(0, 1, 0, 0));
		pBtnArea.add(btn);
		add(pBtnArea);

		btn.setBorder(UIManager.getBorder("Button.border"));
	}
	
	public void setTfText(String str) {
		tfInput.setText(str);
	}
	
	public String getTfText() {
		return tfInput.getText();
	}
	
	public void setTfEnable(boolean enable) {
		tfInput.setEnabled(enable);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			actionPerformedBtn(e);
		}
	}

	protected abstract void actionPerformedBtn(ActionEvent e);
}
