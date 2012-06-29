package uml.base;

import java.util.ArrayList;
import java.util.List;

import uml.hibernate.Productgroup;
import uml.hibernate.ProductgroupHome;
import uml.middleclass.DishGroup;

public class BDishGroup {
	private final ProductgroupHome productgroupHome = getProductgroupHome();

	protected ProductgroupHome getProductgroupHome(){
		return new ProductgroupHome();
	}
	
	public void persist(uml.middleclass.DishGroup dishGroup){
		productgroupHome.persist(new Productgroup(dishGroup.getCategory()));
	}
	
	public List<DishGroup> getAllDishGroups(){
		List<DishGroup> dishgroups = new ArrayList<DishGroup>();
		List<Productgroup> productgroups = productgroupHome.getAllDishGroups();
		for (int i = 0; i < productgroups.size(); i++) {
			dishgroups.add(i, new DishGroup(productgroups.get(i).getCategory()));
		}
		return dishgroups;
	}
	
	public void update(String originalcategory,String newcategory){
		Productgroup productgroup = new Productgroup(originalcategory);
		productgroupHome.update(productgroup,newcategory);
	}
	
	public void delete(String pcatogory){
		productgroupHome.delete(pcatogory);
	}
	
	public DishGroup search(String pcatogory){
		return productgroupHome.search(pcatogory);
	}
}
