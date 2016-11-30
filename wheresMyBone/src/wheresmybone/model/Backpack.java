/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author short
 */
public class Backpack implements Serializable{

       private ArrayList<Item> items;

public Backpack (){
    items = new ArrayList<>();
}

    public Item getItem(int index) {
        int i=0;
        for (Item item: items) {
            if(i==index){
                return item;
            }
            i++;
         }
        return null;
  
    }

   
   public void AddItem(Item newItem) {
        items.add(newItem);
       // return this.newItem;
    }
    
   public Item GiveItem(String itemName) {
        for (Item item: items) {
            if (item.getName().equalsIgnoreCase(itemName)){
                items.remove(item);
                return item;
            }
        }
        return null;
   }
   
   /* @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.item);
        return hash;
    }*/

    /*@Override
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
    }*/
  
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
