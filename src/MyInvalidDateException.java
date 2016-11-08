/**
 * Project Name: Registration<br>
 * File Name: MyInvalidDateException.java<br>
 * Purpose: Exception to catch invalid dates
 *
 * @author Sean Rodriguez
 * @since October 21, 2016
 * @version %I%, %G%
 */

class MyInvalidDateException extends Exception {
    /**
     * Calls exception
     */
    public MyInvalidDateException() {
        super();
    }

    /**
     * Calls exception with a message
     * @param message error message to be displayed.
     */
    MyInvalidDateException(String message) {
        super(message);
    }
}
