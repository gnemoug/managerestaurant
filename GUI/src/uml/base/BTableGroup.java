package uml.base;

import java.util.ArrayList;
import java.util.List;

import uml.hibernate.Dinningtable;
import uml.hibernate.Tablegroup;
import uml.hibernate.TablegroupHome;
import uml.middleclass.TableGroup;

public class BTableGroup {
	private final TablegroupHome tablegroupHome = getTablegroupHome();

	protected TablegroupHome getTablegroupHome(){
		return new TablegroupHome();
	}
	
	public void persist(uml.middleclass.TableGroup ptableGroup){
		Tablegroup tableGroup = new Tablegroup(ptableGroup.getCategory(),ptableGroup.getContain_number(),ptableGroup.getLowest_consumption());
		tablegroupHome.persist(tableGroup);
	}
	
	public List<uml.middleclass.TableGroup> getTablegroups(){
		List<Tablegroup> resultsList = tablegroupHome.findTableGroups();
		List<uml.middleclass.TableGroup> results = new ArrayList<uml.middleclass.TableGroup>();
		for(int i=0;i<resultsList.size();i++){
			results.add(new uml.middleclass.TableGroup(resultsList.get(i).getCategory(),resultsList.get(i).getContainNumber(),resultsList.get(i).getLowestConsumption()));
		}
		
		return results;
	}
	
	public List<uml.middleclass.Table> getTables(uml.middleclass.TableGroup ptableGroup){
		List<Dinningtable> dinningtables = tablegroupHome.getTables(ptableGroup.getCategory());
		List<uml.middleclass.Table> results = new ArrayList<uml.middleclass.Table>();
		for(int i=0;i<dinningtables.size();i++){
			TableGroup tablegroup = new TableGroup(dinningtables.get(i).getTablegroup().getCategory(), dinningtables.get(i).getTablegroup().getContainNumber(), dinningtables.get(i).getTablegroup().getLowestConsumption());
			results.add(new uml.middleclass.Table(dinningtables.get(i).getTableid(),tablegroup,dinningtables.get(i).getState()));
		}
		
		return results;
	}
	
	public void deleteTablegroup(String category){
		tablegroupHome.deleteTablegroup(category);
	}
	
	public void updateTableGroup(String category,TableGroup pTableGroup){
		tablegroupHome.updateTableGroup(category,pTableGroup);
	}
	
	public TableGroup search(String category){
		return tablegroupHome.search(category);
	}
}
