// PalmerPenguinsM4.java
// Joseph Meade
// 06/09/2026
// Reads the CSV file and parses the data

import java.io.*;

public class PalmerPenguinsM4 {

    static final String FILE_NAME =  "PalmerPenguins.csv";
    
    // constants to represent the species and count
    static final String SP_CHINSTRAP = "Chinstrap";
    static final String SP_GENTOO = "Gentoo";
    static final String SP_ADELIE = "Adelie";
    
    public static void main(String[] args) {
        // TODO 1 Declare the variables
        int currRow = 0;
        int specChinstrapCount = 0;
        int specGentooCount = 0;
        int specAdelieCount = 0;
    
        // Read the headers
        String line = CSVReader.readFile(FILE_NAME, currRow++);
        if (line == null) {
            System.out.println("Error: The file is empty or could not be read.");
            return; // Exit the program if no headers are found
        }
        System.out.println("found headers:\n" + line);
    
        // Process each subsequent row
        while ((line = CSVReader.readFile(FILE_NAME, currRow++)) != null) {
            // Check species in the line, increment appropriate accumulator
            if (line.contains(SP_CHINSTRAP)) {
                specChinstrapCount++;
            // TODO 2 complete the branches to increment the accumulators    
            } else if (line.contains(SP_GENTOO)) {
                specGentooCount++;
            } else if (line.contains(SP_ADELIE)) {
                specAdelieCount++;
            }
        }
    
        // Print the results
        // TODO 3 print all accumulators
        System.out.println("Chinstrap count = " + specChinstrapCount);
        System.out.println("Gentoo count = " + specGentooCount);
        System.out.println("Adelie count = " + specAdelieCount);
    }
}

class CSVReader {
    
    /**
     * Reads a specific row from a text file.
     * 
     * @param FILE_NAME the name of the file to be read
     * @param row       the 0-based index of the row to retrieve
     * @return the content of the specified row as a String, or null if the row does not exist
     */
     
    public static String readFile(String FILE_NAME, int row) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            int currentRow = 0;

            while ((line = reader.readLine()) != null) {
                if (currentRow == row) {
                    return line;
                }
                currentRow++;
            }

            // If the specified row does not exist, return null
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file: " + e.getMessage();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}