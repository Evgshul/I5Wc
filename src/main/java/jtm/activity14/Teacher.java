package jtm.activity14;

// This class is used as a definition for persistent objects
// Do not change this class

public class Teacher {

	private int id;
	private String firstName;
	private String lastName;

	// TODO process passed values

	public Teacher(int id, String firstName, String lastName) {
	}

	public int getID() {
		// TODO return required value
		
		return id;
	}

	public String getFirstName() {
		// TODO return required value
		return "Name";
	}

	public String getLastName() {
		// TODO return required value
		return "Surname";
	}

	// TODO
	// Override toString() method which returns teacher in form "Name Surname"
	@Override
	public String toString() {
		return firstName+" "+ lastName;
	}

}
