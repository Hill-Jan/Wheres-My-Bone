/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;
import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author short
 */
public enum Npc implements Serializable{
    
    //keywords and dialogue
    Tommy("Park"),
    OfficerPete("Police Station"),
    DrMice("veterinarian"),
    MrSam("dogcatcher"),
    MsJones("baker"),
    MrSteele("Owns the restaurant"),
    MsCocoa("Runs the drive-in"),
    Tom_Rex_Kit("DeVil Gang"),
    MissEllie("nice old lady"),
    MrNono("zoo keeper"),
    MrCatch("fishmongerer"),
    Elephants("Elephant Enclosure"),
    Kangaroos("Kangaroo Enclosure"),
    Giraffes("Giraffe Enclosure"),
    Brad("lost his homework"),
    MrSneed("parking lot attendant"),
    Tigers("Tiger Enclosure");
    
    //class instance variables
    private final String npcLocation;
    //private final String itemGiven;
    //private final String itemReceived;
    //private final String clue;
    private final Point location;

    Npc(String npcLocation/*, String itemGiven, String itemReceived, String clue*/) {
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
