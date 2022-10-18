
package pl.polsl.calkowanie_metoda_trapezow_i_prostokatow;

import pl.polsl.controller.Controller;


/**
 *
 * @author Karol Pisarski
 * @version 1.0
 * 
 * E-mail: karopis422@student.polsl.pl
 * 
 */
public class Calkowanie_metoda_trapezow_i_prostokatow 
{
    static Controller controller;   // Programme logic
    
    /** Main function
     * 
     * @param args programme arguments
     *        args [0] precision used while calculating Integral
     */
    public static void main( String[] args ) 
    {
        controller = new Controller();
       
        CheckParameters( args );
       
        controller.WelcomeUser();
        controller.GetMethod();
        controller.GetBounderies();
        controller.Calculate();

    }
    
    /** Function checks command line parameters
     *
     * @param args Command line parameters
     */
    public static void CheckParameters( String[] args )
    {     
        controller.CheckCommandLineArguments( args );
        controller.CheckParameterPrecision( args[0] );
    }
    
}