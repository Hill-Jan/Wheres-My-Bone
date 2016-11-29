package wheresmybone.view;

import java.util.Scanner;
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

        System.out.println("\n" + this.description);
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
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double height = 0;

        String heightprompt = "\nHow tall is the cylinder?"
                + "\nEnter a number between 1 and 20.";
        while (!valid) {
            System.out.println("\n" + heightprompt);

            String heightString = keyboard.nextLine();
            heightString = heightString.trim().toUpperCase();
            if (heightString.equals("Q")) {
                break;
            }

            valid = true;
            try {
                height = Double.parseDouble(heightString);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number."
                        + "Try again or enter Q to quit.\n");
            }
            if (height == -1) {
                return -1; //exit loop
            } else if (height < 1 || height > 20) {
                System.out.println("\nHeight is invalid. Try Again.");
                valid = false;
            }

        }
        return height;
    }

    private double getDiameter() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double diameter = 0;
        String diameterprompt = "\nHow wide is the cylinder across?"
                + "\nEnter a number between 1 and 16.";

        while (!valid) {
            System.out.println("\n" + diameterprompt);

            String diameterString = keyboard.nextLine();
            diameterString = diameterString.trim().toUpperCase();
            if (diameterString.equals("Q")) {
                break;
            }

            valid = true;
            try {
                diameter = Double.parseDouble(diameterString);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number."
                        + "Try again or enter Q to quit.\n");
            }
            if (diameter == -1) {
                return -1; //exit loop
            } else if (diameter < 1 || diameter > 16) {
                System.out.println("\nDiameter is invalid. Try Again.");
                valid = false;
            }
            /* if (height > 0 && height < 20 && diameter > 0 && diameter < 16) {
            this.doAction();
        }*/
        }
        return diameter;
    }

    public boolean doAction() {
        boolean retVal = false;
        try {
            String resultStr = CalculationControl.calcCylinderVolume(height, diameter);
            System.out.println(resultStr);
            if (resultStr.contains("too big"))
            System.out.println(resultStr);
        } catch (CalculationControlException ce) {
            System.out.println(ce.getMessage());
        }
        return retVal;
    }
}
