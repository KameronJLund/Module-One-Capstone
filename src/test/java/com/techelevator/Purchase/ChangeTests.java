package com.techelevator.Purchase;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class ChangeTests
{
    BigDecimal changeDue;

    @Test
    public void getChange_shouldbe_1011_ifChangeDue_115(){
        changeDue = new BigDecimal("1.15");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 1.0, 0.0,1.0,1.0);
        String message = "Change should be 1 dollar, 0 quarters, 1 dime, and 1 nickel if changeDue is 1.15";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

    @Test
    public void getChange_shouldbe_0001_ifChangeDue_005(){
        changeDue = new BigDecimal("0.05");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 0.0, 0.0,0.0,1.0);
        String message = "Change should be 0 dollar, 0 quarters, 0 dime, and 1 nickel if changeDue is 0.05";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

    @Test
    public void getChange_shouldbe_1111_ifChangeDue_140(){
        changeDue = new BigDecimal("1.40");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 1.0, 1.0,1.0,1.0);
        String message = "Change should be 1 dollar, 1 quarters, 1 dime, and 1 nickel if changeDue is 1.40";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

    @Test
    public void getChange_shouldbe_0000_ifChangeDue_000(){
        changeDue = new BigDecimal("0.00");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 0.0, 0.0,0.0,0.0);
        String message = "Change should be 0 dollar, 0 quarters, 0 dime, and 0 nickel if changeDue is 0.00";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

    @Test
    public void getChange_shouldbe_0011_ifChangeDue_005(){
        changeDue = new BigDecimal("0.35");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 0.0, 1.0,1.0,0.0);
        String message = "Change should be 0 dollar, 1 quarters, 1 dime, and 0 nickel if changeDue is 0.35";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

    @Test
    public void getChange_shouldbe_0320_ifChangeDue_095(){
        changeDue = new BigDecimal("0.95");

        String expected = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                        + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , 0.0, 3.0,2.0,0.0);
        String message = "Change should be 0 dollar, 3 quarters, 2 dime, and 0 nickel if changeDue is 1.15";

        String actual = Change.changeMaker(changeDue);

        assertEquals(message, expected, actual);
    }

}
