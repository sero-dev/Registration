import javax.swing.JOptionPane;

/**
 * Project Name: Registration
 * Purpose:
 *
 * @author Sean Rodriguez <sean.rodriguez@outlook.com>
 * @since October 21, 2016
 * @version 1.0
 *
 */
class Main {
    public static void main(String[] args) throws MyInvalidDateException {

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
        double[] gp = {
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

        // Create an array of the number of students the user wants
        QueensCollegeStudent[] students = new QueensCollegeStudent[n];

        // Iterate through array, populate values for each student
        // Using randomly pre-determined values
        for(int i = 0; i < students.length; i++) {
            int random = (int)(Math.random() * 10);
            students[i] = new QueensCollegeStudent(fname[random], lname[random],
                    id[random], gp[random], year[random], month[random], day[random],
                    vl[random]);
        }

        System.out.println();

        // Iterate through array, call displayAttributes to display student's info
        for(QueensCollegeStudent student : students) {
            student.displayAttributes();
            System.out.println();
        }

        // Iterate through array, call isValidVenusLogin
        // To display if each student's CUNYFirst ID is valid
        for(QueensCollegeStudent student : students)
            System.out.println(student.firstName + " " +
                    student.lastName + "'s Venus Login is " +
                    (student.isValidVenusLogin() ? "Valid" : "Invalid"));

        System.out.println("\nThe number of students that exists now is " +
                QueensCollegeStudent.getNumberOfStudents());
        System.out.println();
    }
}
