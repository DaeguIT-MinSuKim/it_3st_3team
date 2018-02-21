package kr.or.dgit.it_3st_3team.ui.admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import kr.or.dgit.it_3st_3team.ui.component.StringLabelAddressComp;
import kr.or.dgit.it_3st_3team.ui.component.StringLabelComboxComp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSoftwareRegister extends JPanel implements ActionListener {
	private JTextField tfSWName;
	private JTextField tfSupplyPrice;
	private JTextField tfSalePrice;
	private JButton btnSWImgUp;
	private JFileChooser chooser;
	private JLabel lblSWImg;

	/**
	 * Create the panel.
	 */
	public AdminSoftwareRegister() {
		
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		
		JPanel pRegister = new JPanel();
		pRegister.setBackground(Color.WHITE);
		pRegister.setBounds(0, 0, 1200, 183);
		add(pRegister);
		pRegister.setLayout(null);
		
		lblSWImg = new JLabel("");
		lblSWImg.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSWImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSWImg.setBounds(22, 10, 143, 134);
		pRegister.add(lblSWImg);
		
		btnSWImgUp = new JButton("이미지 등록");
		btnSWImgUp.addActionListener(this);
		btnSWImgUp.setBounds(48, 154, 97, 23);
		pRegister.add(btnSWImgUp);
		
		JLabel lblSWName = new JLabel("품목명");
		lblSWName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSWName.setBounds(188, 75, 57, 15);
		pRegister.add(lblSWName);
		
		tfSWName = new JTextField();
		tfSWName.setBounds(270, 66, 134, 29);
		pRegister.add(tfSWName);
		tfSWName.setColumns(10);
		
		JLabel lblSupplyPrice = new JLabel("공급가격");
		lblSupplyPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSupplyPrice.setBounds(217, 142, 57, 15);
		pRegister.add(lblSupplyPrice);
		
		tfSupplyPrice = new JTextField();
		tfSupplyPrice.setColumns(10);
		tfSupplyPrice.setBounds(299, 135, 120, 29);
		pRegister.add(tfSupplyPrice);
		
		JLabel lblSalePrice = new JLabel("판매가격");
		lblSalePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalePrice.setBounds(217, 103, 57, 15);
		pRegister.add(lblSalePrice);
		
		tfSalePrice = new JTextField();
		tfSalePrice.setBounds(299, 96, 120, 29);
		pRegister.add(tfSalePrice);
		tfSalePrice.setColumns(10);
		
		JButton btnSubmitSW = new JButton("등록");
		btnSubmitSW.setBounds(965, 154, 97, 23);
		pRegister.add(btnSubmitSW);
		
		JButton btnCancelSW = new JButton("취소");
		btnCancelSW.setBounds(1068, 154, 97, 23);
		pRegister.add(btnCancelSW);
		
		JButton btnSubmitCF = new JButton("분류등록");
		btnSubmitCF.setBounds(779, 27, 97, 23);
		pRegister.add(btnSubmitCF);
		
		StringLabelComboxComp panel = new StringLabelComboxComp("공급회사");
		panel.setBorder(null);
		panel.setBounds(238, 27, 243, 30);
		pRegister.add(panel);
		
		StringLabelComboxComp panel_1 = new StringLabelComboxComp("분류 회사");
		panel_1.setBounds(528, 26, 243, 30);
		pRegister.add(panel_1);
		
		StringLabelAddressComp panel_2 = new StringLabelAddressComp("주소");
		panel_2.setBounds(528, 75, 369, 59);
		pRegister.add(panel_2);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSWImgUp) {
			chooser = new JFileChooser();
			actionPerformedBtnSWImgUp(e);
		}
	}
	protected void actionPerformedBtnSWImgUp(ActionEvent e) {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg","png");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		lblSWImg.setIcon(new ImageIcon(filePath));
	}
}
