/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl.SceneType;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Player;
import wheresmybone.model.Scene;
import wheresmybone.view.LostView;
import wheresmybone.view.Welcome;
//import wheresmybone.model.Scene.SceneType;

/**
 *
 * @author Jan
 */
public class GameControl {
    
    double startTime = 1440;

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        // start point
        locations[0][0].setScene(scenes[SceneType.park.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.vacanthouse.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.police.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.animalhospital.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.pound.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.bakery.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.restaurant.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.drivein.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.pond.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.alley.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.carehome.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.neighborshouse.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.yourhouse.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.devilshouse.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.grocerywarehouse.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.zoo.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.elephants.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.tigers.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.gorillas.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.giraffes.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.schoolentrance.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.schoolcafeteria.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.schoolplayground.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.schoolparkinglot.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.fishmonger.ordinal()]);

    }


    public GameControl() {

    }

    public static void saveGame(Game game, String filePath)
            throws GameControlException {

        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);

            output.writeObject(game); // write the game object out to file
        } catch (Exception e) {
            Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, e);
            throw new GameControlException(e.getMessage());
        }

    }

    public static void loadSavedGame(String filePath)
            throws GameControlException {
        Game game = null;

        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);

            game = (Game) input.readObject(); //read the game object from file
        } catch (Exception ex) {
            throw new GameControlException(ex.getMessage());
        }

        //close the output file
        WheresMyBone.setCurrentGame(game); //save in WheresMyBone
    }

    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);

        WheresMyBone.setPlayer(player); //creates the player

        return player;

    }

    public static void createNewGame(Player player) {
        Game game = new Game(); //create new game
        WheresMyBone.setCurrentGame(game); // save in WheresMyBone

        game.setPlayer(player); //save player in the game

        Backpack backpack = new Backpack(); //create backpack
        player.setBackpack(backpack); //save backpack in game

        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map); //save map in game

        //move actors to starting position in the map
        MapControl.movePlayerToStartingLocation(map);
    }

    // calculate time left to complete game  
    public double calcTimeLeft(double travelTime)
            throws GameControlException {
        Game game = WheresMyBone.getCurrentGame();
        double timeLeft = game.getTimeLeft();
        timeLeft -= travelTime;
        if (timeLeft <= 0) {
            throw new GameControlException("\nYou are out of time.\n");
        //    this.displayBanner();
        }
        game.setTimeLeft(timeLeft);
        return timeLeft;
    }
    
    private void displayBanner() {
       LostView.displayBanner();
        }
    // calculate the area for the user to investigate and how much time is spent in the investigation.
    public String calcAreaTime(double length, double width) throws GameControlException {
        
        double area = length * width;
        double searchTime = area*2.4/60;
        double timeLeft = calcTimeLeft(searchTime);
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(timeLeft);
        String searchTimeFormatted = df.format(searchTime);
        if (timeLeft >= 0  && timeLeft <= 1440) {
            return ("\nThis search will take you " + searchTimeFormatted + " minutes.\n"
                    + "\nYou have " + formatted + " minutes remaining.\n"
                    + "\nYou found a clump of cat fur."
                    + "\nYou would recognize this fur anywhere"
                    + "\nIt's none other than the fur of DeVil");
        }

        throw new GameControlException("\nIn your haste you didn't find any clues, and you're out of time.");

    }

}
