package uml.middleclass;

import java.util.List;

import uml.base.BWaiterGroup;;

public class WaiterGroup {
	private int waitergroupid;
	private String category;
	private final BWaiterGroup bWaiterGroup = getBWaiterGroup();
	
	protected BWaiterGroup getBWaiterGroup(){
		return new BWaiterGroup();
	}
	
	public WaiterGroup(int waitergroup,String category){
		setWaitergroupid(waitergroup);
		setCategory(category);
	}
	
	public int getWaitergroupid() {
		return waitergroupid;
	}
	public void setWaitergroupid(int waitergroupid) {
		this.waitergroupid = waitergroupid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public boolean save(){
		return bWaiterGroup.persist(this);
	}
	
	public static List<WaiterGroup> getAllWaiterGroups(){
		BWaiterGroup bWaiterGroup = new BWaiterGroup();
		return bWaiterGroup.getAllWaiterGroups();
	}
	
	public static void delete(int pwaitergroupid){
		BWaiterGroup bWaiterGroup = new BWaiterGroup();
		bWaiterGroup.delete(pwaitergroupid);
	}
	
	public static boolean update(WaiterGroup waiterGroup){
		BWaiterGroup bWaiterGroup = new BWaiterGroup();
		return bWaiterGroup.update(waiterGroup);
	}
	
	public static WaiterGroup getWaiterGroup(String pcategory){
		BWaiterGroup bWaiterGroup = new BWaiterGroup();
		return bWaiterGroup.getWaiterGroup(pcategory);
	}
}
