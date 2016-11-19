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
public class Item implements Serializable{
   
    //class instance variables
    private String startScene;
    private String description;
    private String associatedNpc;
    private String item;

    public Item() {
    }

    public Item(String item, String startScene, String description) {
        this.item = item;
    }
    

    public String getStartScene() {
        return this.startScene;
    }

    public void setStartScene(String startScene) {
        this.startScene = startScene;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssociatedNpc() {
        return this.associatedNpc;
    }

    public void setAssociatedNpc(String associatedNpc) {
        this.associatedNpc = associatedNpc;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.startScene);
        hash = 61 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + startScene + ", description=" + description + '}';
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.startScene, other.startScene)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
}
