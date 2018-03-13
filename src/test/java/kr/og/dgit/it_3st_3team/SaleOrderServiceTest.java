package kr.og.dgit.it_3st_3team;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.type.Payment;

public class SaleOrderServiceTest {
	private static SaleOrderService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = SaleOrderService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindSaleOrderByNo() {
		SaleOrder saleorder = new SaleOrder();
		saleorder.setOrdNo(1);
		SaleOrder findSaleOrder = service.findSaleOrderByNo(saleorder);
		Assert.assertNotNull(findSaleOrder);
	}

	@Test
	public void test2FindSaleOrderWithAllBySearch() {
		Map<String, String> maps = new HashMap<>();
		
		maps.put("sgName", "");
		maps.put("adminName", "");
		maps.put("startDate", "");
		maps.put("endDate", "");
		//maps.put("searchBy", "softwarename");
		maps.put("searchBy", "company");
		maps.put("name", ""); 
		//maps.put("name", "재밌는게임방");
		//maps.put("swName", "바람의 제국");
		List<SaleOrder> saleOrders = service.findSaleOrderWithAllBySearch(maps);
		Assert.assertNotNull(saleOrders);
		for (SaleOrder s : saleOrders) {
			System.out.println(s);
		}
	}
	
	@Test
	public void test3findSaleOrderByAll() {
		List<SaleOrder> findSaleOrder = service.findSaleOrderByAll();
		Assert.assertNotNull(findSaleOrder);
		System.out.println(findSaleOrder);
	}
	
	@Test
	public void test4deleteSaleOrderByNo() {
		int res = service.deleteSaleOrderByNo(new SaleOrder(1));
		Assert.assertEquals(1, res);
		System.out.println(res);
	}
	
	// 영업사원 차트 품목별 판매갯수
	@Test
	public void test5SelectSwGroupBySales() {
		Map<String, String> maps = new HashMap<>();
		
		maps.put("adminName", "영업1");
		maps.put("date", "2018");
		
		List<Map<String, Integer>> listChart = service.selectSwGroupBySales(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}

	// 관리자 차트 품목별 판매갯수
	@Test
	public void test6SelectSwGroupForYears() {
		Map<String, String> maps = new HashMap<>();
		maps.put("date", "2018");
		
		List<Map<String, Integer>> listChart = service.selectSwGroupForYears(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	
	@Test // 고객차트 차트 품목별 판매갯수
	public void test7SelectSwGroupCustomer() {
		Map<String, String> maps = new HashMap<>();
		maps.put("userNo", "2");
		maps.put("date", "2017");
		
		List<Map<String, Integer>> listChart = service.selectSwGroupByCustomer(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	@Test // 공급회사 차트 품목별 판매갯수
	public void test8SelectSwGroupByCompany() {
		Map<String, String> maps = new HashMap<>();
		maps.put("companyNo", "1");
		maps.put("date", "2017");
		
		List<Map<String, Integer>> listChart = service.selectSwGroupByCompany(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	// 관리자 결제타입별 사용횟수 
	@Test
	public void test9SelectPaymentChartByAdmin() {
		Map<String, String> maps = new HashMap<>();

		maps.put("date", "2016");
		
		List<Map<String, Integer>> listChart = service.selectPaymentChartByAdmin(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	// 영업사원 결제타입별 사용횟수 
	@Test
	public void test10SelectPaymentChartBySales() {
		Map<String, String> maps = new HashMap<>();

		maps.put("date", "2016");
		
		List<Map<String, Integer>> listChart = service.selectPaymentChartBySales(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	@Test
	public void updateOrderManagementNo() {
		SaleOrder so = new SaleOrder(49);
		so.setOrdQuantity(450);
		so.setOrdPayment(Payment.SIMPLE);
		
		int res = service.updateOrderManagementNo(so);
		assertEquals(1, res);
		
	}
}
