/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String name;

    public Item(String name, String startScene, String description) {
        this.name = name;
        this.startScene = startScene;
        this.description = description;
        associatedNpc = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String item) {
        this.name = name;
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.startScene);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.associatedNpc);
        hash = 29 * hash + Objects.hashCode(this.name);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.startScene, other.startScene)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.associatedNpc, other.associatedNpc)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "startScene=" + startScene + ", description=" + description + ", associatedNpc=" + associatedNpc + ", name=" + name + '}';
    }
   

    public static ArrayList<Item> createItemList() {
        //created ArrayList of items
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("twig", "Park", "You"));
        items.add(new Item("pebble", "Pond", "Tommy"));
        items.add(new Item("collar", "Pound", "DeVil"));
        items.add(new Item("doughnuts", "Bakery", "Mr. Sneed"));
        items.add(new Item("snow globe", "Zoo Entrance", "Mr. Stealletti"));
        items.add(new Item("treat", "Drive-In", "You"));
        items.add(new Item("bone", "Nursing Home", "You"));
        items.add(new Item("name tag", "Animal Hospital", "Collar"));
        items.add(new Item("meal", "Restaurant", "Miss Ellie"));
        items.add(new Item("card", "Crocery Warehouse", "Smiths"));
        items.add(new Item("fish", "Fishmonger", "Tigers"));
        items.add(new Item("peanuts", "School Cafeteria", "Elephants"));
        items.add(new Item("ball", "School Playground", "Gorrillasl"));
        items.add(new Item("paper", "School Entrance", "Brad"));

        return items;
    }
    
    
}
