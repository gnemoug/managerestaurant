package uml.middleclass;

import java.util.List;

import uml.base.BDishGroup;

public class DishGroup {
	private String category;
	
	private final BDishGroup bDishGroup = getBDishGroup();
	/**
	 * 
	 * @return bWalkinBill
	 */
	protected BDishGroup getBDishGroup(){
		return new BDishGroup();
	}
	/**
	 * 
	 * @param category
	 */
	public DishGroup(String category){
		setCategory(category);
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
	
	public void save(){
		bDishGroup.persist(this);
	}
	/**
	 * 
	 * @return List<DishGroup>
	 */
	public static List<DishGroup> getAllDishGroups(){
		BDishGroup bDishGroup = new BDishGroup();
		return bDishGroup.getAllDishGroups();
	}
	
	public static void update(String originalcategory,String newcategory){
		BDishGroup bDishGroup = new BDishGroup();
		bDishGroup.update(originalcategory,newcategory);		
	}
	
	public static void delete(String pcategory){
		BDishGroup bDishGroup = new BDishGroup();
		bDishGroup.delete(pcategory);	
	}
	
	public static DishGroup search(String pcategory){
		BDishGroup bDishGroup = new BDishGroup();
		return bDishGroup.search(pcategory);	
	}
}
