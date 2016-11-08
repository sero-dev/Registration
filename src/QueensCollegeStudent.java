/**
 * Project Name: Registration<br>
 * File Name: QueensCollegeStudent.java<br>
 * Purpose: Extends Student class, adds venusLogin to member variables
 *
 * @author Sean Rodriguez
 * @since 1.0
 * @version %I%, %G%
 */

class QueensCollegeStudent extends Student {
    private String venusLogin;  // VenusLogin for QCStudent record

    /**
     * Constructor instantiates all member from Student, and assigns venus login
     * @param firstName student's first name
     * @param lastName student's last name
     * @param id student's ID
     * @param gpa student's overall GPA
     * @param year  year that student was born
     * @param month month that student was born
     * @param day day that student was born
     * @param venusLogin student's venus login
     * @throws MyInvalidDateException catches any invalid dates from Date object
     */
    QueensCollegeStudent(String firstName, String lastName,
                                int id, double gpa, int year, int month, int day,
                                String venusLogin) throws MyInvalidDateException {
        super(firstName, lastName, id, gpa, year, month, day);
        this.venusLogin = venusLogin;
    }

    /**
     * Checks if venus login is valid, based on student's first name, last name and ID
     * @return true if venusLogin is valid
     */
    public Boolean isValidVenusLogin() {
        String login = "" + lastName.toLowerCase().charAt(0) + lastName.charAt(1) +
                firstName.toLowerCase().charAt(0) + firstName.charAt(1) + id % 10000;

        return venusLogin.equals(login);
    }

    /**
     * Displays student's attributes to console
     */
    public void displayAttributes() {
        System.out.println();
        System.out.println("Student Name: " + firstName + " " + lastName);
        System.out.println("CUNYFirst ID: " + id);
        System.out.println("GPA: " + gpa);
        System.out.print("Birth Date: "); birthDate.print();
        System.out.println("Venus Login: " + venusLogin);
    }

    /**
     * Gets venus login
     * @return venus login
     */
    public String getVenusLogin() {return venusLogin;}
}
