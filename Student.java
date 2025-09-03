/**
 * Student Stores data for a student.
 * Represents a Student object.
 * 
 * @author Dephaney Zhang
 * @github dephaney
 * @version java 23.0.2 2025-01-21
 */

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

	/**
     * Constructs Student object.
     * 
     * @param id An int of the id.
     * @param fname A String of the first name.
     * @param lname A String of the last name.
     * @param email A String of the email.
     * @param major A String of the major.
     * @param gpa A double of the gpa.
     * @param hours An int of the credit hours.
     * @param house A String of the house.
     * @return Constructed Student object.
     */
	public Student(int id, String fname, String lname, String email, String major, double gpa, int hours, String house) throws IllegalArgumentException{
		if (gpa >= 0.0 && gpa <= 5.0 && hours >= 0) {
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.email = email;
			this.major = major;
			this.gpa = gpa;
			this.hours = hours;
			this.house = house;
		} else {
			throw new IllegalArgumentException("Illegal values inputted.");
		}
	}

	/**
     * Gets the student ID number.
     * 
     * @return An int of the id.
     */
	public int getID() {
		return this.id;
	}

	/**
     * Sets the student ID number.
     * 
     * @param newID An int of the id.
     */
	public void setID(int newID) {
		this.id = newID;
	}

	/**
     * Gets the student first name.
     * 
     * @return A String of the first name.
     */	
	public String getFirst() {
		return this.fname;
	}

	/**
     * Sets the student first name.
     * 
     * @param newFirst A String of the first name.
     */	
	public void setFirst(String newFirst) {
		this.fname = newFirst;
	}

	/**
     * Gets the student last name.
     * 
     * @return A String of the last name.
     */
	public String getLast() {
		return this.lname;
	}

	/**
     * Sets the student last name.
     * 
     * @param newLast A String of the last name.
     */
	public void setLast(String newLast) {
		this.lname = newLast;
	}

	/**
     * Gets the student email.
     * 
     * @return A String of the email.
     */
	public String getEmail() {
		return this.email;
	}

	/**
     * Sets the student email.
     * 
     * @return A String of the email.
     */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	/**
     * Gets the student major.
     * 
     * @return A String of the major.
     */
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String newMajor) {
		this.major = newMajor;
	}

	/**
     * Gets the student GPA.
     * 
     * @return A double of the gpa.
     */
	public double getGPA() {
		return this.gpa;
	}

	/**
     * Sets the student GPA.
     * 
     * @param newGPA A double of the gpa.
     */
	public void setGPA(double newGPA) {
		this.gpa = newGPA;
	}

	/**
     * Gets the student credit hours.
     * 
     * @return An int of the credit hours.
     */
	public int getHours() {
		return this.hours;
	}

	/**
     * Gets the student credit hours.
     * 
     * @param newHours An int of the credit hours.
     */
	public void setHours(int newHours) {
		this.hours = newHours;
	}

	/**
     * Gets the student house.
     * 
     * @return An String of the house.
     */
	public String getHouse() {
		return this.house;
	}

	/**
     * Gets the student house.
     * 
     * @param newHouse An String of the house.
     */
	public void setHouse(String newHouse) {
		this.house = newHouse;
	}

	/**
	 * Creates a string detailing the student object.
     * 
     * @return A string that describes the student.
     */
	@Override
	public String toString() {
		return "Student ID: " + id + "\n" + "First Name: " + fname + "\n" + "Last Name: " +
		lname + "\n"+ "Email: " + email + "\n" + "Major: " + major + "\n" + "GPA: " + gpa + "\n" +
		"Credit Hours: " + hours + "\n" + "House: " + house + "\n";
	}

	/**
	 * Checks the equality between student objects.
     * 
     * @return A bool of whether the students are the same.
     */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Student) {
			Student student = (Student) other;
			return this.id == student.getID();
		}
		return false;
	}
}
