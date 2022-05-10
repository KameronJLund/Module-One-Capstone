package com.techelevator.UI;

import com.techelevator.Product.Dessert;
import com.techelevator.Product.Drink;
import com.techelevator.Product.Munchy;
import com.techelevator.Product.Sandwich;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class UserOutputTests
{
    @Test
    public void dispenseItem_shouldReturnSugar_whenDessert()
    {
        //arrange
        Dessert test = new Dessert("test", new BigDecimal("0"), "TEST1");

        String expected = "*" + "test" + " falls to the bottom of the machine\n" + "Sugar, Sugar, so Sweet!\n";
        String message = "because Dessert should fall to the bottom of the machine with sugar sugar so sweet";

        //act
        String actual = UserOutput.dispenseString(test);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void dispenseItem_shouldReturnSlurp_whenDrink()
    {
        //arrange
        Drink test = new Drink("test", new BigDecimal("0"), "TEST1");

        String expected = "*" + "test" + " falls to the bottom of the machine\n" + "Drinky, Drinky, Slurp Slurp!\n";
        String message = "because Drink should fall to the bottom of the machine with Drinky, Drinky, Slurp Slurp!";

        //act
        String actual = UserOutput.dispenseString(test);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void dispenseItem_shouldReturnSlurp_whenSandwich()
    {
        //arrange
        Sandwich test = new Sandwich("test", new BigDecimal("0"), "TEST1");

        String expected = "*" + "test" + " falls to the bottom of the machine\n" + "Sandwich So Delicious, Yum!\n";
        String message = "because Sandwich should fall to the bottom of the machine with \"Sandwich So Delicious, Yum!\\n\"";

        //act
        String actual = UserOutput.dispenseString(test);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }

    @Test
    public void dispenseItem_shouldReturnSlurp_whenMunchy()
    {
        //arrange
        Munchy test = new Munchy("test", new BigDecimal("0"), "TEST1");

        String expected = "*" + "test" + " falls to the bottom of the machine\n" + "Munchy, Munchy, so Good!\n";
        String message = "because Munchy should fall to the bottom of the machine with Munchy, Munchy, so Good!";

        //act
        String actual = UserOutput.dispenseString(test);
        System.out.println(actual);

        //assert
        assertEquals(message, expected, actual);
    }
}
