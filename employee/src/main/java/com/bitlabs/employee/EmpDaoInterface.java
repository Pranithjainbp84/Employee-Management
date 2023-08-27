package com.bitlabs.employee;

public interface EmpDaoInterface 
{
    public void empRegistration(Emp e);
		
		
	
    public void showAllEmployees();   
    public void updateEmp(int eno,Emp e);
    public void deleteEmp(int eno);
	public void getEmpById(int eno);

}