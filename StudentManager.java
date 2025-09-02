/**
 * StudentManager Manages student objects.
 * Displays options for the user to choose what data to display.
 * 
 * @author Dephaney Zhang
 * @github dephaney
 * @version java 23.0.2 2025-01-21
 */

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {

	public static void main(String [] args) {
		String filename = "hogwarts-students.csv";
        System.out.println("Reading " + filename + "\n");
        ArrayList<Student> students = CSVProcessor.readCSV(filename);

        Scanner input = new Scanner(System.in);
        int choice;

        while(true) {
        	System.out.println("Options:\n[1] View all student information\n[2] View students in a specific house\n" +
        		"[3] View average GPA of all students in a specific house\n[4] Write out average GPA of all students into a file\n" +
        		"[5] Display the number of students in each major\n[6] Display honor roll students\n[7] Search for a student\n" +
        		"[8] Write out average GPA and honor roll students into a file\n[0] Quit");
      		System.out.print(">> ");
      		try {
      			choice = input.nextInt();
      			if (choice == 0) {
	        		System.out.println("exiting program, goodbye ~!");
	        		break;
	      		} else if (choice == 1) {
	      			for (Student s : students) {
	      				System.out.println(s.toString());
	      			}
	      		} else if (choice == 2) {
	      			System.out.println("Which house's student information would you like to view?\n (Choose: Gryffindor, Hufflepuff, Ravenclaw, Slytherin)");
	      			System.out.print(">> ");
	      			String house = input.nextLine();
	      			ArrayList<Student> studentsToPrint = new ArrayList<Student>();
	      			for (Student s : students) {
	      				if (s.getHouse().equalsIgnoreCase(house)) {
	      					studentsToPrint.add(s);
	      				}
	      			}
	      			for (Student s : studentsToPrint) {
	      				System.out.println(s.toString());
	      			}

	      		} else if (choice == 3) {
	      			System.out.println("Which house's averages student GPA would you like to view?\n(Choose: Gryffindor, Hufflepuff, Ravenclaw, Slytherin)");
	      			System.out.print(">> ");
	      			input.nextLine();
	      			String house = input.nextLine();
	      			ArrayList<Student> studentsToCalc = new ArrayList<Student>();
	      			for (Student s : students) {
	      				if (s.getHouse().equalsIgnoreCase(house)) {
	      					studentsToCalc.add(s);
	      				}
	      			}
	      			if (studentsToCalc.size() > 0) {
	      				System.out.print("\nThe average GPA of the students of " + house + " is ");
	      				System.out.printf(" %.2f", avgGPA(studentsToCalc));
	      			}
	      		} else if (choice == 4) {
	      			try {
	      				FileOutputStream fileStream = new FileOutputStream("gpa.txt");
		      			PrintWriter writer = new PrintWriter(fileStream);
		      			writer.print("The average GPA of all students is");
		      			writer.printf(" %.2f", avgGPA(students));
		      			writer.close();
		      			System.out.println("Average gpa successfully written into a file named gpa.txt");
	      			} catch (IOException e) {
	      				System.out.println("Error with file: " + e.getMessage());
	      			}
	      		} else if (choice == 5) {
	      			displayMajors(students);
	      		} else if (choice == 6) { 
	      			System.out.println("Honor Roll: \n");
	      			honorRoll(students);
	      		} else if (choice == 7) {
	      			System.out.println("Which student do you want to search for? (By first name)");
	      			input.nextLine();
	      			String firstName = input.nextLine();
	      			findStudent(firstName, students);
	      		} else if (choice == 8) {
	      			try {
	      				FileOutputStream fileStream = new FileOutputStream("analysis.txt");
		      			PrintWriter writer = new PrintWriter(fileStream);
		      			writer.print("The average GPA of all students is ");
		      			writer.printf("%.2f", avgGPA(students));
		      			writer.println("\n");
		      			ArrayList<Student> honorRoll = new ArrayList<Student>();
						for (Student s : students) {
							if (s.getGPA() > 3.5) { 
								honorRoll.add(s);
							}
						}
						writer.println("Honor Roll:");
						for (Student s : honorRoll) {
							writer.println(s.getFirst() + " " + s.getLast() + ", GPA: " + s.getGPA());
						}
						writer.close();
		      			System.out.println("Average gpa and honor roll students successfully written into a file named analysis.txt");
	      			} catch (IOException e) {
	      				System.out.println("Error with file: " + e.getMessage());
	      			}
	      		} else {
			        System.out.print("invalid input");
			        continue;
	      		}
      		System.out.println();
      		} catch (InputMismatchException e) {
      			System.out.println("input is not an integer, goodbye!");
      			break;
      		}
        }
        input.close();
	}

	/**
     * Calculates the average GPA of the students.
     * 
     * @param students An arraylist of student objects.
     * @return A double of the average GPA of the students.
     */
	public static double avgGPA(ArrayList<Student> students) {
		int count = 0;
		double sum = 0.0;
		for (Student s : students) {
			sum += s.getGPA();
			count++;
		}
		return sum / count;
	}

	/**
     * Displays the number of students in each major.
     * 
     * @param students An arraylist of student objects.
     */
	public static void displayMajors(ArrayList<Student> students) {
		HashMap<String, Integer> majors = new HashMap<String, Integer>();
		String major;
		for (Student s : students) {
			major = s.getMajor();
			if (majors.containsKey(major)) {
				majors.put(major, majors.get(major) + 1);
			} else {
				majors.put(major, 1);
			}
		}
		for (String key : majors.keySet()) {
			System.out.println(key + ": " + majors.get(key));
		}
	}

	/**
     * Displays the studens in honor roll.
     * 
     * @param students An arraylist of student objects.
     */
	public static void honorRoll(ArrayList<Student> students) {
		ArrayList<Student> honorRoll = new ArrayList<Student>();
		for (Student s : students) {
			if (s.getGPA() > 3.5) { 
				honorRoll.add(s);
			}
		}
		for (Student s : honorRoll) {
			System.out.println(s.getFirst() + " " + s.getLast() + ", GPA: " + s.getGPA());
		}		
	}

	/**
     * Finds and displays the user-specificed student.
     * 
     * @param students An arraylist of student objects.
     * @param student A String of the student to be found.
     */
	public static void findStudent(String student, ArrayList<Student> students) {
		for (Student s : students) {
			if (s.getFirst().equalsIgnoreCase(student)) {
				System.out.println(student + " found! Information: \n");
				System.out.println(s.toString());
				return;
			}
		}
		System.out.println("Student could not be found");
	}
}
