package uml.middleclass;

import java.util.Date;
import java.util.List;

import uml.base.BBook;
import uml.middleclass.Table;

public class Book {
	private String cellphone;
	private String name;
	private Date bookTime;
	private String bookingPeriod;
	private Date preArrivalTime;
	private Float proDeposit;
	private String feedback;
	private String state;
	private Date cancelTime;
	private List<Table> tables;
	
	private final BBook bBook = getBBook();
	/**
	 * 
	 * @return bBook
	 */
	protected BBook getBBook(){
		return new BBook();
	}
	/**
	 * 
	 * @param cellphone
	 * @param name
	 * @param bookTime
	 * @param bookingPeriod
	 */
	public Book(String cellphone,String name,Date bookTime,String bookingPeriod,String state,List<Table> tables){
		setCellphone(cellphone);
		setName(name);
		setBookTime(bookTime);
		setBookingPeriod(bookingPeriod);
		setState(state);
		setTables(tables);
	}
	/**
	 * 
	 * @return bookingPeriod
	 */
	public String getBookingPeriod() {
		return bookingPeriod;
	}
	/**
	 * 
	 * @param bookingPeriod
	 */
	public void setBookingPeriod(String bookingPeriod) {
		this.bookingPeriod = bookingPeriod;
	}
	/**
	 * 
	 * @return bookTime
	 */
	public Date getBookTime() {
		return bookTime;
	}
	/**
	 * 
	 * @param bookTime
	 */
	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}
	/**
	 * 
	 * @return cancelTime
	 */
	public Date getCancelTime() {
		return cancelTime;
	}
	/**
	 * 
	 * @param cancelTime
	 */
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	/**
	 * 
	 * @return cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}
	/**
	 * 
	 * @param cellphone
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	/**
	 * 
	 * @return feedback
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * 
	 * @param feedback
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return preArrivalTime
	 */
	public Date getPreArrivalTime() {
		return preArrivalTime;
	}
	/**
	 * 
	 * @param preArrivalTime
	 */
	public void setPreArrivalTime(Date preArrivalTime) {
		this.preArrivalTime = preArrivalTime;
	}
	/**
	 * 
	 * @return proDeposit
	 */
	public Float getProDeposit() {
		return proDeposit;
	}
	/**
	 * 
	 * @param proDeposit
	 */
	public void setProDeposit(Float proDeposit) {
		this.proDeposit = proDeposit;
	}
	/**
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 
	 * @return tables
	 */
	public List<Table> getTables() {
		return tables;
	}
	/**
	 * 
	 * @param tables
	 */
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
	public int save(){
		return bBook.save(this);
	}
	
	public static Book getBook(int bookid){
		BBook bBook = new BBook();
		return bBook.getBook(bookid);
	}

	public static List<String> getbooks(){
		BBook bBook = new BBook();
		return bBook.getbooks();
	}
	
	public static void cancel(int bookbillid){
		BBook bBook = new BBook();
		bBook.cancel(bookbillid);
	}
	public static void arrival(int bookbillid){
		BBook bBook = new BBook();
		bBook.arrival(bookbillid);
	}
	public static void update(int bookbillid,Book book){
		BBook bBook = new BBook();
		bBook.update(bookbillid,book);
	}
	public static void deletebookdishes(int bookid,int tableid){
		BBook bBook = new BBook();
		bBook.deletebookdishes(bookid,tableid);
	}
	public static void updatetablestate(){
		BBook bBook = new BBook();
		bBook.updatetablestate();
	}
	
	public static void checkout(int bookbillid){
		BBook bBook = new BBook();
		bBook.checkout(bookbillid);
	}
}
