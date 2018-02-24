package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CustromerOrderRegister extends JPanel {

	public CustromerOrderRegister() {

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
		btnCorrection.setBounds(964, 117, 80, 30);
		pCorrection.add(btnCorrection);

		JButton btnOrderCancel = new JButton("취소");
		btnOrderCancel.setBounds(1056, 117, 80, 30);
		pCorrection.add(btnOrderCancel);

		LblTfComp pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(335, 67, 199, 30);
		pCorrection.add(pOrderCount);

		StringLblCmbComponent pPayment = new StringLblCmbComponent("결제수단");
		pPayment.setBounds(339, 111, 215, 30);

		pCorrection.add(pPayment);

		CalenderTfComp pOrderDate = new CalenderTfComp((String) null);
		pOrderDate.setBounds(687, 11, 220, 42);
		pCorrection.add(pOrderDate);

		JLabel lblOrderDate = new JLabel("주문일자");
		lblOrderDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderDate.setBounds(615, 21, 60, 22);
		pCorrection.add(lblOrderDate);

		LblTfComp pItemName = new LblTfComp("상품명");
		pItemName.setBounds(634, 68, 253, 30);
		pCorrection.add(pItemName);

		LblTfComp pOrderNo = new LblTfComp("주문번호");
		pOrderNo.setBounds(339, 19, 198, 30);
		pCorrection.add(pOrderNo);

		JLabel pItemImg = new JLabel("New label");
		pItemImg
				.setIcon(new ImageIcon("G:\\Programming\\workspaces\\workspace_java\\it_3st_3team\\DataImg\\sega.png"));
		pItemImg.setBounds(80, 20, 128, 128);
		pCorrection.add(pItemImg);
	}
}