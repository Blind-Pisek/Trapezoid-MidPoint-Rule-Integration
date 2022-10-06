/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.lang.Math;

/**
 *
 * @author Karol Pisarski
 */
public interface Function {
    public double functionToCalculate(double x); 
}


public final class Sinusoidal implements Function {
    
    @Override
    public double functionToCalculate(double x){
        return Math.sin(x);
    }
}


