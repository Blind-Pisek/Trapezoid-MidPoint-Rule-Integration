/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;


/**
 *
 * @author Karol Pisarski
 */
public final class Trapezoidal extends Integration 
{
    public Trapezoidal( Integration itr )
    {
        this.setLowerBound( itr.getLowerBound() );
        this.setUpperBound( itr.getUpperBound() );
        this.setPrecision( itr.getPrecision() );
    }
   

    @Override
    public double CalculateIntegral( Function function )
    {
      double h = (upper_bound - lower_bound) / precision;   // step size
      
      double sum = 0.5 * ( function.functionToCalculate(lower_bound) 
                   + function.functionToCalculate(upper_bound) );   // area
      
      for (int i = 1; i < precision; i++) 
      {
         double x = lower_bound + h * i;
         sum = sum + function.functionToCalculate(x);
      }

      return sum * h;
   }
        
        
}
    
    


