package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.User;

public interface UserDao {
	User selectUserByNo(User UserNo);
	List<User> selectUserAll();
	
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(User userNo);
}
