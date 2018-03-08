package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import kr.or.dgit.it_3st_3team.service.SaleOrderService;

@SuppressWarnings("serial")
public class AdminChartBySwgTypeFullYear extends JPanel  {

	private JFreeChart chart;
	private SaleOrderService saleOrder;
	
	public AdminChartBySwgTypeFullYear() {
		saleOrder = new SaleOrderService();
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1150, 600));
		add(chartPanel);
		setupKorean();
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
		
		
		Map<String, String> maps1 = new HashMap<>();
		maps1.put("date", "2016");
		List<Map<String, Integer>> listChart1 = saleOrder.selectSgGroupYear(maps1);
		
		Map<String, String> maps2 = new HashMap<>();
		maps2.put("date", "2017");
		List<Map<String, Integer>> listChart2 = saleOrder.selectSgGroupYear(maps2);
		
		Map<String, String> maps3 = new HashMap<>();
		maps3.put("date", "2018");
		List<Map<String, Integer>> listChart3 = saleOrder.selectSgGroupYear(maps3);
		
		for(Map<String, Integer> map : listChart1) {
			dataset1.addValue(map.get("count"), map.get("name"), maps1.get("date"));
		}
		
		for(Map<String, Integer> map : listChart2) {
			dataset1.addValue(map.get("count"), map.get("name"), maps2.get("date"));
		}
		
		for(Map<String, Integer> map : listChart3) {
			dataset1.addValue(map.get("count"), map.get("name"), maps3.get("date"));
		}
		return dataset1;

	}


	private JFreeChart createChart(final CategoryDataset dataset) {
		chart = ChartFactory.createBarChart3D("소프트웨어 분류별 판매현황", // chart
				// title
				"", // domain axis label
				"판매갯수", // range axis label
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
}
