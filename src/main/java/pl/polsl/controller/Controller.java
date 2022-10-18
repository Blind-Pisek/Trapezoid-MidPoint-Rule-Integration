/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;

import java.util.Scanner;

import pl.polsl.view.*; // imports all of the classes
import pl.polsl.model.*;

import pl.polsl.errors.ErrorMessages;

/**
 *
 * @author Karol Pisarski
 * 
 */
public class Controller 
{
    ErrorMessages error_messages = new ErrorMessages();
    
    Scanner scanner = new Scanner(System.in);    // console scanner

    String input;   // console input

    
    View view = new View(); // User's GUI
    
    Integration integration = new Integration();    // Class of calculating integration
    
    int method = 0; // Flag which determines calculating method
    

    public void CheckCommandLineArguments( String[] args )
    {
       
        if( args.length == 0 )
        {
           view.NullCommandLineArgument();
           System.exit(0);
        }
    }   // CheckCommandLineArguments
    
    //  DONE 
    public void CheckParameterPrecision( String prec )
    {
        if( IsStringIntOrDouble( prec ) )
        {
            integration.setPrecision(Double.parseDouble( prec ) );
        }
        else
        { 
            view.PrintError( error_messages.EROOR_PARAMETER );
         
            try
            {
                view.AskForPrecision();
                input = scanner.next();
                integration.setPrecision( Double.parseDouble( input ) );  
            }
            catch( NumberFormatException ex )
            {
                view.PrintError( error_messages.ERROR_INPUT_PRECISION );
                System.exit(0);
            }
        }     
    }   // CheckParameterPrecision
    
    // DONE
    public void WelcomeUser()
    {
        view.SeyHelloToUser(); 
    }
    
    
    // DONE
    public void GetMethod()
    {  
       try
       {
        view.AskForMethod();
        input = scanner.next();
        method = Integer.parseInt( input );
       }
       catch( NumberFormatException ex )
       {
        view.PrintError( error_messages.ERROR_INPUT_METHOD );
        System.exit(0);
       }
       
       if( !CheckMethod( method ) )
       {
           view.PrintError(input);
           System.exit(0);
       }
       
    }   // GetMethod
    
    // TODO POLIMORPHISMs
    boolean CheckMethod( Integer meth )
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
            
    // DONE
    public void GetBounderies()
    {
        try
        {
            view.AskLowerBound();
            input = scanner.next();
            integration.setLowerBound( Double.parseDouble( input ) );

            view.AskUpperBound();
            input = scanner.next();
            integration.setUpperBound( Double.parseDouble( input ) );
        }
        catch( NumberFormatException ex )
        {
            view.PrintError( error_messages.ERROR_INPUT_BOUNDERY );
            System.exit(0);
        }
    }   // GetBounderies
    
    
    
    public void Calculate()
    {
        try
        {
          double result = integration.CalculateIntegral( x -> {
                                                         return Math.pow(x,2); } );
          view.PrintResult(result);
        }
        catch (NotAbstractClassException ex)
        {
           System.exit(0);
        }

                                                     
    }
    

    boolean IsStringIntOrDouble( String str )
    {
        return str.matches("\\d+(\\.\\d+)?");  
    }   // IsStringDouble
    

  
}   // class Controler


