package com.techelevator.UI;

import com.techelevator.MainMenu;
import com.techelevator.Purchase.Purchase;
import com.techelevator.Styles.Colors;

import java.util.Scanner;

public class UserInput
{
    private static Scanner input = new Scanner(System.in);
    public static String getWelcomeChoice()
    {
        System.out.printf(Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println("\n" + Colors.BLUE + "(D)" + Colors.RESET + "Display caTEring items");
        System.out.println(Colors.BLUE + "(P)" + Colors.RESET + "Purchase");
        System.out.println(Colors.BLUE + "(E)" + Colors.RESET + "Exit");
        System.out.printf(Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.print(Colors.BLUE + "Please select an option: " + Colors.RESET);

        return input.nextLine().trim().toLowerCase().substring(0,1);
    }

    public static String getDisplayChoice()
    {
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println(Colors.BLUE + "(P)" + Colors.RESET + "Purchase");
        System.out.println(Colors.BLUE + "(Q)" + Colors.RESET + "Quit");
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.print(Colors.BLUE + "Please select an option: " + Colors.RESET);

        return input.nextLine().trim().toLowerCase().substring(0,1);
    }

    public static String getPurchaseScreenChoice()
    {

        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println(Colors.BLUE + "(F)" + Colors.RESET + "Feed Money");
        System.out.println(Colors.BLUE + "(S)" + Colors.RESET + "Select Item");
        System.out.println(Colors.BLUE + "(D)" + Colors.RESET + "Display caTEring items");
        System.out.println(Colors.BLUE + "(C)" + Colors.RESET + "Complete the transaction and return change");
        System.out.println(Colors.BLUE + "(Q)" + Colors.RESET + "Quit Transaction");

        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println("Current Balance: " + Colors.GREEN_BOLD_BRIGHT + "$" + Purchase.getTotalAmount().subtract(Purchase.getTotalPrice()) + Colors.RESET);
        System.out.print(Colors.BLUE + "Please select an option: " + Colors.RESET);

        return input.nextLine().trim().toLowerCase().substring(0,1);
    }

    public static String selectionScreen()
    {
            UserOutput.displayCateringItemsScreen(MainMenu.getVendingMachine());
            System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
            System.out.println("Current Money Provided: " + Colors.GREEN_BOLD_BRIGHT + "$" + Purchase.getTotalAmount() + Colors.RESET);
            System.out.println("Current Price of Selections: " + "$" + Purchase.getTotalPrice());
            System.out.println("Current Balance: " + Colors.GREEN_BOLD_BRIGHT + "$" + Purchase.getTotalAmount().subtract(Purchase.getTotalPrice()) + Colors.RESET);
            System.out.println(Colors.BLUE + "(\"A1\")" + Colors.RESET + "Enter a slot number");
            System.out.println(Colors.BLUE + "(Q)" + Colors.RESET + "Press Q to quit");
            System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
            System.out.print(Colors.BLUE + "Please make a selection: " + Colors.RESET);

            return input.nextLine().trim().toLowerCase();
    }

    public static String feedMoneyChoice()
    {
        System.out.println("\n\nWhat denomination would you like to feed? ");
        System.out.printf("\n" + Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "(1) $1 ");
        System.out.println("(2) $5 ");
        System.out.println("(3) $10 ");
        System.out.println("(4) $20 " + Colors.RESET);
        System.out.println(Colors.BLUE + "(Q)" + Colors.RESET + "Press Q when finished");
        System.out.println("Current Balance: " + Colors.GREEN_BOLD_BRIGHT + "$" + Purchase.getTotalAmount().subtract(Purchase.getTotalPrice()) + Colors.RESET);

        return input.nextLine().toLowerCase().trim();
    }
}
