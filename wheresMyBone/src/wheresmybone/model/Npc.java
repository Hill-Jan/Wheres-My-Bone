/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author short
 */
public class Npc implements Serializable {

    public Npc() {
    }

    public enum Npcs {

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
        Gorillas("GORILLA ENCLOSURE"),
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

        Npcs(String npcLocation) {
            this.npcLocation = npcLocation;
            location = new Point(1, 1);
        }

        public String getNpcLocation() {
            return npcLocation;
        }

        public Point getLocation() {
            return location;
        }

    }
}
