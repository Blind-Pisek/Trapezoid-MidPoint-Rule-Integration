
package pl.polsl.calkowanie_metoda_trapezow_i_prostokatow;

import pl.polsl.controller.Controller;


/**
 *
 * @author Karol Pisarski
 * 
 */
public class Calkowanie_metoda_trapezow_i_prostokatow 
{
    
    /**
     * 
     * @param args programme arguments
     *        args [0] precision used while calculating Integral
     */
    public static void main( String[] args ) 
    {
       Controller controller = new Controller();
       
       
       // TODO EXEPTION FOR NONE ARGUMENT
       //try
       //{
           controller.CheckParameterPrecision( args[0] );
       //}
       //catch( )
       //{
           //system.exit(0);
       //}
      
       controller.WelcomeUser();
       controller.GetMethod();
       controller.GetBounderies();
       controller.GetPrecision( args );
        
       
    }
    
}