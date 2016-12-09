/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

/**
 *
 * @author tCalder
 */
public class EnterYourHouseView extends View{
    GameMenuView gameMenu = new GameMenuView();
    
    public EnterYourHouseView() {
        super("\n"
                + "\n---------------------------------------------"
                + "\nYour House"
                + "\n---------------------------------------------"
                + "\nIt occurs to you that maybe a more thorough "
                + "\nsearch of the backyard is in order."
                + "\n---------------------------------------------"
                + "\n"
                + "\nWhat do you want to do? "
                + "\n"
                + "\nE - Enter to the backyard."
                + "\nR - Return to Game Menu"
                + "\n----------------------------------------------"
                + "\n");
    }

    public EnterYourHouseView(String message) {
        super(message);
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert value to upper case
    
    switch (value) {
        case "E": 
            // Enter the backyard
            this.enterYourHouseView();
            break;
        case "R":
            gameMenu.display();
        default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
       return false;
    }

    private void enterYourHouseView() {
        YourHouseView yourHouseView = new YourHouseView();
        yourHouseView.displayYourHouseView();
    }

    }
