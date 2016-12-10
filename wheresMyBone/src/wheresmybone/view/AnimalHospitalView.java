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
public class AnimalHospitalView extends View {
    //private String promptMessage;{
//}
    GameMenuView gameMenu = new GameMenuView();
    public AnimalHospitalView() {
        super("\n*********************************************************"
                + "\n             ANIMAL HOSPITAL   "               
                + "\n********************************************************"
                + "\n"
                + "\nYou begin to pass the Animal Hospital.  As you get up close,"
		+ "\nyou notice that kind Dr. Mice is outside taking a break.  "
		+ "\nShe’s a sweet, young veterinarian with long brown hair.  She "
		+ "\nlooks a little undernourished, but seems to be ok.  You wander"
		+ "\nup to her on the bench outside the hospital."
		+ "\n"
		+ "\n“Hey, "+ StartProgramView.player.getName() +"!  How are you today?” she greets you with a "
		+ "\nsmile and a scratch."
		+ "\n“I don’t know.”"
		+ "\n“What’s wrong?”"
		+ "\n“I think DeVil took my bone.  Have you seen him?”"
		+ "\n“DeVil?  No, but I found his nametag.  Here.  You can return it "
		+ "\nif you find him.  Maybe Mr. Sam at the Pound has seen him.  "
		+ "\nHe’s always watching out for that feline!”"
		+ "\n“Thanks.”"
                + "\n"
                + "\n********************************************************"
                + "\nG - Get nametag"
                + "\nR - Return to Game Menu"
                + "\n********************************************************"
        );
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "G":
                this.getItem();
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

    private void getItem() {
        Item newItem = new Item("Nametag", "Animal Hospital", "collar");
        StartProgramView.player.addToBackpack(newItem);
    }

    private double timeLeft() {
        double travelTime = 25;
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
