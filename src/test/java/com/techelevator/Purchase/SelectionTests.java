package com.techelevator.Purchase;

import com.techelevator.Product.*;
import com.techelevator.Styles.Colors;
import com.techelevator.UI.UserInput;
import com.techelevator.UI.UserOutput;
import com.techelevator.view.Inventory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelectionTests
{
    private Inventory inventory = new Inventory();
    private UserOutput userOutput = new UserOutput();
    private Purchase purchase = new Purchase();

    @Before
    public void inventoryInit()
    {
        Inventory inventory = new Inventory();
        purchase.setTotalAmount(new BigDecimal("0.00"));
        purchase.setTotalPrice(new BigDecimal("0.00"));
    }

    @Test
    public void slotDetection_shouldReturnNachosAnd6_whenProvidedNachosOnceAtSlotA1()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "6";
        String message = "because slotDetection should return nachos and 6 left when given nachos at slot A1";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldNoSlotOfA7_whenProvidedNachosOnceAtSlotA1()
    {
        //arrange
        String userSelectionToTest = "A7";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "\nSorry, no such slot exists! Please try again.";
        String message = "because slotDetection should no slot found error";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnNachosAnd6_whenProvidedNachosOnceAtSlot_a1()
    {
        //arrange
        String userSelectionToTest = "a1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "6";
        String message = "because slotDetection should return nachos and 6 left when given nachos at slot a1 despite lowercase";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnNachosAnd6_whenProvidedNachosOnceAtSlotA2()
    {
        //arrange
        String userSelectionToTest = "A2";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A2"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A1"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "6";
        String message = "because slotDetection should return nachos and 6 left when given nachos at slot A2";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnOne_whenInputOfOneAsWord()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A3"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "6";
        String message = "moneyCount should set total amount to a big decimal value of 1.00 when fed \" one \"";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnNachosAnd5_whenProvidedNachosTwiceAtSlotA1()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "5";
        String message = "because slotDetection should return nachos and 5 left when given nachos at slot A1 twice";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldSoldOut_whenProvidedNachosSevenTimesAtA1()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "\nSorry, that item has been sold out! Please try again.";
        String message = "because slotDetection should return SOLDOUT! when given nachos at slot A1 seven times";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        actual = Selection.slotDetection(userSelectionToTest, testList);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnNachosCount5MountainMelterCount5_whenProvidedNachosOnceAtSlotA1andMountainMelterAtSlotA2()
    {
        //arrange
        String userSelectionToTest = "A1";
        String secondUserSelectionToTest = "A2";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "*" + "Nachos" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n" + "\nAmount of " + "Nachos" + " left: " + "6";
        String expectedTwo = "*" + "Mountain Melter" + " falls to the bottom of the machine\n" + "Drinky, Drinky, Slurp Slurp!\n" + "\nAmount of " + "Mountain Melter" + " left: " + "6";
        String message = "because slotDetection should return Nachos, 6 and Mountain Melter, 6 when given nachos at slot A1 and Mountain Melter at slot A2";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);
        String actualTwo = Selection.slotDetection(secondUserSelectionToTest, testList);

        System.out.println(actual);
        System.out.println(actualTwo);

        //assert
        assertEquals(message, expected, actual);
        assertEquals(message, expectedTwo, actualTwo);
    }

    @Test
    public void slotDetection_shouldNotEnoughMoney_whenProvidedNachosOnceAtSlotA1andNoMoney()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = Colors.RED_BOLD_BRIGHT + "\nYou do not have enough money to purchase!\nPlease go back and enter money" + Colors.RESET;
        String message = "because not enough money when not enough money";

        //act
        purchase.setTotalAmount(new BigDecimal("00.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);

        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldNoSlot_whenProvidedNachosOnceAtSlotA1andNoMoneyAndNoSlot()
    {
        //arrange
        String userSelectionToTest = "A8";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("3.85"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        String expected = "\nSorry, no such slot exists! Please try again.";
        String message = "because not enough money when not enough money";

        //act
        purchase.setTotalAmount(new BigDecimal("00.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        String actual = Selection.slotDetection(userSelectionToTest, testList);

        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    //PRICE CHECKS VVVV

    @Test
    public void slotDetection_shouldReturnTwoTotalPrice_whenProvidedNachosOnceAtSlotA1andTwoDollars()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("2.00"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        BigDecimal expected = new BigDecimal("2.00");
        String message = "because slotDetection should add 2.00 to total price";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        Selection.slotDetection(userSelectionToTest, testList);
        BigDecimal actual = Purchase.getTotalPrice();
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnFourTotalPrice_whenProvidedTwiceNachosOnceAtSlotA1andTwoDollars()
    {
        //arrange
        String userSelectionToTest = "A1";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("2.00"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("2.35"), "A2"));

        BigDecimal expected = new BigDecimal("4.00");
        String message = "because slotDetection should add 2.00 to total price twice (4.00)";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        BigDecimal actual = Purchase.getTotalPrice();
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnFiveTotalPrice_whenProvidedNachosOnceAtSlotA1forTwoDollarsAndMMSlotA2ThreeDollars()
    {
        //arrange
        String userSelectionToTest = "A1";
        String userSelectionToTestTwo = "A2";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("2.00"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("3.00"), "A2"));

        BigDecimal expected = new BigDecimal("5.00");
        String message = "because slotDetection should add 2.00 to total price and then 3.00 (5.00)";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        Selection.slotDetection(userSelectionToTestTwo, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        BigDecimal actual = Purchase.getTotalPrice();
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnSeventeenTotalPrice_whenProvidedTwiceNachosSevenTimesAtSlotA1forTwoDollarsAndMMSlotA2ThreeDollars()
    {
        //arrange
        String userSelectionToTest = "A1";
        String userSelectionToTestTwo = "A2";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("2.00"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("3.00"), "A2"));

        BigDecimal expected = new BigDecimal("17.00");
        String message = "because slotDetection should add 14.00 to total price and then 3.00 (5.00)";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTestTwo, testList);

        BigDecimal actual = Purchase.getTotalPrice();
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void slotDetection_shouldReturnSeventeenTotalPrice_whenProvidedTwiceNachosEightTimesAtSlotA1forTwoDollarsAndMMSlotA2ThreeDollars()
    {
        //arrange
        String userSelectionToTest = "A1";
        String userSelectionToTestTwo = "A2";
        List<Product> testList = new ArrayList<>();
        testList.add(new Munchy("Nachos", new BigDecimal("2.00"), "A1"));
        testList.add(new Drink("Mountain Melter", new BigDecimal("3.00"), "A2"));

        BigDecimal expected = new BigDecimal("17.00");
        String message = "because slotDetection should add 14.00 to total price and then 3.00 (5.00)";

        //act
        purchase.setTotalAmount(new BigDecimal("100.00"));
        testList.get(0).setAmountLeft(7);
        testList.get(1).setAmountLeft(7);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTest, testList);
        Selection.slotDetection(userSelectionToTestTwo, testList);

        BigDecimal actual = Purchase.getTotalPrice();
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }
}
