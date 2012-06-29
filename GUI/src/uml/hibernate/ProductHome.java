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
import uml.middleclass.Dish;

/**
 * Home object for domain model class Product.
 * @see uml.hibernate.Product
 * @author Hibernate Tools
 */
public class ProductHome {

	private static final Log log = LogFactory.getLog(ProductHome.class);

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

	public void persist(Dish dish) {
		log.debug("persisting Product instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Product product = new Product(dish.getName(),dish.getUnitPrice(),dish.getJinpin(),dish.getCurrentInventory());
			Productgroup result = (Productgroup)session.createCriteria(Productgroup.class).add(Restrictions.eq("category",dish.getDishGroup().getCategory())).setMaxResults(1).uniqueResult();
			product.setProductgroup(result);
			Unitgroup unitgroup = new Unitgroup(dish.getUnitgroup());
			List<Unitgroup> results = session.createCriteria(uml.hibernate.Unitgroup.class).add(Restrictions.eq("unit",dish.getUnitgroup())).list();
			if(results.isEmpty()){
				session.persist(unitgroup);
			}else{
				unitgroup = results.get(0);
			}
			product.setUnitgroup(unitgroup);
			session.persist(product);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(String originalname) {
		log.debug("deleting Product instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Product product = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",originalname)).setMaxResults(1).uniqueResult();
			session.delete(product);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public boolean search(String originalname) {
		log.debug("searching Product instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Product product = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",originalname)).setMaxResults(1).uniqueResult();
			tx.commit();
			if(product == null){
				log.debug("search failed");
				return false;
			}else{
				log.debug("search successful");
				return true;
			}			
		} catch (RuntimeException re) {
			log.error("search failed", re);
			throw re;
		}
	}
	
	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Product findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) sessionFactory.getCurrentSession()
					.get("uml.hibernate.Product", id);
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

	public List findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Product")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public void update(String originalname,Dish dish) {
		log.debug("persisting Product instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Product product = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",originalname)).setMaxResults(1).uniqueResult();
			product.setName(dish.getName());
			product.setUnitPrice(dish.getUnitPrice());
			product.setCurrentInventory(dish.getCurrentInventory());
			product.setJinpin(dish.getJinpin());
			Productgroup result = (Productgroup)session.createCriteria(Productgroup.class).add(Restrictions.eq("category",dish.getDishGroup().getCategory())).setMaxResults(1).uniqueResult();
			product.setProductgroup(result);
			Unitgroup unitgroup = new Unitgroup(dish.getUnitgroup());
			List<Unitgroup> results = session.createCriteria(uml.hibernate.Unitgroup.class).add(Restrictions.eq("unit",dish.getUnitgroup())).list();
			if(results.isEmpty()){
				session.persist(unitgroup);
			}else{
				unitgroup = results.get(0);
			}
			product.setUnitgroup(unitgroup);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Product> getAllDishs() {
		log.debug("finding Product instance by example");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<Product> results = session.createCriteria("uml.hibernate.Product").list();
			tx.commit();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
