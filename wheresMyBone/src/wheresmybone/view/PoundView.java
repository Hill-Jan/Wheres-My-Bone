/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.view;

import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class PoundView extends View {
    //private String promptMessage;{
//}

    public PoundView() {
        super("\n*********************************************************"
                + "\n    THE POUND   "
                + "\n********************************************************"
                + "\n"
                + "\nYou approach the City Shelter slowly.  Mr. Sam isn’t "
				+ "\nexactly kind to dogs wandering on their own.  You look"
				+ "\ninto the glass front door to see him sitting at his desk. "
				+ "\nYou take a deep breath and gather up some courage.  Worst"
				+ "\ncase scenario, he takes you home.  "
				+ "\n"
				+ "\nCarefully you paw at the front door.  Mr. Sam looks up and"
				+ "\nscowls at you.  He gets up and comes to the door.  "
				+ "\n"
				+ "\n\"“\" + StartProgramView.player.getName() +\", what are you doing"
				+ "\nhere?  Where’s your owner?” he asks."
				+ "\n“I’m…looking for DeVil.  Have you seen him?”"
				+ "\n“DeVil!  Why are you looking for him?  You’re not causing fights,"
				+ "\nare you?” the older man warned."
				+ "\n“No, but I think he took my bone.”"
				+ "\n“Ah!  That would explain it.  Well, I’ve seen him.  I took him "
				+ "\nhome about an hour ago.  Actually, wait!  His collar fell off, "
				+ "\nand I forget to return it to his owners.  Would you return it for me?”"
                + "\n"
                + "\n********************************************************"
                + "\nG - Get Collar"
                + "\nX - Leave the Area!"
                + "\n********************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "G":
                this.getCollar();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void getCollar() {
        Item newItem = new Item("Collar", "Animal Hospital", "DeVil");
        StartProgramView.player.addToBackpack(newItem);
		this.console.println("Hmmm.  Looks like this needs a name tag.");
                this.giveItem();
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
			         
    }
    private void giveItem() {
        String newItem = "Nametag";
	StartProgramView.player.giveItem(newItem);
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
			 
	}
    
    public double timeLeft() {
        double travelTime = 30;
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
		