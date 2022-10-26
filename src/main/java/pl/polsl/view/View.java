/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import java.util.List;
import java.util.stream.Stream;

/** Design pattern MVC view class
 *
 * @author Karol Pisarski
 * @version 1.1
 */
public final class View 
{
    /** Prints error message
     *
     * @param val Message to print
     */
    public void printError( String val ) 
    {
        System.out.println( val );
    }
    
    /** Welcomes user
     *
     */
    public void sayHelloToUser()
    {
        System.out.println("Welcome to programme calculating Intergrals :)");
    }
    
    /** Ask user for method to calculate integral
     *
     */
    public void askForMethod()
    {
        System.out.println("Type 0 to use MidPoint method or 1 to use Trapezoidal method: )");
    }
    
    /** Ask user for lower boundary used to calculate integral 
     *
     */
    public void askLowerBound(){
        System.out.println("Tell me the lower bound of integral: ");
    }
    
    /** Ask user for upper boundary used to calculate integral 
     *
     */
    public void askUpperBound(){
        System.out.println("Tell me the upper bound of integral: ");
    }
    
    /** Ask user for precision used to calculate integral 
     *
     */
    public void askForPrecision(){
        System.out.println("Tell me the precision of calculating integral: ");
    }
    
    /** Shows the result of calculating integral
     *
     * @param res Result to show
     */
    public void printResult( double res )
    {
        System.out.println("Result of calculation: " + res );
    }
       
    /** Method prints all of the errors in error list
     *
     * @param str_list List of errors to be printed
     */
    public void printErrorList( List<String> str_list )
    {
        Stream<List<String>> list_str_stream = Stream.of(str_list );
   
        list_str_stream.forEach( x -> System.out.println( x ) );
    }   // printErrorList
    
}   // class View
