/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan
 */
public class GameControlTest {
    
    public GameControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcTimeLeft method, of class GameControl.
     */
    @Test //test case 1
    public void testCalcTimeLeft1() {
        System.out.println("calcTimeLeft");
        double timeLeft = 1440.0;
        double travelTime = 25.0;
        GameControl instance = new GameControl();
        double expResult = 1415.0;
        double result = instance.calcTimeLeft(timeLeft, travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
    
       @Test //test case 2
    public void testCalcTimeLeft2() {
        System.out.println("calcTimeLeft");
        double timeLeft = 1440.0;
        double travelTime = -20.0;
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcTimeLeft(timeLeft, travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
       @Test  //test case 3
    public void testCalcTimeLeft3() {
        System.out.println("calcTimeLeft");
        double timeLeft = 1440.0;
        double travelTime = 1440.0;
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcTimeLeft(timeLeft, travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
       @Test  //test case 4
    public void testCalcTimeLeft4() {
        System.out.println("calcTimeLeft");
        double timeLeft = 1440.0;
        double travelTime = 30.0;
        GameControl instance = new GameControl();
        double expResult = 1410.0;
        double result = instance.calcTimeLeft(timeLeft, travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
       @Test
    public void testCalcTimeLeft5() {
        System.out.println("calcTimeLeft");
        double timeLeft = 5.0;
        double travelTime = 30.0;
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcTimeLeft(timeLeft, travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
}
