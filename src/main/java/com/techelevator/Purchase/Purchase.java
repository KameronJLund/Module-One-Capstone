package com.techelevator.Purchase;

import com.techelevator.MainMenu;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.view.DisplayCaTEring;

import java.math.BigDecimal;
import java.util.Scanner;

public class Purchase {

    private static Scanner input = new Scanner(System.in);
    private static MainMenu mainMenu = new MainMenu();
    private static Purchase purchase = new Purchase();

    private static BigDecimal balance = new BigDecimal("0.00");
    private static BigDecimal totalAmount = new BigDecimal("0.00");
    private static BigDecimal totalPrice = new BigDecimal("0.00");

    //setters and getters
    public static BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    public static BigDecimal getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    public static BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal totalAmount, BigDecimal totalPrice)
    {
        this.balance = totalAmount.subtract(totalPrice);
    }

    public static String moneyScreen() {
        String userSelection = UserInput.getPurchaseScreenChoice();

        if (userSelection.equalsIgnoreCase("q"))
        {
            mainMenu.run(false);
        }

        else if (userSelection.equalsIgnoreCase("c"))
        {
            Change.changeMaker(Purchase.getTotalAmount().subtract(Purchase.getTotalPrice()));
//            Complete the transaction and return change
            UserOutput.finalizePurchaseScreen();

            System.out.println(Change.changeMaker(Purchase.getTotalAmount().subtract(Purchase.getTotalPrice())));
            purchase.setTotalAmount(new BigDecimal("0.00"));
            purchase.setTotalPrice(new BigDecimal("0.00"));
            purchase.setBalance(new BigDecimal("0.00"), new BigDecimal("0.00"));

            mainMenu.run(true);
        }

        else if (userSelection.equalsIgnoreCase("f"))
        {
            FeedMoney.moneyCount(UserInput.feedMoneyChoice());
        }

        else if (userSelection.equalsIgnoreCase("s"))
        {
            Selection.totalSelections(UserInput.selectionScreen());
        }

        else if (userSelection.equalsIgnoreCase("d"))
        {
            DisplayCaTEring.displayScreen();
        }

        return input.next();
    }

}
