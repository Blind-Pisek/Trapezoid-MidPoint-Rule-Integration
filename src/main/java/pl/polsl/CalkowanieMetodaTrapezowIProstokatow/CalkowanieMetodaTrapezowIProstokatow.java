
package pl.polsl.CalkowanieMetodaTrapezowIProstokatow;

import pl.polsl.controller.Controller;


/**
 *
 * @author Karol Pisarski
 * @version 1.0
 * 
 * E-mail: karopis422@student.polsl.pl
 * 
 */
public class CalkowanieMetodaTrapezowIProstokatow 
{
    static Controller controller;   // Programme logic
    
    static boolean app_parapeters = false;
    
    /** Main function
     * 
     * @param args programme arguments
     *        args [0] precision used while calculating Integral
     */
    public static void main( String[] args ) 
    {
        controller = new Controller();

        if( controller.CheckCommandLineArguments( args ) &&
            controller.CheckParameterPrecision( args ) )
        {
            controller.WelcomeUser();
            controller.GetMethod();
            controller.GetBoundaries();
            controller.Calculate();
        }   // if
  
    }   // main
    
}   // Calkowanie_metoda_trapezow_i_prostokatow