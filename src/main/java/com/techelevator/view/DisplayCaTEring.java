package com.techelevator.view;

import com.sun.tools.javac.Main;
import com.techelevator.MainMenu;
import com.techelevator.Purchase.Purchase;
import com.techelevator.Styles.Colors;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;

public class DisplayCaTEring
{
    private static MainMenu mainMenu = new MainMenu();

    public static void displayScreen()
    {
        UserOutput.displayCateringItemsScreen(MainMenu.getVendingMachine());
        String displayChoice =  UserInput.getDisplayChoice();
        while(true)
        {
            if (displayChoice.equalsIgnoreCase("p"))
            {
                Purchase.moneyScreen();
                break;
            } else if (displayChoice.equalsIgnoreCase("q"))
            {
                mainMenu.run(false);
                break;
            } else
            {
                System.out.println("That is not an option. Please" + Colors.RED + "try again.\n" + Colors.RESET);
                displayChoice =  UserInput.getDisplayChoice();
            }
        }
    }
}
