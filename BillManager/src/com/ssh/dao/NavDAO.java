package com.ssh.dao;

import java.util.List;

import com.ssh.model.Nav;

public interface NavDAO {

	void save(Nav transientInstance);

	void delete(Nav persistentInstance);

	Nav findById(java.lang.Integer id);

	List<Nav> findByExample(Nav instance);

	List findByProperty(String propertyName, Object value);

	List<Nav> findByText(Object text);

	List<Nav> findByState(Object state);

	List<Nav> findByIconCls(Object iconCls);

	List<Nav> findByUrl(Object url);

	List<Nav> findByNid(Object nid);

	List findAll(int nid);

}