package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.Software;

public interface SoftwareDao {
	Software selectSoftwareByNo(Software software);
	List<Software> selectSoftwareByAll();
	
	int insertSoftware(Software software);
	int updateSoftware(Software software);
	int deleteSoftware(Software swNo);
}
