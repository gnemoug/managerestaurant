package uml.middleclass;

import uml.base.BReceptionist;

public class Receptionist extends Staff {
	private final BReceptionist bAdminister = getReceptionist();
	
	protected BReceptionist getReceptionist(){
		return new BReceptionist();
	}
    /**
     * construct a Receptionist object
     * @param pname
     * @param ppassword
     */
    public Receptionist(String pname,String ppassword) {
        super(pname, ppassword);
    }
    /**
     * whether authentication receptionist
     */
    public boolean authentication(){
    	return bAdminister.authentication(this);
    }
}
