package com.tmazon.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tmazon.dao.AddressDao;
import com.tmazon.domain.Address;
import com.tmazon.util.DaoUtil;

public class AddressDaoImpl implements AddressDao {

	public List<Address> select(Address address) {
		StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM address WHERE 1=1 ");
		ArrayList<Object> params = new ArrayList<Object>();
		if (address.getUserId() != null) {
			sqlBuilder.append("AND userId=? ");
			params.add(address.getUserId());
		}
		if (address.getAddressId() != null) {
			sqlBuilder.append("AND addressId=? ");
			params.add(address.getAddressId());
		}
		if (address.getDescription() != null) {
			sqlBuilder.append("AND description=? ");
			params.add(address.getDescription());
		}
		if (address.getName() != null) {
			sqlBuilder.append("AND name=? ");
			params.add(address.getName());
		}
		if (address.getPhone() != null) {
			sqlBuilder.append("AND phone=? ");
			params.add(address.getPhone());
		}
		if (address.getZipcode() != null) {
			sqlBuilder.append("AND zipcode=? ");
			params.add(address.getZipcode());
		}

		String sql = sqlBuilder.toString();
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			List<Address> result = runner.query(sql, new BeanListHandler<Address>(Address.class), params.toArray());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Address insert(Address address) {

		String sql = "INSERT INTO address VALUES (?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			runner.insert(sql, new BeanHandler<Address>(Address.class), address.getAddressId(),
					address.getUserId(), address.getDescription(), address.getZipcode(), address.getName(),
					address.getPhone());
			List<Address> results = select(address);
			if(results.isEmpty())
				return null;
			else
				return results.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Address address) {
		return false;
	}

	public boolean delete(Address address) {
		return false;
	}

}
