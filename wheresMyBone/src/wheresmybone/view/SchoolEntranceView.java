/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class SchoolEntranceView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
InputView input = new InputView();

    public SchoolEntranceView() {
        super("\n*********************************************************"
                + "\n    School Entrance  VIEW   "
                + "\n********************************************************"
                + "\n"
                + "\nYou come around the corner to the school entrance."
                + "\nThere are several children nearby playing."
                + "\nYou notice Brad, a lanky 10-year-old from your neighborhood,"
                + "\nfrantically searching for something.  "
                + "\n"
                + "\nWhat should you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nT - Talk to Brad."
                + "\nR - Return to Game Menu"
                + "\n********************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "T":
                this.talkToBrad();
                break;
            case "S":
                this.searchYourBackpack();
                return true;
            case "R":
                gameMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        gameMenu.display();
        return true;

    }

    private void talkToBrad() {
        input.schoolTalkToBrad();
    }

    public void searchYourBackpack() {
        input.schoolSearchYourBackpack();
    }

    private double timeLeft() {
                double travelTime = 20;
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
