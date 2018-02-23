package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbSoftwareComp;

public class AdminOrderRegister extends JPanel {

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
		pCorrection.setBounds(0, 0, 1190, 167);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		JButton btnCorrection = new JButton("수정");
		btnCorrection.setBounds(978, 134, 97, 23);
		pCorrection.add(btnCorrection);
		
		JButton btnOrderCancel = new JButton("취소");
		btnOrderCancel.setBounds(1081, 134, 97, 23);
		pCorrection.add(btnOrderCancel);
		
		LblTfComp pOrderNum = new LblTfComp("주문 번호");
		pOrderNum.setBounds(46, 10, 202, 30);
		pCorrection.add(pOrderNum);
		
		LblTfComp pOrderDate = new LblTfComp("주문 일자");
		pOrderDate.setBounds(46, 62, 202, 30);
		pCorrection.add(pOrderDate);
		
		LblCmbSoftwareComp pSwName = new LblCmbSoftwareComp("품목명");
		pSwName.setBounds(319, 10, 202, 30);
		pCorrection.add(pSwName);
		
		LblTfComp pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(319, 62, 202, 30);
		pCorrection.add(pOrderCount);
		
		LblCmbUserComp pUserName = new LblCmbUserComp("고객명");
		pUserName.setBounds(46, 112, 202, 30);
		pCorrection.add(pUserName);
		
		JPanel pPayment = new JPanel();
		pPayment.setBounds(319, 112, 202, 30);
		pCorrection.add(pPayment);
	}
}