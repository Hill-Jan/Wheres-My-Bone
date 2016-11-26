package wheresmybone.view;

import java.text.DecimalFormat;
import java.util.Scanner;
import wheresmybone.control.CalculationControl;
import wheresmybone.exceptions.CalculationControlException;

/**
 *
 * Jan Hill
 */
public class GiraffesView {

    private String description;
    Double height = null;
    Double diameter = null;

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
        getCylinderHeight();
        getCylinderDiameter();
        Volume();

        RoomMenuView roomMenuView = new RoomMenuView();
        roomMenuView.display();
    }

    public String getHeightInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String value = null;
        String heightprompt = "\nHow tall is the cylinder?"
                + "\nEnter a number between 1 and 20.";

        while (!valid) {
            System.out.println("\n" + heightprompt);

            value = keyboard.nextLine();
            value = value.trim();//removes spaces at front and end
            
            if (value.length() < 1) {
                System.out.println("\n Invalid value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;
    }

    public Double getCylinderHeight() {

        while (height == null) {

            String value = this.getHeightInput();
            value = value.trim().toUpperCase();

            if (value.toUpperCase().equals("X")) {
                break;
            }

            try {
                height = Double.parseDouble(value);
            } catch (NumberFormatException nf) {

                System.out.println("\nYou must enter a valid number."
                        + "\nTry again or X to quit.");
            }

               /* if (height < 1 || height > 20) {
                    System.out.println("\nHeight is invalid. Try Again.");

                    return height;

                }*/
        }
        return height;
    }
    
    
    public String getDiameterInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String value = null;
        String diameterprompt = "\nHow wide is the cylinder across?"
                + "\nEnter a number between 1 and 16.";

        while (!valid) {
            System.out.println("\n" + diameterprompt);

            value = keyboard.nextLine();
            value = value.trim();//removes spaces at front and end
            
            if (value.length() < 1) {
                System.out.println("\n Invalid value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;
    }


    public Double getCylinderDiameter() {

        while (diameter == null) {

            String value = this.getDiameterInput();
            value = value.trim().toUpperCase();

            if (value.toUpperCase().equals("X")) {
                break;
            }

            try {
                diameter = Double.parseDouble(value);
            } catch (NumberFormatException nf) {

                System.out.println("\nYou must enter a valid number."
                        + "\nTry again or X to quit.");
            }
            /*if (diameter < 1 || diameter > 16) {
                System.out.println("\nWidth invalid. Try Again.");

                return diameter;

            }*/

        }
        return diameter;
    }

    public Double Volume() {
        //CalculationControl volumeCalc = new CalculationControl();
        double volume = 0;
        try {
            CalculationControl.calcCylinderVolume(height, diameter);
        } catch (CalculationControlException cce) {
            System.out.println(cce.getMessage());
        }
        return volume;

    }
}
