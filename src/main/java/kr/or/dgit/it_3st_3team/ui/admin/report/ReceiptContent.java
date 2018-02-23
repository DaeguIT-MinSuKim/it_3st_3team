package kr.or.dgit.it_3st_3team.ui.admin.report;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import kr.or.dgit.it_3st_3team.ui.table.ReceiptLists;
import javax.swing.border.EmptyBorder;

public class ReceiptContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReceiptContent() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 42);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("거래명세서");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		ReceiptLists panel_1 = new ReceiptLists();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 52, 800, 489);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 551, 800, 49);
		add(panel_2);
	}

}
