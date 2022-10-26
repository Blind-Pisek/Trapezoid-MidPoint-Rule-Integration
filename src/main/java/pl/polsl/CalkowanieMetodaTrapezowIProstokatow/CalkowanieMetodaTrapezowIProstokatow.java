
package pl.polsl.CalkowanieMetodaTrapezowIProstokatow;

import pl.polsl.controller.Controller;


/**
 *
 * @author Karol Pisarski
 * @version 1.1
 * 
 * E-mail: karopis422@student.polsl.pl
 * 
 */
public class CalkowanieMetodaTrapezowIProstokatow 
{
    static Controller Controller;   // Programme logic
        
    /** Main function
     * 
     * @param args programme arguments
     *        args [0] precision used while calculating Integral
     */
    public static void main( String[] args ) 
    {
        Controller = new Controller();

        if( Controller.checkCommandLineArguments( args ) &&
            Controller.checkParameterPrecision( args ) )
        {
            Controller.welcomeUser();
            Controller.getMethod();
            Controller.getBoundaries();
            Controller.calcIntegral();
        }   // if
  
    }   // main
    
}   // Calkowanie_metoda_trapezow_i_prostokatow