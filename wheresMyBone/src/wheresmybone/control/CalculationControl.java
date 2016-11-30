/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import java.io.Serializable;
import java.text.DecimalFormat;

import wheresmybone.exceptions.CalculationControlException;

/**
 *
 * @author Jan
 */
public class CalculationControl {

    // calcVolumeBox coded by Tif Calder
    public static String calcVolumeBox(double length, double width, double height)
            throws CalculationControlException {
        //box volume calculation
        double volumeBox = length * width * height;
        if (volumeBox > 216) {
            return ("\nThis box was a perfect place for Cat DeVil to take a nap. You found a slimy hairball!\n");
        }
        
            throw new CalculationControlException("\nThat box is to small for cat DeVil to fit into.\n");
        
    }

    //Cylinder Calculations by Jan Hill
    public static String calcCylinderVolume(double height, double diameter) throws CalculationControlException {

        // calculation of the volume
        double radius = diameter / 2;
        double volume = Math.PI * radius * radius * height;
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(volume);

        if (volume >= 157.08 && volume <= 603.19) {
            return("\nVolume is " + formatted + "."
                    + "\nYour bone could be there.  Search for your bone.");
        }
        if (volume > 603.19) {
            return ("\nVolume is " + formatted + "."
                    + "\nThe cylinder is too big for your bone.");
        }
        
            throw new CalculationControlException("\nVolume is " + formatted + "."
                    + "\nThe cylinder is too small for your bone.");
        

        //end of calculation of cylinder volume
        
    }

}
