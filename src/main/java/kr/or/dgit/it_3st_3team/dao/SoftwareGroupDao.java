package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;

public interface SoftwareGroupDao {
	SoftwareGroup selectSoftwareGroupByNo(SoftwareGroup softwaregroup);
	List<SoftwareGroup> selectSoftwareGroupByAll();
	
	int insertSoftwareGroup(SoftwareGroup softwaregroup);
	int deleteSoftwareGroup(SoftwareGroup sgNo);
}
