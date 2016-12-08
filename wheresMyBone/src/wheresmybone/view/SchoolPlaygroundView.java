/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;

/**
 *
 * @author Sexy Mario
 */
public class SchoolPlaygroundView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
    public SchoolPlaygroundView() {
        super("\n********************************************************"
                + "\n                 The School Playground       "
                + "\n********************************************************"
                + "\nThe east side of the building holds the playground."
                + "\nThere's lots of children playing. How are you supposed"
                + "\nto check things out with all these kids?"
                + "\n"
                + "\nJust as you're about to give up, the bell rings."
                + "\nThe children all run inside the building. Thank Goodness!"
                + "\n"
                + "\nYou search through the playground. Your"
                + "\ntrained nose can pick up the scent of a bone anywhere."
                + "\nUnfortunately, all you found was a large red rubber ball"
                + "\nDo you:"
                + "\n"
                + "\n****************************************************"
                + "\nG - Get the ball"
                + "\nR - Return to Game Menu"
                + "\n****************************************************");
        this.console.println("\n*******************************"
                + "\nTime Left: " + timeLeft()
                + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "G":
                this.getTheBall();
                break;
            case "R":
                gameMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return true;

    }

    private void getTheBall() {
        InputView inputView = new InputView();
        inputView.schoolPlaygroundGetTheBall();
    }

    public double timeLeft() {
        double travelTime = 25;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return timeLeft;
    }
}
