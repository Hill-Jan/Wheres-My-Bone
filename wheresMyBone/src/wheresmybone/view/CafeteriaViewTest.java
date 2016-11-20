/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

/**
 *
 * @author Jan
 */
public class CafeteriaViewTest extends View{
     private String promptMessage;{
}
public CafeteriaViewTest() {
            super ("\n*********************************************************"
                    +"\n    CAFETERIA  VIEW   "
                    +"\n********************************************************"
                    +"\n"
                    +"\nYou snuck into the cafeteria at the back of the school."
                    +"\nThere are several children nearby eating lunch or playing."
                    +"\nYou notice a nice lady near the register.  Some snacks."
                    +"\nare displayed on the counter next to her.  What should you do?"
                    +"\n********************************************************"
                    +"\nChoose a menu option:"
                    +"\nT - Talk to the Cashier."
                    +"\nB - Beg for Food from the kids."
                    +"\nX - Get out Fast!"
                    +"\n********************************************************");
                    }

@Override
public boolean doAction (String value){
        value = value.toUpperCase();

        switch(value){
            case "T":
                this.talkToCashier();
                break;
            
            case"B":
                this.begForFood();
                break;
            default:
            System.out.println("\n*** Invalid selection *** Try again");
            break;
        }
       return false;

}

    private void talkToCashier() {
        System.out.println("\n***This calls the Talk To Cashier function"
                            +"\nHe's lost his notebook.");
    }

    private void begForFood() {
        System.out.println("\n**This calls the Beg For Food function**"
                            +"\nPeanut Butter and Jelly.  Yum!");
    }

}

