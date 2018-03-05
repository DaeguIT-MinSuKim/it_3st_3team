package kr.or.dgit.it_3st_3team.ui.admin.db_setting;

import javax.swing.JPanel;

import kr.og.dgit.erp_setting.service.BackUpService;
import kr.og.dgit.erp_setting.service.InitService;
import kr.og.dgit.erp_setting.service.LoadService;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminDBSettingContent extends JPanel implements ActionListener {
	private JButton btnBackUp;
	private JButton btnLoadData;
	private JButton btnInitData;

	public AdminDBSettingContent() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		add(panel_2);

		btnBackUp = new JButton("백업");
		btnBackUp.addActionListener(this);
		btnBackUp.setBounds(80, 52, 100, 100);
		panel_2.add(btnBackUp);

		JLabel lblBackUp = new JLabel("데이터를 백업합니다.");
		lblBackUp.setFont(new Font("굴림", Font.PLAIN, 20));
		lblBackUp.setBounds(380, 87, 300, 30);
		panel_2.add(lblBackUp);

		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(null);

		btnLoadData = new JButton("복원");
		btnLoadData.addActionListener(this);
		btnLoadData.setBounds(80, 55, 100, 100);
		panel_3.add(btnLoadData);

		JLabel lblLoadData = new JLabel("데이터를 복원합니다.");
		lblLoadData.setFont(new Font("굴림", Font.PLAIN, 20));
		lblLoadData.setBounds(380, 90, 300, 30);
		panel_3.add(lblLoadData);

		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(null);

		btnInitData = new JButton("초기화");
		btnInitData.addActionListener(this);
		btnInitData.setBounds(80, 52, 100, 100);
		panel_4.add(btnInitData);

		JLabel lblInitData = new JLabel("기본 데이터로 초기화합니다.");
		lblInitData.setFont(new Font("굴림", Font.PLAIN, 20));
		lblInitData.setBounds(380, 87, 300, 30);
		panel_4.add(lblInitData);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInitData) {
			actionPerformedBtnInitData(e);
		}
		if (e.getSource() == btnLoadData) {
			actionPerformedBtnLoadData(e);
		}
		if (e.getSource() == btnBackUp) {
			actionPerformedBtnBackUp(e);
		}
	}

	protected void actionPerformedBtnBackUp(ActionEvent e) {
		BackUpService.getInstance().service();
	}

	protected void actionPerformedBtnLoadData(ActionEvent e) {
		LoadService.getInstance().service();
	}

	protected void actionPerformedBtnInitData(ActionEvent e) {
		InitService.getInstance().service();
	}
}
