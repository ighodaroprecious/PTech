package com.example.myonlineapp;

public class Books {

    private String name;
    private String productId;
    private String price;
    private String instructions;
    private String photo;


    public Books(String name, String productId, String price, String instructions, String photo) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.instructions = instructions;
        this.photo = photo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
