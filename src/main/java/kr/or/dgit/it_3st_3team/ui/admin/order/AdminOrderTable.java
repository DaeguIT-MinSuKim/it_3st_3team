package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import kr.or.dgit.it_3st_3team.ui.component.PagingComp;

public class AdminOrderTable extends JPanel {
	private JTable TblOrder;

	/**
	 * Create the panel.
	 */
	public AdminOrderTable() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pOrderTable = new JPanel();
		pOrderTable.setBackground(Color.WHITE);
		pOrderTable.setBounds(0, 0, 1200, 600);
		add(pOrderTable);
		pOrderTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 1165, 533);
		pOrderTable.add(scrollPane);
		
		TblOrder = new JTable();
		TblOrder.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uC77C\uC790", "\uBD84\uB958", "\uD488\uBAA9\uBA85", "\uC8FC\uBB38\uC218\uB7C9", "\uACE0\uAC1D\uBA85", "\uACB0\uC81C\uC218\uB2E8", "\uB2F4\uB2F9\uC790", "\uACF5\uAE09\uD68C\uC0AC", "\uC218\uC815/\uC0AD\uC81C"
			}
		));
		scrollPane.setViewportView(TblOrder);
		
		PagingComp pPaging = new PagingComp();
		pPaging.setBounds(12, 553, 1200, 40);
		pOrderTable.add(pPaging);
		pPaging.setBackground(new Color(255, 255, 255));
	}

}
