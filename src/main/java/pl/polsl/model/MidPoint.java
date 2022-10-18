/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

/**
 *
 * @author Karol Pisarski
 */
public class MidPoint extends Integration 
{

public MidPoint( Integration itr )
    {
        this.setLowerBound( itr.getLowerBound() );
        this.setUpperBound( itr.getUpperBound() );
        this.setPrecision( itr.getPrecision() );
    }

// TODO Check if the methods are implemeted in good way
public double CalculateIntegral( Function function )
{
   double h = (upper_bound - lower_bound)/precision;
   double sum = 0;
   
   for(int i = 1; i< precision ; i++)
   {
       sum += function.functionToCalculate( (lower_bound + h/ 2 ) + i * h );
   }
     
   return sum * h;
}
        
        

    
}

