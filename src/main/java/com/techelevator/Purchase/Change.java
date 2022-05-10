package com.techelevator.Purchase;

import java.math.BigDecimal;

public class Change {

    public static String changeMaker(BigDecimal changeDue){

        double balance1;
        double onesCount;
        double quartersCount;
        double dimesCount;
        double nickelsCount;

        balance1 = (changeDue.doubleValue() * 100);
        balance1 = Math.ceil(balance1);
        onesCount = ((int) balance1 / 100);
        balance1 = balance1 - (onesCount * 100);
        quartersCount = ((int) balance1 / 25);
        balance1 = balance1 - (quartersCount * 25);
        dimesCount = ((int) balance1 / 10);
        balance1 = balance1 - (dimesCount * 10);
        nickelsCount = ((int) balance1 / 5);

        String.format("%.0f", onesCount);
        String lineToPrint = String.format("Your change is " + "%.0f" + " ones, " +  "%.0f"
                + " quarters, " + "%.0f" + " dimes and " + "%.0f" + " nickels. "
                , onesCount, quartersCount,dimesCount,nickelsCount);
        return lineToPrint;
    }
}
