
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
    
           public GiraffesView () {
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
    getInputCylinder();
    
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
}

public void getInputCylinder (){
        double height = 0.00;
        double diameter = 0.00;
        Scanner keyboard = new Scanner (System.in);
        boolean valid = false;
        String heightprompt = "\nHow tall is the cylinder?"
                            + "\nEnter a number between 1 and 20.";
        while (!valid){
            System.out.println("\n" + heightprompt);
        
            height = keyboard.nextDouble();
            valid = true;
            if (height < 1 || height > 20){
                System.out.println("\nHeight is invalid. Try Again.");
                valid = false;
            } 
        }
        valid = false;
        String diameterprompt = "\nHow wide is the cylinder across?"
                              + "\nEnter a number between 1 and 16.";
        while (!valid){
            System.out.println("\n" + diameterprompt);
            valid = true;
            
            diameter = keyboard.nextDouble();
            if (diameter < 1 || diameter > 16){
                System.out.println("\nWidth invalid. Try Again.");
                valid = false;
            }
        }

        //CalculationControl volumeCalc = new CalculationControl();
        double volume = 0;
        try {CalculationControl.calcCylinderVolume(height, diameter);
            DecimalFormat df = new DecimalFormat("#.##");
            String formatted = df.format(volume);
            System.out.println("\nVolume of Cylinder is " + formatted);}
        catch (CalculationControlException cce) {
            System.out.println(cce.getMessage());
        }
                

    
}
}