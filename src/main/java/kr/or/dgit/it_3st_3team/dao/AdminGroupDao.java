package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;

public interface AdminGroupDao {
	AdminGroup selectAdminByNo(AdminGroup adGroup);
	
	List<AdminGroup> selectAdminGroupByAll();
}
