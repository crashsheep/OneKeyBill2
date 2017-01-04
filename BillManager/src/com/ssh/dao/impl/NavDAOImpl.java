package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.dao.NavDAO;
import com.ssh.model.Nav;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Nav
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.Nav
 * @author MyEclipse Persistence Tools
 */
@Repository("navDAO")
public class NavDAOImpl extends MyHibernateDaoSupport implements NavDAO {
	private static final Logger log = LoggerFactory.getLogger(NavDAOImpl.class);
	// property constants
	public static final String TEXT = "text";
	public static final String STATE = "state";
	public static final String ICON_CLS = "iconCls";
	public static final String URL = "url";
	public static final String NID = "nid";

	public void save(Nav transientInstance) {
		log.debug("saving Nav instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Nav persistentInstance) {
		log.debug("deleting Nav instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Nav findById(java.lang.Integer id) {
		log.debug("getting Nav instance with id: " + id);
		try {
			Nav instance = (Nav) getSession().get("com.Nav", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Nav> findByExample(Nav instance) {
		log.debug("finding Nav instance by example");
		try {
			List<Nav> results = (List<Nav>) getSession()
					.createCriteria("com.Nav").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Nav instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Nav as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Nav> findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List<Nav> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Nav> findByIconCls(Object iconCls) {
		return findByProperty(ICON_CLS, iconCls);
	}

	public List<Nav> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List<Nav> findByNid(Object nid) {
		return findByProperty(NID, nid);
	}

	public List findAll(int nid) {
		log.debug("finding all Nav instances");
		try {
			String queryString = "from Nav where nid="+nid+"";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}