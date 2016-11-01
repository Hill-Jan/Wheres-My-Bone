
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

//private double getBoxVolume(length,width,height){
    


    private double getLengthInput() {
        
        Scanner keyboard = new Scanner (System.in);
        double boxLength = 0;
        boolean valid = false;
        
        while (!valid)
            System.out.println("\n" + lengthPrompt);
        
            boxLength = keyboard.nextDouble();
            
            if (boxLength <4){
                System.out.println("\nWidth invalid. DeVil won't fit into such a short box.");
            }
            return boxLength;    
        
}
    private double getWidthInput() {
        
        Scanner keyboard = new Scanner (System.in);
        double boxWidth = 0;
        boolean valid = false;
        
        while (!valid)
            System.out.println("\n" + widthPrompt);
        
            boxWidth = keyboard.nextDouble();
            
            if (boxWidth <4){
                System.out.println("\nWidth invalid. DeVil won't fit into such a narrow box.");
            }
            return boxWidth;
    }
    
    private double getHeightInput() {
        
        Scanner keyboard = new Scanner (System.in);
        double boxHeight = 0;
        boolean valid = false;
        
        while (!valid)
            System.out.println("\n" + heightPrompt);
        
            boxHeight = keyboard.nextDouble();
            
            if (boxHeight <4){
                System.out.println("\nWidth invalid. DeVil won't fit into such a short box.");
            }
            return boxHeight;
    }

    private double doAction(boxLength){
        return this.boxVolume();
    }
    

    private double boxVolume() {
        //create boxVolume object
        CalculationControl calcVolumeBox = new CalculationControl();
        calcVolumeBox.calcVolumeBox(boxLength, boxWidth, boxHeight);
    }
}
