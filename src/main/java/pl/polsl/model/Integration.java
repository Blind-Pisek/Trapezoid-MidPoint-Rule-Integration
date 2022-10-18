/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import pl.polsl.errors.ErrorMessages;

/**
 *
 * @author Karol Pisarski
 */
public class Integration 
{
    double lower_bound = 0;
    double upper_bound = 0;
    double precision = 0;

    /** Setter of lower boundery
     *
     * @param num 
     */
    public void setLowerBound( double num ) { lower_bound = num; }
    
    /**
     *
     * @return
     */
    public double getLowerBound() { return lower_bound; }
    
    /**
     *
     * @param num
     */
    public void setUpperBound( double num ) { upper_bound = num; }
    
    /**
     *
     * @return
     */
    public double getUpperBound() { return upper_bound; }
    
    /**
     *
     * @param num
     */
    public void setPrecision( double num ){ precision = num; }
    
    /**
     *
     * @return
     */
    public double getPrecision() { return precision; }
    

    // to sth there

    /**
     *
     * @param function
     * @return
     * @throws NotAbstractClassException
     */
    public double CalculateIntegral ( Function function ) throws NotAbstractClassException
    {
        throw new NotAbstractClassException(ErrorMessages.ERROR_NOT_ABSTRACT_CLASS );
    }   // CalculateIntegral

}

/**
 *
 * @author pisek
 */
public class NotAbstractClassException extends Exception
{

    /**
     *
     * @param error_mess
     */
    public NotAbstractClassException( String error_mess )
    {
        super(error_mess);
    }

}
