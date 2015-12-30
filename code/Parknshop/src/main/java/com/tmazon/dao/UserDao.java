package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Address;
import com.tmazon.domain.User;

public interface UserDao {

	public List<User> select(User user);
	
	public boolean insert(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User findByName(String name);
	
	public List<User> SearchByName(String name);
	
	public List<User> findFriendsById(Integer id);
	
	public boolean insertFriend(Integer userId, Integer friendId);
	
	public boolean deleteFriend(Integer userId, Integer friendId);
	
	public List<Address> selectAddress(User user);
	
	public boolean insertAddress(User user, Address address);
	
	public boolean updateAddress(User user, Address address);
	
	public boolean deleteAddress(User user, Address address);
	
}
