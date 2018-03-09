package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.UserGroup;

public interface UserDao {
	User selectUserByNo(User User);
	User selectUserById(User User);
	User selectUserByLogin(User User);
	User selectUserByFindId(User user);
	User selectUserByFindPw(User user);

	List<User> selectUserAll();
	List<User> selectUserAllByUserGroup(UserGroup userGroup);
	List<User> selectUserBySearch(Map<String, String> map);
	
	int insertUser(User user);
	
	int updateUser(User user);
	int updateUserPassword(Map<String, String> map);
	
	int deleteUser(User userNo);
	int deleteRealUser(User userNo);
}
