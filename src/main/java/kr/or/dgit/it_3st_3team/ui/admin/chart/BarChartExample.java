package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import kr.or.dgit.it_3st_3team.service.SaleOrderService;

public class BarChartExample extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private SaleOrderService saleOrder;
	

	public BarChartExample(String appTitle) {
		super(appTitle);
		saleOrder = new SaleOrderService();
		initComponents();
	}

	private void initComponents() {

		// Create Dataset
		CategoryDataset dataset = createDataset();

		chart = ChartFactory.createBarChart(
				"소프트웨어 결제타입별 판매현황", // Chart Title
				"결제타입", // Category axis
				"결제횟수", // Value axis
		dataset, PlotOrientation.VERTICAL, true, true, false);
		
		// 한글세팅
		setupKorean();
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	private void setupKorean() {
		chart.getTitle().setFont(new Font("굴림", Font.BOLD, 20));
		chart.getLegend().setItemFont(new Font("굴림", Font.BOLD, 20));
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("굴림", Font.BOLD, 17));
		plot.getDomainAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 15));
		plot.getRangeAxis().setLabelFont(new Font("굴림", Font.BOLD, 17));
		plot.getRangeAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 15));
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		
		Map<String, String> maps1 = new HashMap<>();
		maps1.put("date", "2016");
		List<Map<String, Integer>> listChart1 = saleOrder.selectPaymentChartOption(maps1);
		System.out.println(listChart1);
		
		
		Map<String, String> maps2 = new HashMap<>();
		maps2.put("date", "2017");
		List<Map<String, Integer>> listChart2 = saleOrder.selectPaymentChartOption(maps2);
		
		Map<String, String> maps3 = new HashMap<>();
		maps3.put("date", "2018");
		List<Map<String, Integer>> listChart3 = saleOrder.selectPaymentChartOption(maps3);
		
		for(Map<String, Integer> map : listChart1) {
			dataset1.addValue(map.get("count"), map.get("typeofpayment"), maps1.get("date"));
		}
		for(Map<String, Integer> map : listChart2) {
			dataset1.addValue(map.get("count"), map.get("typeofpayment"), maps2.get("date"));
		}
		
		for(Map<String, Integer> map : listChart3) {
			dataset1.addValue(map.get("count"), map.get("typeofpayment"), maps3.get("date"));
		}
		
		return dataset1;
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			BarChartExample example = new BarChartExample("소프트웨어 분류별 판매현황");
			example.setSize(800, 500);
			example.setLocationRelativeTo(null);
			example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			example.setVisible(true);
		});
	}
}
