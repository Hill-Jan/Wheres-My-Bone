/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

/**
 *
 * @author Jan
 */
public class CalculationControl {
    
    // calcVolumeBox coded by Tif Calder
    public double calcVolumeBox(double height, double width, double length){
        if (height <= 0) {
            return -1;
        }
        
        if (width <= 0) {
            return -1;
        }
        
        if (length <= 0) {
            return -1;
        }
        
        double volumeBox = length * width * height;
            return volumeBox;
    }
}
// end calcVolumeBox by Tif Calder