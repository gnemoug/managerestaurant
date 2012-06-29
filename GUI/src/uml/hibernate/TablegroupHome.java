package uml.hibernate;

// Generated 2012-6-15 11:53:05 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import uml.base.HibernateUtil;
import uml.middleclass.TableGroup;

/**
 * Home object for domain model class Tablegroup.
 * @see uml.hibernate.Tablegroup
 * @author Hibernate Tools
 */
public class TablegroupHome {

	private static final Log log = LogFactory.getLog(TablegroupHome.class);

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

	public void persist(Tablegroup transientInstance) {
		log.debug("persisting Tablegroup instance");
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

	public void attachDirty(Tablegroup instance) {
		log.debug("attaching dirty Tablegroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tablegroup instance) {
		log.debug("attaching clean Tablegroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void deleteTablegroup(String category) {
		log.debug("delete TableGroup");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Tablegroup result = (Tablegroup)session.createCriteria(Tablegroup.class).add(Restrictions.eq("category",category)).setMaxResults(1).uniqueResult();
			session.delete(result);
			tx.commit();
			log.debug("delete TableGroup successful");
		} catch (RuntimeException re) {
			log.error("delete TableGroup failed", re);
			throw re;
		}
	}
	
	public TableGroup search(String category) {
		log.debug("search TableGroup");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Tablegroup result = (Tablegroup)session.createCriteria(Tablegroup.class).add(Restrictions.eq("category",category)).setMaxResults(1).uniqueResult();
			tx.commit();
			if(result == null){
				log.debug("search TableGroup failed");
				return null;				
			}else{
				log.debug("search TableGroup successful");
				return new TableGroup(result.getCategory(), result.getContainNumber(), result.getLowestConsumption());	
			}	
		} catch (RuntimeException re) {
			log.error("search TableGroup failed", re);
			throw re;
		}
	}
	public Tablegroup merge(Tablegroup detachedInstance) {
		log.debug("merging Tablegroup instance");
		try {
			Tablegroup result = (Tablegroup) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tablegroup findById(java.lang.Integer id) {
		log.debug("getting Tablegroup instance with id: " + id);
		try {
			Tablegroup instance = (Tablegroup) sessionFactory
					.getCurrentSession().get("uml.hibernate.Tablegroup", id);
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

	public List findByExample(Tablegroup instance) {
		log.debug("finding Tablegroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Tablegroup")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Tablegroup> findTableGroups() {
		log.debug("find TableGroups");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Tablegroup> results = session.createCriteria(Tablegroup.class).list();
			tx.commit();
			log.debug("find TableGroups successful");
			return results;
		} catch (RuntimeException re) {
			log.error("find TableGroups failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Dinningtable> getTables(String category) {
		log.debug("find TableGroups");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Tablegroup result = (Tablegroup)session.createCriteria(Tablegroup.class).add(Restrictions.eq("category",category)).setMaxResults(1).uniqueResult();
			List<Dinningtable> results = session.createCriteria(Dinningtable.class).add(Restrictions.eq("tablegroup",result)).list();
			tx.commit();
			log.debug("find TableGroups successful");
			return results;
		} catch (RuntimeException re) {
			log.error("find TableGroups failed", re);
			throw re;
		}
	}
	public void updateTableGroup(String category,uml.middleclass.TableGroup pTableGroup) {
		log.debug("update TableGroup");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Tablegroup result = (Tablegroup)session.createCriteria(Tablegroup.class).add(Restrictions.eq("category",category)).setMaxResults(1).uniqueResult();
			result.setCategory(pTableGroup.getCategory());
			result.setContainNumber(pTableGroup.getContain_number());
			result.setLowestConsumption(pTableGroup.getLowest_consumption());
			tx.commit();
			log.debug("update TableGroup successful");
		} catch (RuntimeException re) {
			log.error("update TableGroup failed", re);
			throw re;
		}
	}
}
