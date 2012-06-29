package uml.hibernate;

// Generated 2012-6-15 11:53:05 by Hibernate Tools 3.4.0.CR1
import java.util.HashSet;
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
import uml.hibernate.Tablegroup;
import uml.base.HibernateUtil;
import uml.hibernate.WalkinBill;
/**
 * Home object for domain model class Dinningtable.
 * @see uml.hibernate.Dinningtable
 * @author Hibernate Tools
 */
public class DinningtableHome {

	private static final Log log = LogFactory.getLog(DinningtableHome.class);

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

	public void persist(Dinningtable transientInstance) {
		log.debug("persisting Dinningtable instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Tablegroup result = (Tablegroup)session.createCriteria(Tablegroup.class).add(Restrictions.eq("category",transientInstance.getTablegroup().getCategory())).setMaxResults(1).uniqueResult();
			transientInstance.setTablegroup(result);
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Dinningtable instance) {
		log.debug("attaching dirty Dinningtable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dinningtable instance) {
		log.debug("attaching clean Dinningtable instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Dinningtable persistentInstance) {
		log.debug("deleting Dinningtable instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void deleteById(java.lang.Integer id) {
		log.debug("delete Dinningtable instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			session.delete(instance);
			tx.commit();
			log.debug("delete successful, no instance found");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public Dinningtable merge(Dinningtable detachedInstance) {
		log.debug("merging Dinningtable instance");
		try {
			Dinningtable result = (Dinningtable) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dinningtable findById(java.lang.Integer id) {
		log.debug("getting Dinningtable instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			tx.commit();
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

	public List findByExample(Dinningtable instance) {
		log.debug("finding Dinningtable instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.Dinningtable")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void updateTable(java.lang.Integer id,String pstate) {
		log.debug("update Dinningtable instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			instance.setState(pstate);
			tx.commit();
			log.debug("update successful, no instance found");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int getWalkinid(java.lang.Integer id) {
		log.debug("getting Walkinbill instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			Set<WalkinBill> walkinBills = instance.getWalkinBills();
			if (walkinBills.isEmpty()) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			tx.commit();
			for(WalkinBill walkinBill:walkinBills){
				if(walkinBill.getState().equals("EATING")){
					return walkinBill.getWalkinid();
				}
			}	
			return 0;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getBookbillids(java.lang.Integer id) {
		log.debug("getting Walkinbill instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			Set<BookTable> bookTables = instance.getBookTables();
			if (bookTables.isEmpty()) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			tx.commit();
			List<Integer> bookbillids = new ArrayList<Integer>();
			
			for(BookTable bookTable:bookTables){
				bookbillids.add(bookTable.getBookingBill().getBookingid());
			}	
			return bookbillids;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void swaptable(java.lang.Integer id,java.lang.Integer anoid) {
		log.debug("swap Dinningtable instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable instance = (Dinningtable)session.get("uml.hibernate.Dinningtable", id);
			Dinningtable anoinstance = (Dinningtable)session.get("uml.hibernate.Dinningtable", anoid);

			String tempstate = instance.getState();
			Set<WalkinBill> tempwalkinBills = new HashSet<WalkinBill>();
			tempwalkinBills.addAll(instance.getWalkinBills());
			Set<Tabledish> temptabledishs = new HashSet<Tabledish>();
			temptabledishs.addAll(instance.getTabledishs());
			Set<BookTable> tempBookTables = new HashSet<BookTable>();
			tempBookTables.addAll(instance.getBookTables());
	
			Set<BookTable> anotempBookTables = new HashSet<BookTable>();
			anotempBookTables.addAll(anoinstance.getBookTables());
			
			instance.setState(anoinstance.getState());
			anoinstance.setState(tempstate);
			
			for(WalkinBill walkinBill : tempwalkinBills) {
				if(walkinBill.getState().equals("EATING")){
					walkinBill.setDinningtable(anoinstance);
					for(Tabledish tabledish:temptabledishs){
						if(tabledish.getWalkinbillid() == walkinBill.getWalkinid()){
							tabledish.setDinningtable(anoinstance);
						}
					}
				}  
			}
			
			for(BookTable bookTable:tempBookTables){
				if(bookTable.getBookingBill().getState().equals("ARRIVAL")){
					bookTable.setDinningtable(anoinstance);
					for(Tabledish tabledish:temptabledishs){
						if(tabledish.getBookingbillid() == bookTable.getBookingBill().getBookingid()){
							tabledish.setDinningtable(anoinstance);
						}
					}
				}
			}
			tx.commit();
		} catch (RuntimeException re) {
			log.error("swap failed", re);
			throw re;
		}
	}
	public void addDishs(int ptableid,String dishname,int amount,String description,int bookingbillid,int walkinbillid) {
		log.debug("add dishes");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable dinningtable = (Dinningtable)session.createCriteria(Dinningtable.class).add(Restrictions.eq("tableid",ptableid)).setMaxResults(1).uniqueResult();
			Product product = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",dishname)).setMaxResults(1).uniqueResult();
			Tabledish tabledish = new Tabledish(product, dinningtable, amount, description, bookingbillid, walkinbillid);
			session.persist(tabledish);
			/**
			 * 此处改成了用触发器实现
			 */
//			Product product1 = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",dishname)).setMaxResults(1).uniqueResult();
//			int currentInventory = product1.getCurrentInventory();
//			product1.setCurrentInventory(currentInventory - tabledish.getAmount());
			tx.commit();
			log.debug("add successful");
		} catch (RuntimeException re) {
			log.error("add failed", re);
			throw re;
		}
	}
	public void deleteDishs(int ptableid,String dishname,int bookingbillid,int walkinbillid) {
		log.debug("delete dishes");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable dinningtable = (Dinningtable)session.createCriteria(Dinningtable.class).add(Restrictions.eq("tableid",ptableid)).setMaxResults(1).uniqueResult();
			Product product = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",dishname)).setMaxResults(1).uniqueResult();
			Tabledish tabledish = (Tabledish)session.createCriteria(Tabledish.class).add(Restrictions.eq("product",product)).add(Restrictions.eq("dinningtable",dinningtable)).add(Restrictions.eq("walkinbillid",walkinbillid)).add(Restrictions.eq("bookingbillid",bookingbillid)).setMaxResults(1).uniqueResult();
			session.delete(tabledish);
			/**
			 * 此处改成了用触发器实现
			 */
//			Product product1 = (Product)session.createCriteria(Product.class).add(Restrictions.eq("name",dishname)).setMaxResults(1).uniqueResult();
//			int currentInventory = product1.getCurrentInventory();
//			product1.setCurrentInventory(currentInventory + tabledish.getAmount());
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public List<String> getwalkinbillshows(int ptableid,int walkinbillid) {
		log.debug("get dishes");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Dinningtable dinningtable = (Dinningtable)session.createCriteria(Dinningtable.class).add(Restrictions.eq("tableid",ptableid)).setMaxResults(1).uniqueResult();
			List<Tabledish> tabledishs = session.createCriteria(Tabledish.class).add(Restrictions.eq("dinningtable",dinningtable)).add(Restrictions.eq("walkinbillid",walkinbillid)).list();
			List<String> walkinbillshowsList = new ArrayList<String>();
			tx.commit();
			for(Tabledish tabledish:tabledishs){
				walkinbillshowsList.add(tabledish.getProduct().getName());
				walkinbillshowsList.add(String.valueOf(tabledish.getProduct().getUnitPrice()));
				walkinbillshowsList.add(String.valueOf(tabledish.getAmount()));
			}

			log.debug("get successful");
			return walkinbillshowsList;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<String> getbookinbillshows(int ptableid,int bookinbillid) {
		log.debug("get dishes");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			BookingBill instance = (BookingBill)session.get("uml.hibernate.BookingBill", bookinbillid);
			Set<BookTable> bookTables = instance.getBookTables();
			List<String> bookinbillshowsList = new ArrayList<String>();
			for(BookTable bookTable:bookTables){
				List<Tabledish> tabledishs = session.createCriteria(Tabledish.class).add(Restrictions.eq("dinningtable",bookTable.getDinningtable())).add(Restrictions.eq("bookingbillid",bookinbillid)).list();
				for(Tabledish tabledish:tabledishs){
					bookinbillshowsList.add(tabledish.getProduct().getName());
					bookinbillshowsList.add(String.valueOf(tabledish.getProduct().getUnitPrice()));
					bookinbillshowsList.add(String.valueOf(tabledish.getAmount()));
					bookinbillshowsList.add(String.valueOf(bookTable.getDinningtable().getTableid()));
				}
				
			}
			tx.commit();
			log.debug("get successful");
			return bookinbillshowsList;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
