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
public class CareHomeView extends View {
    //private String promptMessage;{
//}
    GameMenuView gameMenu = new GameMenuView();

    public CareHomeView() {
        super("\n*********************************************************"
                + "\n                 The NURSING HOME   "
                + "\n********************************************************"
                + "\n"
                + "\nThe Nursing Home where Miss Ellie stays was on the West side"
                + "\nof town.  It was a pretty white building with flowers all "
                + "\naround.  A few people came and went, but it really wasn’t very"
                + "\n busy.  Most of the people there just couldn’t take care of "
                + "\nthemselves anymore."
                + "\nYou walk through the sliding glass doors in the front of the"
                + "\n building and walk through the lobby.  Having visited Miss "
                + "\nEllie before, you turn down the first left corridor and go to"
                + "\nthe fourth door on your left.  You scratch at the door to get "
                + "\nher attention.  “Just a minute!” an elderly female voice called"
                + "\nfrom inside."
                + "\n"
                + "\n“Hi, " + StartProgramView.player.getName() + ",” an attendant "
                + "\ngreets you in the hallway.  “Visiting Ellie again?  Here, I’ll"
                + "\nopen the door for you.”  She opens the door and calls inside,"
                + "\n“Miss Ellie, you have a visitor!”"
                + "\n“Oh, Thank you, Carol,” the elderly woman calls from her recliner."
                + "\n“I was having trouble getting up.”"
                + "\nCarol closes the door behind you as you go to greet the old"
                + "\nwoman with thin gray hair and dim eyes. "
                + "\n\"Happy Birthday, Miss Ellie!\"" 
                + "\n“Oh, "+ StartProgramView.player.getName() +"!  It’s so"
                + "\ngood to see you!  How’ve you been?”"
                + "\n“I’m ok, I guess.  How are you?”"
                + "\n“Oh, I’m alright.  I’m hungry, but dinner isn’t for another couple"
                + "\nof hours.  You don’t have anything to eat, do you?”"
                + "\n"
                + "\n********************************************************"
                + "\nS - Search Your Backpack"
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
            case "S":
                this.searchYourBackpack();
                break;
            case "G":
                this.searchTheGarden();
                break;
            case "R":
                gameMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        gameMenu.display();
        return true;

    }

    public void searchYourBackpack() {
        InputView input = new InputView();
        input.careHomeSearchYourBackpack();
        return;
    }

    private void searchTheGarden() {
        InputView input = new InputView();
        input.careHomeSearchTheGarden();
    }
    
    public double timeLeft() {
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
