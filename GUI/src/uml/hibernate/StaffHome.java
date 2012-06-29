package uml.hibernate;

// Generated 2012-6-14 7:34:50 by Hibernate Tools 3.4.0.CR1

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

/**
 * Home object for domain model class Staff.
 * @see uml.hibernate.Staff
 * @author Hibernate Tools
 */
public class StaffHome {

	private static final Log log = LogFactory.getLog(StaffHome.class);

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

	public void persist(Staff transientInstance) {
		log.debug("persisting Staff instance");
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

	public void attachDirty(Staff instance) {
		log.debug("attaching dirty Staff instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Staff instance) {
		log.debug("attaching clean Staff instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Staff persistentInstance) {
		log.debug("deleting Staff instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void deleteReceptionist(String pname) {
		log.debug("deleting Receptionists instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Staff result = (Staff)session.createCriteria(uml.hibernate.Staff.class).add(Restrictions.eq("name",pname)).setMaxResults(1).uniqueResult();
			session.delete(result);
			tx.commit();
			log.debug("delete Receptionists successful");
		} catch (RuntimeException re) {
			log.error("delete Receptionists failed", re);
			throw re;
		}
	}
	
	public Staff merge(Staff detachedInstance) {
		log.debug("merging Staff instance");
		try {
			Staff result = (Staff) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Staff findById(java.lang.Integer id) {
		log.debug("getting Staff instance with id: " + id);
		try {
			Staff instance = (Staff) sessionFactory.getCurrentSession().get(
					"uml.hibernate.Staff", id);
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
	@SuppressWarnings("unchecked")
	public List<Staff> findByExample(Staff instance) {
		log.debug("finding Staff instance by example");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Staff> results = session.createCriteria("uml.hibernate.Staff")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Staff> findAllReceptionists() {
		log.debug("finding all Receptionists");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Staff> results = session.createCriteria(uml.hibernate.Staff.class).add(Restrictions.eq("flag","RECEPTIONIST")).list();
			tx.commit();
			log.debug("find all Receptionists, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all Receptionists failed", re);
			throw re;
		}
	}
	public Staff findReceptionist(String pname) {
		log.debug("finding Receptionist");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Staff result = (Staff)session.createCriteria(uml.hibernate.Staff.class).add(Restrictions.eq("name",pname)).setMaxResults(1).uniqueResult();
			tx.commit();
			log.debug("find receptionist successful");
			return result;
		} catch (RuntimeException re) {
			log.error("find Receptionist failed", re);
			throw re;
		}
	}
	
	public void changePassword(String originalname,String newpassword){
		log.debug("change Password");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Staff result = (Staff)session.createCriteria(uml.hibernate.Staff.class).add(Restrictions.eq("name",originalname)).setMaxResults(1).uniqueResult();
			result.setPassword(newpassword);
			tx.commit();
			log.debug("find receptionist successful");
		} catch (RuntimeException re) {
			log.error("find Receptionist failed", re);
			throw re;
		}		
	}
}
