package uml.base;


import java.util.List;
import uml.hibernate.Staff;
import uml.hibernate.StaffHome;

public class BStaff {
	private final StaffHome staffhome = getStaffHome();
	
	protected StaffHome getStaffHome(){
		return new StaffHome();
	}
	
	public boolean authentication(uml.middleclass.Staff pstaff){
		Staff hstaff_admin = new Staff(pstaff.getName(),pstaff.getPassword(),"ADMINISTER");
		Staff hstaff_recep = new Staff(pstaff.getName(),pstaff.getPassword(),"RECEPTIONIST");
		List<Staff> admin_result = staffhome.findByExample(hstaff_admin);
		List<Staff> recepn_result = staffhome.findByExample(hstaff_recep);
		return !(admin_result.isEmpty()&&recepn_result.isEmpty());
	}
	
	public void changePassword(uml.middleclass.Staff pstaff,String newpassword){
		staffhome.changePassword(pstaff.getName(),newpassword);
	}
}
