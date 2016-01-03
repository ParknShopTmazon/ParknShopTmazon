package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.User;

public interface UserDao {

	public List<User> select(User user);
	
	public List<User> search(User user);
	
	public boolean insert(User user);
	
	public boolean update(String name,String status);
	
	public boolean delete(String name);
	
	public User findByName(String name);
	
	public List<User> SearchByName(String name);
	
	public List<User> findFriendsById(Integer id);
	
	public boolean insertFriend(Integer userId, Integer friendId);
	
	public boolean deleteFriend(Integer userId, Integer friendId);
	
	public User findById(Integer id);
	
}
