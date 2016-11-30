/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import wheresmybone.WheresMyBone;

/**
 *
 * @author Sexy Mario
 */
public abstract class View implements ViewInterface {

    protected String promptMessage;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

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
            {
                break; //exit the game
            }            //do the requested action and display the next view
            done = this.doAction(value);

        } while (!done);

    }

    @Override
    public String getInput() {

        String value = null;
        boolean valid = false;

        try {
            while (!valid) {
                this.console.println("\n" + this.promptMessage);

                value = this.keyboard.readLine();
                value = value.trim();//removes spaces at front and end

                if (value.length() < 1) {
                    ErrorView.display(this.getClass().getName(),"\n Invalid value: value cannot be blank");
                    continue;
                }
                break;
            }
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
        }
        return value;

    }

}
