package com.pluralsight;
//This whole page was a mess, i was struggling, pls be gentle with me
public class Product {
        private int id;
        private String name;
        private double price;
    public Product(int id, String name, double price) {
            this.id = id;
            this.name = String.valueOf(name);
            this.price = price;
        }



        public String getName() {
            return this.name;
        }
        public double getPrice() {
            return this.price;
        }
    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
    }

