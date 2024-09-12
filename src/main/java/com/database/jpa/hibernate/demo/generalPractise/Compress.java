package com.database.jpa.hibernate.demo.generalPractise;

public class Compress
{
    public static void main(String[] args)
    {
        String string = "ABABCABABCD"; // "AB*C*D"

        String str = "";

        int lastIncludedIndex = -1;
        for (int i = 0; i < string.length(); i++)
        {
            if(i%2 ==0)
            {
                str += string.charAt(i);
            }
            else
            {
                if(lastIncludedIndex == -1)
                {
                    String firstHalf = string.substring(0, (i+1)/2);
                    String secondHalf = string.substring((i+1)/2, i+1);
                    if(firstHalf.equals(secondHalf))
                    {
                        str = str.substring(0, str.length() - (secondHalf.length() - 1) ); //AB*CABAB
                        str += "*";
                        lastIncludedIndex = i;
                    }
                    else
                    {
                        str += string.charAt(i);
                    }
                }
                else
                {
                    if(i >= (lastIncludedIndex * 2 + 1))
                    {
                        String firstHalf = string.substring(0, (i+1)/2);
                        String secondHalf = string.substring((i+1)/2, i+1);
                        if(firstHalf.equals(secondHalf))
                        {
                            str = str.substring(0, str.length() - (secondHalf.length() - 1) ); //AB*CABAB
                            str += "*";
                            lastIncludedIndex = i;
                        }
                        else
                        {
                            str += string.charAt(i);
                        }
                    }
                    else
                    {
                        str += string.charAt(i);
                    }
                }
            }
        }

        System.out.println(str);
    }
}
