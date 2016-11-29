/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.control.GameControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import wheresmybone.exceptions.GameControlException;



public class YourHouseView {
    
    private String description;
    private String lengthPrompt = "\nHow many feet long do you want to search"
                                + "\nEnter an number between 1 and 150";
    private String widthPrompt = "\nHow many feet wide do you want to search"
                                + "\nEnter a number between 1 and 50.";
    double width = 0.00;
    double length = 0.00;
    
    public YourHouseView(){
        
     this.description = "\n"
                      + "\n===================================================="
                      + "\nTime: (timeLeft)"
                      + "\nLocation:Your House"
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
        
        System.out.println("\n" + this.description);
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
            
            Scanner keyboard = new Scanner (System.in);
            boolean valid = false;
            double length = 0;
            
            while (!valid) {
                System.out.println("\n" + lengthPrompt);
                
                String lengthString = keyboard.nextLine();
                lengthString = lengthString.trim().toUpperCase();
                
                try {
                   length = Double.parseDouble(lengthString);
                } catch (NumberFormatException nf) {
                    System.out.println("\nYou must enter a valid number."
                                + " Try again\n");
                }
                if (length <1 || length > 150){
                    System.out.println("\nLength must be greater than 0 and less than 150.\n");
                }  else{
                        valid = true;
                }
            }
        return length;
    }
            
    private double getWidthInput(){
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double width = 0;
            
            while (!valid) {
                System.out.println("\n" + widthPrompt);
                
                String widthString = keyboard.nextLine();
                widthString = widthString.trim().toUpperCase();
                
               try { 
                   width = Double.parseDouble(widthString);
               } catch (NumberFormatException nf) {
                   System.out.println("\nYou must enter a valid number."
                                + " Try again.\n");
               }
               
                if (width <1 || width > 50){
                    System.out.println("\nWidth must be greater than 0 and less than 50.\n");
                }  else{
                        valid = true;
                }
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
            System.out.println(resultStr);
        } catch (GameControlException gc) {
            System.out.println(gc.getMessage());
        }
        return retVal;  
        
    }
}
            

            
    
    

