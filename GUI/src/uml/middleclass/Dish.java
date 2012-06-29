package uml.middleclass;

import java.util.List;

import uml.base.BDish;
import uml.middleclass.DishGroup;

public class Dish {
	private DishGroup dishGroup;
	private String name;
	private float unitPrice;
	private String jinpin;
	private int currentInventory;
	private String unitgroup;
	
	private final BDish bDish = getBDish();
	/**
	 * 
	 * @return bWalkinBill
	 */
	protected BDish getBDish(){
		return new BDish();
	}
	
	public Dish(DishGroup dishGroup,String name,float unitPrice,String jinpin,int currentInventory,String unitgroup){
		setCurrentInventory(currentInventory);
		setDishGroup(dishGroup);
		setJinpin(jinpin);
		setName(name);
		setUnitgroup(unitgroup);
		setUnitPrice(unitPrice);
	}
	/**
	 * 
	 * @return currentInventory
	 */
	public int getCurrentInventory() {
		return currentInventory;
	}
	/**
	 * 
	 * @param currentInventory
	 */
	public void setCurrentInventory(int currentInventory) {
		this.currentInventory = currentInventory;
	}
	/**
	 * 
	 * @return dishGroup
	 */
	public DishGroup getDishGroup() {
		return dishGroup;
	}
	/**
	 * 
	 * @param dishGroup
	 */
	public void setDishGroup(DishGroup dishGroup) {
		this.dishGroup = dishGroup;
	}
	/**
	 * 
	 * @return jinpin
	 */
	public String getJinpin() {
		return jinpin;
	}
	/**
	 * 
	 * @param jinpin
	 */
	public void setJinpin(String jinpin) {
		this.jinpin = jinpin;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return unitgroup
	 */
	public String getUnitgroup() {
		return unitgroup;
	}
	/**
	 * 
	 * @param unitgroup
	 */
	public void setUnitgroup(String unitgroup) {
		this.unitgroup = unitgroup;
	}
	/**
	 * 
	 * @return unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 
	 * @param unitPrice
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void save(){
		bDish.persist(this);
	}
	
	public static void update(String originalname,Dish dish){
		BDish bDish = new BDish();
		bDish.update(originalname,dish);
	}
	
	public static void delete(String originalname){
		BDish bDish = new BDish();
		bDish.delete(originalname);
	}
	
	public static List<Dish> getAllDishs(){
		BDish bDish = new BDish();
		return bDish.getAllDishs();
	}
	
	public static List<Dish> getJianPinDishs(String jianpin){
		BDish bDish = new BDish();
		return bDish.getJianPinDishs(jianpin);
	}
	public static boolean search(String originalname){
		BDish bDish = new BDish();
		return bDish.search(originalname);
	}
}
