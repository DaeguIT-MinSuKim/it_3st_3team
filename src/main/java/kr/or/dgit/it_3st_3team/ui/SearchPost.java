package kr.or.dgit.it_3st_3team.ui;

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
		lblSido.setBounds(67, 53, 57, 15);
		contentPane.add(lblSido);
		
		JComboBox cmbSido = new JComboBox();
		cmbSido.setBounds(119, 50, 146, 21);
		contentPane.add(cmbSido);
		
		JLabel lblSigungu = new JLabel("시/군/구");
		lblSigungu.setBounds(50, 89, 57, 15);
		contentPane.add(lblSigungu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 86, 146, 21);
		contentPane.add(comboBox);
		
		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setBounds(59, 126, 36, 15);
		contentPane.add(lblDoro);
		
		tfDoro = new JTextField();
		tfDoro.setBounds(119, 123, 196, 21);
		contentPane.add(tfDoro);
		tfDoro.setColumns(10);
		
		JLabel label = new JLabel("건물번호");
		label.setBounds(50, 159, 48, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(119, 156, 91, 21);
		contentPane.add(textField);
		
		JLabel lbl = new JLabel("-");
		lbl.setBounds(222, 159, 57, 15);
		contentPane.add(lbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(243, 156, 91, 21);
		contentPane.add(textField_1);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(86, 200, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnSearchCancel = new JButton("취소");
		btnSearchCancel.setBounds(195, 200, 97, 23);
		contentPane.add(btnSearchCancel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"우편번호", "주소", "지번"
			}
		));
		table.setBounds(12, 233, 345, 175);
		contentPane.add(table);
		
		JButton btnZipCodeOK = new JButton("등록");
		btnZipCodeOK.setBounds(86, 428, 97, 23);
		contentPane.add(btnZipCodeOK);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(195, 428, 97, 23);
		contentPane.add(btnCancel);
	}
}
