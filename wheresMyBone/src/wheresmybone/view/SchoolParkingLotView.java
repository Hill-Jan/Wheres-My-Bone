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
 * @author Sexy Mario
 */
public class SchoolParkingLotView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
InputView input = new InputView();

    public SchoolParkingLotView() {
        super("\n*********************************************************"
                + "\n                 School Parking Lot   "
                + "\n********************************************************"
                + "\n"
                + "\nJust to the north of the playground and building is a large"
                + "\nparking lot.  It’s where the teachers park.  Oddly, the"
                + "\ngate on this side is unattended.  The gate on the street"
                + "\nside, however, has a parking guard.  Mr. Sneed is a nice"
                + "\nman.  He’s tall and broad with black hair, graying a little"
                + "\nat the temples.  His dark eyes are rather mysterious, but "
                + "\nthe ladies in town talk about him a lot!"
                + "\n"
                + "\nYou approach the guard booth carefully.  He looks down at"
                + "\nyou when you sit."
                + "\n"
                + "\nHey, there!  Where’d you come from?”\n" 
                + "\nOver there, you nod."
                + "\n“So, see anything interesting?”" 
                + "\n“Not really.”" 
                + "\n“Man, I wish you had something to eat in that backpack of yours!”"
                + "\nMr. Sneed chuckles. Of course, I don't eat dog food"
                + "\nAs you listen to the man, you notice a piece of paper"
                + "\nup against the fence"
                + "\n********************************************************"
                + "\nS - Search Your Backpack"
                + "\nG - Get Paper"
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
                this.getPaper();
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
        input.parkingLotSearchYourBackpack();
    }

    private void getPaper() {
        input.parkingLotGetPaper();
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
