package kr.or.dgit.it_3st_3team.ui.user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareService;
import kr.or.dgit.it_3st_3team.ui.table.CustomerOrderTable;
import kr.or.dgit.it_3st_3team.utils.DefineUtil;

@SuppressWarnings("serial")
public class CustomerOrderContent extends JPanel {
	private CustomerOrderTable pTable;
	private CustomerOrderRegister pRegister;
	private CustomerOrderSearch pSearch;
	private JTextArea tfIntroduce;
	private JScrollPane scrollPane;
	private User user;

	public CustomerOrderContent(User user) {
		this.user = user;
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1200, 900);

		pRegister = new CustomerOrderRegister(user);
		pRegister.setBounds(0, 0, 1200, 181);
		pRegister.setCo(this);
		add(pRegister);
		pRegister.setEventListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel target = (JLabel) e.getSource();
				if(target.getText() == "소프트웨어 소개") {
					pRegister.setSWIntroName("닫기");
					target.setIcon(new ImageIcon(DefineUtil.DEFAULT_IMG_PATH+"arrowup.png"));
					pRegister.setBounds(0, 0, 1200, 338);
					pSearch.setBounds(0, 338, 1200, 43);
					pTable.setBounds(12, 381, 1164, 460);
				} else {
					pRegister.setBounds(0, 0, 1200,181);
					pSearch.setBounds(0, 191, 1200, 43);
					pTable.setBounds(12, 233, 1164, 621);
					target.setIcon(new ImageIcon(DefineUtil.DEFAULT_IMG_PATH+"arrowdown.png"));
					target.setText("소프트웨어 소개");
				}
			}
		});
		

		pTable = new CustomerOrderTable();
		pTable.loadTableDatas(SoftwareService.getInstance().selectSoftwareByAll());
		pTable.setBounds(12, 224, 1164, 621);
		pTable.setEventListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int no = pTable.getSelectedNo();
					Software software = SoftwareService.getInstance().selectSoftwareByNo(new Software(no));

					pRegister.setOrderData(software);
					
					
				}
			}

		});

		add(pTable);

		pSearch = new CustomerOrderSearch();
		pSearch.setParent(this);
		pSearch.setBounds(0, 180, 1200, 43);
		add(pSearch);

	}

	public void reFreshList() {
		List<Software> li = SoftwareService.getInstance().selectSoftwareByAll();
		pTable.loadTableDatas(li);
	}

	public void setListBySearchData(List<Software> serachData) {
		pTable.loadTableDatas(serachData);
	}
	

	
	
}
