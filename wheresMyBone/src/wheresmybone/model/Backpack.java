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
public class Backpack implements Serializable{
    
    //class instance variables
    private String itemName;
      
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemName() {
        return this.itemName;
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
  
    
}
