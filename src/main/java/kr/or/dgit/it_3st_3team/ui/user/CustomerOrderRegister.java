package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.type.Payment;
import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbStringComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbUserComp;
import kr.or.dgit.it_3st_3team.ui.component.LblSpinnerComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CustomerOrderRegister extends JPanel implements ActionListener {
	private LblTfComp pOrderNum;
	private LblTfComp pSwName;
	private LblCmbStringComp pPayment;
	private JPanel pOrderRegi;
	private ImageComp pImg;
	private JButton btnRegi;
	private JButton btnCancel;
	private LblSpinnerComp pOrderCount;
	private LblCmbUserComp pPcName;
	private JLabel lbldown;
	private User user;
	private CustomerOrderContent parent;
	
	private int swLimitValue;
	private JTextArea tfIntroduce;

	public CustomerOrderRegister(User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		pOrderRegi = new JPanel();
		pOrderRegi.setBounds(0, 0, 1184, 377);
		add(pOrderRegi);
		pOrderRegi.setLayout(null);

		pPayment = new LblCmbStringComp("결제수단");
		String[] payli = { "카드", "모바일", "계좌이체", "무통장", "간편결제" };
		pPayment.loadData(payli);
		pPayment.setBounds(584, 91, 215, 30);

		pOrderRegi.add(pPayment);

		pSwName = new LblTfComp("상품명");
		pSwName.setBounds(596, 42, 260, 30);
		pSwName.setTfEditable(false);
		pOrderRegi.add(pSwName);

		pImg = new ImageComp();
		pImg.setBounds(58, 10, 170, 169);
		pImg.setImageIcon("software.png");
		pOrderRegi.add(pImg);

		btnRegi = new JButton("주문");
		btnRegi.addActionListener(this);
		btnRegi.setBounds(855, 141, 97, 23);
		pOrderRegi.add(btnRegi);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(961, 141, 97, 23);
		pOrderRegi.add(btnCancel);

		pOrderCount = new LblSpinnerComp("품목 수량");
		pOrderCount.setBounds(272, 89, 170, 30);
		pOrderCount.setIntSpinner(1, 1, 999, 1);
		pOrderRegi.add(pOrderCount);

		pPcName = new LblCmbUserComp("제작사");
		pPcName.setBounds(272, 42, 170, 30);
		pOrderRegi.add(pPcName);

		lbldown = new JLabel("소프트웨어 소개");
		lbldown.setIcon(new ImageIcon(DefineUtil.DEFAULT_IMG_PATH + "arrowdown.png"));
		lbldown.setBounds(271, 145, 120, 15);
		pOrderRegi.add(lbldown);
		
		tfIntroduce = new JTextArea();
		tfIntroduce.setBounds(276, 189, 591, 139);
		pOrderRegi.add(tfIntroduce);

		pOrderNum = new LblTfComp("상품번호");
		pOrderNum.setBounds(708, 129, 116, 21);
	}
	

	public void setSWIntroName(String str) {
		lbldown.setText(str);
	}

	public void setEventListener(EventListener listener) {
		if (listener instanceof MouseListener) {
			lbldown.addMouseListener((MouseListener) listener);
		}
	}

	public void setOrderData(Software software) {
		pPcName.removeItem();
		pPcName.addCmbItem(software.getUserNo());
		pSwName.setTfText(software.getSwName());
		pOrderNum.setTfText(Integer.toString(software.getSwNo()));
		if (software.getSwCoverImg() != null && !software.getSwCoverImg().equals("")) {
			pImg.setImageIcon(software.getSwCoverImg());
		} else {
			pImg.setImageIcon(DefineUtil.DEFAULT_USER_IMG);
		}
		swLimitValue = software.getSwQuantity();
		tfIntroduce.setText(software.getSwIntro());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnRegi) {
			actionPerformedBtnRegi(e);
		}
	}

	protected void actionPerformedBtnRegi(ActionEvent e) {

		String swNoText = pOrderNum.getTfText().trim();
		String swName = pSwName.getTfText().trim();
		
		User company = (User) pPcName.getCmbSelectItem();
		
		String payment = (String) pPayment.getCmbSelectItem();
		int orderCount = pOrderCount.getSpnValue();
		
		if (swName.isEmpty() || company == null || swNoText.isEmpty()) {
			JOptionPane.showMessageDialog(null, "주문할 상품을 선택해주세요.");
			return;
		}
		
		if (orderCount < 1 || swLimitValue < orderCount) {
			JOptionPane.showMessageDialog(null, String.format("상품 주문 수량은 1개 이상 %s개 이하여야 합니다.", swLimitValue));
			return;
		}
		
		SaleOrder inputOrder = new SaleOrder();
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
		inputOrder.setSoftware(new Software(Integer.parseInt(swNoText)));
		inputOrder.setUser(user); // 고객

		String commandType = e.getActionCommand();
		String commandMessage = String.format("소프트웨어 %s", commandType);
		int result = JOptionPane.showConfirmDialog(null, String.format("%s을 하시겠습니까?", commandMessage), commandMessage,
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.NO_OPTION) {
			return;
		}

		result = SaleOrderService.getInstance().orderSoftwareByProc(inputOrder);
		if (result != 1) {
			JOptionPane.showMessageDialog(null, "소프트웨어 주문에 실패했습니다.");
			return;
		}

		JOptionPane.showMessageDialog(null, "선택한 소프트웨어를 주문하였습니다.");

		resetData();
	}

	public void resetData() {
		pImg.setImageIcon("software.png");
		pOrderCount.setSpnValue(1);
		pOrderNum.setTfText("");
		pSwName.setTfText("");
		pPcName.removeItem();
		tfIntroduce.setText("");
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		resetData();
		parent.setClearSize(lbldown);
		
	}

	public void setParent(CustomerOrderContent parent) {
		this.parent = parent;
	}
	
	

}
