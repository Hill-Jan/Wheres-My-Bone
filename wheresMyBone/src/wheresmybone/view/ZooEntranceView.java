/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;

/**
 *
 * @author Sexy Mario
 */
public class ZooEntranceView extends View {

    private String promptMessage;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public ZooEntranceView() {
        super("\n"
                + "\n---------------------------------------------"
                + "\nZoo Entrance"
                + "\n---------------------------------------------"
                + "\nNot too far from your house is the local zoo.  It’s on a "
                + "\nstretch of land on the outskirts of town.  It’s fenced all"
                + "\naround, except at the entry.  The tall white walls are connected"
                + "\nat the top with a wide metal arch that says “City Zoo.”  "
                + "\nYou wander in behind some tourists.  Several white buildings"
                + "\nare right there in the front.  One is a restroom, one is an "
                + "\ninformation booth, and one is a souvenir shop.  Hmmm.  If I "
                + "\nwere DeVil, where would I go?"
                + "\n"
                + "\nThe restroom is smelly.  You can smell it from here.  Humans "
                + "\nmust have a poor sense of smell.  The information booth wouldn’t"
                + "\nhave any place to hide a bone.  Must be the souvenir shop.  "
                + "\nLuckily, the door opens just as you get near it."
                + "\n"
                + "\nInside are rows and racks full of zoo-type memorabilia.  Stuffed"
                + "\nanimals, books, canes, lights, postcards, toys, games, and much,"
                + "\nmuch more.  Unfortunately, you don’t smell your bone.  You approach"
                + "\nthe cashier station and find $10 on the ground.  Looking around, "
                + "\nyou don’t see anyone it could have belonged to.  You look up at"
                + "\nthe cashier station to see Mr. Nono there.  He’s a cute oriental"
                + "\nfellow who smiles all the time."
                + "\n"
                + "\n“Hi, " + StartProgramView.player.getName() + "!  Can I interest you in something?  These Snowglobes"
                + "\nare a hot seller right now.”"
                + "\n"
                + "What do you do?"
                + "\n*****************************************************************"
                + "\nG – Get the snowglobe    T – talk some more      X – Leave the area"
                + "\n******************************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "G":
                this.getSnowglobe();
                break;
            case "T":
                this.talkSomeMore();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void getSnowglobe() {
        this.console.println("\nThe snowglobes are pretty.  There’s one with a pink ribbon"
                + "\nand polar bears playing in the snow."
                + "\n“Is $10 enough?\""
                + "\n“Yep.  I can waive the tax for you.”\n"
                + "\nYou pick up the $10 off the floor and hand it to Mr. Nono."
                + "\nHe puts the snowglobe in your backpack."
                + "\n\"Have you seen DeVil?  I think he took my bone.”"
                + "\n“DeVil?  No.  I haven’t seen him.  Maybe Mr. Catch at the"
                + "\nFishmonger station has seen him.  You know how much cats like fish.”"
                + "\n"
                + "\nWhere to next?");
        this.console.println("\n*** puts the snowglobe in your backpack");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }

    private void talkSomeMore() {
        this.console.println("]\n“Have you seen DeVil?  I think he took my bone.”"
                + "\n“DeVil?  No.  I haven’t seen him.  Maybe Mr. Catch at the "
                + "\nFishmonger station has seen him.  You know how much cats like fish.”"
                + "\n"
                + "\nWhere to next?");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
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
