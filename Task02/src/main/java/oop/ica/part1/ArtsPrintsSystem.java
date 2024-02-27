/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.ica.part1;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
    static ArrayList<ArtPrint> artPrints = new ArrayList<ArtPrint>();

    // Create instance of Scanner class for taking user input
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        // Display name and advertising phrase
        welcome();
        

        // Invoke loadData method
        loadData();
        

        // declare local variable
        int option = -1;

        // start while loop
        while (option != 0) {

            // Display the menu
            menu();
            

            // Input validation checks
            if (keyboard.hasNextInt()) {

               
                // listen to keyboard input
                option = keyboard.nextInt();
                

                // process choice
                switch (option) {
                    case 0 -> System.out.print("\n Thanks for using our services, see you next time!");

                    case 1 -> view();

                    case 2 -> buy();

                    case 3 -> add();

                    default -> System.out.println("\n!!!!! Input Error: Value not on the menu list !!!!!\n");

                }// end of switch

            } else {

                System.err.println("\n!!!!! Input Error: not an integer !!!!!\n");
                option = -1;
                keyboard.nextLine();
            }

        } // end of while loop

    }// end of main

    
    
    // Display menu method
    static void menu() {

        System.out.println("\n ### MENU ### ");
        System.out.print("\n [1] View \n [2] Buy \n [3] Add \n [0] Quit \n");
        System.out.print("\nPlease enter a number from the menu or enter [0] to quit:\t");
    }// end of menu method

    
    // Display welcome message method
    static void welcome() {
        
        System.out.println("**** ART PRINTS ****");
        System.out.println("Welcome to ART PRINTS, Where Walls Become Canvases: Art Prints for Every Space!");

    }// end of welcome method

    
    // method to handle buy operation
    static void buy() {

        System.out.println("\n *** BUY *** \n");

        // invoke displayData
        displayData();

        System.out.print("\nPlease enter item number to BUY or enter [0] to terminate operation:\t");

        // get selected item number from user
        int item = getSelectedItem();

        if (item > 0 && artPrints.size() >= item) {
            // get the object element
            ArtPrint artItem = artPrints.get(item - 1);
            
            if(artItem.getStock()==0){
                 System.out.printf("\n %s by %s is out of stock \n", artItem.getTitle(), artItem.getArtist());
            }
            else{
                // get stock balance
                int balance = artItem.getStock() - 1;

                // set stock balance
                artItem.setStock(balance);

                // update our Table
                //artPrints.set(item - 1, artItem);

                // inform user
                System.out.printf("\nThanks for buying %s by %s \n", artItem.getTitle(), artItem.getArtist());
                System.out.printf("\nThe new stock for %s is %d \n", artItem.getTitle(), artItem.getStock());
            }
        } 
        else if(item==0){
            System.out.println("\nOperation terminated\n");
        }
        else if (item != Integer.MIN_VALUE) {
            System.out.println("\n!!!!! Input Error: Value not on the list !!!!!\n");
            keyboard.nextLine();
        } // end of condition

    }// end of buy function

    
    // method to handle view operation
    static void view() {
        System.out.println("\n *** VIEW *** \n");

        // invoke displayData
        displayData();

    }// end of view function

    
    // Display the menu method
    static void add() {
        System.out.println("\n *** ADD *** \n");

        // invoke displayData
        displayData();

        System.out.print("\nPlease enter item number to ADD or enter [0] to terminate operation:\t");

        // local variables
        int item = getSelectedItem();

        // if value is within range
        if (item > 0 && artPrints.size() >= item) {
            // get the object element
            ArtPrint artItem = artPrints.get(item - 1);
            
            // get stock balance
            int balance = artItem.getStock() + 1;
            
            // set stock balance
            artItem.setStock(balance);

            // update our Table
            //artPrints.set(item - 1, artItem);

            // inform user
            System.out.printf("\nThanks for adding %s by %s \n", artItem.getTitle(), artItem.getArtist());
            System.out.printf("\nThe new stock for %s is %d \n", artItem.getTitle(), artItem.getStock());

        }
        else if(item==0){
            System.out.println("\nOperation terminated\n");
        } 
        else if (item != Integer.MIN_VALUE) {
            System.out.println("\n!!!!! Input Error: Value not on the list !!!!!\n");
            keyboard.nextLine();
        } // end of conditions

    }// end of add function

    
    // loadData method
    static void loadData() {
        // Load sample data
        artPrints.add(new ArtPrint(1000001, "Riverbank in spring time", "Gogh", "Acrylic", 50, 3));
        artPrints.add(new ArtPrint(2000002, "Poppy field", "Monet", "Canvas", 25.50, 1));
        artPrints.add(new ArtPrint(2000003, "Bridege over a pondof water lilies", "Monet",
                "Gloss Card", 39.99, 2));
        artPrints.add(new ArtPrint(5000444, "Church in Cassone", "Klimt", "Matt 250gsm Paper ", 109.99, 0));
        artPrints.add(new ArtPrint(9876543, "The Fighting Temeraire", "Turner", "Canvas", 50.50, 2));
        
    }// end of loadData method

    
    // displayData method
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

    
    // Method to receive item number from user
    static int getSelectedItem() {

        int item;
        // test input is an integer
        try {
            // read input
            item = keyboard.nextInt();
        } 
        catch (InputMismatchException e) {
            // warn user
            System.out.println("\n!!!!! Input Error: not an integer !!!!!\n");

            // reset value to min int value
            item = Integer.MIN_VALUE;
            keyboard.nextLine();
        }

        return item;

    }//end of getSelectedItem method

}