import java.io.IOException;

/**
 * Project Name: Registration<br>
 * File Name: WriteThread.java<br>
 * Purpose: Class extends Threads to write to file concurrently
 *
 * @author Sean Rodriguez
 * @since 1.0
 * @version %I%, %G%
 */

class WriteThread extends Thread {

    // file address to write data to
    private String filename;

    /**
     * Assigns filename member variable
     * @param filename file address to write data to
     */
    WriteThread(String filename) {
        this.filename = filename;   // Assign filename member variable
    }

    /**
     * Calls writeDataToFile from Main class, catches all IO errors
     */
    public void run() {
        try {
            Main.writeDataToFile(filename); // Calls writeDataToFile method
        }
        catch(IOException e) {  // Catches all IO erros
            System.out.println("ERROR: Cannot open file");
        }
    }
}
