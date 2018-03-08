package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.admin.order.AdminOrderContent;
import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLblCmbComponent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CustromerOrderRegister extends JPanel implements ActionListener{
	private LblTfComp pOrderNum;
	private LblTfComp pUserName;
	private LblTfComp pSwName;
	private JLabel lblDate;
	private CalenderTfComp pDate;
	private LblCmbStringComp pPayment;
	private LblTfComp pOrderCount;
	private AdminOrderContent adOrder;
	private JPanel pUserOrder;
	private ImageComp pImg;
	private JButton btnRewrite;
	private JButton btnCancel;

	public CustromerOrderRegister() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pUserOrder = new JPanel();
		pUserOrder.setBounds(0, 0, 1184, 201);
		add(pUserOrder);
		pUserOrder.setLayout(null);

		pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(278, 116, 170, 30);
		pUserOrder.add(pOrderCount);

		pPayment = new LblCmbStringComp("결제수단");
		String[] payli = {"카드","모바일","계좌이체","무통장","간편결제"};
		pPayment.loadData(payli);
		pPayment.setBounds(589, 116, 215, 30);
		pUserOrder.add(pPayment);

		pDate = new CalenderTfComp((String) null);
		pDate.setBounds(649, 10, 215, 42);
		pDate.setEnabled(false);
		pUserOrder.add(pDate);
		

		lblDate = new JLabel("주문일자");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(577, 21, 60, 22);
		pUserOrder.add(lblDate);

		pSwName = new LblTfComp("상품명");
		pSwName.setBounds(601, 67, 260, 30);
		pUserOrder.add(pSwName);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(294, 69, 220, 30);
		pUserName.setTfEditable(false);
		pUserOrder.add(pUserName);

		pOrderNum = new LblTfComp("주문번호");
		pOrderNum.setBounds(282, 19, 170, 30);


		pImg = new ImageComp();
		pImg.setBounds(58, 10, 170, 169);
		pUserOrder.add(pImg);
		
		btnRewrite = new JButton("등록");
		btnRewrite.addActionListener(this);
		
		btnRewrite.setBounds(896, 148, 97, 23);
		pUserOrder.add(btnRewrite);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		
		btnCancel.setBounds(1005, 148, 97, 23);
		pUserOrder.add(btnCancel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnRewrite) {
			actionPerformedBtnRewrite(e);
		}
	}
	protected void actionPerformedBtnRewrite(ActionEvent e) {
	}
	protected void actionPerformedBtnCancel(ActionEvent e) {
	}
}