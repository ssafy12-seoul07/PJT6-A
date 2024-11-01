package com.ssafit.rest.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafit.rest.model.dto.User;
@Mapper
public interface UserDao {
	public boolean insertUser (User user);
	public boolean updateUser (User user);
	public boolean deleteUser (int id);
	public User findById(String userId);
	public User findUser(String id);

}
