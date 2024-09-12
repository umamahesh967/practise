package com.database.jpa.hibernate.demo.generalPractise;

public class GenerateIPAddress
{
    public static void main(String[] args)
    {
        generate("25525511135", 0, 1, "");
    }

    private static void generate(String string, int index, int count, String ip)
    {
        if(count == 4)
        {
            Integer integer = Integer.parseInt(string.substring(index));
            if(integer >= 0 && integer < 256)
            {
                System.out.println(ip+integer);
            }
            return;
        }else
        {
            for(int i=1; i<=3; i++)
            {
                Integer integer = Integer.parseInt(string.substring(index, index+i));
                if(integer >= 0 && integer < 256)
                {
                    generate(string, index+i, count+1, ip+integer+".");
                }
            }
        }
    }
}
