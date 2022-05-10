package com.techelevator;

import com.techelevator.Purchase.Purchase;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.view.DisplayCaTEring;
import com.techelevator.view.Inventory;

import java.io.File;

public class MainMenu {

    private static File vendingMachine;
    Inventory inventory = new Inventory();

    public static File getVendingMachine() {
        return vendingMachine;
    }

    public void run(boolean isInitial) {
        if (isInitial) {
            UserOutput.welcomeScreen();
            inventory.setVendingMachine();
            this.vendingMachine = Inventory.getVendingMachine();
        }

        String choice = UserInput.getWelcomeChoice();

        while (true) {

            if (choice.equalsIgnoreCase("e")) {
                UserOutput.finalizePurchaseScreen();
                break;
            } else if (choice.equalsIgnoreCase("d")) {
                DisplayCaTEring.displayScreen();
            } else if (choice.equalsIgnoreCase("p")) {
                Purchase.moneyScreen();
            }
        }
    }
}
