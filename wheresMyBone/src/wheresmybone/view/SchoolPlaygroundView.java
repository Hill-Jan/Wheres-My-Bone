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
public class SchoolPlaygroundView extends View {
    //private String promptMessage;{
//}

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
                + "\nWhat will you do?"
                + "\n"
                + "\n********************************************************"
                + "\nP - Search Your playground"
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
            case "P":
                this.searchThePlayground();
                break;
            case "G":
                this.getTheBall();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void getTheBall() {
        Item ball = new Item("Ball", "School Playground", "Gorrillas");
        StartProgramView.player.addToBackpack(ball);
        this.console.println("You search through the playground.  Your trained nose can"
                +"\npick up the scent of a bone anywhere.  Unfortunately, all you found "
                +"\nwas a large red rubber ball. ");
   /*     RoomMenuView roomMenuView = new RoomMenuView();x
        roomMenuView.display();*/
    }

    public void searchThePlayground() {
        //Game game = WheresMyBone.getCurrentGame();
        //Backpack backpack = game.getPlayer().getBackpack();
       // String itemName = "meal";
       // Item item = backpack.GiveItem(itemName);

        {
            this.console.println("\nYou search through the playground. Your"
                    + "\ntrained nose can pick up the scent of a bone anywhere."
                    + "\nUnfortunately, all you found was a large red rubber ball"
                    + "\nDo you:"
                    + "\n"
                    + "\n****************************************************"
                    + "\nG - Get the ball"
                    + "\nX - Leave the Area"
                    + "\n****************************************************");

        }
        /*RoomMenuView roomMenuView = new RoomMenuView();
        roomMenuView.display();*/
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
