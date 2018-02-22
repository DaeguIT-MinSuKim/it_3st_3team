package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.it_3st_3team.ui.component.LabelAddressCombobox;
import kr.or.dgit.it_3st_3team.ui.component.LabelTextFieldComponent;

public class SearchPost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPost frame = new SearchPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchPost() {
		initComponents();
	}
	private void initComponents() {
		setTitle("주소 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setToolTipText("주소 검색");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("건물번호");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(47, 170, 48, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(113, 160, 91, 30);
		contentPane.add(textField);
		
		JLabel lbl = new JLabel("-");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(205, 167, 27, 15);
		contentPane.add(lbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 160, 91, 30);
		contentPane.add(textField_1);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(86, 200, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnSearchCancel = new JButton("취소");
		btnSearchCancel.setBounds(195, 200, 97, 23);
		contentPane.add(btnSearchCancel);
		
		JButton btnZipCodeOK = new JButton("등록");
		btnZipCodeOK.setBounds(86, 428, 97, 23);
		contentPane.add(btnZipCodeOK);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(195, 428, 97, 23);
		contentPane.add(btnCancel);
		
		JPanel pPostTable = new JPanel();
		pPostTable.setBackground(Color.WHITE);
		pPostTable.setBounds(12, 233, 358, 185);
		contentPane.add(pPostTable);
		pPostTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 358, 185);
		pPostTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC6B0\uD3B8\uBC88\uD638", "\uC8FC\uC18C"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(1).setMinWidth(280);
		table.getColumnModel().getColumn(1).setMaxWidth(280);
		scrollPane.setViewportView(table);
		
		LabelAddressCombobox panel = new LabelAddressCombobox("시/도");
		panel.setBounds(67, 38, 187, 30);
		contentPane.add(panel);
		
		LabelAddressCombobox panel_1 = new LabelAddressCombobox("시/군/구");
		panel_1.setBounds(47, 78, 278, 30);
		contentPane.add(panel_1);
		
		LabelTextFieldComponent panel_2 = new LabelTextFieldComponent("도로명");
		panel_2.setBounds(57, 119, 268, 30);
		contentPane.add(panel_2);
	}
}
