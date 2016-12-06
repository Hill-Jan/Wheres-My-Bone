
        package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import wheresmybone.WheresMyBone;
import wheresmybone.control.CalculationControl;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.CalculationControlException;
import wheresmybone.exceptions.GameControlException;

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
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public VacantHouseView() {
        this.description = "\n"
                + "\n---------------------------------------------"
                + "\nVacant House"
                + "\nTime Left: " + timeLeft()
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

        this.console.println("\n" + this.description);      
            getAllInput(); 
            RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }

    private void getAllInput() {
        boxLength = getLengthInput();
        if (boxLength > 0) {
            boxWidth = getWidthInput();
            if (boxWidth > 0 || boxWidth < -1) {
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

        boolean valid = false;
        double length = 0;

    try {
        while (!valid) {
            this.console.println("\n" + lengthPrompt);
            
            String lengthString;
            
            lengthString = keyboard.readLine();
            
            lengthString = lengthString.trim().toUpperCase();
            
            if (lengthString.equals("Q"))
                break;
            
            try {
            length = Double.parseDouble(lengthString);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                            + "Try again or enter -1 to quit.\n");
            }
            if (length == -1) {
               break;//exit the loop
            }  else if (length < 1 || length > 1000) {
                ErrorView.display(this.getClass().getName(),"\nPlease enter a measurement greater than 0 and less than 1000\n");
            } else {
                valid = true;
            }
        }
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
            }
        return length;
    }

    private double getWidthInput() {

        boolean valid = false;
        double width = 0;
    
    try {
        while (!valid) {
            this.console.println("\n" + widthPrompt);

            String widthString;
            
                widthString = keyboard.readLine();
           
            widthString = widthString.trim().toUpperCase();
            
            if (widthString.equals("Q"))
                break;
            
            try {
                width = Double.parseDouble(widthString);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                           + " Try again or enter -1 to quit.\n");
            }

            if (width == -1) {
                break;//exit the loop
            } else if (width < 1 || width > 1000) {
                ErrorView.display(this.getClass().getName(),"\nPlease enter a measurement greater than 0 and less than 1000\n");
            } else {
                valid = true;
            }
        }
         } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
            }
        return width;
    }

    private double getHeightInput() {

        boolean valid = false;
        double height = 0;
    try {
        while (!valid) {
            this.console.println("\n" + heightPrompt);

           String heightString;
            
                heightString = keyboard.readLine();
            
           heightString = heightString.trim().toUpperCase();
           
           if (heightString.equals("Q"))
               break;
           
           try {
               height = Double.parseDouble(heightString);
           } catch (NumberFormatException nf) {
               ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                          + "Try again or enter -1 to quit.\n");
           }

            if (height == -1) {
                break;//exit the loop
            } else if (height < 1 || height > 1000) {
                ErrorView.display(this.getClass().getName(),"\nPlease enter a measurement greater than 0 and less than 1000\n");
            } else {
                valid = true;
            }
        }
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading input " + ex.getMessage());
            }
        return height;
    }
    private boolean doAction() {
       boolean retVal = false;
        //CalculationControl calcVolumeBox = new CalculationControl();
        try {
            String resultStr = CalculationControl.calcVolumeBox(boxLength, boxWidth, boxHeight);
            this.console.println(resultStr);
        } catch (CalculationControlException ce) {
            ErrorView.display(this.getClass().getName(),ce.getMessage());
        }
        return retVal;
    }
    public double timeLeft() {
        double travelTime = 20;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        return timeLeft;
}
}