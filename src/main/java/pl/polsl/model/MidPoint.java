/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

/** Class implements Midpoint method of calculating integral
 *
 * @author Karol Pisarski
 * @version 1.1
 * 
 */
public class MidPoint extends Integration 
{
    
    public MidPoint()
    {
        lower_bound = 0;
        upper_bound = 0;
        precision= 0;             
    }
    
    /** Constructor that copies private fields from base class
     *
     * @param itr Base class object
     */
    public MidPoint( Integration itr )
    {
        this.setLowerBound( itr.getLowerBound() );
        this.setUpperBound( itr.getUpperBound() );
        this.setPrecision( itr.getPrecision() );
    }   // MidPoint

    /** Calculates integral with specified method
     *
     * @param function Function to calculate integral from
     * @return Result of integration
     */
    @Override
    public double calculateIntegral( Function function )
    {
       double h = (upper_bound - lower_bound)/precision;
       double sum = 0;

       for( int i = 1; i< precision ; i++ )
       {
           sum += function.functionToCalculate( (lower_bound + h/ 2 ) + i * h );
       }

       return sum * h;
    }   // calculateIntegral
        
}   // class MidPoint