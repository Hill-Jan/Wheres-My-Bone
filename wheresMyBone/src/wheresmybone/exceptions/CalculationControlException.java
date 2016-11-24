/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.exceptions;

/**
 *
 * @author Dan
 */
public class CalculationControlException extends Exception {

    public CalculationControlException() {
    }

    public CalculationControlException(String string) {
        super(string);
    }

    public CalculationControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public CalculationControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public CalculationControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
