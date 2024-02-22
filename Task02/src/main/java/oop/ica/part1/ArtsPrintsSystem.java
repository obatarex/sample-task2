/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.ica.part1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OBATARE OBIRE - D3097126
 *         CONFIDENCE ANTWI - S3154679
 *         OLUWATIMILEHIN BANJO - C2249753
 * 
 */
public class ArtsPrintsSystem {
    
    // Create an ArrayList of type ArtPrint
    static ArrayList<ArtPrint> artPrints = new ArrayList<>();
    
    // Create instance of Scanner class for taking user input
    static Scanner keyboard = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        // Display name and advertising phrase
        welcome();
        
        // Invoke loadData method
        loadData();
        
        //declare local variables
        int option = -1;
        
        //start while loop
        while (option != 0) {
            
            // Display the menu
            menu();
            
            
            // Input validation checks
            if(keyboard.hasNextInt()){
                
                // listen to keyboard input
                option = keyboard.nextInt();
                
                //process choice
                switch (option) {
                    case 0 -> System.out.print("\n Thanks for using our services, see you next time!");
                    
                    case 1 ->view();
                    
                    case 2 ->buy();
                    
                    case 3 ->add();
                    
                    default -> System.out.println("\n Incorrect option, please try again!");
                    
                }//end of switch
                
            } 
            else {
                
                System.err.println("\n Incorrect input, please enter a number from the menu options");
                option=-1;
                keyboard.nextLine();
            }
            
            
        }//end of while loop
        
    }//end of main
    
    
    
    //Display menu method
    static void menu(){
        
        System.out.println("\n ### MENU ### ");
        System.out.print("\n 1. View \n 2. Buy \n 3. Add \n 0. Quit \n");
    }//end of menu function
    
    
    //Display welcome message method
    static void welcome(){
        // Display name and advertising phrase
        System.out.println("ART PRINTS");
        System.out.println("Welcome to ART PRINTS, Where Walls Become Canvases: Art Prints for Every Space!");
      
    }//end of welcome function
    
    
    //method to handle buy operation
    static void buy(){
        
        System.out.println("\n *** BUY *** \n");
        
        // invoke displayData
        displayData();
        
    }//end of buy function
    
    
    //method to handle view operation
    static void view(){
        System.out.println("\n *** VIEW *** \n");
        
        // invoke displayData
        displayData();
        
    }//end of view function
    
    
    // Display the menu method
    static void add(){
        System.out.println("\n *** ADD *** \n");
        
        // invoke displayData
        displayData();
        
    }//end of add function
     
    
    //loadData method
    static void loadData() { 
        // Load sample data
        artPrints.add(new ArtPrint(1000001, "Riverbank in spring time", "Gogh", "Acrylic", 50, 3));
        artPrints.add(new ArtPrint(2000002, "Poppy field", "Monet", "Canvas", 25.50, 1));
        artPrints.add(new ArtPrint(2000003, "Bridege over a pondof water lilies", "Monet", 
                "Gloss Card", 39.99, 2));
    }//end of loadData method
    
    
    //displayData method
    static void displayData() {
        // Intialize item number to 1
        int itemNumb = 1;
        
        System.out.println("ITEM NUMBER\tTITLE\t\t\t\tARTIST\t\t\tMATERIAL\t\tPRICE\t\tSTOCK");
        System.out.println("-".repeat(118));
        for (ArtPrint print : artPrints) {
            System.out.printf("%2d\t%-35s\t%-20s\t%-20s\t%-10s\t%2d %n", itemNumb, print.getTitle(),
                    print.getArtist(), print.getMaterial(), print.getPriceAsString(), print.getStock());
            
            itemNumb++;
        }
    }// end of displayData 
    
}   