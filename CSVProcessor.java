import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVProcessor { 

	public static ArrayList<Student> readCSV(String filename) {
        BufferedReader reader = null;
        ArrayList<Student> data = new ArrayList<>();
        try {
            /**
             * Use if statement for the first line so it only reads the first line, split it, and store it
             * in the HashMap under a -1 key so it is only accessed when specified, avoids complications of
             * accidentally calculating String/header data when iterating from 0 to n.
             */
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            String[] splitLine;
            /**
             * While loop splits the line and adds each split section into a column's arraylist
             * before moving to the next column.
             */
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
