package com.ssh.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.ssh.dao.UserDAO;
import com.ssh.model.User;
import com.ssh.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDAO userDAO;
	private List<User> userList;
	//登陆验证
	public boolean loginValidate(String username,String password){
		password=new BASE64Encoder().encode(password.getBytes());
		User user=new User();
		user.setUserName(username);
		user.setPassWord(password);
		userList=userDAO.loginValidate(user);
		if(userList.size()>0)
		{
		return true;
		}
		else{
			return false;
		}		
	}
}
