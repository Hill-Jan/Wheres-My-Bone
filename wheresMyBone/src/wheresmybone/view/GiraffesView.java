package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import wheresmybone.WheresMyBone;
import wheresmybone.control.CalculationControl;
import wheresmybone.exceptions.CalculationControlException;

/**
 *
 * Jan Hill
 */
public class GiraffesView {

    private String description;
    private Double diameter;
    private Double height;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public GiraffesView() {
        this.description = "\n"
                + "\n------------------------------------------"
                + "\n  The Giraffe Enclosure at the Zoo"
                + "\n------------------------------------------"
                + "\n"
                + "\nYou have arrived at a very large and deep"
                + "\nenclosure in the zoo.  Tan and brown heads "
                + "\nlook down at you from over the fence.  "
                + "\n\"What happened to your neck?\" one giraffe asks."
                + "\n "
                + "\n\"Nothing,\" you reply.  \"It's always been like this.\""
                + "\n "
                + "\n\"Oh!\" the giraffe responds and looks at the others.  \"Sorry.\""
                + "\n "
                + "\n\"By any chance have you seen DeVil around with a bone?\" you ask."
                + "\n "
                + "\nAfter talking with the other giraffes, the giraffe answers,"
                + "\n\"Mikiri says he saw DeVil over by the feed cylinder."
                + "\nYou might want to take a look.\""
                + "\n------------------------------------------";
    }

    public void displayGiraffesView() {

        this.console.println("\n" + this.description);
        getInputCylinder();
        RoomMenuView roomMenuView = new RoomMenuView();
        roomMenuView.display();
    }

    public void getInputCylinder() {
        height = getHeight();
        if (height > 0) {
            diameter = getDiameter();
        }
        if (height > 0 && diameter > 0) {
            this.doAction();
        }
    }

    private double getHeight() {
        
        boolean valid = false;
        double height = 0;

        String heightprompt = "\nHow tall is the cylinder?"
                + "\nEnter a number between 1 and 20.";
        try {
        while (!valid) {
            this.console.println("\n" + heightprompt);

            String heightString;
            
                heightString = keyboard.readLine();
            
            heightString = heightString.trim().toUpperCase();
            if (heightString.equals("Q")) {
                break;
            }

            valid = true;
            try {
                height = Double.parseDouble(heightString);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                        + " Try again or enter Q to quit.\n");
            }
            if (height == -1) {
                return -1; //exit loop
            } else if (height < 1 || height > 20) {
                ErrorView.display(this.getClass().getName(),"\nHeight must be greather than 1 and less than 20.\n");
                valid = false;
            }

        }
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
            }
        return height;
    }

    private double getDiameter() {
        
        boolean valid = false;
        double diameter = 0;
        String diameterprompt = "\nHow wide is the cylinder across?"
                + "\nEnter a number between 1 and 16.";

    try {
        while (!valid) {
            this.console.println("\n" + diameterprompt);

            String diameterString;
            
                diameterString = keyboard.readLine();
            
            diameterString = diameterString.trim().toUpperCase();
            if (diameterString.equals("Q")) {
                break;
            }

            valid = true;
            try {
                diameter = Double.parseDouble(diameterString);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                        + "Try again or enter Q to quit.\n");
            }
            if (diameter == -1) {
                return -1; //exit loop
            } else if (diameter < 1 || diameter > 16) {
                ErrorView.display(this.getClass().getName(),"\nWidth must be greater than 1 and less than 16.\n");
                valid = false;
            }
            /* if (height > 0 && height < 20 && diameter > 0 && diameter < 16) {
            this.doAction();
        }*/
        }
        } catch (IOException ex) {
                Logger.getLogger(GiraffesView.class.getName()).log(Level.SEVERE, null, ex);
            }
        return diameter;
    }

    public boolean doAction() {
        boolean retVal = false;
        try {
            String resultStr = CalculationControl.calcCylinderVolume(height, diameter);
            this.console.println(resultStr);
            if (resultStr.contains("too big"))
            this.console.println(resultStr);
        } catch (CalculationControlException ce) {
            this.console.println(ce.getMessage());
        }
        return retVal;
    }
}
