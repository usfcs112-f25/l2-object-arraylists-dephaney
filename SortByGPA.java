/**
 * SortByGPA Sorts students based off of GPA.
 * Implements a Comparator to sort by GPA.
 * 
 * @author Dephaney Zhang
 * @github dephaney
 * @version java 23.0.2 2025-01-21
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByGPA implements Comparator<Student> {

	/**
	 * Compares the gpas of two students.
	 * 
	 * @param stu1 The first student.
	 * @param stu2 The second student.
	 * @return An int that descibes which student comes first.
	 */
	public int compare(Student stu1, Student stu2) {
		if(stu1.getGPA() > stu2.getGPA()) {
			return -1;
		} else if (stu1.getGPA() < stu2.getGPA()) {
			return 1;
		} else {
			return 0;
		}
	}
}