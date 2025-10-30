package com.code.JavaIO;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//This reads bytes in buffered manner from input.jpg and writes to output.jpg.
//use buffered input and output streams for better performance with binary files.
//Buffering improves performance by reducing I/O calls.
public class BufferedCopyExample {

    public static void main(String[] args) {

        String input = "input.jpg";
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String output = "output_" + timestamp + ".jpg";
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input));

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(output));
            byte[] byteData = new byte[4024];//buffer size 4KB
            int bytesRead;
            //read byte-by-byte
            while((bytesRead = bis.read(byteData)) != -1) {
                bos.write(byteData, 0, bytesRead);
            }
            bis.close();
            bos.close();
            System.out.println("File copied successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}
