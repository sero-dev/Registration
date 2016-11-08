import java.io.FileNotFoundException;

/**
 * Project Name: Registration<br>
 * File Name: ReadRunnable.java<br>
 * Purpose: Class extends Threads to read from files concurrently
 *
 * @author Sean Rodriguez
 * @since 1.0
 * @version %I%, %G%
 */

class ReadRunnable implements Runnable  {

    // file address to write data to
    private String filename;

    /**
     * Assigns filename member variable
     * @param filename file address to write data to
     */
    ReadRunnable(String filename) {
        this.filename = filename;   // Assign filename member variable
    }

    /**
     * Calls readDataFromFile and prints out the average GPA, catches all InvalidDateExceptions and FileNotFoundException
     */
    public void run() {
        try {
            System.out.printf("Average GPA from %s: %.2f\n", filename, Main.readDataFromFile(filename));
        }
        catch(FileNotFoundException e) {  // Catches FileNotFoundException from File object
            System.out.println("ERROR: File cannot be opened");
        }
        catch(MyInvalidDateException e) { // Catches MyInvalidDateException from Date object
            System.out.println("ERROR: Record contains invalid birth date");
        }
    }
}
