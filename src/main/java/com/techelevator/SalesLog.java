package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesLog {
    public void writer(String name, int amountSold) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

            logWriter.println(dtf.format(now) + "\t" + String.format("%-20s",name) + String.format("%-10s",amountSold));

        } catch (FileNotFoundException e) {
            ErrorLog.writeToErrorLog(e.getMessage());
        }
    }
}
