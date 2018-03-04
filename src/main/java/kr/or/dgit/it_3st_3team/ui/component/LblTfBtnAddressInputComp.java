package kr.or.dgit.it_3st_3team.ui.component;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class LblTfBtnAddressInputComp extends JPanel {

	public LblTfBtnAddressInputComp() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pTwoAddress = new JPanel();
		pTwoAddress.setBorder(new EmptyBorder(0, 0, 10, 50));
		add(pTwoAddress);
		pTwoAddress.setLayout(new BorderLayout(0, 0));

		LblTfBtnPostSearchComp lblTfBtnAddress = new LblTfBtnPostSearchComp("우편번호", "검색");
		lblTfBtnAddress.setBorder(new EmptyBorder(4, 0, 0, 0));
		pTwoAddress.add(lblTfBtnAddress);

		LblAddressComp pInputAddress = new LblAddressComp("상세 주소");
		add(pInputAddress);

		lblTfBtnAddress.setPanelAddress(pInputAddress);
	}

}
