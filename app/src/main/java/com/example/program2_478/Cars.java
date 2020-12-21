package com.example.program2_478;

public class Cars {
    private String make;
    private int image;

    public Cars(String make, int image){
        //Constructor
        this.make = make;
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
