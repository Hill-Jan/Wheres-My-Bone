/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.view;

import java.io.Serializable;
import wheresmybone.WheresMyBone;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class ThePark extends View {
    //private String promptMessage;{
//}

    public ThePark() {
            super("\n*********************************************************"
                + "\n    THE PARK   "
                + "\n********************************************************"
                + "\n"
                + "\nYou decide to check out the park.  As you follow the nice, "
				+ "\ntree-lined path, you hear the voices of the children playing."
				+ "\nThere’s an old couple sitting on a park bench feeding the "
				+ "\npidgeons.  A bit further down, you spot Tommy.  Tommy is a fun"
				+ "\n12-year-old with dark hair and kind green eyes.  Maybe he’s "
				+ "\nseen DeVil."
				+"\n"
				+"\nYou approach Tommy with a wag of your tail."
				+"\n“Hi, " + StartProgramView.player.getName()+ "!  How’s your day?” "
				+"\nhe asks with a pet on your head.  Ahhh!  “I was just looking for "
				+"\nnew pebbles for my collection. Hey look!”  Tommy pick up a "
				+"\ngood-sized stick from the ground.  “Wanna play fetch?”  He throws"
				+"\nthe stick.  “Go get it!"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nF - Fetch the Stick."
                + "\nS - Search your Backpack"
                + "\nX - Leave the Park"
                + "\n********************************************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "F":
                this.fetchTheStick();
                break;

            case "S":
                this.searchYourBackpack();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void fetchTheStick() {
        this.promptMessage = ("\nYou race after the stick with eager anticipation. "
				+ "\nYou love to play fetch!  Quickly to get the stick and bring it"
				+ "\nback to Tommy.  He happily throws it again and again.  After a"
				+ "\nwhile you see a cat come out of the trees.  Huh?  Oh, no! You"
				+ "\nneed to find DeVil and your bone!"
                                + "\n"
                                + "\n"
                                + "\nWhat will you do?"
                                + "\n"
                                + "\n***************************************************************"
                                + "\nS - Search your Backpack                  X – Leave the Area;"
                                + "\n****************************************************************");
    }

    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        /* ArrayList<Item> item = new ArrayList<>();
       item = GameControl.createItemList();
        //StringBuilder line;

        this.console.println("\n       Inventory");
        //line = new StringBuilder("          ");
        int j=0;
            for(j=0; j<item.size(); j++){
            //line.insert(0, "Item");
            this.console.println(j + "   " + item.get(j).getName() );
            }

       ArrayList<Item> backpack = new ArrayList<>();*/

        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "pebble";
        Item item = backpack.GiveItem(itemName);

   
        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\nYou find the pebble you found at the pond. "
                    + "\n“How's this one?” you ask."
                    + "\n“What?  Oh, " + StartProgramView.player.getName() + "!  This is awesome!” "
                    + "\n\"I've never seen one like it! "
                    + "\n“Have you seen DeVil with a bone?” you ask."
                    + "\n“DeVil?  Last time I saw DeVil he was running"
                    + "\nin front of Officer Pete.  That was down the street some.”"
                    + "\n  Good luck!"
                    + "\n"
                    + "\n****************************************************"
                    + "\nWhere To Now?"
                    + "\n****************************************************");

        } else {
            this.console.println("\n\"Gee, I’m sorry, Tommy.  I don't have a pebble."
                    + "\nI’ll keep my eyes peeled.”"
                    + "\n\"Thanks, " + StartProgramView.player.getName() + ".”"
                    + "\n“You haven’t seen DeVil, have you?”"
                    + "\n“Not today,” Tommy shrugs.  "
                    + "\n“Sorry, \" + StartProgramView.player.getName() + \".\" "
                    + "\n"
                    + "\n****************************************************"
                    + "\nWhere To Now?"
                    + "\n****************************************************");
        }
    }
}
