/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part1;

/**
 *
 * @author confidence
 */
public class ArtPrint {
    // class instance attribiutes
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
    

    //Getters
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
    

    //Setters
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
    
    
    // Service method
    public String getPriceAsString() {
        return String.format("£ %.2f", price);
    }

}
