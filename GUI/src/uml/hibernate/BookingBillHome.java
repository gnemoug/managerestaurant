package uml.hibernate;

// Generated 2012-6-16 9:24:29 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import uml.middleclass.Book;
import uml.middleclass.Table;
import uml.middleclass.TableGroup;
/**
 * Home object for domain model class BookingBill.
 * @see uml.hibernate.BookingBill
 * @author Hibernate Tools
 */
public class BookingBillHome {

	private static final Log log = LogFactory.getLog(BookingBillHome.class);

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

	public void persist(BookingBill transientInstance) {
		log.debug("persisting BookingBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			log.debug("persist successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BookingBill instance) {
		log.debug("attaching dirty BookingBill instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookingBill instance) {
		log.debug("attaching clean BookingBill instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BookingBill persistentInstance) {
		log.debug("deleting BookingBill instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BookingBill merge(BookingBill detachedInstance) {
		log.debug("merging BookingBill instance");
		try {
			BookingBill result = (BookingBill) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BookingBill findById(java.lang.Integer id) {
		log.debug("getting BookingBill instance with id: " + id);
		try {
			BookingBill instance = (BookingBill) sessionFactory
					.getCurrentSession().get("uml.hibernate.BookingBill", id);
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

	public List findByExample(BookingBill instance) {
		log.debug("finding BookingBill instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("uml.hibernate.BookingBill")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<String> getbooks() {
		log.debug("finding all BookingBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").list();
			log.debug("find all BookingBill successful, result size: "
					+ results.size());
			List<String> bookStrings = new ArrayList<String>();
			for (int i = 0; i < results.size(); i++) {
				bookStrings.add(String.valueOf(results.get(i).getBookingid()));
				bookStrings.add(results.get(i).getBooker().getName());
				bookStrings.add(results.get(i).getBooker().getCellphone());
				bookStrings.add(results.get(i).getBookingPeriod());
				String tableString = "";
				Set<BookTable> bookTables = results.get(i).getBookTables();
				for(BookTable bookTable:bookTables){
					tableString = tableString + " " + bookTable.getDinningtable().getTableid();
				}
				bookStrings.add(tableString);
			}
			return bookStrings;
		} catch (RuntimeException re) {
			log.error("find all BookingBill failed", re);
			throw re;
		}
	}
	public void cancel(int bookbillid) {
		log.debug("canceling BookingBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			SQLQuery query = session.createSQLQuery("{Call cancelbooking(?)}");
			query.setInteger(0, bookbillid);
			query.executeUpdate();
			/**
			 * 用java实现，有bug
			 */
//			BookingBill instance = (BookingBill) session.get("uml.hibernate.BookingBill", bookbillid);
//			instance.setState("CANCEL");
//			Date date = new Date();
//			instance.setCancelTime(date);
//			
//			Book book = getBook(bookbillid);
//			for (int i = 0; i < book.getTables().size(); i++) {
////				(bookbillid, book.getTables().get(i).getTableid());
//			}
			log.debug("cancel successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("cancel failed", re);
			throw re;
		}
	}
	public void arrival(int bookbillid) {
		log.debug("arrivaling BookingBill instance");
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			BookingBill instance = (BookingBill) session.get("uml.hibernate.BookingBill", bookbillid);
			instance.setState("ARRIVAL");
			Date date = new Date();
			instance.setPreArrivalTime(date);
			log.debug("arrival successful");
			Set<BookTable> bookTables = instance.getBookTables();
			for(BookTable bookTable:bookTables){
				bookTable.getDinningtable().setState("BOOK");
			}
			tx.commit();
		} catch (RuntimeException re) {
			log.error("arrival failed", re);
			throw re;
		}
	}
	public void update(int bookbillid,Book book) {
		log.debug("updating BookingBill instance with id: " + bookbillid);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			BookingBill instance = (BookingBill)session.get("uml.hibernate.BookingBill", bookbillid);
			if (instance == null) {
				log.debug("update successful, no instance found");
			} else {
				log.debug("update successful, instance found");
			}
			Booker booker = instance.getBooker();
			booker.setCellphone(book.getCellphone());
			booker.setName(book.getName());
			instance.setBookingPeriod(book.getBookingPeriod());
			instance.setProDeposit(book.getProDeposit());
			instance.setFeedback(book.getFeedback());
			Set<BookTable> booktalbes = instance.getBookTables();
			for(BookTable bookTable:booktalbes){
				session.delete(bookTable);
			}
			
			for (int i = 0; i < book.getTables().size(); i++) {
				session.persist(new BookTable((Dinningtable)session.get("uml.hibernate.Dinningtable", book.getTables().get(i).getTableid()), instance));
			}
			tx.commit();
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	public uml.middleclass.Book getBook(int id) {
		log.debug("getting Book instance with id: " + id);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			BookingBill instance = (BookingBill) session.get("uml.hibernate.BookingBill", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			List<Table> tables = new ArrayList<Table>();
			Set<BookTable> tabledishs = instance.getBookTables();
			for(BookTable tabledish:tabledishs) {
				tables.add(new Table(tabledish.getDinningtable().getTableid(), new TableGroup(tabledish.getDinningtable().getTablegroup().getCategory(), tabledish.getDinningtable().getTablegroup().getContainNumber(), tabledish.getDinningtable().getTablegroup().getLowestConsumption()), tabledish.getDinningtable().getState()));
			}
			uml.middleclass.Book book = new uml.middleclass.Book(instance.getBooker().getCellphone(), instance.getBooker().getName(), instance.getBookTime(), instance.getBookingPeriod(), instance.getState(),tables );
			book.setFeedback(instance.getFeedback());
			book.setProDeposit(instance.getProDeposit());
			book.setPreArrivalTime(instance.getPreArrivalTime());
			return book;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void deletebookdishes(int bookid,int ptableid) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("{Call updatebooking(?,?)}");
			query.setInteger(0, ptableid);
			query.setInteger(1, bookid);
			query.executeUpdate();
			/**
			 * 下面是通过执行原生sql进行操作实例
			 */
//			session.doWork(new Work(){
//				public void execute(Connection connection) throws SQLException{
//					connection.prepareCall("{Call updatebooking()}");
//				}
//			});
			/**
			 * 下面通过执行java代码进行操作，而且还有bug
			 */
//			Dinningtable dinningtable = (Dinningtable)session.createCriteria(Dinningtable.class).add(Restrictions.eq("tableid",ptableid)).setMaxResults(1).uniqueResult();
//			List<Tabledish> tabledishs = session.createCriteria(Tabledish.class).add(Restrictions.eq("dinningtable",dinningtable)).add(Restrictions.eq("bookingbillid",bookid)).list();
//			for (int i = 0; i < tabledishs.size(); i++) {
//				session.delete(tabledishs.get(i));
//			}
			tx.commit();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void checkout(int bookbillid){
		log.debug("checkout BookingBill instance with id: " + bookbillid);
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("{Call checkoutbooking(?)}");
			query.setInteger(0, bookbillid);
			query.executeUpdate();
			
			/**
			 * 下面是java操作，有bug
			 */
//			BookingBill instance = (BookingBill)session.get("uml.hibernate.BookingBill", bookbillid);
//			if (instance == null) {
//				log.debug("checkout successful, no instance found");
//			} else {
//				log.debug("checkout successful, instance found");
//			}
//			instance.setState("CHECKOUT");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public void updatetablestate() {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			int hour = date.getHours();
			if(hour == 7){
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","BREAKFAST")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("BOOK");
						}
					}
				}
			}else if(hour == 9){
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","BREAKFAST")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("EMPTY");
						}
					}
					cancel(results.get(i).getBookingid());
				}
			}else if (hour == 11) {
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","LUNCH")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("BOOK");
						}
					}
				}
			}else if (hour == 13) {
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","LUNCH")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("EMPTY");
						}
					}
					cancel(results.get(i).getBookingid());
				}
			}else if (hour == 16) {
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","DINNER")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("BOOK");
						}
					}
				}
			}else if (hour == 18) {
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","DINNER")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("EMPTY");
						}
					}
					cancel(results.get(i).getBookingid());
				}
			}else if (hour == 20){
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","SUPER")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("BOOK");
						}
					}
				}
			}else if (hour == 22){
				List<BookingBill> results = session.createCriteria("uml.hibernate.BookingBill").add(Restrictions.eq("state","NOTARRIVAL")).add(Restrictions.eq("bookingPeriod","SUPER")).list();
				for (int i = 0; i < results.size(); i++) {
					if(results.get(i).getBookTime().getDay() == date.getDay() && results.get(i).getBookTime().getMonth() == date.getMonth()){
						List<BookTable> bookTables = session.createCriteria("uml.hibernate.BookTable").add(Restrictions.eq("bookingBill",results.get(i))).list();
						for (int j = 0; j < bookTables.size(); j++) {
							bookTables.get(j).getDinningtable().setState("EMPTY");
						}
					}
					cancel(results.get(i).getBookingid());
				}
			}else{
				;
			}
			tx.commit();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
