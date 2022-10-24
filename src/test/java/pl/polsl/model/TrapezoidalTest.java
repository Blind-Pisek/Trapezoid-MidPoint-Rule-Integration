/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Karol Pisarski
 * @version 1.0
 * 
 */
public class TrapezoidalTest {
    
    private Trapezoidal integral;
    public TrapezoidalTest() {
    }
    
    /**
     *
     */
    @BeforeEach
    public void setUpClass() 
    {    
        integral = new Trapezoidal();
    }  
    
    @Test
    public void testCalculateIntegral()
    {
        integral = new Trapezoidal();
        integral.setLowerBound(100);
        integral.setUpperBound(200);
        integral.setPrecision(1000);
        integral.CalculateIntegral( x -> {
                                           return Math.pow(x,2); });
        
        
    }
    
    @ParameterizedTest
    @CsvSource({"0,2,100","2,30,10000","52,132,1000"})
    void palindromes(double lb, double ub, double pre ) {
        integral.setLowerBound(lb);
        integral.setUpperBound(ub);
        integral.setPrecision(pre);
        integral.CalculateIntegral( x -> {
                                           return Math.pow(x,2); });
    }

    
}
