package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.Address;

public interface AddressDao {
	Address selcectAddressBySido();
	Address selcectAddressBySigungu(Address address);
	List<Address> selectAddressByAll();
	
	
}
