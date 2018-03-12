package kr.or.dgit.it_3st_3team.ui.admin.chart;

import javax.swing.JPanel;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.ui.SalesReportUI;


@SuppressWarnings("serial")
public class AdminChartContent extends JPanel {
	
	private AdminChartSearch pSearch;	
	private SaleOrderService soService;
	private Admin admin;
	private User user;
	private SoftwareGroup swg;
	private Admin ad;
	private AdminChartBySwgTypeFullYear sWgTypeFullYear;
	private AdminChartByPayment chartPayment;
	
	
	public AdminChartContent(Object who) {
		this.soService = SaleOrderService.getInstance();
		setUsingUser(who);
		initComponents(who);
	}

	private void initComponents(Object who) {
		setLayout(null);

		pSearch = new AdminChartSearch(who);
		pSearch.setBounds(0, 10, 1190, 96);
		add(pSearch);
		
		chartPayment = new AdminChartByPayment(who);
		chartPayment.setBounds(12, 116, 1157, 670);
		add(chartPayment);
	}

	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}
}
