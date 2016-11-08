import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Project Name: Registration<br>
 * File Name: Main.java<br>
 * Purpose: Uses threads to write and read Students to/from a file concurrently
 *
 * @author Sean Rodriguez
 * @since 1.0
 * @version %I%, %G%
 */

public class Main {
    public static void main(String[] args) throws IOException, MyInvalidDateException {

        // Prompt user for file names to write to and read from
        String filename1 = JOptionPane.showInputDialog(
                "Choose a file to write to:");
        String filename2 = JOptionPane.showInputDialog(
                "Choose a file to write to:");
        String filename3 = JOptionPane.showInputDialog(
                "Choose a file to write to:");

        // Create three write Threads that pass in a filename to write to
        WriteThread wThread1 = new WriteThread(filename1);
        WriteThread wThread2 = new WriteThread(filename2);
        WriteThread wThread3 = new WriteThread(filename3);

        // Start threads
        wThread1.start();
        wThread2.start();
        wThread3.start();

        try {
            // Wait for all threads to finish
            wThread1.join();
            wThread2.join();
            wThread3.join();
        } catch(InterruptedException e) {   // Catches interruption errors inside the threads
            System.out.println("\nERROR: System failed to update file.");
        }

        // Print write threads status'
        System.out.println("\nFile update completed.\n");

        // Create three read Thread that pass in a filename to read from
        Thread rThread1 = new Thread(new ReadRunnable(filename1));
        Thread rThread2 = new Thread(new ReadRunnable(filename2));
        Thread rThread3 = new Thread(new ReadRunnable(filename3));

        // Start threads
        rThread1.start();
        rThread2.start();
        rThread3.start();

        try {
            // Wait for all threads to finish
            rThread1.join();
            rThread2.join();
            rThread3.join();
        } catch(InterruptedException e) {   // Catches interruption errors inside the threads
            System.out.println("ERROR: System failed to read file.");
        }

        System.out.println("\nNumber of Students: " +
                QueensCollegeStudent.getNumberOfStudents());    // Prints number of total student
        System.out.println("File read successfully");           // Prints threads status'
    }


    /**
     * Writes to the file using randomly selected pre-determined records
     * @param filename file address to write to
     * @throws IOException catches all IO errors from FileWrite object
     */
    static void writeDataToFile(String filename) throws IOException {
        FileWriter outFile = new FileWriter(filename, true);    // Create FileWriter to open file

        // Pre-determined information for first name...
        String[] fname = {
                "James", "Mary", "John", "Patricia",
                "Robert", "Jennifer", "Michael", "Elizabeth",
                "William", "Linda"
        };

        // ...last name...
        String[] lname = {
                "Smith", "Johnson", "Williams", "Brown",
                "Jones", "Miller", "Davis", "Garcia",
                "Rodriguez", "Wilson"
        };

        // ...CUNYFirst ID...
        int[] id = {
                12345678, 87654321, 12547896, 36521478,
                96587412, 15987536, 75321456, 11523658,
                78965221, 11455682
        };

        // ...GPA...
        double[] gpa = {
                3.30, 3.09, 2.85, 2.99, 3.01, 3.24,
                2.14, 3.78, 3.26, 2.45
        };

        // ...Year...
        int[] year = {
                1996, 1893, 2010, 1995, 1975,
                1969, 1988, 2001, 1983, 1990
        };

        // ...Month...
        int[] month = {2, 8, 4, 3, 7, 6, 2, 11, 9, 12};
        // ...Day...
        int[] day = {29, 18, 5, 1, 26, 12, 9, 30, 11, 21};

        // ...Venus login
        String[] vl = {
                "smja5678", "joma4321",
                "wijo7896", "brpa1478",
                "joro7412", "mije7536",
                "dami1456", "gael3658",
                "rowi5221", "wili5682"
        };

        // Prompt the user for the number of students they would like to initiate
        int n = Integer.parseInt(JOptionPane.showInputDialog(
                "How many students do you want to initiate?"));

        // Write 'n' randomly generated students to file
        for(int i = 0; i < n; i++) {
            int rand = (int)(Math.random() * 10);   // Generate random index
            outFile.write(fname[rand] + " " + lname[rand] + " " + id[rand] + " "
                    + gpa[rand] + " " + year[rand] + " " + month[rand] + " "
                    + day[rand] + " " + vl[rand] + "\n");
        }

        outFile.flush();    // flush FileWriter
        outFile.close();    // close FileWriter
    }

    /**
     * Read from file, prints file average GPA
     * @param filename file address to read from
     * @return average GPA of all students in file
     * @throws FileNotFoundException catches 'file not found' error from File object
     * @throws MyInvalidDateException catches invalid dates from Date object
     */
    static double readDataFromFile(String filename) throws FileNotFoundException, MyInvalidDateException {
        File file = new File(filename);         // Opens filename argument
        Scanner inFile = new Scanner(file);     // Scanner to iterate through the file

        // Variables to calculate gpa return
        int count = 0;
        double totalGPA = 0;

        // Loop until end of file
        while(inFile.hasNext()) {

            // Grab all variables for student record
            String firstName = inFile.next();
            String lastName = inFile.next();
            int id = inFile.nextInt();
            double gpa = inFile.nextDouble();
            int year = inFile.nextInt();
            int month = inFile.nextInt();
            int day = inFile.nextInt();
            String venusLogin = inFile.next();

            // Instantiate student object
            QueensCollegeStudent qcStudent = new QueensCollegeStudent(firstName, lastName, id,
                    gpa, year, month, day, venusLogin);

            count++;            // Increment count by 1
            totalGPA += gpa;    // Add GPAs to total GPA
        }

        inFile.close();             // close Scanner
        return totalGPA / count;    // return average gpa of file
    }
}
