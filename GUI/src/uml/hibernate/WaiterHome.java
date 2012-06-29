package uml.hibernate;

// Generated 2012-6-26 17:05:03 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import uml.base.HibernateUtil;
import uml.middleclass.WaiterGroup;

/**
 * Home object for domain model class Waiter.
 * @see uml.hibernate.Waiter
 * @author Hibernate Tools
 */
public class WaiterHome {

	private static final Log log = LogFactory.getLog(WaiterHome.class);

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

	public boolean persist(Waiter waiter) {
		log.debug("persisting Waiter instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();	
			SQLQuery query = session.createSQLQuery("select savewaiter(?,?,?,?,?,?,?)");
			query.setInteger(0, waiter.getWaiterid());
			query.setString(1, waiter.getName());
			query.setString(2, waiter.getSex());
			query.setInteger(3, waiter.getWaitergroup().getWaitergroupid());
			query.setString(4, waiter.getCellphone());
			query.setString(5, waiter.getCid());
			query.setDate(6, waiter.getSalarydate());
			log.debug("persist successful");
			Boolean result = (Boolean)query.uniqueResult();
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Waiter instance) {
		log.debug("attaching dirty Waiter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Waiter instance) {
		log.debug("attaching clean Waiter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(int pwaitergroupid) {
		log.debug("deleting Waiter instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Waiter instance = (Waiter) session.get("uml.hibernate.Waiter", pwaitergroupid);
			session.delete(instance);
			log.debug("delete successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Waiter merge(Waiter detachedInstance) {
		log.debug("merging Waiter instance");
		try {
			Waiter result = (Waiter) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Waiter findById(int id) {
		log.debug("getting Waiter instance with id: " + id);
		try {
			Waiter instance = (Waiter) sessionFactory.getCurrentSession().get(
					"uml.hibernate.Waiter", id);
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

	public List findByExample(Waiter instance) {
		log.debug("finding Waiter instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Waiter")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<uml.middleclass.Waiter> getAllWaiters(){	
		log.debug("finding Waitergroup instance by example");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Waiter> results = session.createCriteria("uml.hibernate.Waiter").list();
			log.debug("find by example successful, result size: "
					+ results.size());
			List<uml.middleclass.Waiter> finalresults = new ArrayList<uml.middleclass.Waiter>();
			for (int i = 0; i < results.size(); i++) {
				finalresults.add(new uml.middleclass.Waiter(results.get(i).getWaiterid(), new WaiterGroup(results.get(i).getWaitergroup().getWaitergroupid(), results.get(i).getWaitergroup().getCategory()), results.get(i).getName(), results.get(i).getSex(), results.get(i).getCellphone(), results.get(i).getCid(), results.get(i).getSalarydate()));
			}
			
			return finalresults;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public boolean update(Waiter waiter) {
		log.debug("persisting Waiter instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();	
			SQLQuery query = session.createSQLQuery("select updatewaiter(?,?,?,?,?,?,?)");
			query.setInteger(0, waiter.getWaiterid());
			query.setString(1, waiter.getName());
			query.setString(2, waiter.getSex());
			query.setInteger(3, waiter.getWaitergroup().getWaitergroupid());
			query.setString(4, waiter.getCellphone());
			query.setString(5, waiter.getCid());
			query.setDate(6, waiter.getSalarydate());
			log.debug("persist successful");
			Boolean result = (Boolean)query.uniqueResult();
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
}
