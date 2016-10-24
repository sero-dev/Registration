/**
 * Project Name: Registration
 * Purpose:
 *
 * @author Sean Rodriguez <sean.rodriguez@outlook.com>
 * @since October 21, 2016
 * @version 1.0
 *
 */

abstract class Student {
    private static int numberOfStudents = 0;

    int id;
    String firstName, lastName;
    double gpa;
    Date birthDate;

    Student(String firstName, String lastName,
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
        }

        numberOfStudents++; // Increment when a new Student is created
    }

    static int getNumberOfStudents() {
        return numberOfStudents;
    }

    //Get Accessors for variables
    double getGPA() {return gpa;}
    int getId() {return id;}
    String getFirstName() {return firstName;}
    String getLastName() {return lastName;}
    Date getBirthDate() {return birthDate;}
}
