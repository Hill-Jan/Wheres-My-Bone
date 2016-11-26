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
    int height = 0;
    int diameter = 0;

    public GiraffesView() {
        this.description = "\n"
                + "\n------------------------------------------"
                + "\n  The Giraffe Enclosure at the Zoo"
                + "\n------------------------------------------"
                + "\n"
                + "\nYou have arrived at a very large and deep"
                + "\nenclosure in the zoo.  Tan and brown heads "
                + "\nlook down at you from over the fence.  The"
                + "\ngiraffes wonder what happened to your neck."
                + "\nAfter exchanging pleasantries, one giraffe"
                + "\ntells he saw DeVil over by the feed cylinder."
                + "\nGo take a look."
                + "\n------------------------------------------";
    }

    public void displayGiraffesView() {

        System.out.println("\n" + this.description);
        getAllInput();

        RoomMenuView roomMenuView = new RoomMenuView();
        roomMenuView.display();
    }

   private void getAllInput() {
        height = getHeight();
        if (height > 0 && height < 20) {
            diameter = getDiameter();
        }
        if (height > 0 && height <= 20 && diameter > 0 && diameter <= 20) {
            this.doAction();
        }
        //if (height < 0 || diameter < 0){
        //System.out.println("\nYou chose a negative number. Canceling Cylinder Volume");}
    }
   
   private String getHeightInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String height = null;
        String heightprompt = "\nHow tall is the cylinder?"
                + "\nEnter a number between 1 and 20, or enter -1 to cancel.";

        while (!valid) {
            System.out.println("\n" + heightprompt);

            height = keyboard.nextLine();
            height = height.trim();
            
            if (height.length() < 1) {
                System.out.println ("\n Invalid value: value cannot be blank");
            }
           else {
                valid = true;
            }
        }
        return height;
   }
        
    public int getHeight() {
        
        while (height == 0) {
            String value = this.getHeightInput();
            value = value.trim().toUpperCase();
            boolean valid = false;
            
            try{
                height = Integer.parseInt(value);}
            catch (NumberFormatException nf){
                System.out.println("\nYou must enter a valid number."
                        + "\nTry again or input -1 to quit.");
            }
            
            /*if (height == -1) {
                return -1;//exit the loop
            }  else if (height < 1 || height > 20) {
                System.out.println("\nPlease enter a measurement greater than 0 or less than 20, or enter -1 to cancel.");
            } else {
                valid = true;
            }
               break;*/
        }
        return height ;
    }
    
    private String getDiameterInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String diameter = null;
        String diameterprompt = "\nHow wide is the cylinder across?"
                + "\nEnter a number between 1 and 16, or enter -1 to cancel.";

        while (!valid) {
            System.out.println("\n" + diameterprompt);

            diameter = keyboard.nextLine();
            diameter = diameter.trim();
            
            if (diameter.length() < 1) {
                System.out.println ("\n Invalid value: value cannot be blank");
            }
            else {
                valid = true;
            }
        }
        return diameter;
    }

    public int getDiameter() {

        while (diameter == 0) {

            String value = this.getDiameterInput();
            value = value.trim().toUpperCase();
            boolean valid = false;
            
            try {
                diameter = Integer.parseInt(value);
            } catch (NumberFormatException nf) {

                System.out.println("\nYou must enter a valid number."
                        + "\nTry again or -1 to quit.");
            }
            
            /*if (diameter == -1) {
                return -1;//exit the loop
            }  else if (diameter < 1 || diameter > 20) {
                System.out.println("\nPlease enter a measurement greater than 0 or less than 16, or enter -1 to cancel.");
            } else {
                valid = true;
            }
            break;*/
        }
        return diameter;
    }
    
    private void doAction() {
        //CalculationControl calcVolumeBox = new CalculationControl();
        try {
            CalculationControl.calcCylinderVolume(height, diameter);
        }
        catch (CalculationControlException cce) {
            System.out.println(cce.getMessage());
        }
        
    }

}
