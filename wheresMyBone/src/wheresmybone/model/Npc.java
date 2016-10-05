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
public class Npc implements Serializable{
    
    //class instance variables
    private String name;
    private String dialogue;
    private String itemGiven;
    private String itemReceived;
    private String clue;

    public Npc() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getItemGiven() {
        return itemGiven;
    }

    public void setItemGiven(String itemGiven) {
        this.itemGiven = itemGiven;
    }

    public String getItemReceived() {
        return itemReceived;
    }

    public void setItemReceived(String itemReceived) {
        this.itemReceived = itemReceived;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.dialogue);
        hash = 59 * hash + Objects.hashCode(this.itemGiven);
        hash = 59 * hash + Objects.hashCode(this.itemReceived);
        hash = 59 * hash + Objects.hashCode(this.clue);
        return hash;
    }

    @Override
    public String toString() {
        return "NPC{" + "name=" + name + ", dialogue=" + dialogue + ", itemGiven=" + itemGiven + ", itemReceived=" + itemReceived + ", clue=" + clue + '}';
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
        final Npc other = (Npc) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dialogue, other.dialogue)) {
            return false;
        }
        if (!Objects.equals(this.itemGiven, other.itemGiven)) {
            return false;
        }
        if (!Objects.equals(this.itemReceived, other.itemReceived)) {
            return false;
        }
        if (!Objects.equals(this.clue, other.clue)) {
            return false;
        }
        return true;
    }
    
    
}
