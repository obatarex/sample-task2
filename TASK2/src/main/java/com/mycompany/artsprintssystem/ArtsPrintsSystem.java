/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.artsprintssystem;

/**
 *
 * @author hp
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ArtPrint {
    private int id;
    private String title;
    private String artist;
    private String material;
    private double price;
    private int stock;

    // Constructor
    public ArtPrint(int id, String title, String artist, String material, double price, int stock) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.material = material;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPriceAsString() {
        return String.format("%.2f", price);
    }
}

public class ArtsPrintsSystem {
    private final static ArrayList<ArtPrint> artPrints = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    loadData(); // Load sample data

    System.out.println("ART PRINTS");
    System.out.println("Welcome to ART PRINTS, Where Walls Become Canvases: Art Prints for Every Space!");
    System.out.println("");

    displayMenu();

    int option = -1;
    while (option != 0) {
        try {
            option = keyboard.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Thanks for using our services, see you next time!");
                    break;
                case 1:
                    System.out.println("Your selected option is: ");
                    System.out.println("View");
                    displayData();
                    break;
                case 2:
                    System.out.println("Your selected option is: ");
                    System.out.println("Buy");
                    displayData();
                    System.out.println("Enter the ID of the art print you wish to buy: ");
                    int buyId = keyboard.nextInt();
                    buyArtPrint(buyId);
                    break;
                case 3:
                    System.out.println("Your selected option is: ");
                    System.out.println("Add");
                    displayData();
                    System.out.println("Enter the ID of the art print you wish to add to: ");
                    int addId = keyboard.nextInt();
                    addArtPrint(addId);
                    break;
                default:
                    System.out.println("Incorrect option, please try again!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input, please enter a number from the menu options");
            keyboard.next();
        }

        if (option != 0) {
            System.out.println("");
            displayMenu();
        }
    }
}
    
private static void buyArtPrint(int id) {
    for (ArtPrint print : artPrints) {
        if (print.getId() == id) {
            if (print.getStock() > 0) {
                print.setStock(print.getStock() - 1);
                System.out.println("You have successfully bought the following art print:");
                System.out.printf("Title: %s\nArtist: %s\nMaterial: %s\nPrice: $%s\n",
                        print.getTitle(), print.getArtist(), print.getMaterial(), print.getPriceAsString());
                System.out.println("Remaining stock: " + print.getStock());
            } else {
                System.out.println("Sorry, this art print is out of stock.");
            }
            return;
        }
    }
    System.out.println("Art print not found with ID: " + id);
}

private static void addArtPrint(int id) {
    for (ArtPrint print : artPrints) {
        if (print.getId() == id) {
            print.setStock(print.getStock() + 1);
            System.out.println("You have successfully added one art print to the stock.");
            System.out.println("Updated stock: " + print.getStock());
            return;
        }
    }
    System.out.println("Art print not found with ID: " + id);
}

    private static void loadData() {
        // Load sample data
       
        artPrints.add(new ArtPrint(nextId++, "Riverbank in spring time", "Van gogh", "acrylic", 50.00, 3));
        artPrints.add(new ArtPrint(nextId++, "View of the city of london", "constable", "gloss card", 49.75, 6));
        artPrints.add(new ArtPrint(nextId++, "Poppy field", "Monet", "canvas", 25.5, 1));
        artPrints.add(new ArtPrint(nextId++, "Goldfinger photograph", "fourdrinier", "matt 250gsm paper", 150, 4));
        artPrints.add(new ArtPrint(nextId++, "church in cassone", "klimt", "matt 250gsm paper", 109.99, 0));
        artPrints.add(new ArtPrint(nextId++, "sea bills photograph", "beddoes", "acrylic", 250, 1));
        artPrints.add(new ArtPrint(nextId++, "yachts", "Monet", "canvas", 99.99, 3));
        artPrints.add(new ArtPrint(nextId++, "The Fighting Temeraire", "turner", "canvas", 50.5, 2));
        artPrints.add(new ArtPrint(nextId++, "View of the City of London", "constable", "canvas", 79.99, 1));
        artPrints.add(new ArtPrint(nextId++, "Bridege over a pond\n\tof water lilies", "\t\tMonet", "Gloss Card", 39.99, 2));
    }

    private static void displayMenu() {
        System.out.println("MENU: ");
        System.out.println("\n 1. View \n 2. Buy \n 3. Add \n 0. Quit ");
    }

  private static void displayData() {
    System.out.println("ID\tTITLE\t\t\t\tARTIST\t\t\tMATERIAL\t\tPRICE\tSTOCK");
     System.out.println("-".repeat(110));
    for (ArtPrint print : artPrints) {
        System.out.printf("%d\t%-30s\t%-20s\t%-20s\t$%s\t%d\n", print.getId(), print.getTitle(),
                print.getArtist(), print.getMaterial(), print.getPriceAsString(), print.getStock());
    }
}

}

