package com.ssh.dao.impl;

import com.ssh.model.Preininvoice;
import com.ssh.util.MyHibernateDaoSupport;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Preininvoice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.Preininvoice
 * @author MyEclipse Persistence Tools
 */
@Repository
public class PreininvoiceDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PreininvoiceDAOImpl.class);
	// property constants
	public static final String INVOICE_NUM = "invoiceNum";
	public static final String BALANCE_NUM = "balanceNum";
	public static final String OUT_NAME = "outName";
	public static final String IN_NAME = "inName";
	public static final String TAX_RATE = "taxRate";
	public static final String AMOUNT = "amount";
	public static final String REMARK = "remark";

	public void save(Preininvoice transientInstance) {
		log.debug("saving Preininvoice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Preininvoice persistentInstance) {
		log.debug("deleting Preininvoice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Preininvoice findById(java.lang.Integer id) {
		log.debug("getting Preininvoice instance with id: " + id);
		try {
			Preininvoice instance = (Preininvoice) getSession().get(
					"com.Preininvoice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Preininvoice> findByExample(Preininvoice instance) {
		log.debug("finding Preininvoice instance by example");
		try {
			List<Preininvoice> results = (List<Preininvoice>) getSession()
					.createCriteria("com.Preininvoice").add(create(instance))
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
		log.debug("finding Preininvoice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Preininvoice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Preininvoice> findByInvoiceNum(Object invoiceNum) {
		return findByProperty(INVOICE_NUM, invoiceNum);
	}

	public List<Preininvoice> findByBalanceNum(Object balanceNum) {
		return findByProperty(BALANCE_NUM, balanceNum);
	}

	public List<Preininvoice> findByOutName(Object outName) {
		return findByProperty(OUT_NAME, outName);
	}

	public List<Preininvoice> findByInName(Object inName) {
		return findByProperty(IN_NAME, inName);
	}

	public List<Preininvoice> findByTaxRate(Object taxRate) {
		return findByProperty(TAX_RATE, taxRate);
	}

	public List<Preininvoice> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<Preininvoice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Preininvoice instances");
		try {
			String queryString = "from Preininvoice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Preininvoice merge(Preininvoice detachedInstance) {
		log.debug("merging Preininvoice instance");
		try {
			Preininvoice result = (Preininvoice) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Preininvoice instance) {
		log.debug("attaching dirty Preininvoice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Preininvoice instance) {
		log.debug("attaching clean Preininvoice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}