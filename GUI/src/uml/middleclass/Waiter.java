package uml.middleclass;

import java.util.Date;
import java.util.List;

import uml.base.BWaiter;
import uml.base.BWaiterGroup;

public class Waiter {
	private int waiterid;
	private WaiterGroup waitergroup;
	private String name;
	private String sex;
	private String cellphone;
	private String cid;
	private Date salarydate;
	private final BWaiter bWaiter = getBWaiter();
	
	protected BWaiter getBWaiter(){
		return new BWaiter();
	}	
	
	public Waiter() {
		
	}

	public Waiter(int waiterid, WaiterGroup waitergroup, String name,
			String sex, String cellphone, String cid, Date salarydate) {
		this.waiterid = waiterid;
		this.waitergroup = waitergroup;
		this.name = name;
		this.sex = sex;
		this.cellphone = cellphone;
		this.cid = cid;
		this.salarydate = salarydate;
	}

	public int getWaiterid() {
		return this.waiterid;
	}

	public void setWaiterid(int waiterid) {
		this.waiterid = waiterid;
	}

	public WaiterGroup getWaitergroup() {
		return this.waitergroup;
	}

	public void setWaitergroup(WaiterGroup waitergroup) {
		this.waitergroup = waitergroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Date getSalarydate() {
		return this.salarydate;
	}

	public void setSalarydate(Date salarydate) {
		this.salarydate = salarydate;
	}
	
	public boolean save(){
		return bWaiter.persist(this);
	}
	
	public static List<Waiter> getAllWaiters(){
		BWaiter bWaiter = new BWaiter();
		return bWaiter.getAllWaiters();
	}
	
	public static void delete(int pwaiterid){
		BWaiter bWaiter = new BWaiter();
		bWaiter.delete(pwaiterid);
	}
	
	public static boolean update(Waiter waiter){
		BWaiter bWaiter = new BWaiter();
		return bWaiter.update(waiter);
	}
}
