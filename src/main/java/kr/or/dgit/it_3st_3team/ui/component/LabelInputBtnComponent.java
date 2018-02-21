package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LabelInputBtnComponent extends JPanel {
	private JTextField tfInput;
	private JLabel lbltitle;
	private JButton btn;

	public LabelInputBtnComponent(String title, String btnName) {
		lbltitle = new JLabel(title);
		btn = new JButton(btnName);
		
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel pLabelArea = new JPanel();
		pLabelArea.setBackground(Color.WHITE);
		pLabelArea.setBorder(new EmptyBorder(0, 0, 0, 20));
		pLabelArea.setLayout(new GridLayout(0, 1, 0, 0));
		pLabelArea.add(lbltitle);
		add(pLabelArea);

		tfInput = new JTextField();
		tfInput.setColumns(10);
		add(tfInput);

		JPanel pBtnArea = new JPanel();
		pBtnArea.setBackground(Color.WHITE);
		pBtnArea.setBorder(new EmptyBorder(0, 20, 0, 0));
		pBtnArea.setLayout(new GridLayout(0, 1, 0, 0));
		pBtnArea.add(btn);
		add(pBtnArea);
		
		btn.setBorder(UIManager.getBorder("Button.border"));
	}

}
