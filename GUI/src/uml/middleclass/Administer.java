package uml.middleclass;

import java.util.List;

import uml.middleclass.Receptionist;
import uml.base.BAdminister;

public class Administer extends Staff {
	private final BAdminister bAdminister = getBAdminister();
	
	protected BAdminister getBAdminister(){
		return new BAdminister();
	}	
    /**
     * construct a Receptionist object
     * @param pname
     * @param ppassword
     */
    public Administer(String pname,String ppassword) {
        super(pname, ppassword);
    }
    /**
     * whether authentication receptionist
     */
    public boolean authentication(){
    	return bAdminister.authentication(this);
    }
    
    public List<Receptionist> showReceptionists(){
    	return bAdminister.getReceptionists();
    }
    
    public static void deleteReceptionist(String recepname){
    	BAdminister bAdminister = new BAdminister();
    	bAdminister.deleteReceptionist(recepname);
    }
    
    public static boolean addReceptionist(Receptionist precep){
    	BAdminister bAdminister = new BAdminister();
    	return bAdminister.addReceptionist(precep);
    }
}
