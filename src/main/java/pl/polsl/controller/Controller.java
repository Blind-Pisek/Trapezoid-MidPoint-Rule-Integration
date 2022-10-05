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
 */
public class Controller {
    
    Scanner scanner;
    
    View view;
    Integration integration;
    
    
    public void getData(){
        
        String input;
        
        scanner = new Scanner(System.in);
        
        view.seyHelloToUser(); 
        
        view.askLowerBound();
        input = scanner.next();
        integration.setLowerBound();
        view.askUpperBound();
        
    }
    
}
