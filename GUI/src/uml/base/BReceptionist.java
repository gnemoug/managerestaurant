package uml.base;


import java.util.List;
import uml.hibernate.Staff;
import uml.hibernate.StaffHome;

public class BReceptionist {
	private final StaffHome staffhome = getStaffHome();
	
	protected StaffHome getStaffHome(){
		return new StaffHome();
	}
	@SuppressWarnings("unchecked")
	public boolean authentication(uml.middleclass.Receptionist precep){
		Staff hstaff_recep = new Staff(precep.getName(),precep.getPassword(),"RECEPTIONIST");
		List<Staff> recepn_result = staffhome.findByExample(hstaff_recep);
		return !recepn_result.isEmpty();
	}
}
