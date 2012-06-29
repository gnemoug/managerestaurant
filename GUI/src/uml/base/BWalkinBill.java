package uml.base;

import uml.hibernate.Dinningtable;
import uml.hibernate.DinningtableHome;
import uml.hibernate.Tablegroup;
import uml.hibernate.WalkinBillHome;
import uml.hibernate.WalkinBill;

public class BWalkinBill {
	private final WalkinBillHome walkinBillHome = getWalkinBillHome();

	protected WalkinBillHome getWalkinBillHome(){
		return new WalkinBillHome();
	}
	
	public void persist(uml.middleclass.WalkinBill pWalkinBill){
		if(pWalkinBill.getFeedback() == null){
			Tablegroup tablegroup = new Tablegroup(pWalkinBill.getbTable().getTableGroup().getCategory(), pWalkinBill.getbTable().getTableGroup().getContain_number(), pWalkinBill.getbTable().getTableGroup().getLowest_consumption());
			Dinningtable dinningtable = new Dinningtable(pWalkinBill.getbTable().getTableid(),tablegroup,pWalkinBill.getbTable().getState());
			WalkinBill walkinBill = new WalkinBill(dinningtable, pWalkinBill.getPeopleNumber(), pWalkinBill.getDate(),pWalkinBill.getState());
			walkinBillHome.persist(walkinBill);
		}else{
			Tablegroup tablegroup = new Tablegroup(pWalkinBill.getbTable().getTableGroup().getCategory(), pWalkinBill.getbTable().getTableGroup().getContain_number(), pWalkinBill.getbTable().getTableGroup().getLowest_consumption());
			Dinningtable dinningtable = new Dinningtable(pWalkinBill.getbTable().getTableid(),tablegroup,pWalkinBill.getbTable().getState());
			WalkinBill walkinBill = new WalkinBill(dinningtable, pWalkinBill.getPeopleNumber(),pWalkinBill.getFeedback(), pWalkinBill.getDate(),pWalkinBill.getState());	
			walkinBillHome.persist(walkinBill);
		}
	}
	
	public void update(int tableid,int peopleNumber,String feedback){
		DinningtableHome dinningtableHome = new DinningtableHome();
		int walkinid =  dinningtableHome.getWalkinid(tableid);
		walkinBillHome.update(walkinid,peopleNumber,feedback);
	}
	
	public void checkout(int walkinid,int tableid){
		walkinBillHome.checkout(walkinid,tableid);
	}
	public uml.middleclass.WalkinBill getWalkinBill(int walkinbillid){
		return walkinBillHome.getWalkinBill(walkinbillid);
	}
	public void giveup(int walkinbillid,int ptableid){
		walkinBillHome.giveup(walkinbillid,ptableid);
	}
}