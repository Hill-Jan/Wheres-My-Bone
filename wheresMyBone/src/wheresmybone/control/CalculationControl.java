/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import java.text.DecimalFormat;
import wheresmybone.exceptions.CalculationControlException;


/**
 *
 * @author Jan
 */
public class CalculationControl {
    
    // calcVolumeBox coded by Tif Calder
    public static void calcVolumeBox(double length, double width, double height)
                                throws CalculationControlException {
        //box volume calculation
        double volumeBox = length * width * height;
        if (volumeBox > 216) {
            System.out.println("This box was a perfect place for Cat DeVil to take a nap. You found a slimy hairball!");
        }
        if (volumeBox < 216) {
                throw new CalculationControlException("That box is to small"
                        + "\nfor cat DeVil to fit into.");
            }
        
    }   
   
    //Cylinder Calculations by Jan Hill
    public static double calcCylinderVolume(double height, double diameter) 
        throws CalculationControlException {
        
        // calculation of the volume
	double radius = diameter/2;
	double volume = Math.PI*radius*radius*height;
        DecimalFormat df = new DecimalFormat("#.##");
            String formatted = df.format(volume);
        
        if (volume >= 157.08 && volume <=603.19){
                    System.out.println ("\nVolume is " + formatted + "." 
                            + "\nYour bone could be there.  Search for your bone.");
                }
                else if (volume > 603.19) {
                    throw new CalculationControlException ("\nVolume is " + formatted + "."
                            + "\nThe cylinder is too big for your bone.");
                }
                else if (volume < 157.08) {
                    throw new CalculationControlException ("\nVolume is " + formatted + "."
                            + "\nThe cylinder is too small for your bone.");
                }

    //end of calculation of cylinder volume
    return volume;
    }
    
    
}
