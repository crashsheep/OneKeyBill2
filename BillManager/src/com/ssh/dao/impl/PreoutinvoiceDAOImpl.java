package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.model.Preoutinvoice;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Preoutinvoice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.Preoutinvoice
 * @author MyEclipse Persistence Tools
 */
@Repository
public class PreoutinvoiceDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PreoutinvoiceDAOImpl.class);
	// property constants
	public static final String INVOICE_NUM = "invoiceNum";
	public static final String BALANCE_NUM = "balanceNum";
	public static final String OUT_NAME = "outName";
	public static final String IN_NAME = "inName";
	public static final String TAX_RATE = "taxRate";
	public static final String AMOUNT = "amount";
	public static final String REMARK = "remark";

	public void save(Preoutinvoice transientInstance) {
		log.debug("saving Preoutinvoice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Preoutinvoice persistentInstance) {
		log.debug("deleting Preoutinvoice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Preoutinvoice findById(java.lang.Integer id) {
		log.debug("getting Preoutinvoice instance with id: " + id);
		try {
			Preoutinvoice instance = (Preoutinvoice) getSession().get(
					"com.Preoutinvoice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Preoutinvoice> findByExample(Preoutinvoice instance) {
		log.debug("finding Preoutinvoice instance by example");
		try {
			List<Preoutinvoice> results = (List<Preoutinvoice>) getSession()
					.createCriteria("com.Preoutinvoice").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Preoutinvoice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Preoutinvoice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Preoutinvoice> findByInvoiceNum(Object invoiceNum) {
		return findByProperty(INVOICE_NUM, invoiceNum);
	}

	public List<Preoutinvoice> findByBalanceNum(Object balanceNum) {
		return findByProperty(BALANCE_NUM, balanceNum);
	}

	public List<Preoutinvoice> findByOutName(Object outName) {
		return findByProperty(OUT_NAME, outName);
	}

	public List<Preoutinvoice> findByInName(Object inName) {
		return findByProperty(IN_NAME, inName);
	}

	public List<Preoutinvoice> findByTaxRate(Object taxRate) {
		return findByProperty(TAX_RATE, taxRate);
	}

	public List<Preoutinvoice> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<Preoutinvoice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Preoutinvoice instances");
		try {
			String queryString = "from Preoutinvoice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Preoutinvoice merge(Preoutinvoice detachedInstance) {
		log.debug("merging Preoutinvoice instance");
		try {
			Preoutinvoice result = (Preoutinvoice) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Preoutinvoice instance) {
		log.debug("attaching dirty Preoutinvoice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Preoutinvoice instance) {
		log.debug("attaching clean Preoutinvoice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}