package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Address;
import com.tmazon.domain.User;

public interface AddressService {

	public List<Address> getAddress(User user);
	
	public Address insertAddress(Address address);
	
	public Address findById(Integer id);
}
