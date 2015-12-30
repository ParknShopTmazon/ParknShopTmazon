package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Address;

public interface AddressDao {

	public List<Address> select(Address address);

	public Address insert(Address address);

	public boolean update(Address address);

	public boolean delete(Address address);

}
