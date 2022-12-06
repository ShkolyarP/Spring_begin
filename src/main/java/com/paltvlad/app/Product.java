package com.paltvlad.app;

public class Product {

    private int id;
    private String title;
    private double coast;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCoast() {
        return coast;
    }

    public Product(int i, String s, int j) {
        this.id = i;
        this.title =s;
        this.coast =(double) j;
    }
}
