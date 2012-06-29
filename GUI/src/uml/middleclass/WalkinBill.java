package uml.middleclass;

import java.util.Date;

import uml.base.BWalkinBill;
import uml.middleclass.Table;

public class WalkinBill {
	private Table table;
	private int peopleNumber;
	private String feedback;
	private Date date;
	private String state;
	
	private final BWalkinBill bWalkinBill = getBWalkinBill();
	/**
	 * 
	 * @return bWalkinBill
	 */
	protected BWalkinBill getBWalkinBill(){
		return new BWalkinBill();
	}
	
	public WalkinBill(Table table,int peopleNumber,String feedback,String state){
		Date date = new Date();
		setDate(date);
		setPeopleNumber(peopleNumber);
		setFeedback(feedback);
		setTable(table);
		setState(state);
	}
	public WalkinBill(Table table,int peopleNumber,String state){
		Date date = new Date();
		setDate(date);
		setPeopleNumber(peopleNumber);
		setFeedback(null);
		setTable(table);
		setState(state);
	}
	public WalkinBill(Table table,int peopleNumber,String state,Date date){
		setDate(date);
		setPeopleNumber(peopleNumber);
		setFeedback(null);
		setTable(table);
		setState(state);
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
	 * @return bTable
	 */
	public Table getbTable() {
		return table;
	}
	/**
	 * 
	 * @param table
	 */
	public void setTable(Table table) {
		this.table = table;
	}
	/**
	 * 
	 * @return peopleNumber
	 */
	public int getPeopleNumber() {
		return peopleNumber;
	}
	/**
	 * 
	 * @param peopleNumber
	 */
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
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
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 
	 */
	public void save(){
		bWalkinBill.persist(this);
	}
	/**
	 * 
	 * @param tableid
	 * @param peopleNumber
	 * @param feedback
	 */
	public static void update(int tableid,int peopleNumber,String feedback){
		BWalkinBill bWalkinBill = new BWalkinBill();
		bWalkinBill.update(tableid,peopleNumber,feedback);
	}
	/**
	 * 
	 * @param tableid
	 */
	public static void checkout(int walkinid,int tableid){
		BWalkinBill bWalkinBill = new BWalkinBill();
		bWalkinBill.checkout(walkinid,tableid);
	}
	public static WalkinBill getWalkinBill(int walkinbillid){
		BWalkinBill bWalkinBill = new BWalkinBill();
		return bWalkinBill.getWalkinBill(walkinbillid);
	}
	public static void giveup(int walkinbillid,int ptableid){
		BWalkinBill bWalkinBill = new BWalkinBill();
		bWalkinBill.giveup(walkinbillid,ptableid);
	}
}
