/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Npc;
import wheresmybone.model.Player;
import wheresmybone.model.Scene;
import wheresmybone.model.Time;

/**
 *
 * @author Sexy Mario
 */
public class WheresMyBone {
    
    public static void teamTest() {
        
    Player userName = new Player();
        
        userName.setName("Chuck Whiffendiffer");
        userName.setGender("Male");
        
        String userInfo = userName.toString();
        System.out.println(userInfo);
     
    }

    public static void tifTest() {
        Backpack userBackpack = new Backpack();
        
        userBackpack.setItemName("Whistle");
        
        String backpackItem = userBackpack.toString();
        System.out.println(backpackItem);
        
        Item whistle = new Item();
        
        whistle.setName("Cat Collar");
        whistle.setDescription("Red cat collar found at the pound");
        
        String itemInfo = whistle.toString();
        System.out.println(itemInfo);
        
        Npc fishMonger = new Npc();
        
        fishMonger.setName("Mr. Catch");
        fishMonger.setDialogue("I've saved a fresh fish, just for you.");
        fishMonger.setItemGiven("fish");
        fishMonger.setItemReceived("none");
        fishMonger.setClue("I haven't seen DeVil today.");
        
        String fishMongerInfo = fishMonger.toString();
        System.out.println(fishMongerInfo);
        
        Npc dogCatcher = new Npc();
        
        dogCatcher.setName("Evil Dude");
        dogCatcher.setDialogue("Come here, boy. I won't hurt you!");
        dogCatcher.setItemGiven("none");
        dogCatcher.setItemReceived("none");
        dogCatcher.setClue("You're my first dog of the day! All I've been seeing are devilsh CATS.");
        
        String dogCatcherInfo = dogCatcher.toString();
        System.out.println(dogCatcherInfo);
    }
    
    public static void janTest() {
        
        //Map test
        Map userName = new Map();
        
        userName.setRowCount("C");
        userName.setColumnCount(3);
        userName.setTravelTime (5);
        
        String userInfo = userName.toString();
        System.out.println(userInfo);
        
        //Scene Test
        Scene sceneInfo = new Scene();
        
        sceneInfo.setSceneName("SCHOOL CAFETERIA");
        sceneInfo.setSceneDescript("You are in the cafeteria.  Brad is here.");
        sceneInfo.setNpcDescription("Brad is short with red hair and freckles.");
        
        String sceneInfoTest = sceneInfo.toString();
        System.out.println(sceneInfoTest);
        
        //Location Test
        Location LocationInfo = new Location();
        
        LocationInfo.setRow("A");
        LocationInfo.setColumn(3);
        LocationInfo.setVisited(">>>>");
        LocationInfo.setNpcName("Brad");
        LocationInfo.setScene("POND");
        LocationInfo.setCalculations(19);
        
        String locationOne = LocationInfo.toString();
        System.out.println(locationOne);
        
    }
    
    public static void danTest(){
        Game gameOne = new Game();
            
            gameOne.setStartTime(24);
            gameOne.setBestTime(12.1);
            gameOne.setAttribute("Kilroy's game");
            gameOne.setInstructions("press (H) to get help");
            
        
        String gameOneInfo = gameOne.toString();
        System.out.println(gameOneInfo);
         
        Time gameTime = new Time();
            
            gameTime.setTotalTime(24.0);
            gameTime.setTimeSubtracted(10.0);
            
        String gameTimeInfo = gameTime.toString ();
        System.out.println(gameTimeInfo);
        
    }
   
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        teamTest();
        tifTest();
        janTest();
        danTest();
    }
    
   
}
