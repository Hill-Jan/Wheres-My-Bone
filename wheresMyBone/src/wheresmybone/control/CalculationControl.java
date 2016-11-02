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
    public double calcVolumeBox(double length, double width, double height){
        //box volume calculation
        double volumeBox = length * width * height;
        
        if (volumeBox < 216) {
                return -1;
            }
            
            if (volumeBox >= 216) {
            return 1;
            }
            return volumeBox;
            
            // end calcVolumeBox by Tif Calder
    }   
   
    //Cylinder Calculations by Jan Hill
    public double calcCylinderVolume(double height, double diameter) {

        
    if (height <= 0 || height >20) {//height is negative or too large
            return -1;
                }
	if (diameter <= 0 || diameter > 16) {//diameter is negative or too large
            return -1;
            }

        // calculation of the volume
	double radius = diameter/2;
	double volume =(Math.PI*radius*radius*height)/1728;
	return volume;

    //end of calculation of cylinder volume
    }
    
    
}
