package uml.middleclass;

import uml.base.BStaff;

public class Staff {
	
	private String name;
	private String password;
	private final BStaff bStaff = getBStaff();
	
	protected BStaff getBStaff(){
		return new BStaff();
	}		
	/**
	 * consruct a new Staff object
	 * @param pname
	 * @param ppassword
	 */
	public Staff(String pname,String ppassword) {
		setName(pname);
		setPassword(ppassword);
	}
	/**
	 * set name
	 * @param pname
	 */
	public void setName(String pname) {
		this.name = pname;
	}
	/**
	 * set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @return whether authentication staff
	 */
	public boolean authentication(){
		return bStaff.authentication(this);
	}
	/**
	 * 
	 * @param pnewpassword
	 * @return whether change
	 */
	public void changePassword(String pnewpassword){
		bStaff.changePassword(this,pnewpassword);
	}
}
