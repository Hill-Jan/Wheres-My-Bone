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
public class Backpack implements Serializable{
    
    //Setting the ArrayList
    private ArrayList<Item> createItemList() {
        //created ArrayList of items
        ArrayList<Item> items = new ArrayList<>();

        
                       return items;}

    public String getItemName() {
        return itemName;
    }
    //class instance variables
    private String itemName;
      
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
   void AddItem(Item newItem) {
        items.Add(newItem);
        return this.newItem;
    }
    
   void String GiveItem(itemName) {
         int index = -1;
        for (int i=0; i<items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                index = i;
            }
        }
        items.remove(index);
        
        
   }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.itemName);
        return hash;
    }

    @Override
    public String toString() {
        return "Backpack{" + "itemName=" + itemName + '}';
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
        final Backpack other = (Backpack) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        return true;
    }
  
  /*   public static ArrayList<Item> createItemList() {
        //created ArrayList of items
        ArrayList<Item> items = new ArrayList<>();
        
        items.add(new Item("twig", "Park", "a twig on the ground"));
        items.add(new Item("pebble", "Pond", "pebble from the pond"));
        items.add(new Item("collar", "Pound", "cat collar"));
        items.add(new Item("doughnuts", "Bakery", "sticky doughnuts"));
        items.add(new Item("snow globe", "Neighbor's House", "snow globe"));
        items.add(new Item("treat", "Drive-In", "special treat"));
        items.add(new Item("bone", "Unknown", "favorite bone"));
        items.add(new Item("name tag", "Animal Hospital", "cat name tag"));
        items.add(new Item("meal", "Restaurant", "delicious free meal"));
        items.add(new Item("card", "Zoo", "punch card"));
        items.add(new Item("fish", "Fishmonger", "fresh fish"));
        items.add(new Item("peanuts", "School Cafeteria", "salty peanuts"));
        items.add(new Item("ball", "School Playground", "bouncy ball"));
        items.add(new Item("paper", "School Entrance", "piece of paper"));
        
        return items;*/
}
