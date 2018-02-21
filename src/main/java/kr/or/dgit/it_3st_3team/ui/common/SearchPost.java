package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;

public class SearchPost extends JFrame {

	private JPanel contentPane;
	private JTextField tfDoro;
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
		contentPane.setToolTipText("주소 검색");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSido = new JLabel("시/도");
		lblSido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSido.setBounds(38, 53, 57, 15);
		contentPane.add(lblSido);
		
		JComboBox cmbSido = new JComboBox();
		cmbSido.setBounds(129, 50, 146, 21);
		contentPane.add(cmbSido);
		
		JLabel lblSigungu = new JLabel("시/군/구");
		lblSigungu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSigungu.setBounds(38, 89, 57, 15);
		contentPane.add(lblSigungu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 86, 146, 21);
		contentPane.add(comboBox);
		
		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoro.setBounds(59, 126, 36, 15);
		contentPane.add(lblDoro);
		
		tfDoro = new JTextField();
		tfDoro.setBounds(129, 123, 196, 21);
		contentPane.add(tfDoro);
		tfDoro.setColumns(10);
		
		JLabel label = new JLabel("건물번호");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(47, 159, 48, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(129, 156, 91, 21);
		contentPane.add(textField);
		
		JLabel lbl = new JLabel("-");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(220, 158, 27, 15);
		contentPane.add(lbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(250, 156, 91, 21);
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
	}
}
