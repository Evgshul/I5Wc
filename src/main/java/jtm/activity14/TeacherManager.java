package jtm.activity14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;


private static Logger log = Logger.getLogger(StudentManager.class);

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
		return null;

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
		// TODO #6 Write an sql statement that updates teacher information.
		return false;
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
		return false;
	}

	public void closeConnecion() {
		// TODO Close connection if and reset it to release connection to the
		// database server
	}
}
