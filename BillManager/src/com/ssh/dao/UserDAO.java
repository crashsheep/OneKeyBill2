package com.ssh.dao;

import java.util.List;

import com.ssh.model.User;

public interface UserDAO {

	void save(User transientInstance);

	void delete(User persistentInstance);

	User findById(java.lang.Integer id);

	List<User> findByExample(User instance);

	List findByProperty(String propertyName, Object value);

	List<User> findByPassWord(Object passWord);

	List<User> findByUserName(Object userName);

	List<User> findByGender(Object gender);

	List<User> findByTel(Object tel);

	List<User> findByRemark(Object remark);

	List<User> findByActivity(Object activity);

	List<User> findByRoleId(Object roleId);

	List findAll();
	
	List<User> loginValidate(User instance);

}