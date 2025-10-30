package com.code.JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//This reads bytes one-by-one from input.jpg and writes to output.jpg.
//use input and output streams for binary files.
public class CopyFileExample {


    public static void main(String[] args) {
        // Implementation goes here
        String input = "input.jpg";
                // Use new Time API
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String output = "output_" + timestamp + ".jpg";
 //        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try {
            FileInputStream fis =  new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            int byteData;
            //read byte-by-byte
            while((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            fis.close();
            fos.close();
            System.out.println("File copied successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
