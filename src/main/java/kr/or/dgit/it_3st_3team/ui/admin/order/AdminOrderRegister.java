package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.type.Payment;
import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import kr.or.dgit.it_3st_3team.ui.component.LblSpinnerComp;

@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel implements ActionListener {

	private LblTfComp pOrderNum;
	private LblTfComp pUserName;
	private LblTfComp pSwName;
	private JLabel lblDate;
	private CalenderTfComp pDate;
	private LblCmbStringComp pPayment;
	//private LblTfComp pOrderCount;
	private AdminOrderContent adOrder;
	private JPanel pOrderRegi;
	private ImageComp pImg;
	private JButton btnRewrite;
	private JButton btnCancel;
	private LblSpinnerComp pOrderCount;

	public AdminOrderRegister() {

		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pOrderRegi = new JPanel();
		pOrderRegi.setBounds(0, 0, 1184, 201);
		add(pOrderRegi);
		pOrderRegi.setLayout(null);

		pPayment = new LblCmbStringComp("결제수단");
		String[] payli = {"카드","모바일","계좌이체","무통장","간편결제"};
		pPayment.loadData(payli);
		pPayment.setBounds(589, 116, 215, 30);

		pOrderRegi.add(pPayment);

		pDate = new CalenderTfComp((String) null);
		pDate.setBounds(649, 10, 215, 42);
		pDate.setEnabled(false);
		pOrderRegi.add(pDate);
		

		lblDate = new JLabel("주문일자");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(577, 21, 60, 22);
		pOrderRegi.add(lblDate);

		pSwName = new LblTfComp("상품명");
		pSwName.setBounds(601, 67, 260, 30);
		pSwName.setTfEditable(false);
		pOrderRegi.add(pSwName);

		pUserName = new LblTfComp("상호명");
		pUserName.setBounds(294, 69, 220, 30);
		pUserName.setTfEditable(false);
		pOrderRegi.add(pUserName);

		pOrderNum = new LblTfComp("주문번호");
		pOrderNum.setBounds(282, 19, 170, 30);
		pOrderNum.setTfEditable(false);
		pOrderRegi.add(pOrderNum);

		pImg = new ImageComp();
		pImg.setBounds(58, 10, 170, 169);
		pOrderRegi.add(pImg);
		
		btnRewrite = new JButton("수정");
		btnRewrite.addActionListener(this);
		btnRewrite.setBounds(896, 148, 97, 23);
		pOrderRegi.add(btnRewrite);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(1005, 148, 97, 23);
		pOrderRegi.add(btnCancel);
		
		pOrderCount = new LblSpinnerComp("품목 수량");
		pOrderCount.setBounds(279, 116, 170, 30);
		pOrderCount.setIntSpinner(1, 1, 999, 1);
		pOrderRegi.add(pOrderCount);
	}
	
	
	public void setOrderData(SaleOrder saleOrder) {
		pUserName.setTfText(saleOrder.getUser().getName());
		pOrderCount.setSpnValue(saleOrder.getOrdQuantity());
		pSwName.setTfText(saleOrder.getSoftware().getSwName());
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
		btnRewrite.setText("수정");
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
		
		String swName = pSwName.getTfText().trim();
		int orderCount = pOrderCount.getSpnValue();
		String userName = pUserName.getTfText().trim();
		int orderNo = Integer.parseInt(pOrderNum.getTfText().trim());
		String payment =  (String) pPayment.getCmbSelectItem();
		System.out.println(payment);
		
		SaleOrder inputOrder = new SaleOrder();
		inputOrder.setOrdNo(orderNo);//번호
		//결제수단
		if(payment.equals("계좌이체")) {
			inputOrder.setOrdPayment(Payment.ATM);
		}else if(payment.equals("무통장")) {
			inputOrder.setOrdPayment(Payment.BANK);
		}else if(payment.equals("카드")) {
			inputOrder.setOrdPayment(Payment.CARD);
		}else if(payment.equals("모바일")) {
			inputOrder.setOrdPayment(Payment.MOBILE);
		}else if(payment.equals("간편결제")) {
			inputOrder.setOrdPayment(Payment.SIMPLE);
		}
		
		inputOrder.setOrdQuantity(orderCount);//수량
		User user = new User();
		user.setName(userName);
		inputOrder.setUser(user);//상호명
		inputOrder.setSoftware(new Software(swName));
		
		String softwareImgFullPath = pImg.getImageIcon().toString();
		Software sw = new Software();
		sw.setSwCoverImg(new File(softwareImgFullPath).getName());
		inputOrder.setSoftware(sw);
		
		String commandType = e.getActionCommand();
		String commandMessage = String.format("사용자 %s", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("%s을 하시겠습니까?", commandMessage),commandMessage,JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}
		
		if(commandType.equals("수정")) {
			result = SaleOrderService.getInstance().updateOrderManagementNo(inputOrder);
		}
		adOrder.reFreshList();
		resetData();
	}
	
	public void resetData() {
		pDate.setDate("");
		pImg.setImageIcon("nobody.png");
		pOrderCount.setSpnValue(1);
		pOrderNum.setTfText("");
		pSwName.setTfText("");
		pUserName.setTfText("");
	}
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		resetData();
	}

	public void setAdOrder(AdminOrderContent adOrder) {
		this.adOrder = adOrder;
	}
	
	
	
}