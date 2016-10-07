/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import wheresmybone.model.Backpack;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Npc;
import wheresmybone.model.Player;
import wheresmybone.model.Scene;

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
      
        
        
        Location fishMarket = new Location();
        
        fishMarket.setRow("Z");
        fishMarket.setColumn(4);
        fishMarket.setVisited("No");
        fishMarket.setNpcName("Mr. Catch");
        fishMarket.setScene("outdoor fish market");
        fishMarket.setCalculations(0);
        
        String fishMarketInfo = fishMarket.toString();
        System.out.println(fishMarketInfo);
        
        Map gameMap = new Map();
        
        gameMap.setRowCount(5);
        gameMap.setColumnCount(5);
        gameMap.setTravelTime(12);
        
        String gameMapInfo = gameMap.toString();
        System.out.println(gameMapInfo);
        
        Scene fishMarketScene = new Scene();
        
        fishMarketScene.setSceneName("Fish Market");
        fishMarketScene.setSceneDescript("open air fish market");
        fishMarketScene.setNpcDescription("Mr. Catch");
        
        String fishMarketSceneInfo = fishMarketScene.toString();
        System.out.println(fishMarketSceneInfo);   
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //teamTest();
        tifTest();
    }
    
   
}
