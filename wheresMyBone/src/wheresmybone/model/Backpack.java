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

       public final ArrayList<Item> items;

public Backpack (){
    items = new ArrayList<>();
    
    //sample item for testing
    items.add(new Item("$10", "The Floor", "Souvenir Shop"));
    
   
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

    @Override
    public String toString() {
        return "Backpack{" + "items=" + items + '}';
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.items);
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
        final Backpack other = (Backpack) obj;
        return Objects.equals(this.items, other.items);
    }
}
