package uml.middleclass;

import java.util.List;
import uml.base.BTableGroup;

public class TableGroup {
	private String category;
	private int contain_number;
	private float lowest_consumption;
	private final BTableGroup bTableGroup = getBTableGroup();
	/**
	 * 
	 * @return BTableGroup
	 */
	protected BTableGroup getBTableGroup(){
		return new BTableGroup();
	}
	/**
	 * 
	 * @param pcategory
	 * @param pcontain_number
	 * @param plowest_consumption
	 */
	public TableGroup(String pcategory,int pcontain_number,float plowest_consumption){
		setCategory(pcategory);
		setContain_number(pcontain_number);
		setLowest_consumption(plowest_consumption);
	}
	/**
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 
	 * @return contain_number
	 */
	public int getContain_number() {
		return contain_number;
	}
	/**
	 * 
	 * @param contain_number
	 */
	public void setContain_number(int contain_number) {
		this.contain_number = contain_number;
	}
	/**
	 * 
	 * @return lowest_consumption
	 */
	public float getLowest_consumption() {
		return lowest_consumption;
	}
	/**
	 * 
	 * @param lowest_consumption
	 */
	public void setLowest_consumption(float lowest_consumption) {
		this.lowest_consumption = lowest_consumption;
	}
	/**
	 * save a tablegroup
	 */
	public void save(){
		bTableGroup.persist(this);
	}
	/**
	 * 
	 * @return Tablegroups
	 */
	public static List<TableGroup> getTablegroups(){
		BTableGroup btableGroup = new BTableGroup();
		return btableGroup.getTablegroups();
	}
	/**
	 * 
	 * @return table list
	 */
	public List<Table> getTables(){
		return bTableGroup.getTables(this);
	}
	/**
	 * 
	 * @param category
	 */
	public static void deleteTableGroup(String category){
		BTableGroup btableGroup = new BTableGroup();
		btableGroup.deleteTablegroup(category);		
	}
	/**
	 * 
	 * @param category
	 * @param pTableGroup
	 */
	public static void updateTableGroup(String category,TableGroup pTableGroup){
		BTableGroup btableGroup = new BTableGroup();
		btableGroup.updateTableGroup(category,pTableGroup);		
	}
	public static TableGroup search(String category){
		BTableGroup btableGroup = new BTableGroup();
		return btableGroup.search(category);	
	}
}
