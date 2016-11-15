/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author short
 */
public enum Npc implements Serializable{
    
    //keywords and dialogue
    Tommy("in the park"),
    OfficerPete("chasing a crook"),
    DrMice("veterinarian"),
    MrSam("dogcatcher"),
    MsJones("baker"),
    MrSteele("Owns the restaurant"),
    MsCocoa("Runs the drive-in"),
    Tom_Rex_Kit("DeVil Gang"),
    MissEllie("nice old lady"),
    MrNono("zoo keeper"),
    MrCatch("fishmongerer"),
    Elephants("gimme peanuts"),
    Kangaroos("gimme a ball"),
    Giraffes("food cylinder"),
    Brad("lost his homework"),
    MrSneed("parking lot attendant"),
    Tigers("gimme fish");
    
    //class instance variables
    private final String dialogue;
    private final String itemGiven;
    private final String itemReceived;
    private final String clue;
    private final Point location;

    Npc(String dialogue) {
        this.dialogue = dialogue;
        location = new Point(1,1);
    }

    public String getDialogue() {
        return dialogue;
    }

    public String getItemGiven() {
        return itemGiven;
    }

    public String getItemReceived() {
        return itemReceived;
    }

    public String getClue() {
        return clue;
    }

    public Point getLocation() {
        return location;
}

    @Override
    public String toString() {
        return "NPC{" + "name=" + name + ", dialogue=" + dialogue + ", itemGiven=" + itemGiven + ", itemReceived=" + itemReceived + ", clue=" + clue + '}';
    }
}
