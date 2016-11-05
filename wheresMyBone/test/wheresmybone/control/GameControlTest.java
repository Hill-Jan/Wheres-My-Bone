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

        double travelTime = 25.0;
        GameControl instance = new GameControl();
        double expResult = 1415.0;
        double result = instance.calcTimeLeft(travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
    
       @Test //test case 2
    public void testCalcTimeLeft2() {
        System.out.println("calcTimeLeft");

        double travelTime = -20.0;
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcTimeLeft(travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
       @Test  //test case 3
    public void testCalcTimeLeft3() {
        System.out.println("calcTimeLeft");

        double travelTime = 1440.0;
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcTimeLeft(travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
       @Test  //test case 4
    public void testCalcTimeLeft4() {
        System.out.println("calcTimeLeft");
        
        double travelTime = 30.0;
        GameControl instance = new GameControl();
        double expResult = 1410.0;
        double result = instance.calcTimeLeft(travelTime);
        assertEquals(expResult, result, 0.0);

    
    }
    
    
    // Author Dan
    /**
     * Test of calcAreaTime method, of class GameControl.
     */
    @Test
    public void testCalcAreaTime1() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 30;
        int width = 20;
        double timeInSeconds = 2.4;
   
        GameControl instance = new GameControl();
        double expResult = 1416.0;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }
    @Test
    public void testCalcAreaTime2() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 0;
        int width = 30;
        double timeInSeconds = 2.4;
      
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime3() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 50;
        int width = 0;
        double timeInSeconds = 2.4;
      
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime4() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 55;
        int width = 15;
        double timeInSeconds = 2.4;
     
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime5() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 25;
        int width = 35;
        double timeInSeconds = 2.4;
      
        GameControl instance = new GameControl();
        double expResult = -1;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime6() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 50;
        int width = 1;
        double timeInSeconds = 2.4;

        GameControl instance = new GameControl();
        double expResult = 1438.0;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime7() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 1;
        int width = 30;
        double timeInSeconds = 2.4;

        GameControl instance = new GameControl();
        double expResult = 1438.8;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }@Test
    public void testCalcAreaTime8() {
        System.out.println("calcAreaTime");
        double timeLeft = 1440.0;
        int length = 50;
        int width = 30;
        double timeInSeconds = 2.4;
        GameControl instance = new GameControl();
        double expResult = 1380.0;
        double result = instance.calcAreaTime(length, width);
        assertEquals(expResult, result, 0.0);
        
    }
}
