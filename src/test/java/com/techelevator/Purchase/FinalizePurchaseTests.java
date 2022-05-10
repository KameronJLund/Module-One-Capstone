package com.techelevator.Purchase;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FinalizePurchaseTests
{
    Purchase purchase = new Purchase();
    @Test
    public void balance_shouldReset_whenPurchaseFinalize()
    {
        //arrange
        BigDecimal expectedBalance = new BigDecimal("0.00");
        String message = "because whe change is give, monetary values must be reset";

        //act
        purchase.setBalance(new BigDecimal("500.00"), new BigDecimal("501.00"));
        FinalizePurchase.finalizePurchase();
        BigDecimal actualBalance = Purchase.getBalance();

        //assert
        assertEquals(message, expectedBalance, actualBalance);
    }

}
