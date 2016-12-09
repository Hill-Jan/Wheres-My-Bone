/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.PrintWriter;
import wheresmybone.WheresMyBone;

/**
 *
 * @author tCalder
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = WheresMyBone.getOutFile();
    private static final PrintWriter logFile = WheresMyBone.getLogFile();
    
    public static void display(String className, String errorMessage) {
        
        errorFile.println(
                        "------------------------------------------------------"
                       +"\n" + errorMessage
                       +"\n----------------------------------------------------");
        //log error
        logFile.println(className + " - " + errorMessage);
    }
    
}
