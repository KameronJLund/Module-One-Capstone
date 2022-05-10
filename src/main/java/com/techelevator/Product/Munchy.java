package com.techelevator.Product;

import java.math.BigDecimal;

public class Munchy extends Product
{
    public Munchy(String name, BigDecimal price, String slotNumber)
    {
        super(name, price, slotNumber);
    }

    @Override
    public int getAmountLeft()
    {
        return super.getAmountLeft();
    }

    @Override
    public void setAmountLeft(int amountLeft)
    {
        super.setAmountLeft(amountLeft);
    }

    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public BigDecimal getPrice()
    {
        return super.getPrice();
    }

    @Override
    public String getSlotNumber()
    {
        return super.getSlotNumber();
    }
}
