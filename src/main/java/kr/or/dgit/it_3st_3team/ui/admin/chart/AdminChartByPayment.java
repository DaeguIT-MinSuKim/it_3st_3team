package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;

@SuppressWarnings("serial")
public class AdminChartByPayment extends JPanel  {

	private JFreeChart chart;
	private SaleOrderService saleOrder;
	private Admin admin;
	private User user;
	
	
	public AdminChartByPayment() {
		saleOrder = new SaleOrderService();
	}
	
	public void createChart(Object who) {
		setUsingUser(who);
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1150, 600));
		setupKorean();
		removeAll();
		add(chartPanel);
		revalidate();
		repaint();
		
	}
	
	private void setupKorean() {
		chart.getTitle().setFont(new Font("굴림", Font.BOLD, 30));
		chart.getLegend().setItemFont(new Font("굴림", Font.BOLD, 30));
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("굴림", Font.BOLD, 20));
		plot.getDomainAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 18));
		plot.getRangeAxis().setLabelFont(new Font("굴림", Font.BOLD, 20));
		plot.getRangeAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 18));
		
	}

	private CategoryDataset createDataset() {

		final DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);

		
		if (admin != null) {
			// 관리자
			if (admin.getAdminGroup().getAgNo() == 1) {
				addAdminChartData(dataset1, year-2);//2년전
				addAdminChartData(dataset1, year-1);//1년전
				addAdminChartData(dataset1, year);//올해		
				
				return dataset1;
			} else {
			// 영업사원	
				addSalesChartData(dataset1, year-2);
				addSalesChartData(dataset1, year-1);
				addSalesChartData(dataset1, year);

				return dataset1;
			}
		} else {
			// 사용자
			if (user.getUserGroup().getValue() == 1) {
			/*	addCustomerChartData(dataset1, year-2);
				addCustomerChartData(dataset1, year-1);
				addCustomerChartData(dataset1, year);*/
			
				return dataset1;
			} else {
			// 공급회사
			/*	addCompanyChartData(dataset1, year-2);
				addCompanyChartData(dataset1, year-1);
				addCompanyChartData(dataset1, year);*/
				return dataset1;
			}
		}


	}

	//공급회사
	private void addCompanyChartData(final DefaultCategoryDataset dataset, int year) {
		Map<String, String> maps = new HashMap<>();
		maps.put("companyNo", String.valueOf(user.getUserNo()));
		maps.put("date", String.valueOf(year));
		List<Map<String, Integer>> listChart1 = saleOrder.selectSwGroupByCompany(maps);
		for(Map<String, Integer> map : listChart1) {
			dataset.addValue(map.get("count"), map.get("payment"), maps.get("date"));
		}
		
	}

	//고객
	private void addCustomerChartData(final DefaultCategoryDataset dataset, int year) {
		Map<String, String> maps = new HashMap<>();
		maps.put("userNo", String.valueOf(user.getUserNo()));
		maps.put("date", String.valueOf(year));
		List<Map<String, Integer>> listChart1 = saleOrder.selectSwGroupByCustomer(maps);
		for(Map<String, Integer> map : listChart1) {
			dataset.addValue(map.get("count"), map.get("payment"), maps.get("date"));
		}
		
	}

	// 영업사원
	private void addSalesChartData(final DefaultCategoryDataset dataset, int year) {
		Map<String, String> maps = new HashMap<>();
		maps.put("adminNo", String.valueOf(admin.getAdminNo()));
		maps.put("date", String.valueOf(year));
		List<Map<String, Integer>> listChart1 = saleOrder.selectPaymentChartBySales(maps);
		for(Map<String, Integer> map : listChart1) {
			dataset.addValue(map.get("count"), map.get("payment"), maps.get("date"));
		}
		
	}

	// 관리자
	private void addAdminChartData(final DefaultCategoryDataset dataset, int year) {
		Map<String, String> maps = new HashMap<>();
		maps.put("date", String.valueOf(year));
		List<Map<String, Integer>> listChart = saleOrder.selectPaymentChartByAdmin(maps);
		for(Map<String, Integer> map : listChart) {
			dataset.addValue(map.get("count"), map.get("payment"), maps.get("date"));
		}
		
		
	}


	private JFreeChart createChart(final CategoryDataset dataset) {
		chart = ChartFactory.createBarChart3D("소프트웨어 결제타입별 사용현황", // chart
				// title
				"", // domain axis label
				"사용횟수", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
		);
		final CategoryPlot plot = chart.getCategoryPlot();
		
		final CategoryAxis axis = plot.getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

		final CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setItemLabelsVisible(true);
		
		final BarRenderer r = (BarRenderer) renderer;
		
		return chart;
	}
	public void setUsingUser(Object who) {
		if (who instanceof Admin) {
			admin = (Admin) who;
		} else {
			user = (User) who;
		}
	}

	
}
