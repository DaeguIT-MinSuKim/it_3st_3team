package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;

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

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;

public class BarChartExample extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private SoftwareGroupService swgService;
	private SaleOrderService saleOrder;
	private SoftwareGroup swgGroup;

	public BarChartExample(String appTitle) {
		super(appTitle);
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
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		saleOrder = new SaleOrderService();
		int res = saleOrder.sumCount();
		
		//여기서 DB자료 가져옴
		
		
		// Population in 2015
		dataset.addValue(res, "사무", "2015");
		dataset.addValue(15, "게임", "2015");
		dataset.addValue(20, "그래픽", "2015");

		// Population in 2016
		dataset.addValue(15, "사무", "2016");
		dataset.addValue(20, "게임", "2016");
		dataset.addValue(25, "그래픽", "2016");

		// Population in 2017
		dataset.addValue(20, "사무", "2017");
		dataset.addValue(25, "게임", "2017");
		dataset.addValue(30, "그래픽", "2017");

		return dataset;
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