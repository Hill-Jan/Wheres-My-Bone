/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import wheresmybone.control.GameControl;
import wheresmybone.WheresMyBone;
import wheresmybone.exceptions.GameControlException;



public class YourHouseView {
    
    private String description;
    private String lengthPrompt = "\nHow many feet long do you want to search"
                                + "\nEnter an number between 1 and 150";
    private String widthPrompt = "\nHow many feet wide do you want to search"
                                + "\nEnter a number between 1 and 50.";
    double width = 0.00;
    double length = 0.00;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();
    public YourHouseView(){
        
     this.description ="\n===================================================="
                     + "\n"
                     + "\nLocation:Your House"
                     + "\nTime Left: " + timeLeft()
                     + "\n"
                     + "\n"
                     + "\nAfter finding your precious bone gone, you decide to"
                     + "\nsearch the backyard. You know that the first 24"
                     + "\nhours are the most critical. You know you need to"
                     + "\nget on the trail as soon as possible."
                     + "\n"
                     + "\nThe yard is 50 feet wide by 150 feet long"
                     + "\n"
                     + "\nHow much of the yard to you want to search?"
                     + "\nIf you choose to search too much of the yard, you"
                     + "\n run out of time!"
                     + "\n====================================================";
                    
            }

    
    public void displayYourHouseView() {
        
        this.console.println("\n" + this.description);
        getAllInput();
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }
    public void getAllInput() {
        length = getLengthInput();
        if (length > 0) {
            width = getWidthInput();
        }
        if (length > 0 && width > 0) {
            this.doAction();
        }
    }
    private double getLengthInput(){
            
            boolean valid = false;
            double length = 0;
        try {  
            while (!valid) {
                this.console.println("\n" + lengthPrompt);
                
                String lengthString;
                
                    lengthString = keyboard.readLine();
                
                lengthString = lengthString.trim().toUpperCase();
                
                try {
                   length = Double.parseDouble(lengthString);
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                                + " Try again\n");
                }
                if (length <1 || length > 150){
                    ErrorView.display(this.getClass().getName(),"\nnLength must be greater than 0 and less than 150.\n");
                }  else{
                        valid = true;
                }
            }
            } catch (IOException ex) {
                   ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
                }
        return length;
    }
            
    private double getWidthInput(){

        boolean valid = false;
        double width = 0;
        try {    
            while (!valid) {
                this.console.println("\n" + widthPrompt);
                
                String widthString;
            
                widthString = keyboard.readLine();
            
                widthString = widthString.trim().toUpperCase();
                
               try { 
                   width = Double.parseDouble(widthString);
               } catch (NumberFormatException nf) {
                   ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                                + " Try again.\n");
               }
               
                if (width <1 || width > 50){
                    ErrorView.display(this.getClass().getName(),"\nWidth must be greater than 0 and less than 50.\n");
                }  else{
                        valid = true;
                }
            }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading inpu: " + ex.getMessage());
            }
        return width;
    }
     
    private boolean doAction() {
     boolean retVal = false;   
     double timeLeft = 0;
     
   
        try {
            //String formatted = df.format (timeLeft);
            GameControl calcArea = new GameControl();
            String resultStr = calcArea.calcAreaTime(length, width);
            this.console.println(resultStr);
        } catch (GameControlException gc) {
            ErrorView.display(this.getClass().getName(),gc.getMessage());
        }
        return retVal;  
        
    }
        public double timeLeft() {
        double travelTime = 0;
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
            

            
    
    

