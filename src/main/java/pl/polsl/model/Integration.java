/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import pl.polsl.model.Function;

/**
 *
 * @author Karol Pisarski
 */
public final class Integration {
    
    double lower_bound = 0;
    double upper_bound = 0;
    int precision = 0;
    
    public Integration(){
       
    }
    
    public void setLowerBound(double num){
        lower_bound = num;
    }
    
    public double getLowerBound(){
        return lower_bound;
    }
    
    public void setUpperBound(double num){
        upper_bound = num;
    }
    
    public double getUpperBound(){
        return upper_bound;
    }
    
    public void setPrecision(int num){
        precision = num;
    }
    
    public int getPrecision(){
        return precision;
    }
   
}
