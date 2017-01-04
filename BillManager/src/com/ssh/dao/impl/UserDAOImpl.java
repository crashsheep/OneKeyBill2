package com.ssh.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.dao.UserDAO;
import com.ssh.model.User;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.User
 * @author MyEclipse Persistence Tools
 */
@Repository("userDAO")
public class UserDAOImpl extends MyHibernateDaoSupport implements UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	// property constants
	public static final String PASS_WORD = "passWord";
	public static final String USER_NAME = "userName";
	public static final String GENDER = "gender";
	public static final String TEL = "tel";
	public static final String REMARK = "remark";
	public static final String ACTIVITY = "activity";
	public static final String ROLE_ID = "roleId";

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#save(com.ssh.model.User)
	 */
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#delete(com.ssh.model.User)
	 */
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findById(java.lang.Integer)
	 */
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get("com.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByExample(com.ssh.model.User)
	 */
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getSession()
					.createCriteria("com.User").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByPassWord(java.lang.Object)
	 */
	public List<User> findByPassWord(Object passWord) {
		return findByProperty(PASS_WORD, passWord);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByUserName(java.lang.Object)
	 */
	public List<User> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByGender(java.lang.Object)
	 */
	public List<User> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByTel(java.lang.Object)
	 */
	public List<User> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByRemark(java.lang.Object)
	 */
	public List<User> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByActivity(java.lang.Object)
	 */
	public List<User> findByActivity(Object activity) {
		return findByProperty(ACTIVITY, activity);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findByRoleId(java.lang.Object)
	 */
	public List<User> findByRoleId(Object roleId) {
		return findByProperty(ROLE_ID, roleId);
	}

	/* (non-Javadoc)
	 * @see com.ssh.dao.impl.UserDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<User> loginValidate(User instance){
		try {
			Criteria queryObject = getSession().createCriteria(User.class).add(Example.create(instance));
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}