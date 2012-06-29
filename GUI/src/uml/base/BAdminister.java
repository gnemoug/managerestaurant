package uml.base;

import java.util.ArrayList;
import java.util.List;
import uml.hibernate.Staff;
import uml.hibernate.StaffHome;

public class BAdminister {
	private final StaffHome staffhome = getStaffHome();
	
	protected StaffHome getStaffHome(){
		return new StaffHome();
	}
	@SuppressWarnings("unchecked")
	public boolean authentication(uml.middleclass.Administer pdminister){
		Staff hstaff_admin = new Staff(pdminister.getName(),pdminister.getPassword(),"ADMINISTER");
		List<Staff> admin_result = staffhome.findByExample(hstaff_admin);
		return !admin_result.isEmpty();
	}
	@SuppressWarnings("unchecked")
	public List<uml.middleclass.Receptionist> getReceptionists(){
		List<Staff> allreceps = staffhome.findAllReceptionists();
		List<uml.middleclass.Receptionist> mreceptionists = new ArrayList<uml.middleclass.Receptionist>();
		for(int i=0;i<allreceps.size();i++){
			mreceptionists.add(new uml.middleclass.Receptionist(allreceps.get(i).getName(),allreceps.get(i).getPassword()));
		}
		
		return mreceptionists;
	}
	
	public void deleteReceptionist(String recepname){
		staffhome.deleteReceptionist(recepname);
	}
	
	public uml.middleclass.Receptionist findReceptionist(String pname){
		Staff result = staffhome.findReceptionist(pname);
		uml.middleclass.Receptionist receptionist = new uml.middleclass.Receptionist(result.getName(),result.getPassword());
		return receptionist;
	}
	
	public boolean hasReceptionist(String pname){
		Staff result = staffhome.findReceptionist(pname);	
		return result == null?false:true;
	}
	
	public boolean addReceptionist(uml.middleclass.Receptionist precep){
		if(hasReceptionist(precep.getName())){
			return false;
		}else {
			Staff receptionist = new Staff(precep.getName(),precep.getPassword(),"RECEPTIONIST");
			staffhome.persist(receptionist);
			return true;
		}
	}
}
