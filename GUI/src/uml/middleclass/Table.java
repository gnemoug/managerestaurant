package uml.middleclass;

import uml.base.BTable;
import java.util.List;

import org.apache.commons.collections.map.StaticBucketMap;

public class Table {
	private int tableid;
	private TableGroup tableGroup;
	private String state;
	private final BTable bTable = getBTable();
	
	protected BTable getBTable(){
		return new BTable();
	}
	
	public Table(int tableid,TableGroup ptableGroup,String pstate) {
		setTableid(tableid);
		setTableGroup(ptableGroup);
		setState(pstate);
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
	 * @return tableGroup
	 */
	public TableGroup getTableGroup() {
		return tableGroup;
	}
	/**
	 * 
	 * @param tableGroup
	 */
	public void setTableGroup(TableGroup tableGroup) {
		this.tableGroup = tableGroup;
	}
	/**
	 * 
	 * @return tableid
	 */ 
	public int getTableid() {
		return tableid;
	}
	/**
	 * 
	 * @param tableid
	 */
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	/**
	 * save table
	 * @return state
	 */
	public void save(){
		bTable.prisist(this);
	}
	/**
	 * delete table
	 * @param ptableid
	 */
	public static void deleteTable(int ptableid){
		BTable bTable = new BTable();
		bTable.deleteTable(ptableid);
	}
	/**
	 * update ptableid
	 * @param ptableid
	 */
	public static void update(int ptableid,String pstate){
		BTable bTable = new BTable();
		bTable.updateTable(ptableid,pstate);
	}
	public static Table search(int ptableid){
		BTable bTable = new BTable();
		return bTable.search(ptableid);
	}
	/**
	 * 
	 * @param tableid
	 */
	public static int getWalkinid(int ptableid){
		BTable bTable = new BTable();
		return bTable.getWalkinid(ptableid);
	}
	/**
	 * 
	 * @param tableid
	 * @param anotableid
	 */
	public static void swap(int tableid,int anotableid){
		BTable bTable = new BTable();
		bTable.swap(tableid,anotableid);
	}
	/**
	 * 
	 * @param tableid
	 */
	public static List<Integer> getBookbillids(int ptableid){
		BTable bTable = new BTable();
		return bTable.getBookbillids(ptableid);
	}
	public static void addDishs(int ptableid,String dishname,int amount,String description,int bookingbillid,int walkinbillid){
		BTable bTable = new BTable();
		bTable.addDishs(ptableid,dishname,amount,description,bookingbillid, walkinbillid);
	}
	public static void deleteDishs(int ptableid,String dishname,int bookingbillid,int walkinbillid){
		BTable bTable = new BTable();
		bTable.deleteDishs(ptableid,dishname,bookingbillid, walkinbillid);
	}
	public static List<String> getwalkinbillshows(int ptableid,int walkinbillid){
		BTable bTable = new BTable();
		return bTable.getwalkinbillshows(ptableid,walkinbillid);
	}
	public static List<String> getbookbillshows(int ptableid,int bookinbillid){
		BTable bTable = new BTable();
		return bTable.getbookinbillshows(ptableid,bookinbillid);
	}
}
