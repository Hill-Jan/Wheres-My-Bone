package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.control.CalculationControl;

/**
 *
 * @author tCalder
 */
public class VacantHouseView {

    private String lengthPrompt = "\nPlease enter the length of the box, or enter -1 to cancel:";
    private String widthPrompt = "\nPlease enter the width of the box, or enter -1 to cancel:";
    private String heightPrompt = "\nPlease enter the height of the box, or enter -1 to cancel:";
    private String description;
    private double boxLength = 0;
    private double boxWidth = 0;
    private double boxHeight = 0;

    public VacantHouseView() {
        this.description = "\n"
                + "\n---------------------------------------------"
                + "\nVacant House"
                + "\n---------------------------------------------"
                + "\nYou come upon the old house that's up for"
                + "\nsale. It's beat up with windows broken, but"
                + "\nthat won't stop Cat DeVil. In the kitchen you"
                + "\nfind a box. Looking inside the box may give"
                + "\na clue, but first you must decide if the box"
                + "\nis even big enough for DeVil to hide in."
                + "\n---------------------------------------------";
    }

    public double displayVacantHouseView() {

        System.out.println("\n" + this.description);
        double volume = getAllInput();
        return volume;//if return is >0, box was big enough for DeVil; if <0, box was too small for DeVil
    }

    private double getAllInput() {
        boxLength = getLengthInput();
        if (boxLength > 0) {
            boxWidth = getWidthInput();
            if (boxWidth > 0) {
                boxHeight = getHeightInput();
            }
        }
        if (boxLength > 0 && boxWidth > 0 && boxHeight > 0) {
            return this.doAction();
        }

        System.out.println("\nYou chose -1. Canceling box Volume");
        return -1;
    }

    private double doAction() {
        double volume = boxVolume();

        if (volume == -1) {
            System.out.println("That box is too small for Cat DeVil to hide in.");
        } else {
            System.out.println("This box was a perfect place for Cat DeVil to take a nap. You found a slimy hairball!");
        }
        //System.out.println(volume <0 ? "That box is too small for Cat DeVil to hide in." : "This box was a perfect place for Cat DeVil to take a nap. You found a slimy hairball!");
        return volume;
    }

    /*needs to take boxLength, boxWidth, and boxHeight and pass them into the calcVolumeBox() from Calculation Control.
  if the boxVolume is less than 216 "Overall volume is too small. There's no way DeVil could have been in this box", else "This box was a perfect place for DeVil to take a snooze. You found a slimy hairball." */
    private double boxVolume() {
        //create boxVolume object
        CalculationControl calcVolumeBox = new CalculationControl();
        double boxVolume = calcVolumeBox.calcVolumeBox(boxLength, boxWidth, boxHeight);
        return boxVolume;
    }

    private double getLengthInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double length = 0;

        while (!valid) {
            System.out.println("\n" + lengthPrompt);

            length = keyboard.nextDouble();

            if (length == -1) {
                return -1;//exit the loop
            }  else if (length < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (length > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return length;

    }

    private double getWidthInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double width = 0;
        while (!valid) {
            System.out.println("\n" + widthPrompt);

            width = keyboard.nextDouble();

            if (width == -1) {
                return -1;//exit the loop
            } else if (width < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (width > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return width;
    }

    private double getHeightInput() {

        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        double height = 0;

        while (!valid) {
            System.out.println("\n" + heightPrompt);

            height = keyboard.nextDouble();

            if (height == -1) {
                return -1;//exit the loop
            } else if (height < 1) {
                System.out.println("\nPlease enter a measurement greater than 0");
            } else if (height > 1000) {
                System.out.println("\nPlease enter a measurement less than 1000");
            } else {
                valid = true;
            }
        }
        return height;
    }
}
