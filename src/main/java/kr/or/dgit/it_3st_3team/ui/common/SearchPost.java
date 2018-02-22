package kr.or.dgit.it_3st_3team.ui.common;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField tfBNum1;
	private JTextField tfNum2;
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("주소 검색");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBNum = new JLabel("건물번호");
		lblBNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBNum.setBounds(39, 166, 48, 15);
		contentPane.add(lblBNum);
		
		tfBNum1 = new JTextField();
		tfBNum1.setColumns(10);
		tfBNum1.setBounds(107, 159, 91, 30);
		contentPane.add(tfBNum1);
		
		JLabel lblempty = new JLabel("-");
		lblempty.setHorizontalAlignment(SwingConstants.CENTER);
		lblempty.setBounds(200, 166, 27, 15);
		contentPane.add(lblempty);
		
		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(228, 159, 91, 30);
		contentPane.add(tfNum2);
		
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
		
		LabelAddressCombobox pSido = new LabelAddressCombobox("시/도");
		pSido.setBounds(57, 39, 203, 30);
		contentPane.add(pSido);
		
		LabelAddressCombobox pSigungu = new LabelAddressCombobox("시/군/구");
		pSigungu.setBounds(39, 79, 198, 30);
		contentPane.add(pSigungu);
		
		LabelTextFieldComponent pDoro = new LabelTextFieldComponent("도로 명");
		pDoro.setBounds(47, 119, 272, 30);
		contentPane.add(pDoro);
	}
	
	public void settTfBNum1(String text) {
		tfBNum1.setText(text);
	}

	public String getTfBNum1() {
		return tfBNum1.getSelectedText();
	}
	
	public void settTfBNum2(String text) {
		tfBNum1.setText(text);
	}

	public String getTfBNum2() {
		return tfBNum1.getSelectedText();
	}
}
