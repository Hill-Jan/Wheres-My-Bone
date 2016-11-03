
package wheresmybone.view;

import java.text.DecimalFormat;
import java.util.Scanner;
import wheresmybone.control.CalculationControl;

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
}

public void getInputCylinder (){
        Scanner keyboard = new Scanner (System.in);
        boolean valid = false;
        String heightprompt = "\nHow tall is the cylinder?"
                            + "\nEnter a number between 1 and 20.";
        while (!valid)
            System.out.println("\n" + heightprompt);
        
            double height = keyboard.nextDouble();
            if (height < 1 || height > 20){
                System.out.println("\nHeight is invalid. Try Again.");
            } 
        String diameterprompt = "\nHow wide is the cylinder across?"
                              + "\nEnter a number between 1 and 16.";

            System.out.println("\n" + diameterprompt);
        
            double diameter = keyboard.nextDouble();
            if (diameter < 1 || diameter > 16){
                System.out.println("\nWidth invalid. Try Again.");
            }

        CalculationControl volumeCalc = new CalculationControl();
        Double volume = volumeCalc.calcCylinderVolume(height, diameter);
            DecimalFormat df = new DecimalFormat("#.##");
            String formatted = df.format(volume);
            System.out.println("\nVolume of Cylinder is " + formatted);
                if (volume < 157.08) {
                    System.out.println("\nThe cylinder is too small for your bone.");
                }
                if (volume > 603.19) {
                    System.out.println ("\nThe cylinder is too big for your bone.");
                }
                else {
                    System.out.println ("\nYour bone could be there.  Search for your bene.");
                }
}
        //List Room Menu

}