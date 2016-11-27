/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.control.GameControl;
import java.text.DecimalFormat;

/**
 *
 * @author Dan
 */


public class YourHouseView {
    
    private String description;
    
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
                      + "\nThe yard is 50 feet wide by 100 feet long"
                      + "\n"
                      + "\nHow much of the yard to you want to search?"
                      + "\n====================================================";
                    
            }

    
    public void displayYourHouseView(){
        
        System.out.println("\n" + this.description);
        getInputYard();
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }
    
    public void getInputYard (){
            double width = 0.00;
            double length = 0.00;
            Scanner keyboard = new Scanner (System.in);
            boolean valid = false;
            String lengthPrompt = "\nHow many feet long do you want to search"
                                + "\nEnter an number between 1 and 100";
            while (!valid) {
                System.out.println("\n" + lengthPrompt);
                
                length = keyboard.nextDouble();
                valid = true;
                if (length <= 1 || length > 100){
                    System.out.println("\nLength is invalid. Try Again.");
                    valid = false;
            }            
        }
            valid = false;
            String widthPrompt = "\nHow many feet wide do you want to search"
                                + "\nEnter a number between 1 and 50.";
            while (!valid) {
                System.out.println("\n" + widthPrompt);
                valid = true;
                
                width = keyboard.nextDouble();
                if (width < 1 || width > 50){
                    System.out.println("\nWidth invalid. Try Again.");
                    valid = false;
                }
            }
     
    GameControl calcArea = new GameControl();
    
    double area = calcArea.calcAreaTime(length, width);
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format (area);
        System.out.println("\nYou have " + formatted + " minutes left");
            if (area > 1420 ) {
                System.out.println("\nIn your haste you didn't find any clues");
            }
            else if (area <= 1420) {
                System.out.println("\nYou found a clump of cat fur."
                                  +"\nYou would recognize this fur anywhere"
                                  +"\nIt's none other than the fur of DeVil");
    }
    }
    }
            

            
    
    

