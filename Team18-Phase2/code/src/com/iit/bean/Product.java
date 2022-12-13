package com.iit.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer productid;
    private String name;
    private Double price;
    private String image;
    private String manufacturer;
    private String creditscore;
    private Double loanamount;
    private Double rating;
    private Integer quantity;
    private String type;

    public Product(){

    }

    public Product(Integer productid, String name, Double price, String image, String manufacturer, String creditscore,
                   Double loanamount, Double rating, Integer quantity, String type) {
        this.productid = productid;
        this.name = name;
        this.price = price;
        this.image = image;
        this.manufacturer = manufacturer;
        this.creditscore = creditscore;
        this.loanamount = loanamount;
        this.rating = rating;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditscore() {
        return creditscore;
    }

    public void setCreditscore(String creditscore) {
        this.creditscore = creditscore;
    }

    public Double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(Double loanamount) {
        this.loanamount = loanamount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
