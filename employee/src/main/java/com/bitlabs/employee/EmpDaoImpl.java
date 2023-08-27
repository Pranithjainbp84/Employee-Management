package com.bitlabs.employee;


import java.sql.*;
import java.util.Scanner;
 
public  class EmpDaoImpl implements EmpDaoInterface 

{
    Connection con;
    EmpDaoImpl()
    {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");          
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/heros","root","root");
       }
      catch(Exception e) {
       System.out.println(e);
      }
    }
    public void empRegistration(Emp e)
    {
    	Scanner sc=new Scanner(System.in);
    	
   
        try
        {
            PreparedStatement pstmt=con.prepareStatement("INSERT INTO EMP VALUES(?,?,?) ");
            pstmt.setInt(1,e.getEno());
          pstmt.setString(2,e.getEname());    
            pstmt.setInt(3,e.getEsal());    
                         int i=pstmt.executeUpdate();
                  if(i==1)
                    {
                       System.out.println("Employee Record Successfully Inserted");            
                    }
                    else
                    {
                      System.out.println("ERROR OCCUR WHILE  ADDING");
                    }    
                  
            }
            catch(SQLException e1) {
               System.out.println(e1);
            }
    }
    public void showAllEmployees()
    {
        try
        {
          Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("SELECT * FROM EMP");
             ResultSetMetaData rsmd=rs.getMetaData();
             int colscount=rsmd.getColumnCount();
            for(int i=1;i<=colscount;i++)
            {          System.out.print(rsmd.getColumnName(i)+"\t      ");
            }
            System.out.println("\n----------------------------------------");
             while(rs.next())
             {
                 for(int i=1;i<=colscount;i++)
                 {
               System.out.print(rs.getString(i)+"\t      ");
                 }
                  System.out.println();
             }
                         
            }
            catch(Exception e) {
                System.out.println(e);
            }
    }
    public void getEmpById(int eno)
    {	
    	 try {
    	Statement st = con.createStatement();
   	   
   	   ResultSet re = st.executeQuery("SELECT * FROM EMP WHERE eno=" +eno);
   	   
   	   ResultSetMetaData rmsd = re.getMetaData();
   	  int ccount = rmsd.getColumnCount();
   	  
   	  for (int i = 1;i<=ccount;i++) {
   		 System.out.print(rmsd.getColumnName(i) + "\t");
   	  }
   	 System.out.println("\n------------------------");
   	   while (re.next()) 
   	   {
   		  for (int i = 1;i<=ccount;i++) {
   			 System.out.print(re.getString(i) + "\t" );
   	   }
   		 System.out.println();
   	   }
 	
      }
      catch (Exception e) {
   	   System.out.println(e);
      
 }
    }
    public void updateEmp(int eno,Emp e)
    {
    

        try {
    	  PreparedStatement pstmt=con.prepareStatement("UPDATE EMP SET ename=?,esal=? WHERE eno=" +eno);

    	  pstmt.setInt(1,e.getEno());
          pstmt.setString(2,e.getEname());    
          pstmt.setInt(3,e.getEsal());     

  

         int i=pstmt.executeUpdate();
                  if(i==1)
                  {
                      System.out.println("Record Updated Successfully");                   
                  }
                  else
                  {
                    System.out.println("ERROR OCCUR WHILE Updating");
                  }    

                 
         }
         catch(Exception e1) {
             System.out.println(e);
         }
    }
    public void deleteEmp(int eno)
    {
    	 

    	try {
    	PreparedStatement pstmt=con.prepareStatement("DELETE FROM EMP WHERE eno="+eno+"");

    	 

        int i=pstmt.executeUpdate();


                 if(i==1)

                 {

                     System.out.println("Employee Record Deleted Successfully");                   

                 }

                 else

                 {

                   System.out.println("ERROR OCCUR WHILE Deleting");

                 }    


        }

        catch(Exception e) {

            System.out.println(e);

        }

 

    }
}