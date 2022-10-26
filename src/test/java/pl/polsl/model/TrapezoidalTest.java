/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Karol Pisarski
 * @version 1.0
 * 
 */
public class TrapezoidalTest {
    
    private Trapezoidal Integral;

    /** Creates Trapezoidal object with 0 values 
     *
     */
    @BeforeEach
    public void setUpClass() 
    {    
        Integral = new Trapezoidal();
    }  
    
    /** Test calculates different values of specified integral
     *
     */
    @Test
    public void testCalculateIntegral()
    {
        Integral = new Trapezoidal();
        Integral.setLowerBound(100);
        Integral.setUpperBound(200);
        Integral.setPrecision(1000);
        Integral.calculateIntegral( x -> {
                                           return Math.pow(x,2); });
        
        Integral.setLowerBound(145);
        Integral.setUpperBound(12);
        Integral.setPrecision(10000);
        Integral.calculateIntegral( x -> {
                                           return Math.asin(x); });
  
        Integral.setLowerBound(-100);
        Integral.setUpperBound(20);
        Integral.setPrecision(10000);
        Integral.calculateIntegral( x -> {
                                           return Math.sin(Math.cos(x)); });
  
        Integral.setLowerBound(10);
        Integral.setUpperBound(-2);
        Integral.setPrecision(1000);
        Integral.calculateIntegral( x -> {
                                           return Math.atan2(x,2); });
  
        Integral.setLowerBound(21);
        Integral.setUpperBound(37);
        Integral.setPrecision(2137);
        Integral.calculateIntegral( x -> {
                                           return Math.log(x); });
  
    }   // testCalculateIntegral
    
    @ParameterizedTest
    @CsvSource( {"0,2,100", "2,30,10000", "52,132,1000"} )
    void prametrisedTest( double lb, double ub, double pre ) {
        Integral.setLowerBound(lb);
        Integral.setUpperBound(ub);
        Integral.setPrecision(pre);
        Integral.calculateIntegral( x -> {
                                           return Math.pow(x,2) * Math.acos(x); });
    }   // prametrisedTest
    
}
