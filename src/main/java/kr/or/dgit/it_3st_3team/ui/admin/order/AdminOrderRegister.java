package kr.or.dgit.it_3st_3team.ui.admin.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.type.Payment;
import kr.or.dgit.it_3st_3team.ui.component.CalenderTfComp;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblSpinnerComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

@SuppressWarnings("serial")
public class AdminOrderRegister extends JPanel implements ActionListener {
	private LblTfComp pOrderNum;
	private LblTfComp pUserName;
	private LblTfComp pSwName;
	private JLabel lblDate;
	private CalenderTfComp pDate;
	private LblCmbStringComp pPayment;
	private AdminOrderContent adOrder;
	private JPanel pOrderRegi;
	private ImageComp pImg;
	private JButton btnRewrite;
	private JButton btnCancel;
	private LblSpinnerComp pOrderCount;
	private int swLimitValue;

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
		String[] payli = { "카드", "모바일", "계좌이체", "무통장", "간편결제" };
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
		pOrderCount.setIntSpinner(1, 1, 9999999, 1);
		pOrderRegi.add(pOrderCount);
	}

	public void setOrderData(SaleOrder saleOrder) {
		Software sw = SoftwareService.getInstance().findSoftwareByName(saleOrder.getSoftware());
		if (sw == null) {
			JOptionPane.showMessageDialog(null, "현재는 팔지 않는 소프트웨어입니다.");
			return;
		}
		
		swLimitValue = saleOrder.getOrdQuantity() + sw.getSwQuantity();
		pUserName.setTfText(saleOrder.getUser().getName());
		pOrderCount.setSpnValue(saleOrder.getOrdQuantity());
		pSwName.setTfText(sw.getSwName());
		pOrderNum.setTfText(Integer.toString(saleOrder.getOrdNo()));

		if (saleOrder.getSoftware().getSwCoverImg() != null && !saleOrder.getSoftware().getSwCoverImg().equals("")) {
			pImg.setImageIcon(saleOrder.getSoftware().getSwCoverImg());
		} else {
			pImg.setImageIcon(DefineUtil.DEFAULT_SOFTWARE_IMG);
		}

		if (saleOrder.getOrdPayment() == Payment.CARD) {
			pPayment.setCmbSelectIndex(0);
		} else if (saleOrder.getOrdPayment() == Payment.MOBILE) {
			pPayment.setCmbSelectIndex(1);
		} else if (saleOrder.getOrdPayment() == Payment.ATM) {
			pPayment.setCmbSelectIndex(2);
		} else if (saleOrder.getOrdPayment() == Payment.BANK) {
			pPayment.setCmbSelectIndex(3);
		} else if (saleOrder.getOrdPayment() == Payment.SIMPLE) {
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

		String ordNoText = pOrderNum.getTfText().trim();
		if (ordNoText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "주문번호가 없습니다.");
			return;
		}

		String payment = (String) pPayment.getCmbSelectItem();
		int orderCount = pOrderCount.getSpnValue();
		System.out.println(orderCount + " " + swLimitValue);
		if (orderCount < 1 || swLimitValue < orderCount) {
			JOptionPane.showMessageDialog(null, String.format("상품 주문 수량은 1개 이상 %s개 이하여야 합니다.", swLimitValue));
			return;
		}
		
		SaleOrder inputOrder = new SaleOrder();
		inputOrder.setOrdNo(Integer.parseInt(ordNoText));// 번호
		
		// 결제수단
		if (payment.equals("계좌이체")) {
			inputOrder.setOrdPayment(Payment.ATM);
		} else if (payment.equals("무통장")) {
			inputOrder.setOrdPayment(Payment.BANK);
		} else if (payment.equals("카드")) {
			inputOrder.setOrdPayment(Payment.CARD);
		} else if (payment.equals("모바일")) {
			inputOrder.setOrdPayment(Payment.MOBILE);
		} else if (payment.equals("간편결제")) {
			inputOrder.setOrdPayment(Payment.SIMPLE);
		}

		inputOrder.setOrdQuantity(orderCount);// 수량
		System.out.println(inputOrder);

		String commandType = e.getActionCommand();
		String commandMessage = String.format("사용자 주문 변경", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("주문을 변경하시겠습니까?", commandMessage), commandMessage,
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}

		result = SaleOrderService.getInstance().updateOrderSoftwareByProc(inputOrder);
		if (result != 1) {
			JOptionPane.showMessageDialog(null, "주문 변경에 실패했습니다.");
			return;
		}
		JOptionPane.showMessageDialog(null, "선택한 주문을 변경하였습니다.");

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