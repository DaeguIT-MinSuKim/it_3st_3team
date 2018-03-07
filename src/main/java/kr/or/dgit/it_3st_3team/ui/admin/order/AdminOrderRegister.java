package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.type.Payment;
import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;

@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel {

	private LblTfComp pOrderNum;
	private LblTfComp pUserName;
	private LblTfComp pItemName;
	private JLabel lblDate;
	private CalenderTfComp pDate;
	private LblCmbStringComp pPayment;
	private LblTfComp pOrderCount;
	private AdminOrder adOrder;
	private JPanel pOrderRegi;


	public AdminOrderRegister() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pOrderRegi = new JPanel();
		pOrderRegi.setBounds(0, 0, 1652, 166);
		add(pOrderRegi);
		pOrderRegi.setLayout(null);

		pOrderCount = new LblTfComp("품목 수량");
		pOrderCount.setBounds(333, 116, 170, 30);
		pOrderRegi.add(pOrderCount);

		pPayment = new LblCmbStringComp("결제수단");
		String[] payli = {"카드","모바일","계좌이체","무통장","간편결제"};
		pPayment.loadData(payli);
		pPayment.setBounds(661, 117, 215, 30);

		pOrderRegi.add(pPayment);

		pDate = new CalenderTfComp((String) null);
		pDate.setBounds(721, 11, 204, 42);
		pOrderRegi.add(pDate);
		

		lblDate = new JLabel("주문일자");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(649, 21, 60, 22);
		pOrderRegi.add(lblDate);

		pItemName = new LblTfComp("상품명");
		pItemName.setBounds(673, 68, 253, 30);
		pOrderRegi.add(pItemName);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(349, 69, 220, 30);
		pOrderRegi.add(pUserName);

		pOrderNum = new LblTfComp("주문번호");
		pOrderNum.setBounds(337, 19, 170, 30);
		pOrderRegi.add(pOrderNum);

		JPanel pImg = new JPanel();
		pImg.setBounds(80, 20, 128, 128);
		pOrderRegi.add(pImg);
	}
	
	
	public void setOrderData(SaleOrder saleOrder) {
		pUserName.setTfText(saleOrder.getUser().getName());
		pOrderCount.setTfText(Integer.toString(saleOrder.getOrdQuantity()));
		pItemName.setTfText(saleOrder.getSoftware().getSwName());
		pOrderNum.setTfText(Integer.toString(saleOrder.getOrdNo()));
		
		if(saleOrder.getOrdPayment()==Payment.CARD) {
			pPayment.setCmbSelectIndex(0);
		}else if(saleOrder.getOrdPayment()==Payment.MOBILE) {
			pPayment.setCmbSelectIndex(1);
		}else if(saleOrder.getOrdPayment()==Payment.ATM) {
			pPayment.setCmbSelectIndex(2);
		}else if(saleOrder.getOrdPayment()==Payment.BANK) {
			pPayment.setCmbSelectIndex(3);
		}else if(saleOrder.getOrdPayment()==Payment.SIMPLE) {
			pPayment.setCmbSelectIndex(4);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		pDate.setDate(dateFormat.format(saleOrder.getOrdDatetime()));
		adOrder.setBtnRewrite("수정");
	}

	public void setAdOrder(AdminOrder adOrder) {
		this.adOrder = adOrder;
	}
	
	
}