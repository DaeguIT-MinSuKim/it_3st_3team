package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;


@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel {

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
		
		LblTfComp pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(319, 62, 202, 30);
		pCorrection.add(pOrderCount);
		

		LblCmbUserComp pUserName = new LblCmbUserComp("고객명");
		pUserName.setBounds(46, 112, 202, 30);
		pCorrection.add(pUserName);
		
		StringLblCmbComponent pPayment = new StringLblCmbComponent("결제수단");
		pPayment.setBounds(323, 112, 198, 30);

		pCorrection.add(pPayment);
		
		CalenderTfComp panel = new CalenderTfComp((String) null);
		panel.setBounds(879, 10, 220, 42);
		pCorrection.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(817, 21, 60, 22);
		pCorrection.add(lblNewLabel);
	}
}