package com.techelevator.Product;

import java.math.BigDecimal;

public abstract class Product
{
    private String name;
    private BigDecimal price;
    private String slotNumber;
    private int amountLeft;

    public Product(String name){
        this.name = name;
    }

    public Product(String name, BigDecimal price, String slotNumber)
    {
        this.name = name;
        this.price = price;
        this.slotNumber = slotNumber;
    }

    public Product() {

    }

    //getters and setters
    public String getName()
    {
        return name;
    }
    public BigDecimal getPrice()
    {
        return price;
    }
    public String getSlotNumber()
    {
        return slotNumber;
    }
    public int getAmountLeft() {
        return amountLeft;
    }
    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }
}
