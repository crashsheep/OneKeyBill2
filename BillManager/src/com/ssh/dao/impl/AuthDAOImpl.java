package com.ssh.dao.impl;

import com.ssh.model.Auth;
import com.ssh.util.MyHibernateDaoSupport;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for Auth
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.Auth
 * @author MyEclipse Persistence Tools
 */
@Repository("authDAO")
public class AuthDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AuthDAOImpl.class);
	// property constants
	public static final String AUTH_NAME = "authName";
	public static final String AUTH = "auth";
	public static final String REMARK = "remark";

	public void save(Auth transientInstance) {
		log.debug("saving Auth instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Auth persistentInstance) {
		log.debug("deleting Auth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Auth findById(java.lang.Integer id) {
		log.debug("getting Auth instance with id: " + id);
		try {
			Auth instance = (Auth) getSession().get("com.Auth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Auth> findByExample(Auth instance) {
		log.debug("finding Auth instance by example");
		try {
			List<Auth> results = (List<Auth>) getSession()
					.createCriteria("com.Auth").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Auth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Auth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Auth> findByAuthName(Object authName) {
		return findByProperty(AUTH_NAME, authName);
	}

	public List<Auth> findByAuth(Object auth) {
		return findByProperty(AUTH, auth);
	}

	public List<Auth> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Auth instances");
		try {
			String queryString = "from Auth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}