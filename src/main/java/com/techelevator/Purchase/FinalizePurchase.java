package com.techelevator.Purchase;

import com.techelevator.Styles.Colors;
import com.techelevator.UI.UserOutput;

import java.math.BigDecimal;

public class FinalizePurchase
{
    private static Purchase purchase = new Purchase();
    public static void finalizePurchase()
    {
        UserOutput.finalizePurchaseScreen();

        System.out.println(Change.changeMaker(Purchase.getTotalAmount().subtract(Purchase.getTotalPrice())));
        purchase.setTotalAmount(new BigDecimal("0.00"));
        purchase.setTotalPrice(new BigDecimal("0.00"));
        purchase.setBalance(new BigDecimal("0.00"), new BigDecimal("0.00"));
    }
}
