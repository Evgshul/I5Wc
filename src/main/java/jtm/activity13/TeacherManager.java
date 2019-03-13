package jtm.activity13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TeacherManager {

//	private static final Connection con = null;
	protected Connection conn = null;


	public TeacherManager()  {
		// TODO #1 When new TeacherManager is created, create connection to the
		// database server:
		// url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&characterEncoding=utf8"
		// user = "root"
		// pass = "Student007"
		// Hints:
		// 1. Do not pass database name into url, because some statements
		// for tests need to be executed server-wise, not just database-wise.
		// 2. Set AutoCommit to false and use conn.commit() where necessary in
		// other methods
		
		String url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&characterEncoding=utf8";
		String user = "root";
		String pass = "Student007";
		
		
		try{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(url, user, pass);
			 //this.conn=con;
			 conn.setAutoCommit(true);
			 //Statement stmt = con.createStatement();

            } catch (Exception e){
            	System.err.print(e);
            }
		
	}

	/**
	 * Returns a Teacher instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @return a Teacher object
	 */
	public Teacher findTeacher(int id) {
		// TODO #2 Write an sql statement that searches teacher by ID.
		// If teacher is not found return Teacher object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "database_activity.Teacher"
		
		//int nId =0;
		String firstname=null;
		String lastname=null;
		
		try{
			PreparedStatement pStmt = conn.prepareStatement("select * from database_activity.Teacher where id = ?");
			
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
		
				 
		while(rs.next()){
				//nId = rs.getInt(1);
				
				firstname = rs.getString("firstName");
				lastname = rs.getString("lastName");
						
		}
		if(firstname != null && lastname != null) {
		  return new Teacher(id, firstname, lastname);
			                         }
		
		}
		catch(Exception e)
		{
			
		e.printStackTrace();}
		return new Teacher(0,null,null);
	}

	/**
	 * Returns a list of Teacher object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of teacher.
	 * @param lastName
	 *            the last name of teacher.
	 * @return a list of Teacher object.
	 */
	public List<Teacher> findTeacher(String firstName, String lastName) {
		// TODO #3 Write an sql statement that searches teacher by first and
		// last name and returns results as ArrayList<Teacher>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// Note, that if nothing is found return empty list!
		List<Teacher> teacher = new ArrayList<Teacher>();
		
		try{
			PreparedStatement pStmt = conn.prepareStatement("select * from database_activity.Teacher where (firstName like ? and lastName like ?)");
			
			pStmt.setString(1, "%" + firstName + "%");
			pStmt.setString(2, "%" + lastName + "%");
			
			ResultSet rs = pStmt.executeQuery();
			
			int nId;
			String Nfirstname = null;
			String NlastName = null;
			
			
			while(rs.next()){
			
				nId = rs.getInt("id");
				Nfirstname= rs.getString("firstName");
				NlastName = rs.getString("lastName");
				teacher.add (new Teacher (nId, Nfirstname, NlastName));
			}
		
					
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return teacher;

	}

	/**
	 * Insert an new teacher (first name and last name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if success, else false.
	 */

	public boolean insertTeacher(String firstName, String lastName) {
		// TODO #4 Write an sql statement that inserts teacher in database.       
		                 
  try {
    	  PreparedStatement pStmt = conn.prepareStatement("insert into database_activity.Teacher (firstName,lastName) values (?,?)");
		                         
          pStmt.setString(1, firstName);
          pStmt.setString(2, lastName);
          pStmt.executeUpdate();
		  
          conn.commit();
          
         if (pStmt.executeUpdate() > 0) {
        	 //conn.commit();
		     return true;
		                   
         
        }
         //conn.close();
		        } catch (SQLException e) {
		                          
		              e.printStackTrace();
		                 }
		                 return true;
		
		
	}

	/**
	 * Insert teacher object into database
	 * 
	 * @param teacher
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertTeacher(Teacher teacher) {
		// TODO #5 Write an sql statement that inserts teacher in database.

		          
try {
	PreparedStatement pStmt = conn.prepareStatement("insert into database_activity.Teacher (id,firstName,lastName) values (?,?,?)");		        	 
		        	 
		        	 
		                    
	 pStmt.setInt(1, teacher.getID());
	 pStmt .setString(2, teacher.getFirstName());
	 pStmt.setString(3, teacher.getLastName());
		                   
	 pStmt.executeUpdate();
	   

	// conn.commit();
     
	//if (pStmt.executeUpdate() > 0) {
		 //conn.commit();
	//	 return true;}
		              
	
	
		    } catch (SQLException e) {
		                          
		      e.printStackTrace();
		                 }
			
		return false;
	}

	/**
	 * Updates an existing Teacher in the repository with the values represented
	 * by the Teacher object.
	 * 
	 * @param teacher
	 *            a Teacher object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateTeacher(Teacher teacher) {
		//boolean status = false;
		
	              
         try {
        	 PreparedStatement pStmt = conn.prepareStatement("update database_activity.Teacher set firstname = ?, lastname = ? where id = ?");
        	
        	     pStmt.setString(1, teacher.getFirstName());
                 pStmt.setString(2, teacher.getLastName());
                 pStmt.setInt(3, teacher.getID());
                 //pStmt.executeUpdate();
                 if (pStmt.executeUpdate() > 0) {
                // status = true;
                	// conn.commit();
                	 return true;
                 }
                 //conn.close();
         } catch (SQLException e) {

                e.printStackTrace();
       }
        //return status;
         return false;
		
		
		
		
		
		// TODO #6 Write an sql statement that updates teacher information.
	
	}

	/**
	 * Delete an existing Teacher in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of teacher.
	 * @return true if row was deleted.
	 */
	
	public boolean deleteTeacher(int id) {
		// TODO #7 Write an sql statement that deletes teacher from database.
		
		try {
            PreparedStatement pStmt = conn.prepareStatement("delete from database_activity.Teacher where id = ?");

            pStmt.setInt(1, id);
            
          //  conn.commit();
            
       if(pStmt.executeUpdate()>0)
            	{//conn.commit();
            	return true;	}
           
       
       
       closeConnecion();
        } catch (SQLException e) {

	        e.printStackTrace();

                }
		
		
		return false;
	}

	public void closeConnecion(){
		
		//con.close();
		// TODO Close connection if and reset it to release connection to the
		// database server
		
		if (conn!=null) {	
		      try {
		        conn.close();
		       } catch (Exception e) {
			                                 
		         e.printStackTrace();
		    }
		    conn = null;
	}
	}
	}
