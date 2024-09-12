package com.database.jpa.hibernate.demo.java.tryWithResource;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Until 1.6 version whatever resources we have opened in try block we have to close them in finally block explicitly.
 *
 * In Java, the try-with-resources statement is a try statement that declares one or more resources.
 * The resource is as an object that must be closed after finishing the program. The try-with-resources
 * statement ensures that each resource is closed at the end of the statement execution.
 *
 * Once control comes to the end of the try block either normally or abnormally(Exception)
 * it will automatically close the resource/connection. We don't need to worry of closing the resource.
 *
 * You can pass any object that implements java.lang.AutoCloseable, which includes all objects
 * which implement java.io.Closeable.
 *
 * You can use catch and finally blocks with try-with-resources statement just like an ordinary try statement.
 *
 * Note - In a try-with-resources statement, catch or finally block executes after closing of the declared resources.
 *
 * https://www.javatpoint.com/java-try-with-resources
 * https://www.baeldung.com/java-try-with-resources
 */
public class TestTryWithResource
{
    public static void main(String args[]){
        // Using try-with-resources
        try(    // Using multiple resources
                FileOutputStream fileOutputStream =new FileOutputStream("/java7-new-features/src/abc.txt");
                InputStream input = new FileInputStream("/java7-new-features/src/abc.txt"))
        {
            // -----------------------------Code to write data into file--------------------------------------------//
            String msg = "Welcome to javaTpoint!";
            byte byteArray[] = msg.getBytes();  // Converting string into byte array
            fileOutputStream.write(byteArray);  // Writing  data into file
            System.out.println("------------Data written into file--------------");
            System.out.println(msg);


            // -----------------------------Code to read data from file---------------------------------------------//
            // Creating input stream instance
            DataInputStream inst = new DataInputStream(input);
            int data = input.available();
            // Returns an estimate of the number of bytes that can be read from this input stream.
            byte[] byteArray2 = new byte[data]; //
            inst.read(byteArray2);
            String str = new String(byteArray2); // passing byte array into String constructor
            System.out.println("------------Data read from file--------------");
            System.out.println(str); // display file data
        }

        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }
}
