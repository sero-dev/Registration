/**
 * Project Name: Registration<br>
 * File Name: Student.java<br>
 * Purpose: Creates a Student object filled with basic information
 *
 * @author Sean Rodriguez
 * @since 1.0
 * @version %I%, %G%
 */

abstract public class Student {
    private static int numberOfStudents = 0;    // Keeps track of all student objects

    String firstName, lastName;
    int id;
    double gpa;
    Date birthDate;

    /**
     * Assigns member variables and validates date for birthDate
     * @param firstName student's first name
     * @param lastName student's last name
     * @param id student's ID
     * @param gpa student's overall GPA
     * @param year  year that student was born
     * @param month month that student was born
     * @param day day that student was born
     * @throws MyInvalidDateException catches any invalid dates from Date object
     */
    public Student(String firstName, String lastName,
                   int id, double gpa, int year, int month, int day)
            throws MyInvalidDateException {

        // Assigns member variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;

        try {	// Set valid birthday attribute
            birthDate = new Date(day, month, year);
        } catch(MyInvalidDateException e) { // Catch invalid dates
            birthDate = new Date();         // Create a default date object
        }

        numberOfStudents++; // Increment when a new Student is created
    }

    /**
     * Gets the number of total students
     * @return number of total students
     */
    static int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Gets student's GPA
     * @return student's GPA
     */
    public double getGPA() {
        return gpa;
    }

    /**
     * Gets student's ID
     * @return student's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets student's first name
     * @return student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets student's last name
     * @return student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets student's birth date
     * @return student's birthDate object
     */
    public Date getBirthDate() {
        return birthDate;
    }
}
