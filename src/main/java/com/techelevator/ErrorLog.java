package com.techelevator;

import com.techelevator.UI.UserOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ErrorLog
{
    public static String getErrorLogString(String message)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now) + "  " + message;
    }

    public static void writeToErrorLog(String message)
    {
        File rewrite = new File("AuditRewrite.txt");
        File auditOriginal = new File("Audit.txt");
        Path rewritePath = Paths.get(rewrite.getAbsolutePath());
        Path auditOriginalPath = Paths.get(auditOriginal.getAbsolutePath());

        if(!rewrite.exists())
        {
            try
            {
                rewrite.createNewFile();
            }
            catch (IOException e)
            {
                // log the error
                e.printStackTrace();
            }
        }

        try(
            PrintWriter fileWriter = new PrintWriter(rewrite);
            Scanner fileReader = new Scanner(auditOriginal);
        )
        {
            while (fileReader.hasNextLine())
            {
                fileWriter.println(fileReader.nextLine());
            }

            fileWriter.println(getErrorLogString(message));

//            Files.move(rewritePath, auditOriginalPath);
        }
        catch (IOException e)
        {
            System.out.println("ERROR LOGGER FAILED: " + e.getMessage());
        }
        try
        {
            Files.delete(auditOriginalPath);
            Files.move(rewritePath, auditOriginalPath);
        }
        catch (IOException e){System.out.println("ERROR LOGGER FAILED: " + e.getMessage());}
    }

}
