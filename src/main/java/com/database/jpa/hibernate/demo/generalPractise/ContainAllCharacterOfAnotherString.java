package com.database.jpa.hibernate.demo.generalPractise;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ContainAllCharacterOfAnotherString {
    public static void main (String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(reader.readLine());
        while( t-- > 0)
        {
            String str = reader.readLine();
            String pattern = reader.readLine();
            int[] table = new int[26];
            Map<Character, Integer> map = new HashMap();
            int noOfChar = 0;
            for(char ch: pattern.toCharArray())
            {
                table[ch-'a']++;
                noOfChar++;
            }

            int count =0;
            int start = 0, end =0;
            int startIndex = -1;
            int totalLength = Integer.MAX_VALUE;
            for(int i=0; i<str.length(); i++)
            {
                char ch = str.charAt(i);

                if(table[ch-'a'] > 0)
                {
                    if(map.containsKey(ch))
                    {
                        if(map.get(ch) <  table[ch-'a'])
                        {
                            count++;
                        }
                        map.put( ch, map.get(ch) + 1);
                    }
                    else
                    {
                        count++;
                        map.put( ch, 1);
                    }
                }

                while(count >= noOfChar)
                {
                    char ch1 = str.charAt(start);
                    if(!map.containsKey(ch1))
                    {
                        start++;
                    }
                    else if(map.get(ch1) > table[ch1-'a'])
                    {
                        map.put(ch1, map.get(ch1)-1);
                        start++;
                    }
                    else
                    {
                        if(i- start+1 < totalLength)
                        {
                            totalLength = i- start + 1;
                            startIndex = start;
                        }
                        break;
                    }
                }
            }
            if(startIndex == -1)
            {
                System.out.println("-1");
            }
            else
            {
                System.out.println(str.substring(startIndex, startIndex+totalLength));
            }
        }
    }
}