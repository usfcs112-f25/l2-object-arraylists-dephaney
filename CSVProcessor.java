/**
 * CSVProcessor Reads a given filename and returns information in an Arraylist.
 * Properly reads a CSV file and stores the data.
 * 
 * @author Dephaney Zhang
 * @github dephaney
 * @version java 23.0.2 2025-01-21
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVProcessor { 

	/**
     * Reads the CSV and returns data.
     * @param filename A String with the filename.
     * @return An ArrayList of the student objects created.
     */
	public static ArrayList<Student> readCSV(String filename) {
        BufferedReader reader = null;
        ArrayList<Student> data = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            String[] splitLine;

            while ((line = reader.readLine()) != null) {
                splitLine = line.split(",");
           		Student student = new Student(Integer.valueOf(splitLine[0]), splitLine[1], splitLine[2],
           			splitLine[3], splitLine[4], Double.valueOf(splitLine[5]), Integer.valueOf(splitLine[6]),
           			splitLine[7]);
           		data.add(student);
            }
        } catch (FileNotFoundException exception) {
            System.err.println("Error: File could not be opened.");
            return null;
        } catch (IOException exception) {
            System.err.println("Error: Line could not be read.");
            return null;
        } catch (NumberFormatException exception) {
        	System.err.println("Error: Student data malformed.");
        } finally {
            if (reader != null) {
                try {
                    // closes the reader and returns the data
                    reader.close();
                    return data;
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                    return null;
                }
            }
            return null;
        }
    }
}
