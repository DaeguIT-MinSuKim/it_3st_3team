package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.UserGroup;

public interface UserDao {
	User selectUserByNo(User User);
	User selectUserById(User User);
	User selectUserByLogin(User User);
	List<User> selectUserAll();
	List<User> selectUserAllByUserGroup(UserGroup userGroup);
	
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(User userNo);
}
