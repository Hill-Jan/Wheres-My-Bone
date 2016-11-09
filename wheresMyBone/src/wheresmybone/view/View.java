/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;

/**
 *
 * @author Sexy Mario
 */
public abstract class View implements ViewInterface {
    
    protected String promptMessage;
    
    public View() {
}
 
    public View(String message) {
        this.promptMessage = message;
    }
    
    @Override
    public void display() {
        
        boolean done = false; //set flag to not done
        do {
            String value = this.getInput();
            if (value.toUpperCase().equals("X")) // user wants to quit
                   break; //exit the game
            //do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done);
        
        }
    
    @Override
     public String getInput() {


        Scanner keyboard = new Scanner(System.in);
        String value = null;
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();//removes spaces at front and end
            
            if (value.length() < 1) {
                System.out.println("\n Invalid value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;       }
     
}
