/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

/** Design pattern MVC view class
 *
 * @author Karol Pisarski
 * @version 1.0
 */
public final class View 
{
    /** Prints error message
     *
     * @param val Message to print
     */
    public void PrintError( String val ) 
    {
        System.out.println( val );
    }
    
    /** Welcomes user
     *
     */
    public void SeyHelloToUser()
    {
        System.out.println("Welcome to programme calculating Intergrals :)");
    }
    
    /** Ask user for method to calculate integral
     *
     */
    public void AskForMethod()
    {
        System.out.println("Type 0 to use MidPoint method or 1 to use Trapezoidal method: )");
    }
    
    /** Ask user for lower boundary used to calculate integral 
     *
     */
    public void AskLowerBound(){
        System.out.println("Tell me the lower bound of integral: ");
    }
    
    /** Ask user for upper boundary used to calculate integral 
     *
     */
    public void AskUpperBound(){
        System.out.println("Tell me the upper bound of integral: ");
    }
    
    /** Ask user for precision used to calculate integral 
     *
     */
    public void AskForPrecision(){
        System.out.println("Tell me the precision of calculating integral: ");
    }
    
    /** Shows the result of calculating integral
     *
     * @param res Result to show
     */
    public void PrintResult( double res )
    {
        System.out.println("Result of calculation: " + res );
    }
    
    
}   // class View
