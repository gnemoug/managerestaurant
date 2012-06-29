package uml.hibernate;

// Generated 2012-6-16 9:24:29 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import uml.base.HibernateUtil;
import uml.middleclass.DishGroup;

/**
 * Home object for domain model class Productgroup.
 * @see uml.hibernate.Productgroup
 * @author Hibernate Tools
 */
public class ProductgroupHome {

	private static final Log log = LogFactory.getLog(ProductgroupHome.class);

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

	public void persist(Productgroup transientInstance) {
		log.debug("persisting Productgroup instance");
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

	public void attachDirty(Productgroup instance) {
		log.debug("attaching dirty Productgroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Productgroup instance) {
		log.debug("attaching clean Productgroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(String pcatogory) {
		log.debug("deleting Productgroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Productgroup result = (Productgroup)session.createCriteria(Productgroup.class).add(Restrictions.eq("category",pcatogory)).setMaxResults(1).uniqueResult();
			session.delete(result);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DishGroup search(String pcatogory) {
		log.debug("searching Productgroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Productgroup result = (Productgroup)session.createCriteria(Productgroup.class).add(Restrictions.eq("category",pcatogory)).setMaxResults(1).uniqueResult();
			tx.commit();
			if(result == null){
				return null;
			}else{
				log.debug("search successful");	
				return new DishGroup(result.getCategory());				
			}
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}
	
	public Productgroup merge(Productgroup detachedInstance) {
		log.debug("merging Productgroup instance");
		try {
			Productgroup result = (Productgroup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Productgroup findById(java.lang.Integer id) {
		log.debug("getting Productgroup instance with id: " + id);
		try {
			Productgroup instance = (Productgroup) sessionFactory
					.getCurrentSession().get("uml.hibernate.Productgroup", id);
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

	public List findByExample(Productgroup instance) {
		log.debug("finding Productgroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Productgroup")
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
	public List<Productgroup> getAllDishGroups() {
		log.debug("finding Productgroup instance by example");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Productgroup> results = session.createCriteria("uml.hibernate.Productgroup").list();
			tx.commit();
			log.debug("find all productgroup successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all productgroup failed", re);
			throw re;
		}
	}

	public void update(Productgroup productgroup,String newcategory) {
		log.debug("updateing Productgroup instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Productgroup result = (Productgroup)session.createCriteria(Productgroup.class).add(Restrictions.eq("category",productgroup.getCategory())).setMaxResults(1).uniqueResult();
			result.setCategory(newcategory);
			tx.commit();
			log.debug("update productgroup successful");
		} catch (RuntimeException re) {
			log.error("update productgroup failed", re);
			throw re;
		}
	}
}
