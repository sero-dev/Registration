/**
 * Project Name: Registration
 * Purpose:
 *
 * @author Sean Rodriguez <sean.rodriguez@outlook.com>
 * @copyright Sean Rodriguez October 21, 2016
 * @version 1.0
 *
 */

abstract class Student {
    static int numberOfStudents = 0;

    int id;
    String firstName, lastName;
    double gpa;
    Date birthDate;

    public Student(String firstName, String lastName,
                   int id, double gpa, int year, int month, int day)
            throws MyInvalidDateException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gpa = gpa;

        try {	// Set valid birthday attribute
            birthDate = new Date(day, month, year);
        } catch(MyInvalidDateException e) { // Catch invalid value
            birthDate = new Date();
        };

        numberOfStudents++; // Increment when a new Student is created
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    //Get Accessors for variables
    public double getGPA() {return gpa;}
    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Date getBirthDate() {return birthDate;}
}
