package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.Admin;

public interface AdminDao {
	Admin selectAdminByNo(Admin admin);
	Admin selectAdminById(Admin admin);
	Admin selectAdminByLogin(Admin admin);
	List<Admin> selectAdminAll();
	
	int insertAdmin(Admin admin);
	int updateAdmin(Admin admin);
	int deleteAdmin(Admin admin);
}
