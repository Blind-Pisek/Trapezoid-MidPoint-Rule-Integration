/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

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