package uml.base;

import java.util.List;

import uml.hibernate.BookTable;
import uml.hibernate.BookTableHome;
import uml.hibernate.BookingBill;
import uml.hibernate.Booker;
import uml.hibernate.BookerHome;
import uml.hibernate.BookingBillHome;
import uml.hibernate.Dinningtable;
import uml.hibernate.DinningtableHome;
import uml.hibernate.Tablegroup;
import uml.middleclass.Book;


public class BBook {
	private final BookingBillHome bookingBillHome = getBookingBillHome();
	private final BookerHome bookerHome = getBookerHome();
	private final BookTableHome bookTableHome = getBookTableHome();

	protected BookTableHome getBookTableHome(){
		return new BookTableHome();
	}
	
	protected BookingBillHome getBookingBillHome(){
		return new BookingBillHome();
	}
	
	protected BookerHome getBookerHome(){
		return new BookerHome();
	}
	
	public int save(Book book){
		Booker booker =  new Booker();
		booker.setCellphone(book.getCellphone());
		booker.setName(book.getName());
		bookerHome.persist(booker);
		BookingBill bookingBill = new BookingBill(booker, book.getBookTime(), book.getBookingPeriod(), book.getState());
		bookingBill.setFeedback(book.getFeedback());
		bookingBill.setProDeposit(book.getProDeposit());
		bookingBillHome.persist(bookingBill);
		
		int bookingid = bookingBill.getBookingid();
		
		for (int i = 0; i < book.getTables().size(); i++) {
			uml.middleclass.Table pTable = book.getTables().get(i);
			Tablegroup tablegroup = new Tablegroup(pTable.getTableGroup().getCategory(), pTable.getTableGroup().getContain_number(), pTable.getTableGroup().getLowest_consumption());
			Dinningtable dinningtable = new Dinningtable(pTable.getTableid(),tablegroup,pTable.getState());
			bookTableHome.persist(new BookTable(dinningtable, bookingBill));
		}
		
		return bookingid;
	}
	
	public List<String> getbooks(){
		return bookingBillHome.getbooks();
	}
	
	public void cancel(int bookbillid){
		bookingBillHome.cancel(bookbillid);
	}
	
	public void arrival(int bookbillid){
		bookingBillHome.arrival(bookbillid);
	}
	public void update(int bookbillid,Book book){
		bookingBillHome.update(bookbillid, book);
		BookTableHome bookTableHome = new BookTableHome();
		DinningtableHome dinningtableHome = new DinningtableHome();
	}
	public uml.middleclass.Book getBook(int bookid){
		return bookingBillHome.getBook(bookid);
	}
	public void deletebookdishes(int bookid,int tableid){
		bookingBillHome.deletebookdishes(bookid,tableid);
	}
	
	public void updatetablestate(){
		bookingBillHome.updatetablestate();
	}
	public void checkout(int bookbillid){
		bookingBillHome.checkout(bookbillid);
	}
}
