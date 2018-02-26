package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel {

	public AdminOrderRegister() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JPanel pCorrection = new JPanel();
		pCorrection.setBackground(new Color(255, 255, 255));
		pCorrection.setBounds(0, 0, 1190, 166);
		add(pCorrection);
		pCorrection.setLayout(null);

		JButton btnCorrection = new JButton("수정");
		btnCorrection.setBounds(973, 117, 80, 30);
		pCorrection.add(btnCorrection);

		JButton btnOrderCancel = new JButton("취소");
		btnOrderCancel.setBounds(1065, 117, 80, 30);
		pCorrection.add(btnOrderCancel);

		LblTfComp pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(333, 116, 170, 30);
		pCorrection.add(pOrderCount);

		StringLblCmbComponent pPayment = new StringLblCmbComponent("결제수단");
		pPayment.setBounds(661, 117, 215, 30);

		pCorrection.add(pPayment);

		CalenderTfComp panel = new CalenderTfComp((String) null);
		panel.setBounds(721, 11, 220, 42);
		pCorrection.add(panel);

		JLabel lblNewLabel = new JLabel("주문일자");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(649, 21, 60, 22);
		pCorrection.add(lblNewLabel);

		LblTfComp pItemName = new LblTfComp("상품명");
		pItemName.setBounds(673, 68, 253, 30);
		pCorrection.add(pItemName);

		LblTfComp pUserName = new LblTfComp("상호명");
		pUserName.setBounds(349, 69, 220, 30);
		pCorrection.add(pUserName);

		LblTfComp lblTfComp = new LblTfComp("주문번호");
		lblTfComp.setBounds(337, 19, 170, 30);
		pCorrection.add(lblTfComp);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(80, 20, 128, 128);
		pCorrection.add(panel_1);
	}
}