
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.control.CalculationControl;

/**
 *
 * @author tCalder
 */
public class VacantHouseView {

    private String lengthPrompt = "\nPlease enter the length of the box:";
    private String widthPrompt = "\nPlease enter the width of the box:";
    private String heightPrompt = "\nPlease enter the height of the box:";
    private String description; 
    private String message;
    private double boxLength = 0;
    private double boxWidth = 0;
    private double boxHeight = 0;
    
        public VacantHouseView(){
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
}

  

    private double getLengthInput() {
        
        Scanner keyboard = new Scanner (System.in);
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + lengthPrompt);
        
            this.boxLength = keyboard.nextDouble();
            
            if (boxLength <1){
                System.out.println("\nPlease enter a measurement greater than 0");
            }
        }
            return boxLength; 
        
}
    private double getWidthInput() {
        
        Scanner keyboard = new Scanner (System.in);
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + widthPrompt);
        
            this.boxWidth = keyboard.nextDouble();
            
            if (boxWidth <1){
                System.out.println("\nPlease enter a measurement greater than 0");
            }
        }    
            return boxWidth;
    }
    
    private double getHeightInput() {
        
        Scanner keyboard = new Scanner (System.in);
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + heightPrompt);
        
            this.boxHeight = keyboard.nextDouble();
            
            if (boxHeight <1){
                System.out.println("\nPlease enter a measurement greater than 0");
            }
        }
            return boxHeight;
    }
        
    

    private double doAction(double volume){
        volume = boxVolume();
        
        if (volume = -1) {
            System.out.println("That box is too small for Cat DeVil to hide in.");
        }
        if (volume = 1) {
            System.out.println("This box was a perfect place for Cat DeVil to take nap. You found a slimy hairball!");
        }
        
    }
    
/*needs to take boxLength, boxWidth, and boxHeight and pass them into the calcVolumeBox() from Calculation Control.
  if the boxVolume is less than 216 "Overall volume is too small. There's no way DeVil could have been in this box", else "This box was a perfect place for DeVil to take a snooze. You found a slimy hairball." */
 
    private double boxVolume() {
        //create boxVolume object
        CalculationControl calcVolumeBox = new CalculationControl();
        double boxVolume = calcVolumeBox.calcVolumeBox(boxLength, boxWidth, boxHeight);
        return boxVolume;
    }
}
