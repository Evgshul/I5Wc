package jtm.activity14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import jtm.activity13.Teacher;

public class StudentManager {

	protected Connection conn;
	private static Logger log = Logger.getLogger(StudentManager.class);

	public StudentManager() {
		// TODO #1 When new StudentManager is created, create connection to the
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
		conn = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns a Student instance represented by the specified ID.
	 * 
	 * @param id
	 *            the ID of teacher
	 * @return a Student object
	 */
	public Student findStudent(int id) {
		// TODO #2 Write an sql statement that searches teacher by ID.
		// If teacher is not found return Student object with zero or null in
		// its fields!
		// Hint: Because default database is not set in connection,
		// use full notation for table "database_activity.Student"
		String firstname = null;
		String lastname = null;

		String query = "select * from database_activity.Teacher where id = ?";
		
		try {
			PreparedStatement pStmt = conn.prepareStatement(query);

			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {

				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");

			}

			if (firstname != null && lastname != null) {
				return new Student(id, firstname, lastname);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return new Student(0, null, null);
		
		
		
	}

	/**
	 * Returns a list of Student object that contain the specified first name
	 * and last name. This will return an empty List of no match is found.
	 * 
	 * @param firstName
	 *            the first name of teacher.
	 * @param lastName
	 *            the last name of teacher.
	 * @return a list of Student object.
	 */
	public List<Student> findStudent(String firstName, String lastName) {
		// TODO #3 Write an sql statement that searches teacher by first and
		// last name and returns results as ArrayList<Student>.
		// Note that search results of partial match
		// in form ...like '%value%'... should be returned
		// Note, that if nothing is found return empty list!
		List<Student> student = new ArrayList<Student>();

		String sql = "select * from database_activity.Student where (firstname like ? and lastname like ?)";
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, "%" + firstName + "%");
			pStmt.setString(2, "%" + lastName + "%");

			ResultSet rs = pStmt.executeQuery();

			int nId;
			String Nfirstname = null;
			String NlastName = null;

			while (rs.next()) {

				nId = rs.getInt("id");
				Nfirstname = rs.getString("firstname");
				NlastName = rs.getString("lastname");
				student.add(new Student(nId, Nfirstname, NlastName));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;

	}

	/**
	 * This method will attempt to insert an new teacher (first name and last
	 * name) into the repository.
	 * 
	 * @param firstName
	 *            the first name of teacher
	 * @param lastName
	 *            the last name of teacher
	 * @return true if insert, else false.
	 */

	public boolean insertStudent(String firstName, String lastName) {
		// TODO #4 Write an sql statement that inserts teacher in database.
		String query = "INSERT INTO database_activity.Student (firstname, lastname) VALUES (?, ?)";
		PreparedStatement pStmt;
		try {
			conn.setAutoCommit(false);
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, firstName);
			pStmt.setString(2, lastName);
			int a = pStmt.executeUpdate();

			if (a == 1) {
				conn.commit();
				return true;

			}
			// conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

		
		
	}

	/**
	 * Try to insert Student in database
	 * 
	 * @param student
	 * @return true on success, false on error (e.g. non-unique id)
	 */
	public boolean insertStudent(Student student) {
		// TODO #5 Write an sql statement that inserts teacher in database.
		
		String query = "INSERT INTO database_activity.Student (id, firstname, lastname) VALUES (?, ?, ?)";
		PreparedStatement pStmt;
		try {

			conn.setAutoCommit(false);
			pStmt = conn.prepareStatement(query);

			pStmt.setInt(1, student.getID());
			pStmt.setString(2, student.getFirstName());
			pStmt.setString(3, student.getLastName());

			int a = pStmt.executeUpdate();

			if (a == 1) {
				conn.commit();
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
		
		
		
	}

	/**
	 * Updates an existing Student in the repository with the values represented
	 * by the Student object.
	 * 
	 * @param student
	 *            a Student object, which contain information for updating.
	 * @return true if row was updated.
	 */
	public boolean updateStudent(Student student) {
		boolean status = false;
		// TODO #6 Write an sql statement that updates teacher information.
		
		
		String query = "UPDATE database_activity.Student SET firstname = ?, lastname = ? WHERE id like ?";
		try {
			conn.setAutoCommit(false);
			PreparedStatement pStmt = conn.prepareStatement(query);

			pStmt.setString(1, student.getFirstName());
			pStmt.setString(2, student.getLastName());
			pStmt.setInt(3, student.getID());
			pStmt.execute();

			conn.commit();
			status = pStmt.getUpdateCount() == 1;
			return status;

			/*
			 * if (pStmt.executeUpdate() == 1) {
			 * 
			 * conn.commit(); return true; }
			 */

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}

	/**
	 * Delete an existing Student in the repository with the values represented
	 * by the ID.
	 * 
	 * @param id
	 *            the ID of teacher.
	 * @return true if row was deleted.
	 */
	public boolean deleteStudent(int id) {
		// TODO #7 Write an sql statement that deletes teacher from database.
		String s = "DELETE FROM database_activity.Student WHERE id = ?";
		try {
			conn.setAutoCommit(false);
			
			PreparedStatement pStmt = conn.prepareStatement(s);
			pStmt.setInt(1, id);
			

			if (pStmt.executeUpdate() == 1) {
				conn.commit();
				return true;
			}

			
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false;
		
	}

	public void closeConnecion() {
		// TODO Close connection if and reset it to release connection to the
		// database server
		try {
			if (conn != null)

				conn.close();

			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
