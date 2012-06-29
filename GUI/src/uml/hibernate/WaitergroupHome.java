package uml.hibernate;

// Generated 2012-6-26 17:05:03 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import uml.base.HibernateUtil;
import uml.middleclass.WaiterGroup;

/**
 * Home object for domain model class Waitergroup.
 * @see uml.hibernate.Waitergroup
 * @author Hibernate Tools
 */
public class WaitergroupHome {

	private static final Log log = LogFactory.getLog(WaitergroupHome.class);

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

	public boolean persist(Waitergroup transientInstance) {
		log.debug("persisting Waitergroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();		
			SQLQuery query = session.createSQLQuery("select savewaitergroup(?,?)");
			query.setInteger(0, transientInstance.getWaitergroupid());
			query.setString(1, transientInstance.getCategory());			
			log.debug("persist successful");
			Boolean result = (Boolean)query.uniqueResult();
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Waitergroup instance) {
		log.debug("attaching dirty Waitergroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Waitergroup instance) {
		log.debug("attaching clean Waitergroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(int pwaitergroupid) {
		log.debug("deleting Waitergroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Waitergroup waitergroup = (Waitergroup)session.createCriteria(Waitergroup.class).add(Restrictions.eq("waitergroupid",pwaitergroupid)).setMaxResults(1).uniqueResult();
			session.delete(waitergroup);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Waitergroup merge(Waitergroup detachedInstance) {
		log.debug("merging Waitergroup instance");
		try {
			Waitergroup result = (Waitergroup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Waitergroup findById(int id) {
		log.debug("getting Waitergroup instance with id: " + id);
		try {
			Waitergroup instance = (Waitergroup) sessionFactory
					.getCurrentSession().get("uml.hibernate.Waitergroup", id);
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

	public List findByExample(Waitergroup instance) {
		log.debug("finding Waitergroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Waitergroup")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<WaiterGroup> getAllWaiterGroups(){	
		log.debug("finding Waitergroup instance by example");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Waitergroup> results = session.createCriteria("uml.hibernate.Waitergroup").list();
			log.debug("find by example successful, result size: "
					+ results.size());
			List<WaiterGroup> finalresults = new ArrayList<WaiterGroup>();
			for (int i = 0; i < results.size(); i++) {
				finalresults.add(new WaiterGroup(results.get(i).getWaitergroupid(), results.get(i).getCategory()));
			}
			
			return finalresults;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public boolean update(Waitergroup transientInstance) {
		log.debug("persisting Waitergroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();		
			SQLQuery query = session.createSQLQuery("select updatewaitergroup(?,?)");
			query.setInteger(0, transientInstance.getWaitergroupid());
			query.setString(1, transientInstance.getCategory());			
			log.debug("persist successful");
			Boolean result = (Boolean)query.uniqueResult();
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	public WaiterGroup getWaiterGroup(String pcategory) {
		log.debug("geting Waitergroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Waitergroup waitergroup = (Waitergroup)session.createCriteria(Waitergroup.class).add(Restrictions.eq("category",pcategory)).setMaxResults(1).uniqueResult();
			tx.commit();
			log.debug("get successful");
			return new WaiterGroup(waitergroup.getWaitergroupid(), waitergroup.getCategory());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
