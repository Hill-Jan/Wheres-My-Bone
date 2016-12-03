/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.Serializable;

/**
 *
 * @author tCalder
 */
public class HelpMenuView extends View {

    private String promptMessage;

    {

    }

    public HelpMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Help Menu                                     "
                + "\n -------------------------------------------------"
                + "\nP - How to Play"
                + "\nM - How to Move"
                + "\nN - Scene Names by Map Symbol"
                + "\nC - Clues"
                + "\nO - Objects"
                + "\nH - How to Save/Load Game"
                + "\nB - Bad Guys"
                + "\nX - Exit Help Menu, return to Game Menu"
                + "\n --------------------------------------------------"
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert value to upper case

        switch (value) {
            case "P": //How to Play
                this.howPlay();
                break;
            case "M": //How to Move
                this.howMove();
                break;
            case "N":
                this.MapSymbolSceneName();
                break;
            case "C": //about Clues
                this.aboutClues();
                break;
            case "O": //about Objects
                this.aboutObjects();
                break;
            case "B": //about bad guys
                this.aboutBadGuys();
                break;
            case "H": //how to save/load game
                this.howSave();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;

    }

    /* startNewGame(): void
BEGIN
Create a new Game
Create a new Game Menu View
Display the Game Menu
END */

    private void howPlay() {
        this.console.println("\n-------------------------------------------------"
                + "\nHow to Play"
                + "\n-------------------------------------------------"
                + "\nAs you travel the map, talk to those you meet"
                + "\nand solve basic puzzles to get your precious bone"
                + "\nback. You will be presented with a map and asked "
                + "\nto choose a location to move to. Pick up items as"
                + "\nyou come upon them and interact with the game"
                + "\ncharacters to get clues as you look for the bone."
                + "\nYou may be asked for input to solve some simple  "
                + "\nmath puzzles. Your goal is to find the bone before"
                + "\n your time runs out! Watch out for the Dog Catcher!"
                + "\n"
                + "\n-------------------------------------------------"
        );
    }

    private void howMove() {
        this.console.println("\n-------------------------------------------------"
                + "\nHow to Move"
                + "\n-------------------------------------------------"
                + "\nWhen you are presented with the map grid, pick a "
                + "\nlocation and input the two-letter Map Symbol shown"
                + "\n on the map. You will then be moved to that location"
                + "\n and be able to continue your quest for the bone."
                + "\n"
                + "\n-------------------------------------------------"
        );
    }

    private void aboutClues() {
        this.console.println("\n-------------------------------------------------"
                + "\nAbout Clues"
                + "\n-------------------------------------------------"
                + "\nAs you advance through the game you will meet"
                + "\ncharacters in various locations on the map."
                + "\nThese characters, or their surroundings, may give"
                + "\nyou clues to finding your bone. You'll have to"
                + "\ndecide if they're trying to help you, or throw you"
                + "\noff the trail!"
        );
    }

    private void aboutObjects() {
        this.console.println("\n-------------------------------------------------"
                + "\nAbout Objects"
                + "\n-------------------------------------------------"
                + "\nEach location on the map has an object at it for"
                + "\nyou to find. When you find an item you can pick"
                + "\nit up and put it in your Backpack. Later, when"
                + "\nencounter another character on the map, you may"
                + "\nneed some of these items to gain your clues."
        );
    }

    private void aboutBadGuys() {
        this.console.println("\n-------------------------------------------------"
                + "\nAbout Bad Guys"
                + "\n-------------------------------------------------"
                + "\nCat DeVil Gang: DeVil, the neighbor cat, has"
                + "\nalways been on the watch list for a number of"
                + "\ncrimes in the area. Due to her posse and quick"
                + "\ntongue, she has always been able to avoid getting"
                + "\ncaught. Keep an eye out for her and her gang as"
                + "\nthey will not be too happy with you trying to get"
                + "\nyour bone back."
                + "\n"
                + "\nDog Catcher: He randomly moves around from"
                + "\nsquare to square. If you encounter him, he will"
                + "\ntake you to the pound. This will cost valuable"
                + "\ntime, making it harder to retrieve your precious"
                + "\nin time!"
        );
    }

    private void howSave() {
        this.console.println("\n"
                + "\nHow to Save"
                + "\n-------------------------------------------------"
                + "\nIn order to save your game, open the game menu,"
                + "\npress 'X' to exit to the Main Menu,and press 'S'."
                + "\nEnter your desired filed name. This will save your "
                + "\ngame. When you are ready to comeback and start taking"
                + "\n a bite out of crime again, Press 'L' in the Main Menu "
                + "\nand then enter the name you gaveyour saved game."
                + "\n This will load your saved game.");
    }

    private void MapSymbolSceneName() {
        MapSymbolSceneName sceneFromSymbol = new MapSymbolSceneName();
        //display
        sceneFromSymbol.display();
    }

}
