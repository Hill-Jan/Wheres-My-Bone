/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import wheresmybone.WheresMyBone;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Map;
import wheresmybone.model.Player;
import wheresmybone.model.Time;

/**
 *
 * @author Jan
 */
public class GameControl {

    double timeLeft;
    public GameControl (){
        timeLeft = 1440;
    
    }
    public static Player createPlayer(String name) {
        if (name == null ){
            return null;
            }
        Player player = new Player();
        player.setName(name);
 
        WheresMyBone.setPlayer(player); //creates the player
        
        return player;
        
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
    public double calcTimeLeft(double travelTime) {

  
        if (timeLeft<=0) {
            return -1;
         }
        if (travelTime<0) {
            return -1;
        }

       timeLeft -= travelTime;
       if (timeLeft <= 0) {
             return -1;
       }
       return timeLeft;
       }
    
    // calculate the area for the user to investigate and how much time is spent in the investigation.
    public double calcAreaTime(double length, double width) {
        
        if (length <=0){
            return -1;
        }
        if (length>100){
            return -1;
        }
        if (width <=0) {
            return -1;
        }
        if (width >50) {
            return -1;
        }
        
        timeLeft = timeLeft - length * width * 2.4 / 60;
        
        return timeLeft;
    }
    
    }
