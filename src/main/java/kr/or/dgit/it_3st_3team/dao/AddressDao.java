package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.Address;

public interface AddressDao {
	List<Address> selcectAddressBySido();
	List<Address> selcectAddressBySigungu(Address address);
	Address selectAddressByDoro(Address address);
	Address selectAddressByBuilding1(Address address);
	Address selectAddressByBuilding2(Address address);
	
	
}
