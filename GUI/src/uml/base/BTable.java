package uml.base;

import java.util.List;

import uml.hibernate.Dinningtable;
import uml.hibernate.DinningtableHome;
import uml.hibernate.Tablegroup;
import uml.middleclass.TableGroup;

public class BTable {
	private final DinningtableHome dinningtableHome = getDinningtableHome();

	protected DinningtableHome getDinningtableHome(){
		return new DinningtableHome();
	}
	
	public void prisist(uml.middleclass.Table pTable){
		Tablegroup tablegroup = new Tablegroup(pTable.getTableGroup().getCategory(), pTable.getTableGroup().getContain_number(), pTable.getTableGroup().getLowest_consumption());
		Dinningtable dinningtable = new Dinningtable(pTable.getTableid(),tablegroup,pTable.getState());
		dinningtableHome.persist(dinningtable);
	}
	
	public void deleteTable(int ptableid){
		dinningtableHome.deleteById(ptableid);
	}
	
	public void updateTable(int ptableid,String pstate){	
		dinningtableHome.updateTable(ptableid,pstate);
	}
	
	public uml.middleclass.Table search(int ptableid){
		Dinningtable dinningtable = dinningtableHome.findById(ptableid);
		if(dinningtable == null){
			return null;
		}else{
			return new uml.middleclass.Table(dinningtable.getTableid(),new TableGroup(dinningtable.getTablegroup().getCategory(), dinningtable.getTablegroup().getContainNumber(), dinningtable.getTablegroup().getLowestConsumption()),dinningtable.getState());
		}
	}
	
	public int getWalkinid(int ptableid){
		return dinningtableHome.getWalkinid(ptableid);
	}
	
	public List<Integer> getBookbillids(int ptableid){
		return dinningtableHome.getBookbillids(ptableid);
	}
	
	public void swap(int tableid,int anotableid){
		dinningtableHome.swaptable(tableid,anotableid);
	}
	public void addDishs(int ptableid,String dishname,int amount,String description,int bookingbillid,int walkinbillid){
		dinningtableHome.addDishs(ptableid,dishname, amount, description, bookingbillid, walkinbillid);
	}
	public void deleteDishs(int ptableid,String dishname,int bookingbillid,int walkinbillid){
		dinningtableHome.deleteDishs(ptableid,dishname, bookingbillid, walkinbillid);
	}
	public List<String> getwalkinbillshows(int ptableid,int walkinbillid){
		return dinningtableHome.getwalkinbillshows(ptableid,walkinbillid);
	}
	
	public List<String> getbookinbillshows(int ptableid,int bookinbillid){
		return dinningtableHome.getbookinbillshows(ptableid,bookinbillid);
	}
}
