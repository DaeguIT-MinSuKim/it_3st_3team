package kr.or.dgit.it_3st_3team.ui.admin.company;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.ui.component.ImageComp;
import kr.or.dgit.it_3st_3team.ui.component.LblAddressComp;
import kr.or.dgit.it_3st_3team.ui.component.LblPwdTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfBtnComp;
import kr.or.dgit.it_3st_3team.ui.component.LblTfComp;
import kr.or.dgit.it_3st_3team.ui.component.LblCmbAdminComp;

@SuppressWarnings("serial")
public class AdminCompanyRegister extends JPanel {

	public AdminCompanyRegister() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1178, 250);
				
		ImageComp pImgArea = new ImageComp();
		pImgArea.setBounds(12, 10, 200, 230);
		add(pImgArea);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(235, 10, 931, 230);
		panel_2.setLayout(null);
		add(panel_2);

		JButton button_2 = new JButton("등록");
		button_2.setBounds(654, 190, 97, 30);
		panel_2.add(button_2);

		JButton button_3 = new JButton("취소");
		button_3.setBounds(783, 190, 97, 30);
		panel_2.add(button_3);
		
		LblTfBtnComp panel = new LblTfBtnComp("아이디", "중복확인");
		panel.setBounds(103, 10, 288, 30);
		panel_2.add(panel);
		
		LblPwdTfComp panel_1 = new LblPwdTfComp("비밀번호");
		panel_1.setBounds(91, 50, 300, 30);
		panel_2.add(panel_1);
		
		LblPwdTfComp lblPwdTfComp = new LblPwdTfComp("비밀번호 확인");
		lblPwdTfComp.setBounds(63, 90, 291, 30);
		panel_2.add(lblPwdTfComp);
		
		LblTfComp panel_3 = new LblTfComp("상호명");
		panel_3.setBounds(103, 130, 288, 30);
		panel_2.add(panel_3);
		
		LblTfComp lblTfComp = new LblTfComp("전화번호");
		lblTfComp.setBounds(91, 170, 263, 30);
		panel_2.add(lblTfComp);
		
		LblTfBtnComp lblTfBtnComp = new LblTfBtnComp("우편번호", "검색");
		lblTfBtnComp.setBounds(514, 50, 280, 30);
		panel_2.add(lblTfBtnComp);
		
		LblAddressComp panel_4 = new LblAddressComp("주소");
		panel_4.setBounds(538, 90, 342, 70);
		panel_2.add(panel_4);
		
		LblCmbAdminComp panel_5 = new LblCmbAdminComp("담당자");
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(528, 10, 245, 30);
		panel_2.add(panel_5);
	}
}
