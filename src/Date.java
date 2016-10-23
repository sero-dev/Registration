/**
 * Project Name: Registration
 * Purpose:
 *
 * @author Sean Rodriguez <sean.rodriguez@outlook.com>
 * @since October 21, 2016
 * @version 1.0
 *
 */

class Date {
    private int year, month, day;

    Date() {
        year = 1950;
        month = 1;
        day = 1;
    }

    Date(int day, int month, int year) throws MyInvalidDateException {
        // Checks for leap year
        Boolean isLeapYear = (year % 100 == 0
                && year % 400 == 0
                || year % 4 == 0);

        // Checks for invalid range for days, months, or years
        if(year < 1 || year > 2016)
            throw new MyInvalidDateException("Invalid Year");
        else this.year = year;

        if(month < 1 || month > 12)
            throw new MyInvalidDateException("Invalid Month");
        else this.month = month;

        if(day < 1)
            throw new MyInvalidDateException("Day is less than 1");
        else { // Checks for invalid maximum for days
            if(month == 1 || month == 3 || month == 5 ||
                    month == 7 || month == 8 || month == 10
                    || month == 12) { // Checks all 31 day months
                if(day > 31) throw new MyInvalidDateException("Day Exceeds 31");
                else this.day = day;
            } else if(month == 2) {
                if(isLeapYear){ // Checks Feburary if it is a leap year
                    if(day > 29) throw new MyInvalidDateException("Day Exceeds 29");
                    else this.day = day;
                } else { // Checks Feburary if it is not a leap year
                    if(day > 28) throw new MyInvalidDateException("Day Exceeds 28");
                    else this.day = day;
                }
            } else { // Checks all 30 day months
                if(day > 30) throw new MyInvalidDateException("Day Exceeds 30");
                else this.day = day;
            }
        }
    }

    void print() {
        System.out.println(month + "/" + day + "/" + year);
    }
}
