/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl.SceneType;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Player;
import wheresmybone.model.Scene;
//import wheresmybone.model.Scene.SceneType;
import wheresmybone.model.Time;

/**
 *
 * @author Jan
 */
public class GameControl {

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

    double timeLeft;

    public GameControl() {
        timeLeft = 1440;

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

    public static ArrayList<Item> createItemList() {
        //created ArrayList of items
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("twig", "Park", "a twig on the ground"));
        items.add(new Item("pebble", "Pond", "pebble from the pond"));
        items.add(new Item("collar", "Pound", "cat collar"));
        items.add(new Item("doughnuts", "Bakery", "sticky doughnuts"));
        items.add(new Item("snow globe", "Neighbor's House", "snow globe"));
        items.add(new Item("treat", "Drive-In", "special treat"));
        items.add(new Item("bone", "Unknown", "favorite bone"));
        items.add(new Item("name tag", "Animal Hospital", "cat name tag"));
        items.add(new Item("meal", "Restaurant", "delicious free meal"));
        items.add(new Item("card", "Zoo", "punch card"));
        items.add(new Item("fish", "Fishmonger", "fresh fish"));
        items.add(new Item("peanuts", "School Cafeteria", "salty peanuts"));
        items.add(new Item("ball", "School Playground", "bouncy ball"));
        items.add(new Item("paper", "School Entrance", "piece of paper"));

        return items;
    }

    /*createNewGame(Player player): int
BEGIN
 if (player == null)
 return -1
 create a new game
 save the game in CuriousWorkmanship
 get player from CuriousWorkmanship
 save player in the game
 create list of inventory items
 save inventory list in game
 create the wagon
 save wagon in the game
 create the ship
 save ship in the game
 create the map
 save map in the game */
    public static void createNewGame(Player player) {
        Game game = new Game(); //create new game
        WheresMyBone.setCurrentGame(game); // save in WheresMyBone

        game.setPlayer(player); //save player in the game

        Time time = new Time(); //create the start time
        game.setTime(time); //save time in game

        Backpack backpack = new Backpack(); //create backpack
        player.setBackpack(backpack); //save backpack in game

        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map); //save map in game

        //move actors to starting position in the map
        MapControl.movePlayerToStartingLocation(map);
    }

    // calculate time left to complete game  
    /* ****Bro Jones: we haven't implemented this one anywhere yet
    so the "throws" isn't actually throwing it anywhere.*/
    public double calcTimeLeft(double travelTime)
            throws GameControlException {

        timeLeft -= travelTime;
        if (timeLeft <= 0) {
            throw new GameControlException("\nYou are out of time.\n");
        }
         return timeLeft;
    }

    // calculate the area for the user to investigate and how much time is spent in the investigation.
    public String calcAreaTime(double length, double width) throws GameControlException {
        double timeLeft = 200.0;
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(timeLeft);
        double area = length * width;
        timeLeft = timeLeft - area * 2.4 / 60;
        if (timeLeft > 0 && timeLeft <= 1420) {
            return ("\nYou have " + timeLeft + " minutes remaining. "
                    + "\nYou found a clump of cat fur."
                    + "\nYou would recognize this fur anywhere"
                    + "\nIt's none other than the fur of DeVil");
        }

        throw new GameControlException("\nIn your haste you didn't find any clues, and you're out of time.");

    }

}
