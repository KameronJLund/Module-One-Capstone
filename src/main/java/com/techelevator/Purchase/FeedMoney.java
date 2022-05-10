package com.techelevator.Purchase;

import com.techelevator.Styles.Colors;
import com.techelevator.UI.UserInput;

import java.math.BigDecimal;
import java.util.Scanner;

public class FeedMoney
{
    private static Purchase purchase = new Purchase();
    private static Scanner input = new Scanner(System.in);

    public static void moneyCount(String moneyScreenChoice)
    {
        while (!moneyScreenChoice.equalsIgnoreCase("Q"))
        {
            insertMoney(moneyScreenChoice);
            moneyScreenChoice = UserInput.feedMoneyChoice();
        }

        if(moneyScreenChoice.equalsIgnoreCase("q"))
        {
            Purchase.moneyScreen();
        }
    }

    public static void insertMoney(String moneyScreenChoice)
    {
        switch (moneyScreenChoice.toLowerCase())
        {
            case "1":
            case "one":
                purchase.setTotalAmount(Purchase.getTotalAmount().add(new BigDecimal("1.00")));
                break;
            case "2":
            case "5":
            case "five":
                purchase.setTotalAmount(Purchase.getTotalAmount().add(new BigDecimal("5.00")));
                break;
            case "3":
            case "10":
            case "ten":
                purchase.setTotalAmount(Purchase.getTotalAmount().add(new BigDecimal("10.00")));
                break;
            case "4":
            case "20":
            case "twenty":
                purchase.setTotalAmount(Purchase.getTotalAmount().add(new BigDecimal("20.00")));
                break;
            case "q":
                break;
        }
    }

}
