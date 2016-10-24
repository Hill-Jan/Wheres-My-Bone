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
public class GameControl {
    // calculate time left to complete game
    public double calcTimeLeft(double timeLeft, double travelTime) {

  
        if (timeLeft<=0) {
            return -1;
         }
        if (travelTime<0) {
            return -1;
        }

       timeLeft -= travelTime;
       if (timeLeft <= 0) {
             return -1;
       }
       return timeLeft;
       }
    
    // calculate the area for the user to investigate and how much time is spent in the investigation.
    public double calcAreaTime(double startTime, int length, int width, double timeInSeconds, double timeLeft) {
        
        if (length <=0){
            return -1;
        }
        if (length>50){
            return -1;
        }
        if (width <=0) {
            return -1;
        }
        if (width >30) {
            return -1;
        }
        
        timeLeft = startTime - length * width * 2.4 / 60 ;
        
        return timeLeft;
    }
    
    }
