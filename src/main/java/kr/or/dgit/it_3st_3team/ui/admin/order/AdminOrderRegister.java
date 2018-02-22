package kr.or.dgit.it_3st_3team.ui.admin.order;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import kr.or.dgit.it_3st_3team.ui.component.UserLabelComboxComponent;

public class AdminOrderRegister extends JPanel {
	private JTextField tfOrderDate;
	private JTextField tfOrderCount;
	private JTextField tfOrderNum_1;

	/**
	 * Create the panel.
	 */
	public AdminOrderRegister() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pCorrection = new JPanel();
		pCorrection.setBackground(Color.WHITE);
		pCorrection.setBounds(0, 0, 1200, 167);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		JComboBox lblOrderNum = new JComboBox();
		lblOrderNum.setBounds(93, 88, 149, 29);
		pCorrection.add(lblOrderNum);
		
		JLabel lblSWName = new JLabel("품목명");
		lblSWName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSWName.setBounds(12, 95, 57, 15);
		pCorrection.add(lblSWName);
		
		JLabel lblBSName = new JLabel("고객명");
		lblBSName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBSName.setBounds(235, 17, 57, 15);
		pCorrection.add(lblBSName);
		
		JComboBox tfBSName = new JComboBox();
		tfBSName.setBounds(318, 10, 149, 29);
		pCorrection.add(tfBSName);
		
		JLabel lblOrderDate = new JLabel("주문일자");
		lblOrderDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderDate.setBounds(12, 58, 57, 15);
		pCorrection.add(lblOrderDate);
		
		tfOrderDate = new JTextField();
		tfOrderDate.setColumns(10);
		tfOrderDate.setBounds(94, 49, 134, 29);
		pCorrection.add(tfOrderDate);
		
		JLabel lblPayment = new JLabel("결제수단");
		lblPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayment.setBounds(260, 134, 57, 15);
		pCorrection.add(lblPayment);
		
		JLabel lblOrderCount = new JLabel("주문수량");
		lblOrderCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderCount.setBounds(12, 134, 57, 15);
		pCorrection.add(lblOrderCount);
		
		tfOrderCount = new JTextField();
		tfOrderCount.setColumns(10);
		tfOrderCount.setBounds(94, 127, 120, 29);
		pCorrection.add(tfOrderCount);
		
		JLabel tfOrderNum = new JLabel("주문번호");
		tfOrderNum.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOrderNum.setBounds(12, 19, 57, 15);
		pCorrection.add(tfOrderNum);
		
		tfOrderNum_1 = new JTextField();
		tfOrderNum_1.setColumns(10);
		tfOrderNum_1.setBounds(94, 10, 97, 29);
		pCorrection.add(tfOrderNum_1);
		
		JComboBox cmbPayment = new JComboBox();
		cmbPayment.setBounds(340, 127, 149, 29);
		pCorrection.add(cmbPayment);
		
		JButton btnCorrection = new JButton("수정");
		btnCorrection.setBounds(988, 133, 97, 23);
		pCorrection.add(btnCorrection);
		
		JButton btnOrderCancel = new JButton("취소");
		btnOrderCancel.setBounds(1091, 133, 97, 23);
		pCorrection.add(btnOrderCancel);
		
		UserLabelComboxComponent panel = new UserLabelComboxComponent("고객명");
		panel.setBounds(537, 29, 265, 44);
		pCorrection.add(panel);
	}

}
