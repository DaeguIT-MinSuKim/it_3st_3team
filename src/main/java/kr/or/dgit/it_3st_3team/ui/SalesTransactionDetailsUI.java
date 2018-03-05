package kr.or.dgit.it_3st_3team.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.ui.table.SalesTransactionLists;

@SuppressWarnings("serial")
public class SalesTransactionDetailsUI extends JFrame {
	private JPanel contentPane;
	private SalesTransactionLists pLists;

	public SalesTransactionDetailsUI(List<SaleOrder> list) {
		initComponents(list);
	}

	private void initComponents(List<SaleOrder> list) {
		setTitle("거래명세서");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pTitle = new JPanel();
		contentPane.add(pTitle, BorderLayout.NORTH);

		JLabel lblTransaction = new JLabel("거래명세서");
		lblTransaction.setFont(new Font("굴림", Font.PLAIN, 18));
		pTitle.add(lblTransaction);

		pLists = new SalesTransactionLists();
		contentPane.add(pLists, BorderLayout.CENTER);
		
		pLists.loadTableDatas(list);
	}

}
