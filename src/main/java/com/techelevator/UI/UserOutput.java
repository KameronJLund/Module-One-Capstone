package com.techelevator.UI;

import com.techelevator.Product.*;
import com.techelevator.Styles.Colors;
import com.techelevator.view.Inventory;

import java.io.File;

public class UserOutput
{
    private String selectionResponse;

    public static void welcomeScreen()
    {
        System.out.printf(Colors.BLUE_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println(Colors.BLUE + "Welcome to the Taste Elevator catering distributor!" + Colors.RESET);
        System.out.printf(Colors.BLUE_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println();
    }

    public static void displayCateringItemsScreen(File vendingMachine)
    {
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        Inventory.printProducts(Inventory.getSlots());
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
    }

    public static void finalizePurchaseScreen()
    {
        System.out.printf("\n\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println("Thank you for using the Taste Elevator Vending Machine!");
        System.out.println("Come Again!");
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n\n");
    }

    public static String dispenseString(Product product)
    {
            if (product instanceof Dessert)
            {
                return ("*" + product.getName() + " falls to the bottom of the machine\n" + "Sugar, Sugar, so Sweet!\n");
            }

            else if (product instanceof Drink)
            {
                return ("*" + product.getName() + " falls to the bottom of the machine\n" + "Drinky, Drinky, Slurp Slurp!\n");
            }

            else if (product instanceof Sandwich)
            {
                return ("*" + product.getName() + " falls to the bottom of the machine\n" + "Sandwich So Delicious, Yum!\n");
            }

            else if (product instanceof Munchy)
            {
                return ("*" + product.getName() + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n");
            }

            return "type does not exist";
    }



}
