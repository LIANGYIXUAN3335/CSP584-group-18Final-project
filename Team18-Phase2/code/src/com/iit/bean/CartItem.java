package com.iit.bean;

import java.math.BigDecimal;

public class CartItem {
    private Integer productid;
    private String name;
    private Double price;
    private Integer count;
    private Double amount;

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId=" + productid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }

    public CartItem(Integer productid, String name, Double price, Integer count, Double amount) {
        this.productid = productid;
        this.name = name;
        this.price = price;
        this.count = count;
        this.amount = amount;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String bookName) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        BigDecimal bigDecimalPrice = new BigDecimal(price + "");
        BigDecimal bigDecimalCount = new BigDecimal(count + "");

        return bigDecimalCount.multiply(bigDecimalPrice).doubleValue();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void countIncrease(){
        this.count ++;
    }

    public void countDecrease(){
        this.count --;
    }
}
