/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;

import java.util.Scanner;

import pl.polsl.view.*; // imports all of classes
import pl.polsl.model.Integration;



/**
 *
 * @author Karol Pisarski
 * 
 */
public class Controller {
    
    Scanner scanner;    // console scanner

    String input;   // console input

    
    View view = new View(); // User's GUI
    Integration integration = new Integration();    // Class of calculating integration
    
    
    
    public void GetBounderies()
    {
        scanner = new Scanner(System.in);
        
        view.seyHelloToUser(); 
        
        view.askLowerBound();
        input = scanner.next();
        integration.setLowerBound(Double.parseDouble(input));
        
        view.askUpperBound();
        input = scanner.next();
        integration.setUpperBound(Double.parseDouble(input));
    }
    
    
    public void GetPrecision( String[] args )
    {
  
        try
        {
              double prec = Double.parseDouble(args[0]);
              System.out.println("Read precision prec: " + prec );
              integration.setPrecision(prec);

        }
        catch( NumberFormatException ex )
        {
            view.PrintExeptionError( args[0] );
        }

         
    
        // There define function to calculate integral
        // The best way is to use lambda
        double result = integration.CalculateIntegral( x -> {
                                                      return Math.pow(x,2); } );
        
        view.PrintResult(result);
       
    
    
    }
    
    
    
    

    
}
