package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.model.Company;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Company entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Company
 * @author MyEclipse Persistence Tools
 */
@Repository
public class CompanyDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CompanyDAOImpl.class);
	// property constants
	public static final String COMPANY_NAME = "companyName";
	public static final String COMPANY_OWNER = "companyOwner";
	public static final String COMPANY_STATE = "companyState";
	public static final String CORPORATE_NUM = "corporateNum";
	public static final String CORPORATE_NAME = "corporateName";
	public static final String CORPORATE_PHONE = "corporatePhone";
	public static final String REMARK = "remark";

	public void save(Company transientInstance) {
		log.debug("saving Company instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Company persistentInstance) {
		log.debug("deleting Company instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Company findById(java.lang.Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Company instance = (Company) getSession().get("com.Company", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Company> findByExample(Company instance) {
		log.debug("finding Company instance by example");
		try {
			List<Company> results = (List<Company>) getSession()
					.createCriteria("com.Company").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Company instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Company as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Company> findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List<Company> findByCompanyOwner(Object companyOwner) {
		return findByProperty(COMPANY_OWNER, companyOwner);
	}

	public List<Company> findByCompanyState(Object companyState) {
		return findByProperty(COMPANY_STATE, companyState);
	}

	public List<Company> findByCorporateNum(Object corporateNum) {
		return findByProperty(CORPORATE_NUM, corporateNum);
	}

	public List<Company> findByCorporateName(Object corporateName) {
		return findByProperty(CORPORATE_NAME, corporateName);
	}

	public List<Company> findByCorporatePhone(Object corporatePhone) {
		return findByProperty(CORPORATE_PHONE, corporatePhone);
	}

	public List<Company> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Company instances");
		try {
			String queryString = "from Company";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}