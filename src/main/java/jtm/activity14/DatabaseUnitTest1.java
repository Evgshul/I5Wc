
package jtm.activity14;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseUnitTest1 {

	static Student student;
	static StudentManager manager;

/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}*/

	/**
	 * Test method for {@link jtm.activity14.StudentManager#StudentManager()}.
	 */
	@Test
	public final void testStudentManager() {
		manager = new StudentManager();

		// fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#findStudent(int)}.
	 */
	@Test
	public final void testFindStudentInt() {
		manager = new StudentManager();
		int id = 1;
		manager.findStudent(id);
		assertEquals("Input ID = " + id + " and output id = " + manager.findStudent(id).getID() + " do not match", id, manager.findStudent(id).getID());
		
		//student = new Student(1, "Dan", "Olga");
		// fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#findStudent(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testFindStudentStringString() {

		// fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#insertStudent(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testInsertStudentStringString() {
		//Student student = new Student(10, "John", "Silver");
		assertTrue(manager.insertStudent(student.getFirstName(), student.getLastName()));
		assertFalse(manager.insertStudent(null, null));

		// fail("Not yet implemented"); // TODO

	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#insertStudent(jtm.activity14.Student)}.
	 */
	@Test
	public final void testInsertStudentStudent() {
		assertTrue(manager.insertStudent("instudent", "student"));
		assertFalse(manager.insertStudent(" ", " "));

	}

	/**
	 * Test method for
	 * {@link jtm.activity14.StudentManager#updateStudent(jtm.activity14.Student)}.
	 */
	@Test
	public final void testUpdateStudent() {
		assertTrue(manager.updateStudent(new Student(5, "name", "student")));
		assertFalse(manager.updateStudent(new Student(0, " ", " ")));	
		

		
		// fail("Not yet implemented"); // TODO

	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#deleteStudent(int)}.
	 */

	@Test
	public final void testDeleteStudent() {
		assertTrue(manager.deleteStudent(1));
		
		
		// fail("Not yet implemented"); // TODO

	}

	/**
	 * Test method for {@link jtm.activity14.StudentManager#closeConnecion()}.
	 */
	@Test
	public final void testCloseConnecion() {

		if (manager.conn != null) {
			manager.closeConnecion();
			assertNull(manager.conn);
		} else
			assertNotNull(manager.conn);

		// fail("Not yet implemented"); // TODO

	}

	public static void main(String[] args) {

		DatabaseUnitTest dbUnitTest = new DatabaseUnitTest();
		dbUnitTest.test();

	}
}