/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import wheresmybone.model.Backpack;
import wheresmybone.model.Item;
import wheresmybone.model.Npc;
import wheresmybone.model.Player;

/**
 *
 * @author Sexy Mario
 */
public class WheresMyBone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Player userName = new Player();
        
        userName.setName("Chuck Whiffendiffer");
        userName.setGender("Male");
        
        String userInfo = userName.toString();
        System.out.println(userInfo);
      
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
    }
    
   
}
