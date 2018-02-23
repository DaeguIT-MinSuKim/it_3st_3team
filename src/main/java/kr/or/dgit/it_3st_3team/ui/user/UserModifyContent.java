package kr.or.dgit.it_3st_3team.ui.user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import kr.or.dgit.it_3st_3team.ui.component.LabelPwdFieldComponent;

@SuppressWarnings("serial")
public class UserModifyContent extends JPanel {

	public UserModifyContent() {
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.WHITE);
		setLayout(null);

		UserInfoContent panel = new UserInfoContent();
		panel.setLayout(null);
		panel.setBounds(10, 10, 688, 460);
		add(panel);

		JButton btnNewButton = new JButton("수정");
		btnNewButton.setBounds(223, 411, 97, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(386, 411, 97, 30);
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 480, 686, 194);
		add(panel_1);
		panel_1.setLayout(null);

		LabelPwdFieldComponent labelPwdFieldComponent = new LabelPwdFieldComponent("현재 비밀번호");
		labelPwdFieldComponent.setBounds(86, 37, 280, 38);
		panel_1.add(labelPwdFieldComponent);

		LabelPwdFieldComponent labelPwdFieldComponent_1 = new LabelPwdFieldComponent("바꿀 비밀번호 확인");
		labelPwdFieldComponent_1.setBounds(58, 133, 308, 38);
		panel_1.add(labelPwdFieldComponent_1);

		LabelPwdFieldComponent labelPwdFieldComponent_2 = new LabelPwdFieldComponent("바꿀 비밀번호");
		labelPwdFieldComponent_2.setBounds(86, 85, 280, 38);
		panel_1.add(labelPwdFieldComponent_2);

		JButton button = new JButton("수정");
		button.setBounds(421, 141, 97, 30);
		panel_1.add(button);

		JButton button_1 = new JButton("취소");
		button_1.setBounds(553, 141, 97, 30);
		panel_1.add(button_1);
	}
}
