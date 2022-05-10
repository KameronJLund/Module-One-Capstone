package com.techelevator.Purchase;

import com.techelevator.ErrorLog;
import com.techelevator.SalesLog;
import com.techelevator.Styles.Colors;
import com.techelevator.UI.UserOutput;
import com.techelevator.view.Inventory;
import com.techelevator.Product.*;
import com.techelevator.UI.UserInput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Selection {

    private static Purchase purchase = new Purchase();

    public static void totalSelections(String userSelection)
    {
        List<Product> printProducts = Inventory.getSlots();

        while (!userSelection.equalsIgnoreCase("q"))
        {
            System.out.println(slotDetection(userSelection, printProducts));

            try
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e)
            {
                ErrorLog.writeToErrorLog(e.getMessage());
            }

            userSelection = UserInput.selectionScreen();
        }

        if (userSelection.equalsIgnoreCase("q"))
        {
            Purchase.moneyScreen();
        }
    }

    public static String slotDetection(String userSelection, List<Product> printProducts)
    {
        boolean canBuy = false;

        for (Product product : printProducts)
        {
            canBuy = (Purchase.getTotalAmount().subtract(Purchase.getTotalPrice()).subtract(product.getPrice()).compareTo(new BigDecimal("0.00"))) == 1;
            SalesLog writer = new SalesLog();

            if (product.getSlotNumber().equalsIgnoreCase(userSelection) && product.getAmountLeft() > 0 && canBuy)
            {
                purchase.setTotalPrice(Purchase.getTotalPrice().add(product.getPrice()));
                product.setAmountLeft(product.getAmountLeft() - 1);


                writer.writer(product.getName(), (7 - product.getAmountLeft()));

                return UserOutput.dispenseString(product) + "\nAmount of " + product.getName() + " left: " + product.getAmountLeft();
            }

            else if (product.getSlotNumber().equalsIgnoreCase(userSelection) && canBuy)
            {
                return "\nSorry, that item has been sold out! Please try again.";
            }

            else if (product.getSlotNumber().equalsIgnoreCase(userSelection) && !canBuy)
            {
                return (Colors.RED_BOLD_BRIGHT + "\nYou do not have enough money to purchase!\nPlease go back and enter money" + Colors.RESET);
            }
        }

        return "\nSorry, no such slot exists! Please try again.";
    }



}
