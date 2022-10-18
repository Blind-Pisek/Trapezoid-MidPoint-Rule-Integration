
package pl.polsl.calkowanie_metoda_trapezow_i_prostokatow;

import pl.polsl.controller.CommandLineException;
import pl.polsl.controller.Controller;


/**
 *
 * @author Karol Pisarski
 * 
 */
public class Calkowanie_metoda_trapezow_i_prostokatow 
{
    static Controller controller;
    
    /**
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
        controller.GetPrecision( args );
        
       
    }
    
    public static void CheckParameters( String[] args )
    {     
        controller.CheckCommandLineArguments( args );
        controller.CheckParameterPrecision( args[0] );
    }
    
}