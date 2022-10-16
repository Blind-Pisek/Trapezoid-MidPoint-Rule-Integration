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
    double precision = 0;
    
    public Integration(){
       
    }
    
    public void setLowerBound( double num ) { lower_bound = num; }
    
    public double getLowerBound() { return lower_bound; }
    
    
    public void setUpperBound( double num ) { upper_bound = num; }
    
    public double getUpperBound() { return upper_bound; }
    
    
    public void setPrecision( int num ){ precision = num; }
    
    public double getPrecision() { return precision; }
   
    
    public double CalculateIntegral(Function function)
    {
        double modifier = 1;    // changes the sign 
        double area = 0;    // area of calculated integral
        
        if ( lower_bound > upper_bound ) 
        {
            double temp_lower_bound = lower_bound;  // temporary lower boundery
            lower_bound = upper_bound;
            upper_bound = temp_lower_bound;
            modifier = -1;  // bounderies are reversed, sign needs to be changed
        }
        
        precision /= 10000;
        
        double diff_from_lower_bound = 0;
        
        for ( double i = lower_bound + precision; 
              i < upper_bound; i += precision ) 
        {
            diff_from_lower_bound = i - lower_bound;
            area += ( precision / 2 ) * 
                     ( function.functionToCalculate( lower_bound + diff_from_lower_bound ) +
                       function.functionToCalculate( lower_bound + diff_from_lower_bound - precision ) );
            
        }
        
        
        
        return area * modifier;
    }
    
    
}
