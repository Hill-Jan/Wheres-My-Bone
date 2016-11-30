/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;
import java.awt.Point;

/**
 *
 * @author short
 */

public class Npc {

    public enum Npcs{
    
    //keywords and dialogue
    Tommy("PARK"),
    OfficerPete("POLICE STATION"),
    DrMice("ANIMAL HOSPITAL"),
    MrSam("POUND"),
    MsJones("BAKERY"),
    MrSteele("RESTAURANT"),
    MsCocoa("DRIVE IN"),
    Tom_Rex_Kit("DEVILS HOUSE"),
    MissEllie("CARE HOME"),
    MrNono("ZOO"),
    MrCatch("FISH MARKET"),
    Elephants("ELEPHANT ENCLOSURE"),
    Kangaroos("KANGAROO ENCLOSURE"),
    Giraffes("GIRAFFE ENCLOSURE"),
    Brad("SCHOOL ENTRANCE"),
    MrSneed("PARKING LOT"),
    Tigers("TIGER ENCLOSURE");
    
    //class instance variables
    private final String npcLocation;
    //private final String itemGiven;
    //private final String itemReceived;
    //private final String clue;
    private final Point location;

    Npcs(String npcLocation/*, String itemGiven, String itemReceived, String clue*/) {
        this.npcLocation = npcLocation;
        /*this.itemGiven = itemGiven;
        this.itemReceived = itemReceived; // not sure on this, added because we were getting an error saying itemReceived not initialized
        this.clue = clue; // not sure on this, added because we were getting an error saying clue not initialized*/
        location = new Point(1,1);
        
    }

    public String getNpcLocation() {
        return npcLocation;
    }

    /*public String getItemGiven() {
        return itemGiven;
    }

    public String getItemReceived() {
        return itemReceived;
    }

    public String getClue() {
        return clue;
    }*/

    public Point getLocation() {
        return location;
}
    
}
}
