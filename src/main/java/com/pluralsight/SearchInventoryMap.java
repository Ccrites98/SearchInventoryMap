package com.pluralsight;
import java.util.HashMap;
import java.util.*;
import java.io.*;

//class is in session jamie
public class SearchInventoryMap {

  //Make it hash, Jamie
    public static Map<Integer, Product> loadInventory(String filename) {
        Map<Integer, Product> inventory = new HashMap<>();
        try (BufferedReader buffr = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = buffr.readLine()) != null) {
                String[] values = line.split("\\|");
                if (values.length == 3) {
                    int id = Integer.parseInt(values[0]);
                    String name = values[1];
                    double price = 0.0;
                    try {
                       price = Double.parseDouble(values[2]);
                    } catch (NumberFormatException e) {
                        System.err.println("Dude, you just broke everything.: " + name);
                    }
                    Product item = new Product(id, name, price);
                    inventory.put(id, item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
    //Put together that search engine Jamie
    public static void main(String[] args) {
        String filename = "src/main/resources/inventory.csv";
            Map<Integer, Product> inventory = loadInventory(filename);
            Scanner keyboard = new Scanner(System.in);
            boolean searchAgain = true;
            //Put the IDs in jaime
            while (searchAgain) {
                System.out.print("Input 4-digit item ID here: ");
                int searchId = keyboard.nextInt();
                Product item = inventory.get(searchId);
                if (item != null) {
                    System.out.println("Item found: " + item);
                } else {
                    System.out.println("Nope, you're wrong: " + searchId);
                }
                System.out.print("Do you want to search again? \n (yes/no): ");
                String answer = keyboard.next().toLowerCase();
                searchAgain = answer.equals("yes");
            }
            System.out.println("Thanks, now get out.");
        }
}
