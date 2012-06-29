package uml.hibernate;

// Generated 2012-6-16 6:03:03 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import uml.hibernate.DinningtableHome;
import uml.middleclass.Table;
import uml.middleclass.TableGroup;
import uml.base.HibernateUtil;
import uml.hibernate.Tabledish;
/**
 * Home object for domain model class WalkinBill.
 * @see uml.hibernate.WalkinBill
 * @author Hibernate Tools
 */
public class WalkinBillHome {

	private static final Log log = LogFactory.getLog(WalkinBillHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(WalkinBill transientInstance) {
		log.debug("persisting WalkinBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WalkinBill instance) {
		log.debug("attaching dirty WalkinBill instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WalkinBill instance) {
		log.debug("attaching clean WalkinBill instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WalkinBill persistentInstance) {
		log.debug("deleting WalkinBill instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WalkinBill merge(WalkinBill detachedInstance) {
		log.debug("merging WalkinBill instance");
		try {
			WalkinBill result = (WalkinBill) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WalkinBill findById(java.lang.Integer id) {
		log.debug("getting WalkinBill instance with id: " + id);
		try {
			WalkinBill instance = (WalkinBill) sessionFactory
					.getCurrentSession().get("uml.hibernate.WalkinBill", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WalkinBill instance) {
		log.debug("finding WalkinBill instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.WalkinBill")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void update(int walkinbillid,int peopleNumber,String feedback) {
		log.debug("updateing WalkinBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			WalkinBill walkinBill = (WalkinBill)session.get("uml.hibernate.WalkinBill", walkinbillid);
			walkinBill.setFeedback(feedback);
			walkinBill.setPeopleNumber(peopleNumber);
			tx.commit();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public uml.middleclass.WalkinBill getWalkinBill(java.lang.Integer id) {
		log.debug("getting WalkinBill instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			WalkinBill instance = (WalkinBill) session.get("uml.hibernate.WalkinBill", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			uml.middleclass.WalkinBill walkinBill = new uml.middleclass.WalkinBill(new Table(instance.getDinningtable().getTableid(), new TableGroup(instance.getDinningtable().getTablegroup().getCategory(), instance.getDinningtable().getTablegroup().getContainNumber(), instance.getDinningtable().getTablegroup().getLowestConsumption()), instance.getDinningtable().getState()), instance.getPeopleNumber(), instance.getState(), instance.getDate());
			if(instance.getFeedback() == null){
				;
			}else{
				walkinBill.setFeedback(instance.getFeedback());
			}
			
			return walkinBill;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void checkout(int walkinbillid,int ptableid) {
		log.debug("checkout with id: " + ptableid);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Dinningtable dinningtable = (Dinningtable)session.get("uml.hibernate.Dinningtable", ptableid);
			dinningtable.setState("EMPTY");
			WalkinBill walkinBill = (WalkinBill)session.get("uml.hibernate.WalkinBill", walkinbillid);
			walkinBill.setState("CHECKOUT");
			tx.commit();
			log.debug("checkout successful");
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void giveup(int walkinbillid,int ptableid) {
		log.debug("giveup WalkinBill instance with id: " + walkinbillid);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			WalkinBill instance = (WalkinBill) session.get("uml.hibernate.WalkinBill", walkinbillid);
			instance.setState("GIVEUP");
			Dinningtable dinningtable = (Dinningtable)session.get("uml.hibernate.Dinningtable", ptableid);
			dinningtable.setState("EMPTY");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("giveup failed", re);
			throw re;
		}
	}
}
