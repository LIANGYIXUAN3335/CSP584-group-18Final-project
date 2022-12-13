package com.iit.bean;

import java.math.BigDecimal;
import java.util.*;

public class Cart {

    private Map<Integer,CartItem> cartItemMap = new HashMap<>();

    public void addToCart(Product product){
        if (cartItemMap.containsKey(product.getProductid())) {
            itemCountIncrease(product.getProductid());
        }else {
            CartItem cartItem = new CartItem(product.getProductid(),product.getName(),product.getPrice(),1,product.getPrice());
            cartItemMap.put(cartItem.getProductid(),cartItem);
        }
    }

    public Map<Integer,CartItem> getCartItemMap(){
        return cartItemMap;
    }

    public void itemCountIncrease(Integer productId){
        cartItemMap.get(productId).countIncrease();
    }

    public void itemCountDecrease(Integer productId){
        CartItem cartItem = cartItemMap.get(productId);
        cartItem.countDecrease();
        if (cartItem.getCount() == 0) {
            removeCartItem(productId);
        }
    }

    public void removeCartItem(Integer productId){
        cartItemMap.remove(productId);
    }

    public void updateItemCount(Integer productId,Integer newCount){
        cartItemMap.get(productId).setCount(newCount);
    }

    public Integer getTotalCount(){

        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> cartItemEntry : cartItemMap.entrySet()) {
            totalCount += cartItemEntry.getValue().getCount();
        }
        return totalCount;
    }

    public Double getTotalAmount(){

        BigDecimal bigDecimalTotalAmount = new BigDecimal("0.0");
        for (Map.Entry<Integer, CartItem> cartItemEntry : cartItemMap.entrySet()) {
            bigDecimalTotalAmount = bigDecimalTotalAmount.add(new BigDecimal(cartItemEntry.getValue().getAmount() + ""));
        }
        return bigDecimalTotalAmount.doubleValue();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItemMap=" + cartItemMap +
                '}';
    }
}
