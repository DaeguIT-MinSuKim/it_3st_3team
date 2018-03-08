package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.Software;

public interface SoftwareDao {
	Software selectSoftwareByNo(Software software);
	List<Software> selectSoftwareBySearch(Map<String, String> map);
	List<Software> selectSoftwareByAll();
	List<Software> selectSoftwareByNoCustomer(Software software);
	List<Software> selectSoftwareByNameCustomer(Software software);
	
	
	int insertSoftware(Software software);
	int updateSoftware(Software software);
	int deleteSoftware(Software swNo);
}
