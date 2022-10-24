/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.polsl.view.*; // imports all of the classes
import pl.polsl.model.*;

import pl.polsl.errors.ErrorMessages;

/** Design pattern MVC controller class
 *
 * @author Karol Pisarski
 * @version 1.1
 * 
 */
public class Controller 
{
    ErrorMessages error_messages = new ErrorMessages(); // Strings of errors
    
    Scanner scanner = new Scanner(System.in);    // console scanner

    String input;   // console input
    
    View view = new View(); // User's GUI
    
    Integration integration = new Integration();    // Class of calculating integration
    
    int method = 0; // Flag which determines calculating method
    
    List<String> ErrorList = new ArrayList<>(); // error list used to log 
    
    /** Method checks if command line is not empty
     *
     * @param args Command Line
     * @return If is not empty
     */
    public boolean CheckCommandLineArguments( String[] args )
    {
        if( args.length == 0 )
        {     
           view.PrintError( error_messages.EROOR_PARAMETER );
           ErrorList.add( java.time.LocalTime.now() + error_messages.EROOR_PARAMETER );
           return false;
        }
        return true;
    }   // CheckCommandLineArguments
    
    
    /** Checks if Precision is digital and if is correctly passed through
     *  command line
     *
     * @param args Command Line
     * @return If getting precision was correctly inserted
     */
    public boolean CheckParameterPrecision( String[] args )
    {
        boolean result = false;
        boolean stop_flag = true;
             
        while( stop_flag )
        {
            try
            {       
                if( IsStringIntOrDouble( args[0] )  )
                {
                    integration.setPrecision(Double.parseDouble( args[0] ) );
                }
                else
                {
                    view.AskForPrecision();
                    input = scanner.next();
                    integration.setPrecision( Double.parseDouble( input ) );  
                }
                
                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.PrintError( error_messages.ERROR_INPUT_PRECISION );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_PRECISION );
            }
            
        }   // while       
        return result;
    }   // CheckParameterPrecision
    
    /** Method welcomes user
     *
     */
    public void WelcomeUser()
    {
        view.SeyHelloToUser(); 
    }   // WelcomeUser
    
    /** Gets method of calculating integral from user
     *
     * @return If method is correct
     */
    public boolean GetMethod()
    {  
        boolean result = false;
        boolean stop_flag = true;
             
        while( stop_flag )
        {
            try
            {
                view.AskForMethod();
                input = scanner.next();
                method = Integer.parseInt( input );
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.PrintError( error_messages.ERROR_INPUT_METHOD );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_METHOD );
            }
            
            if( !CheckMethod( method ) )
            {
                view.PrintError(error_messages.ERROR_INPUT_METHOD );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_METHOD );
                stop_flag = true;
            }
            else
            {
                result = true;
            }
        }
        
       return result;
    }   // GetMethod
    
    
    /** Switches between methods using polymorphism
     *
     * @param meth Method to choose
     * 
     * @return If method was correctly chosen
     */
    private boolean CheckMethod( Integer meth )
    {
        boolean state = false;
        method = meth;

        switch( meth )
        {  
            case 0: 
                integration = new MidPoint( integration );
                state = true;
                break;

            case 1:

                integration = new Trapezoidal( integration );
                state = true;
                break;

            default:
                // Write there sth

                state = false;
                break;
        } // switch
            
        return state;     
    }   // CheckMethod
            

    /** Gets the boundaries form user using I/O
     *
     * @return If user inserted correctly boundaries
     */
    public boolean GetBoundaries()
    {
        boolean result = false;
        boolean stop_flag = true;
        
        while( stop_flag )
        {
            try
            {
                view.AskLowerBound();
                input = scanner.next();
                integration.setLowerBound( Double.parseDouble( input ) );

                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.PrintError( error_messages.ERROR_INPUT_BOUNDERY );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_BOUNDERY );
            }
        }   // while
        
        stop_flag = true;
        
        while( stop_flag )
        {
            try
            {
                view.AskUpperBound();
                input = scanner.next();
                integration.setUpperBound( Double.parseDouble( input ) );

                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.PrintError( error_messages.ERROR_INPUT_BOUNDERY );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_BOUNDERY );
            }
        }   // while
        
        return result;
    }   // GetBounderies
    
    /** Calculates definitely integral
     *
     */
    public void Calculate()
    {
        try
        {
            // There needs to be defined function using lambda to pass it further
            double result = integration.CalculateIntegral( x -> {
                                                           return Math.pow(x,2); } );
            view.PrintResult(result);
        }
        catch (NotAbstractClassException ex)
        {
           System.exit(0);
        }
                                    
    }   // Calculate
    

    /** Checks if string is int or double convertible
     *
     * @param str String to check
     * @return Result of checking using regex
     */
    private boolean IsStringIntOrDouble( String str )
    {
        return str.matches("\\d+(\\.\\d+)?");  
    }   // IsStringDouble
    
 
}   // class Controler