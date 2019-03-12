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

	private static final Connection con = null;
	protected Connection conn;


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
			 this.conn=con;
			 con.setAutoCommit(false);
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
		
		int nId =0;
		String firstname="";
		String lastname="";
		try{
			PreparedStatement pStmt = con.prepareStatement("Select * from database_activity.Teacher where id=?");
			
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
		
				 
		while(rs.next()){
				nId = rs.getInt(1);
				
				firstname = rs.getString(2);
				lastname = rs.getString(3);
				
				
		}
		}
		catch(Exception e)
		{
			
		e.printStackTrace();}
		return new Teacher(nId,firstname,lastname);
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
			PreparedStatement pStmt = con.prepareStatement("Select * from database_activity.Teacher where firstname like ?,lastname like ?");
			
			pStmt.setString(1, '%' + firstName + '%');
			pStmt.setString(2, '%' + firstName + '%');
			
			ResultSet rs = pStmt.executeQuery();
			//if(rs.)
			while(rs.next()){
			
				teacher.add(0, new Teacher(rs.getInt(0),rs.getString(1),rs.getString(2)));;
			}
		
					
		
		}catch(SQLException e){
			System.err.println(e);
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
		
		String sql = "insert into database_activity.Teacher (firstname,lastname) values (?,?)";
		                 PreparedStatement preparedStatement;
		                  try {
		                          preparedStatement = conn.prepareStatement(sql);
		                         preparedStatement.setString(1, firstName);
		                          preparedStatement.setString(2, lastName);
		                          if (preparedStatement.executeUpdate() > 0) {
		                                  return true;
		                          }
		                  } catch (SQLException e) {
		                          // TODO Auto-generated catch block
		                          e.printStackTrace();
		                 }
		                 return false;
		
		
	}

	/**
	 * Insert teacher object into database
	 * 
	 * @param teacher
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertTeacher(Teacher teacher) {
		// TODO #5 Write an sql statement that inserts teacher in database.
		 String sql = "insert into database_activity.Teacher (id,firstname,lastname) values (?,?,?)";
		          PreparedStatement preparedStatement;
		         try {
		                     preparedStatement = conn.prepareStatement(sql);
		                       preparedStatement.setInt(1, teacher.getID());
		                        preparedStatement.setString(2, teacher.getFirstName());
		                       preparedStatement.setString(3, teacher.getLastName());
		                       if (preparedStatement.executeUpdate() > 0) {
		                                  return true;
		                         }
		                } catch (SQLException e) {
		                          // TODO Auto-generated catch block
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
		boolean status = false;
		
	              String sql = "UPDATE database_activity.Teacher SET firstname = ?, lastname = ? WHERE id = ?";
         PreparedStatement preparedStatement;
         try {
                preparedStatement = conn.prepareStatement(sql);
                 preparedStatement.setString(2, teacher.getLastName());
                preparedStatement.setString(1, teacher.getFirstName());
                 preparedStatement.setInt(3, teacher.getID());
                 if (preparedStatement.executeUpdate() > 0) {
                        status = true;
                 }
         } catch (SQLException e) {

                e.printStackTrace();
       }
        return status;
		
		
		
		
		
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
            PreparedStatement pStmt = conn.prepareStatement("delete from account where id = ?");

            pStmt.setInt(1, id);
            pStmt.executeUpdate();	
            conn.commit();
        } catch (SQLException e) {

	        System.err.println(e);

                }
		
		
		return false;
	}

	public void closeConnecion(){
		
		//con.close();
		// TODO Close connection if and reset it to release connection to the
		// database server
		
		if (conn != null) {	
		      try {
		        conn.close();
		       } catch (SQLException e) {
			                                 // TODO Auto-generated catch block
		         e.printStackTrace();
		    }
		    conn = null;
	}
	}
	}
