/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

/**
 *
 * @author Karol Pisarski
 */
public final class View {
    
    public void SeyHelloToUser()
    {
        System.out.println("Welcome to programme calculating Intergrals :)");
    }
    
    
    public void AskForMethod()
    {
        System.out.println("Type 0 to use X method or 1 to use Trapezoidal method: )");
    }
    
    
    public void AskLowerBound(){
        System.out.println("Tell me the lower bound of integral: ");
    }
    
    
    public void AskUpperBound(){
        System.out.println("Tell me the upper bound of integral: ");
    }
    
    
    public void AskForPrecision(){
        System.out.println("Tell me the precision of calculating integral: ");
    }
    
    
    public void WritePrecision( double prec )
    {
        System.out.println( "Read precision precision from parameter: " + prec );
    }
    
    
    public void PrintResult( double res )
    {
        System.out.println("Result of calculation: " + res );
    }
    
    
    public void PrintError( String val ) 
    {
        System.out.println("Error : " + val );
    }
    
    public void PrintString( String str )
    {
         System.out.println( str );
    }
    
}
