package com.database.jpa.hibernate.demo.java.multithreading.nonRepeatingCharacter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

//https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
public class ReadingFile
{
    public static void main(String[] args)throws Exception
    {
        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        String directory = "/Users/ubodanapu/Music/JPA/demo/src/main/java/com/database/jpa/hibernate/demo/multithreading/Thread.txt";
        File file = new File(directory);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
        {
            System.out.println(st);
        }


//        Scanner sc = new Scanner(file);
//
//        // we just need to use \\Z as delimiter
//        sc.useDelimiter("\\Z");
//
//        System.out.println(sc.next());


        //Return all line as list
        System.out.println(Files.readAllLines(Paths.get(directory), StandardCharsets.UTF_8));

        //Returns total content of file as string
        String data = new String(Files.readAllBytes(Paths.get(directory)));
        System.out.println(data);
    }
}
