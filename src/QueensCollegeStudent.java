/**
 * Project Name: Registration
 * Purpose:
 *
 * @author Sean Rodriguez <sean.rodriguez@outlook.com>
 * @since October 21, 2016
 * @version 1.0
 *
 */

class QueensCollegeStudent extends Student {
    private String venusLogin;

    public QueensCollegeStudent(String firstName, String lastName,
                                int id, double gpa, int year, int month, int day,
                                String venusLogin) throws MyInvalidDateException {
        super(firstName, lastName, id, gpa, year, month, day);
        this.venusLogin = venusLogin;
    }

    // Checks if the Venus Login is valid
    public Boolean isValidVenusLogin() {
        String login = "" + lastName.toLowerCase().charAt(0) + lastName.charAt(1) +
                firstName.toLowerCase().charAt(0) + firstName.charAt(1) + id % 10000;

        return venusLogin.equals(login);
    }

    // Displays the student's information
    public void displayAttributes() {
        System.out.println("Student Name: " + firstName + " " + lastName);
        System.out.println("CUNYFirst ID: " + id);
        System.out.println("GPA: " + gpa);
        System.out.print("Birth Date: "); birthDate.print();
        System.out.println("Venus Login: " + venusLogin);
    }

    public String getVenusLogin() {return venusLogin;}
}
