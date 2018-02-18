package kr.or.dgit.it_3st_3team.ui;
import java.awt.GridLayout;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class InputBtnContent extends InputContent {

	private JButton btnNewButton;
	public InputBtnContent(String title, String btnName) {
		super(title);
		btnNewButton = new JButton(btnName);
		initComponents();
	}
	private void initComponents() {
		GridLayout gridLayout = (GridLayout) getLayout();
		gridLayout.setColumns(3);
		
		add(btnNewButton);
	}


}
