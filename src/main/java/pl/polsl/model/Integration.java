/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import pl.polsl.errors.ErrorMessages;

/** Class implements base class of calculating integral
 * 
 * @author Karol Pisarski
 * @verson 1.0
 * 
 */
public class Integration 
{
    double lower_bound = 0; // Lower boundary used in integration
    double upper_bound = 0; // Upper boundary used in integration
    double precision = 0;   // Precision of calculating integral

    /** Setter of lower boundary
     *
     * @param num Value of new boundary
     */
    public void setLowerBound( double num ) { lower_bound = num; }
    
    /** Getter of lower boundary
     *
     * @return  Private field of upper boundary
     */
    public double getLowerBound() { return lower_bound; }
    
    /** Setter of upper boundary
     *
     * @param num Value of new boundary
     */
    public void setUpperBound( double num ) { upper_bound = num; }
    
    /** Getter of upper boundary
     *
     * @return Private field of lower boundary
     */
    public double getUpperBound() { return upper_bound; }
    
    /** Setter of precision
     *
     * @param num Private field of precision
     */
    public void setPrecision( double num ) { precision = num; }
    
    /** Getter of precision
     *
     * @return Private field of precision
     */
    public double getPrecision() { return precision; }  

    /** Calculates integral with specified method
     *  in base class It throws exception to avoid
     *  calculating integral without specified method
     *
     * @param function Function to calculate integral from
     * @return Result of integration
     * @throws NotAbstractClassException 
     */
    public double CalculateIntegral ( Function function ) throws NotAbstractClassException
    {
        throw new NotAbstractClassException(ErrorMessages.ERROR_NOT_ABSTRACT_CLASS );
    }   // CalculateIntegral

}

/** Class implemented to throw the exception of calculating
 *  integral from base class
 *
 * @author Karol Pisarski
 * @version 1.0
 */
public class NotAbstractClassException extends Exception
{

    /** Default constructor that sends exception message 
     *
     * @param error_mess Message to send
     */
    public NotAbstractClassException( String error_mess )
    {
        super(error_mess);
    }

}
