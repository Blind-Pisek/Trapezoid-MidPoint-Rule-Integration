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

    
    View view = new View();
    Integration integration = new Integration();
    
    
    
    public void getBounderies(){
        
        
        scanner = new Scanner(System.in);
        
        view.seyHelloToUser(); 
        
        view.askLowerBound();
        input = scanner.next();
        integration.setLowerBound(Double.parseDouble(input));
        
        view.askUpperBound();
        input = scanner.next();
        integration.setUpperBound(Double.parseDouble(input));
        
        
       
    }
    
    public void getPrecision(){
        view.askForPrecision();
        input = scanner.next();
        integration.setPrecision(Integer.parseInt(input)); 
    
        
        System.out.println("Result: ");
        double resaul= integration.CalculateIntegral(x -> {
         return Math.pow(x,2);  });
        
        
        
        System.out.println( resaul);
    
    
    }
    
    
   
}
