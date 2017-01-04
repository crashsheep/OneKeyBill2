package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssh.model.Ininvoice;
import com.ssh.util.MyHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ininvoice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Ininvoice
 * @author MyEclipse Persistence Tools
 */
@Repository
public class IninvoiceDAOImpl extends MyHibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(IninvoiceDAOImpl.class);
	// property constants
	public static final String INVOICE_NUM = "invoiceNum";
	public static final String BALANCE_NUM = "balanceNum";
	public static final String OUT_NAME = "outName";
	public static final String IN_NAME = "inName";
	public static final String TAX_RATE = "taxRate";
	public static final String AMOUNT = "amount";
	public static final String REMARK = "remark";

	public void save(Ininvoice transientInstance) {
		log.debug("saving Ininvoice instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ininvoice persistentInstance) {
		log.debug("deleting Ininvoice instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ininvoice findById(java.lang.Integer id) {
		log.debug("getting Ininvoice instance with id: " + id);
		try {
			Ininvoice instance = (Ininvoice) getSession().get("com.Ininvoice",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Ininvoice> findByExample(Ininvoice instance) {
		log.debug("finding Ininvoice instance by example");
		try {
			List<Ininvoice> results = (List<Ininvoice>) getSession()
					.createCriteria("com.Ininvoice").add(create(instance))
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
		log.debug("finding Ininvoice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ininvoice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Ininvoice> findByInvoiceNum(Object invoiceNum) {
		return findByProperty(INVOICE_NUM, invoiceNum);
	}

	public List<Ininvoice> findByBalanceNum(Object balanceNum) {
		return findByProperty(BALANCE_NUM, balanceNum);
	}

	public List<Ininvoice> findByOutName(Object outName) {
		return findByProperty(OUT_NAME, outName);
	}

	public List<Ininvoice> findByInName(Object inName) {
		return findByProperty(IN_NAME, inName);
	}

	public List<Ininvoice> findByTaxRate(Object taxRate) {
		return findByProperty(TAX_RATE, taxRate);
	}

	public List<Ininvoice> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List<Ininvoice> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Ininvoice instances");
		try {
			String queryString = "from Ininvoice";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ininvoice merge(Ininvoice detachedInstance) {
		log.debug("merging Ininvoice instance");
		try {
			Ininvoice result = (Ininvoice) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ininvoice instance) {
		log.debug("attaching dirty Ininvoice instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ininvoice instance) {
		log.debug("attaching clean Ininvoice instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}