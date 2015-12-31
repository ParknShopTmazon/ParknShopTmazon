package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.AddressDao;
import com.tmazon.domain.Address;
import com.tmazon.domain.User;
import com.tmazon.service.AddressService;
import com.tmazon.util.BasicFactory; 

public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao = BasicFactory.getImpl(AddressDao.class);

	public List<Address> getAddress(User user) {
		Address address = new Address();
		address.setUserId(user.getUserId());
		return addressDao.select(address);
	}

	public Address insertAddress(Address address) {
		return addressDao.insert(address);
	}

	public Address findById(Integer id) {
		List<Address> addresses = addressDao.select(new Address(id, null, null, null, null, null));
		return (addresses != null && !addresses.isEmpty())? addresses.get(0) : null;
	}
	
}
