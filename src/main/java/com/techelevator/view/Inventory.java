package com.techelevator.view;

import com.techelevator.ErrorLog;
import com.techelevator.Product.*;
import com.techelevator.Styles.Colors;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory
{
    private static Scanner input = new Scanner(System.in);
    private static List<Product> slots;
    private static File vendingMachine;

    public static List<Product> getSlots()
    {
        return slots;
    }

    public void setVendingMachine()
    {
        //System.out.printf(Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");
        System.out.println("Which vending machine would you like to browse?");

        String fileNameChoice = input.nextLine();
        System.out.printf(Colors.BLACK_UNDERLINED + "%55s" + Colors.RESET, "\n");


        File vendingMachine = new File(fileNameChoice);
        Inventory inventory = new Inventory();
        inventory.setSlots(vendingMachine);

        if(vendingMachine.exists())
        {
            this.vendingMachine = vendingMachine;
        }

        else
        {
            System.out.println("No such file exists! Please try again!\n");
            setVendingMachine();
        }

    }

    public static File getVendingMachine()
    {
        return vendingMachine;
    }

    public void setSlotsManual(List<Product> list)
    {
        this.slots = slots;
    }

    public void setSlots(File vendingMachine)
    {

        List<Product> slots = new ArrayList<>();
        try(Scanner vendingMachineScanner = new Scanner(vendingMachine))
        {
            while (vendingMachineScanner.hasNextLine())
            {
                String line = vendingMachineScanner.nextLine();
                String[] columns = line.split(",");

                String slot = columns[0];
                String name = columns[1];
                String type = columns[2];
                BigDecimal price = new BigDecimal(columns[3]);

                switch(type)
                {
                    case "Munchy":
                        Munchy munchy = new Munchy(name, price, slot);
                        slots.add(munchy);
                        munchy.setAmountLeft(7);
                        break;
                    case "Sandwich":
                        Sandwich sandwich = new Sandwich(name, price, slot);
                        slots.add(sandwich);
                        sandwich.setAmountLeft(7);
                        break;
                    case "Drink":
                        Drink drink = new Drink(name, price, slot);
                        slots.add(drink);
                        drink.setAmountLeft(7);
                        break;
                    case "Dessert":
                        Dessert dessert = new Dessert(name, price, slot);
                        slots.add(dessert);
                        dessert.setAmountLeft(7);
                        break;
                }
            }
        }
        catch ( IOException e)
        {
            ErrorLog.writeToErrorLog(e.getMessage());
        }
        this.slots = slots;
    }

    public static void printProducts(List<Product> slots)
    {
        for(Product product: slots)
        {
            String template = "%-5s, %-20s, %-3.2f";
            String lineToPrint = String.format(template
                    , product.getSlotNumber()
                    , product.getName()
                    , product.getPrice());
            System.out.print(lineToPrint.replace(",", ""));

            if (product.getAmountLeft() == 0) System.out.println(Colors.YELLOW_BOLD_BRIGHT + "  SOLD OUT" + Colors.RESET);
            else System.out.println("  AMOUNT LEFT: " + product.getAmountLeft());
        }
    }
}
