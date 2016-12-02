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
 * @author Dan
 */
public class Game implements Serializable{
    
    private int startTime;
    private double bestTime;
    private String instructions;
    private Time time;
    private Player player;
    private Backpack backpack;
    private Map map;
    
    public Game() {
        instructions = "";
        backpack = new Backpack();
        
    }
        
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

     public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public Map getMap() {
        return this.map;
    }

    @Override
    public String toString() {
        return "Game{" + "startTime=" + startTime + ", bestTime=" + bestTime + ", instructions=" + instructions + "time=" + time + ", player=" + player + ", backpack=" + backpack + ", map=" + map + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.startTime;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.bestTime) ^ (Double.doubleToLongBits(this.bestTime) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.instructions);
        hash = 17 * hash + Objects.hashCode(this.time);
        hash = 17 * hash + Objects.hashCode(this.player);
        hash = 17 * hash + Objects.hashCode(this.backpack);
        hash = 17 * hash + Objects.hashCode(this.map);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.startTime != other.startTime) {
            return false;
        }
        if (Double.doubleToLongBits(this.bestTime) != Double.doubleToLongBits(other.bestTime)) {
            return false;
        }
        if (!Objects.equals(this.instructions, other.instructions)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        return Objects.equals(this.map, other.map);
    }

    

   
    }

