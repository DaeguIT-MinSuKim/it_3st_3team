package kr.or.dgit.it_3st_3team.ui.admin.chart;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

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
public class BarChartExample3D extends JPanel  {

	private JFreeChart chart;
	private SaleOrderService saleOrder;
	
	public BarChartExample3D() {
		saleOrder = new SaleOrderService();
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		add(chartPanel);
		setupKorean();
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

		final DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		
		
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
		dataset1.addValue(listChart1.get("합계"), "합계", "2016");
		
		dataset1.addValue(listChart2.get("사무"), "사무", "2017");
		dataset1.addValue(listChart2.get("게임"), "게임", "2017");
		dataset1.addValue(listChart2.get("그래픽"), "그래픽", "2017");
		dataset1.addValue(listChart2.get("합계"), "합계", "2017");
		
		dataset1.addValue(listChart3.get("사무"), "사무", "2018");
		dataset1.addValue(listChart3.get("게임"), "게임", "2018");
		dataset1.addValue(listChart3.get("그래픽"), "그래픽", "2018");
		dataset1.addValue(listChart3.get("합계"), "합계", "2018");
		return dataset1;

	}


	private JFreeChart createChart(final CategoryDataset dataset) {
		chart = ChartFactory.createBarChart3D("소프트웨어 분류별 판매현황", // chart
				// title
				"영업사원1", // domain axis label
				"판매이윤", // range axis label
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

	public static void main(final String[] args) {

		final BarChartExample3D demo = new BarChartExample3D();
		//demo.pack();
	//	RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}
}
