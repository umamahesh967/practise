package com.database.jpa.hibernate.demo.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Dictionary
{
    static class Letter
    {
        Map<Character, Letter> map = new HashMap<>();
        List<String> valuesEndingHere = new ArrayList<>();
    }

    public static void main (String[] args)
    {
        Letter mainLetter = new Letter();

        //Inserting single word into the dictionary.
        String str = "ABC";
        String value = "AdsBcsCds";

        Letter dummy = mainLetter;
        int i=1;
        for(Character ch: str.toCharArray())
        {
            Letter letter = null;
            if(!dummy.map.containsKey(ch))
            {
                letter = new Letter();
                dummy.map.put(ch, letter);
            }
            else
            {
                letter = dummy.map.get(ch);
            }

            if(i == str.length())
            {
                dummy.valuesEndingHere.add(value);
            }
            dummy = letter;
            i++;
        }
    }

    private List<String> print(Letter letter, List<String> list)
    {
        list.addAll(letter.valuesEndingHere);
        for (Iterator<Letter> itr = letter.map.values().iterator(); itr.hasNext(); )
        {
            print(itr.next(), list);
        }

        return list;
    }
}
