package com.database.jpa.hibernate.demo.java.tryWithResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Here in finally block we have to close the resources explicitly. Or else we are wasting the connection.
 *
 * To overcome this problem 1.7 version they have introduced the try with resources.
 */
public class TryCatchFinally
{
    public static void main(String args[])
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("In Finally");
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
