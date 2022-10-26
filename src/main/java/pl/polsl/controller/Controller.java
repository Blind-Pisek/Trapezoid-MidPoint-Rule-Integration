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
    public boolean checkCommandLineArguments( String[] args )
    {
        if( args.length == 0 )
        {     
           view.printError( error_messages.EROOR_PARAMETER );
           ErrorList.add( java.time.LocalTime.now() + error_messages.EROOR_PARAMETER );
           return false;
        }
        return true;
    }   // checkCommandLineArguments
    
    
    /** Checks if Precision is digital and if is correctly passed through
     *  command line
     *
     * @param args Command Line
     * @return If getting precision was correctly inserted
     */
    public boolean checkParameterPrecision( String[] args )
    {
        boolean result = false;
        boolean stop_flag = true;
             
        while( stop_flag )
        {
            try
            {       
                if( isStringIntOrDouble( args[0] )  )
                {
                    integration.setPrecision(Double.parseDouble( args[0] ) );
                }
                else
                {
                    view.askForPrecision();
                    input = scanner.next();
                    integration.setPrecision( Double.parseDouble( input ) );  
                }
                
                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.printError( error_messages.ERROR_INPUT_PRECISION );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_PRECISION );
            }
            
        }   // while       
        return result;
    }   // checkParameterPrecision
    
    /** Method welcomes user
     *
     */
    public void welcomeUser()
    {
        view.sayHelloToUser(); 
    }   // welcomeUser
    
    /** Gets method of calculating integral from user
     *
     * @return If method is correct
     */
    public boolean getMethod()
    {  
        boolean result = false;
        boolean stop_flag = true;
             
        while( stop_flag )
        {
            try
            {
                view.askForMethod();
                input = scanner.next();
                method = Integer.parseInt( input );
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.printError( error_messages.ERROR_INPUT_METHOD );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_METHOD );
            }
            
            if( !checkMethod( method ) )
            {
                view.printError(error_messages.ERROR_INPUT_METHOD );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_METHOD );
                stop_flag = true;
            }
            else
            {
                result = true;
            }
        }
        
       return result;
    }   // getMethod
    
    
    /** Switches between methods using polymorphism
     *
     * @param meth Method to choose
     * 
     * @return If method was correctly chosen
     */
    private boolean checkMethod( Integer meth )
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
    }   // checkMethod
            

    /** Gets the boundaries form user using I/O
     *
     * @return If user inserted correctly boundaries
     */
    public boolean getBoundaries()
    {
        boolean result = false;
        boolean stop_flag = true;
        
        while( stop_flag )
        {
            try
            {
                view.askLowerBound();
                input = scanner.next();
                integration.setLowerBound( Double.parseDouble( input ) );

                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.printError( error_messages.ERROR_INPUT_BOUNDERY );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_BOUNDERY );
            }
        }   // while
        
        stop_flag = true;
        
        while( stop_flag )
        {
            try
            {
                view.askUpperBound();
                input = scanner.next();
                integration.setUpperBound( Double.parseDouble( input ) );

                result = true;
                stop_flag = false;
            }
            catch( NumberFormatException ex )
            {
                view.printError( error_messages.ERROR_INPUT_BOUNDERY );
                ErrorList.add( java.time.LocalTime.now() + error_messages.ERROR_INPUT_BOUNDERY );
            }
        }   // while
        
        return result;
    }   // GetBounderies
    
    /** Calculates definitely integral
     *
     */
    public void calcIntegral()
    {
        try
        {
            // There needs to be defined function using lambda to pass it further
            double result = integration.calculateIntegral( x -> {
                                                           return Math.pow(x,2); } );
            view.printResult(result);
        }
        catch (NotAbstractClassException ex)
        {
           System.exit(0);
        }
                                    
    }   // calcIntegral
    

    /** Checks if string is int or double convertible
     *
     * @param str String to check
     * @return Result of checking using regex
     */
    private boolean isStringIntOrDouble( String str )
    {
        return str.matches("\\d+(\\.\\d+)?");  
    }   // IsStringDouble
    
 
}   // class Controler