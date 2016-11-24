/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.exceptions;

/**
 *
 * @author tCalder
 */
public class NumberFormatException extends Exception {

    public NumberFormatException() {
    }

    public NumberFormatException(String message) {
        super(message);
    }

    public NumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberFormatException(Throwable cause) {
        super(cause);
    }

    public NumberFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
