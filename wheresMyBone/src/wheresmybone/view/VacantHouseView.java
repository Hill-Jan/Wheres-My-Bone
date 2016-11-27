
        package wheresmybone.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import wheresmybone.control.CalculationControl;
import wheresmybone.exceptions.CalculationControlException;

/**
 *
 * @author tCalder
 */
public class VacantHouseView {

    private String lengthPrompt = "\nPlease enter the length of the box, or enter -1 to cancel:";
    private String widthPrompt = "\nPlease enter the width of the box, or enter -1 to cancel:";
    private String heightPrompt = "\nPlease enter the height of the box, or enter -1 to cancel:";
    private String description;
    private double boxLength = 0;
    private double boxWidth = 0;
    private double boxHeight = 0;

    public VacantHouseView() {
        this.description = "\n"
                + "\n---------------------------------------------"
                + "\nVacant House"
                + "\n---------------------------------------------"
                + "\nYou come upon the old house that's up for"
                + "\nsale. It's beat up with windows broken, but"
                + "\nthat won't stop Cat DeVil. In the kitchen you"
                + "\nfind a box. Looking inside the box may give"
                + "\na clue, but first you must decide if the box"
                + "\nis even big enough for DeVil to hide in."
                + "\n---------------------------------------------";
    }

    public void displayVacantHouseView() {

        System.out.println("\n" + this.description);
        try {       
            getAllInput();
        } catch (CalculationControlException ex) {
            System.out.println(ex.getMessage());
        } 
        finally {RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();}
    }

    private void getAllInput() throws CalculationControlException {
        boxLength = getLengthInput();
        if (boxLength > 0) {
            boxWidth = getWidthInput();
            if (boxWidth > 0) {
                boxHeight = getHeightInput();
            }
        }
        if (boxLength > 0 && boxWidth > 0 && boxHeight > 0) {
            this.doAction();
        }
    }

    /*needs to take boxLength, boxWidth, and boxHeight and pass them into the calcVolumeBox() from Calculation Control.
  if the boxVolume is less than 216 "Overall volume is too small. There's no way DeVil could have been in this box", else "This box was a perfect place for DeVil to take a snooze. You found a slimy hairball." */
    

    private double getLengthInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double length = 0;

        while (!valid) {
            System.out.println("\n" + lengthPrompt);
            
            String lengthString = keyboard.nextLine();
            lengthString = lengthString.trim().toUpperCase();
            
            if (lengthString.equals("Q"))
                break;
            
            try {
            length = Double.parseDouble(lengthString);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number."
                            + "Try again or enter Q to quit.\n");
            }
            if (length == -1) {
                return -1;//exit the loop
            }  else if (length < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (length > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return length;

    }

    private double getWidthInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double width = 0;
        
        while (!valid) {
            System.out.println("\n" + widthPrompt);

            String widthString = keyboard.nextLine();
            widthString = widthString.trim().toUpperCase();
            
            if (widthString.equals("Q"))
                break;
            
            try {
                width = Double.parseDouble(widthString);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number."
                           + "Try again or enter Q to quit.\n");
            }

            if (width == -1) {
                return -1;//exit the loop
            } else if (width < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (width > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return width;
    }

    private double getHeightInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double height = 0;

        while (!valid) {
            System.out.println("\n" + heightPrompt);

           String heightString = keyboard.nextLine();
           heightString = heightString.trim().toUpperCase();
           
           if (heightString.equals("Q"))
               break;
           
           try {
               height = Double.parseDouble(heightString);
           } catch (NumberFormatException nf) {
               System.out.println("\nYou must enter a valid number."
                          + "Try again or enter Q to quit.\n");
           }

            if (height == -1) {
                return -1;//exit the loop
            } else if (height < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (height > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return height;
    }
    private void doAction() throws CalculationControlException {
        //CalculationControl calcVolumeBox = new CalculationControl();
            CalculationControl.calcVolumeBox(boxLength, boxWidth, boxHeight);
    }

}
