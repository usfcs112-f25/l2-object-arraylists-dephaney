/**
 * SortByName Sorts students based off of first name.
 * Implements a Comparator to sort by first name.
 * 
 * @author Dephaney Zhang
 * @github dephaney
 * @version java 23.0.2 2025-01-21
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByName implements Comparator<Student> {

	/**
	 * Compares the names of two students.
	 * 
	 * @param stu1 The first student.
	 * @param stu2 The second student.
	 * @return An int that descibes which student comes first.
	 */
	public int compare(Student stu1, Student stu2) {
		return a.getFirst().compareTo(b.getFirst());
	}
}
