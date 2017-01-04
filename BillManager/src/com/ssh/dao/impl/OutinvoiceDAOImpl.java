package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.model.Outinvoice;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Outinvoice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Outinvoice
 * @author MyEclipse Persistence Tools
 */
@Repository
public class OutinvoiceDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(OutinvoiceDAOImpl.class);
	// property constants
	public static final String INVOICE_NUM = "invoiceNum";
	public static final String BALANCE_NUM = "balanceNum";
	public static final String OUT_NAME = "outName";
	public static final String IN_NAME = "inName";
	public static final String TAX_RATE = "taxRate";
	public static final String AMOUNT = "amount";
	public static final String REMARK = "remark";

	public void save(Outinvoice transientInstance) {
		log.debug("saving Outinvoice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Outinvoice persistentInstance) {
		log.debug("deleting Outinvoice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Outinvoice findById(java.lang.Integer id) {
		log.debug("getting Outinvoice instance with id: " + id);
		try {
			Outinvoice instance = (Outinvoice) getSession().get(
					"com.Outinvoice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Outinvoice> findByExample(Outinvoice instance) {
		log.debug("finding Outinvoice instance by example");
		try {
			List<Outinvoice> results = (List<Outinvoice>) getSession()
					.createCriteria("com.Outinvoice").add(create(instance))
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
		log.debug("finding Outinvoice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Outinvoice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Outinvoice> findByInvoiceNum(Object invoiceNum) {
		return findByProperty(INVOICE_NUM, invoiceNum);
	}

	public List<Outinvoice> findByBalanceNum(Object balanceNum) {
		return findByProperty(BALANCE_NUM, balanceNum);
	}

	public List<Outinvoice> findByOutName(Object outName) {
		return findByProperty(OUT_NAME, outName);
	}

	public List<Outinvoice> findByInName(Object inName) {
		return findByProperty(IN_NAME, inName);
	}

	public List<Outinvoice> findByTaxRate(Object taxRate) {
		return findByProperty(TAX_RATE, taxRate);
	}

	public List<Outinvoice> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<Outinvoice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Outinvoice instances");
		try {
			String queryString = "from Outinvoice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Outinvoice merge(Outinvoice detachedInstance) {
		log.debug("merging Outinvoice instance");
		try {
			Outinvoice result = (Outinvoice) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Outinvoice instance) {
		log.debug("attaching dirty Outinvoice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Outinvoice instance) {
		log.debug("attaching clean Outinvoice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}