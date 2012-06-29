package uml.base;

import java.util.List;

import uml.hibernate.Waitergroup;
import uml.hibernate.WaitergroupHome;
import uml.middleclass.WaiterGroup;

public class BWaiterGroup {
	private final WaitergroupHome waitergroupHome = getWaitergroupHome();
	
	protected WaitergroupHome getWaitergroupHome(){
		return new WaitergroupHome();
	}
	
	public boolean persist(WaiterGroup waiterGroup){
		return waitergroupHome.persist(new Waitergroup(waiterGroup.getWaitergroupid(),waiterGroup.getCategory()));
	}
	
	public List<WaiterGroup> getAllWaiterGroups(){
		return waitergroupHome.getAllWaiterGroups();
	}
	
	public void delete(int pwaitergroupid){
		waitergroupHome.delete(pwaitergroupid);
	}
	
	public boolean update(WaiterGroup waiterGroup){
		return waitergroupHome.update(new Waitergroup(waiterGroup.getWaitergroupid(),waiterGroup.getCategory()));
	}
	public WaiterGroup getWaiterGroup(String pcategory) {
		return waitergroupHome.getWaiterGroup(pcategory);
	}
}
