package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;
import java.util.HashMap;
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
				"소프트웨어 분류별 판매현황", // Chart Title
				"분류", // Category axis
				"판매이윤", // Value axis
		dataset, PlotOrientation.VERTICAL, true, true, false);
		
		// 한글세팅
		setupKorean();
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}

	private void setupKorean() {
		chart.getTitle().setFont(new Font("굴림", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("굴림", Font.BOLD, 15));
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.getDomainAxis().setLabelFont(new Font("굴림", Font.BOLD, 13));
		plot.getDomainAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 8));
		plot.getRangeAxis().setLabelFont(new Font("굴림", Font.BOLD, 13));
		plot.getRangeAxis().setTickLabelFont(new Font("굴림", Font.BOLD, 8));
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		
		Map<String, String> maps1 = new HashMap<>();
		maps1.put("adminName", "영업1");
		maps1.put("date", "2016");
		Map<String, Integer> listChart1 = saleOrder.selectSaleOrderBySwgType(maps1);
		
		Map<String, String> maps2 = new HashMap<>();
		maps2.put("adminName", "영업1");
		maps2.put("date", "2017");
		Map<String, Integer> listChart2 = saleOrder.selectSaleOrderBySwgType(maps2);
		
		Map<String, String> maps3 = new HashMap<>();
		maps3.put("adminName", "영업1");
		maps3.put("date", "2018");
		Map<String, Integer> listChart3 = saleOrder.selectSaleOrderBySwgType(maps3);
		
		dataset1.addValue(listChart1.get("사무"), "사무", "2016");
		dataset1.addValue(listChart1.get("게임"), "게임", "2016");
		dataset1.addValue(listChart1.get("그래픽"), "그래픽", "2016");

		
		dataset1.addValue(listChart2.get("사무"), "사무", "2017");
		dataset1.addValue(listChart2.get("게임"), "게임", "2017");
		dataset1.addValue(listChart2.get("그래픽"), "그래픽", "2017");

		
		dataset1.addValue(listChart3.get("사무"), "사무", "2018");
		dataset1.addValue(listChart3.get("게임"), "게임", "2018");
		dataset1.addValue(listChart3.get("그래픽"), "그래픽", "2018");

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
