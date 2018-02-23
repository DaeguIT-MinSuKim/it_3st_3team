package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;
import javax.swing.SwingConstants;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;


@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel {

	public AdminOrderRegister() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		JPanel pCorrection = new JPanel();
		pCorrection.setBackground(Color.WHITE);
		pCorrection.setBounds(0, 0, 1190, 205);
		add(pCorrection);
		pCorrection.setLayout(null);
		
		JButton btnCorrection = new JButton("수정");
		btnCorrection.setBounds(895, 160, 97, 30);
		pCorrection.add(btnCorrection);
		
		JButton btnOrderCancel = new JButton("취소");
		btnOrderCancel.setBounds(1017, 159, 97, 30);
		pCorrection.add(btnOrderCancel);
		
		LblTfComp pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(330, 106, 202, 30);
		pCorrection.add(pOrderCount);
		
		StringLblCmbComponent pPayment = new StringLblCmbComponent("결제수단");
		pPayment.setBounds(580, 106, 215, 30);

		pCorrection.add(pPayment);
		
		CalenderTfComp panel = new CalenderTfComp((String) null);
		panel.setBounds(905, 36, 220, 42);
		pCorrection.add(panel);
		
		JLabel lblNewLabel = new JLabel("주문일자");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(843, 47, 60, 22);
		pCorrection.add(lblNewLabel);
		
		ImageComp pUserImg = new ImageComp();
		pUserImg.setImagesIcon("nobody.png");
		pUserImg.setBounds(80, 0, 150, 205);
		pCorrection.add(pUserImg);
		
		LblTfComp pItemName = new LblTfComp("상품명");
		pItemName.setBounds(593, 48, 202, 30);
		pCorrection.add(pItemName);
		
		LblTfComp pUserName = new LblTfComp("상호명");
		pUserName.setBounds(345, 48, 202, 30);
		pCorrection.add(pUserName);
	}
}