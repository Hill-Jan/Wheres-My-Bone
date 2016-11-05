/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author short
 */
public class CalculationControlTest {
    
    public CalculationControlTest() {
    }

    /**
     * Tif Calder's Test of calcVolumeBox method, of class CalculationControl.
     */
    @Test //test case 1
    public void testCalcVolumeBox1() {
        System.out.println("calcVolumeBox");
        double height = 12.0;
        double width = 10.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = 1.0;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 2
    public void testCalcVolumeBox2() {
        System.out.println("calcVolumeBox");
        double height = -12.0;
        double width = 10.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 3
    public void testCalcVolumeBox13() {
        System.out.println("calcVolumeBox");
        double height = 12.0;
        double width = -10.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 4
    public void testCalcVolumeBox4() {
        System.out.println("calcVolumeBox");
        double height = 12.0;
        double width = 10.0;
        double length = -12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 5
    public void testCalcVolumeBox5() {
        System.out.println("calcVolumeBox");
        double height = 0.0;
        double width = 10.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 6
    public void testCalcVolumeBox6() {
        System.out.println("calcVolumeBox");
        double height = 10.0;
        double width = 0.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 7
    public void testCalcVolumeBox7() {
        System.out.println("calcVolumeBox");
        double height = 10.0;
        double width = 12.0;
        double length = 0.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 8
    public void testCalcVolumeBox8() {
        System.out.println("calcVolumeBox");
        double height = 1.0;
        double width = 10.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1.0;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 9
    public void testCalcVolumeBox9() {
        System.out.println("calcVolumeBox");
        double height = 10.0;
        double width = 1.0;
        double length = 12.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1.0;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test //test case 10
    public void testCalcVolumeBox10() {
        System.out.println("calcVolumeBox");
        double height = 12.0;
        double width = 10.0;
        double length = 1.0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1.0;
        double result = instance.calcVolumeBox(height, width, length);
        assertEquals(expResult, result, 0.0);
    }
 
    //tests for calcCylinderVolume
    @Test// test case 1

    /**
     *
     */
    public void testCalcCylinderVolume1(){
        System.out.println("calcCylinderVolume");
        double height = 20;
        double diameter = 16;
        CalculationControl instance = new CalculationControl();
        double expResult = 2.3271056693257726;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 2
    public void testCalcCylinderVolume2(){
        System.out.println("calcCylinderVolume");
        double height = -3;
        double diameter = 16;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 3
    public void testCalcCylinderVolume3(){
        System.out.println("calcCylinderVolume");
        double height = 20;
        double diameter = -2;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 4
    public void testCalcCylinderVolume4(){
        System.out.println("calcCylinderVolume");
        double height = 10;
        double diameter = 37;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 5
    public void testCalcCylinderVolume5(){
        System.out.println("calcCylinderVolume");
        double height = 0;
        double diameter = 160;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 6
    public void testCalcCylinderVolume6(){
        System.out.println("calcCylinderVolume");
        double height = 20;
        double diameter = 0;
        CalculationControl instance = new CalculationControl();
        double expResult = -1;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
    
    @Test//test case 7
    public void testCalcCylinderVolume7(){
        System.out.println("calcCylinderVolume");
        double height = 20;
        double diameter = 16;
        CalculationControl instance = new CalculationControl();
        double expResult = 2.3271056693257726;
        double result = instance.calcCylinderVolume (height, diameter);
        assertEquals(expResult, result, 0.0);
        }
}
