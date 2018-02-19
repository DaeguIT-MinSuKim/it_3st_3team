package kr.or.dgit.it_3st_3team.ui;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputButton extends AbstractInputComponent<TextField> {
	private JTextField textField;
	
	public InputButton(String title) {
		super(title);
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btn = new JButton("중복확인");
		pCmp.add(textField);
		//pCmp.add(btn);
	}

}
