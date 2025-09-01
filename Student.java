import java.util.ArrayList;

public class Student { 

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String major;
	private double gpa;
	private int hours;
	private String house;

	public Student(int id, String fname, String lname, String email, String major, double gpa, int hours, String house) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.major = major;
		this.gpa = gpa;
		this.hours = hours;
		this.house = house;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int newID) {
		this.id = newID;
	}
	
	public String getFirst() {
		return this.fname;
	}

	public void setFirst(String newFirst) {
		this.fname = newFirst;
	}

	public String getLast() {
		return this.lname;
	}

	public void setLast(String newLast) {
		this.lname = newLast;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String newMajor) {
		this.major = newMajor;
	}

	public double getGPA() {
		return this.gpa;
	}

	public void setGPA(double newGPA) {
		this.gpa = newGPA;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(int newHours) {
		this.hours = newHours;
	}

	public String getHouse() {
		return this.house;
	}

	public void setHouse(String newHouse) {
		this.house = newHouse;
	}

	@Override
	public String toString() {
		return "Student ID: " + id + "\n" + "First Name: " + fname + "\n" + "Last Name: " + 
		lname + "\n"+ "Email: " + email + "\n" + "Major: " + major + "\n" + "GPA: " + gpa + "\n" +
		"Credit Hours: " + hours + "\n" + "House: " + house + "\n";
	}
}