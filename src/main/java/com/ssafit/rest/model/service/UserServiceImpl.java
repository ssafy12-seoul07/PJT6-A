package com.ssafit.rest.model.service;

import org.springframework.stereotype.Service;

import com.ssafit.rest.model.dao.UserDao;
import com.ssafit.rest.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean signup(User user) {
		System.out.println("유저 삽입");
		if (userDao.insertUser(user)) {
			return true;
		}
		return false;
	}

	@Override
	public User login(String id, String password) {
		User loginUser = userDao.findUser(id);
		
		if (loginUser == null) {
	        return null;  
	    }
		
		if (loginUser.getPassword().equals(password)) {
			return loginUser;
		}
		return null;
	}

	

	@Override
	public boolean delete(int id) {
		if (userDao.deleteUser(id)) {
			System.out.println("유저 삭제 완료");
			return true;
		}
		return false;
	}
	
	@Override 
	public boolean isUserExist(String userId) {
		User user = userDao.findById(userId);
		if (user!=null) {
			return true;
		}
		return false;
	}
	

}
