package com.techelevator.Purchase;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FeedMoneyTests
{
    @Before
    public void initializeTotalAmount()
    {
        Purchase purchase = new Purchase();
        purchase.setTotalAmount(new BigDecimal("0.00"));
    }

    @Test
    public void feedMoney_shouldReturnOne_whenInputOfOne()
    {
        //arrange
        String inputToTest = "1";
        BigDecimal expected = new BigDecimal("1.00");
        String message = "moneyCount should set total amount to a big decimal value of 1.0 when fed \" 1 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnFive_whenInputOfTwo()
    {
        //arrange
        String inputToTest = "5";
        BigDecimal expected = new BigDecimal("5.00");
        String message = "moneyCount should set total amount to a big decimal value of 5.0 when fed \" 2 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnTen_whenInputOfThree()
    {
        //arrange
        String inputToTest = "3";
        BigDecimal expected = new BigDecimal("10.00");
        String message = "moneyCount should set total amount to a big decimal value of 10.00 when fed \" 3 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnTwenty_whenInputOfFour()
    {
        //arrange
        String inputToTest = "4";
        BigDecimal expected = new BigDecimal("20.00");
        String message = "moneyCount should set total amount to a big decimal value of 20.00 when fed \" 4 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnFive_whenInputOfFive()
    {
        //arrange
        String inputToTest = "5";
        BigDecimal expected = new BigDecimal("5.00");
        String message = "moneyCount should set total amount to a big decimal value of 5.00 when fed \" 5 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnTen_whenInputOfTen()
    {
        //arrange
        String inputToTest = "10";
        BigDecimal expected = new BigDecimal("10.00");
        String message = "moneyCount should set total amount to a big decimal value of 10.00 when fed \" 10 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnTwenty_whenInputOfTwenty()
    {
        //arrange
        String inputToTest = "20";
        BigDecimal expected = new BigDecimal("20.00");
        String message = "moneyCount should set total amount to a big decimal value of 20.00 when fed \" 20 \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnOne_whenInputOfOneAsWord()
    {
        //arrange
        String inputToTest = "one";
        BigDecimal expected = new BigDecimal("1.00");
        String message = "moneyCount should set total amount to a big decimal value of 1.00 when fed \" one \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnZero_whenInputOfQ()
    {
        //arrange
        String inputToTest = "q";
        BigDecimal expected = new BigDecimal("0.00");
        String message = "moneyCount should not set total amount to a big decimal value when fed \" q \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void feedMoney_shouldReturnZero_whenInputOfRandom()
    {
        //arrange
        String inputToTest = "randomString";
        BigDecimal expected = new BigDecimal("0.00");
        String message = "moneyCount should not set total amount to a big decimal value when fed \" randomString \"";

        //act
        FeedMoney.insertMoney(inputToTest);
        BigDecimal actual = Purchase.getTotalAmount();

        //assert
        assertEquals(message, expected, actual);
    }
}
