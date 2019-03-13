package jtm.activity13;

public class Teacher {

	private int id;
	private String firstName;
	private String lastName;

	// TODO process passed values

	public Teacher(int id, String firstName, String lastName) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public int getID() {
		// TODO return required value
		
		return id;
	}

	public String getFirstName() {
		// TODO return required value
		return firstName;
	}

	public String getLastName() {
		// TODO return required value
		return lastName;
	}

	// TODO
	// Override toString() method which returns teacher in form "Name Surname"
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
