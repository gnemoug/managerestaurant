package uml.base;

import java.util.ArrayList;
import java.util.List;
import uml.hibernate.Product;
import uml.hibernate.ProductHome;
import uml.middleclass.Dish;
import uml.middleclass.DishGroup;

public class BDish {
	private final ProductHome productHome = getProductHome();

	protected ProductHome getProductHome(){
		return new ProductHome();
	}
	
	public void persist(Dish dish){
		productHome.persist(dish);
	}
	public void update(String originalname,Dish dish){
		productHome.update(originalname,dish);
	}
	public void delete(String originalname){
		productHome.delete(originalname);
	}
	public List<Dish> getAllDishs(){
		List<Product> products =  productHome.getAllDishs();
		List<Dish> dishesDishs = new ArrayList<Dish>();
		for (int i = 0; i < products.size(); i++) {
			dishesDishs.add(new Dish(new DishGroup(products.get(i).getProductgroup().getCategory()), products.get(i).getName(), products.get(i).getUnitPrice(), products.get(i).getJinpin(), products.get(i).getCurrentInventory(), products.get(i).getUnitgroup().getUnit()));
		}
		return dishesDishs;
	}
	
	public List<Dish> getJianPinDishs(String jianpin){
		List<Product> products =  productHome.getAllDishs();
		List<Dish> dishesDishs = new ArrayList<Dish>();
		for (int i = 0; i < products.size(); i++) {
			if(jianpin.equals(products.get(i).getJinpin())){
				dishesDishs.add(new Dish(new DishGroup(products.get(i).getProductgroup().getCategory()), products.get(i).getName(), products.get(i).getUnitPrice(), products.get(i).getJinpin(), products.get(i).getCurrentInventory(), products.get(i).getUnitgroup().getUnit()));
			}
		}

		return dishesDishs;
	}
	public boolean search(String originalname){
		return productHome.search(originalname);
	}
}
