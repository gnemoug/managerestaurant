package uml.base;

import java.util.List;

import uml.hibernate.Waiter;
import uml.hibernate.WaiterHome;
import uml.hibernate.Waitergroup;
import uml.middleclass.WaiterGroup;

public class BWaiter {
	private final WaiterHome waiterHome = getWaiterHome();
	
	protected WaiterHome getWaiterHome(){
		return new WaiterHome();
	}
	
	public boolean persist(uml.middleclass.Waiter waiter){
		return waiterHome.persist(new Waiter(waiter.getWaiterid(), new Waitergroup(waiter.getWaitergroup().getWaitergroupid(),waiter.getWaitergroup().getCategory()), waiter.getName(), waiter.getSex(), waiter.getCellphone(), waiter.getCid(), waiter.getSalarydate()));
	}
	
	public List<uml.middleclass.Waiter> getAllWaiters(){
		return waiterHome.getAllWaiters();
	}
	
	public void delete(int pwaitergroupid){
		waiterHome.delete(pwaitergroupid);
	}
	
	public boolean update(uml.middleclass.Waiter waiter){
		return waiterHome.update(new Waiter(waiter.getWaiterid(), new Waitergroup(waiter.getWaitergroup().getWaitergroupid(),waiter.getWaitergroup().getCategory()), waiter.getName(), waiter.getSex(), waiter.getCellphone(), waiter.getCid(), waiter.getSalarydate()));
	}
}
