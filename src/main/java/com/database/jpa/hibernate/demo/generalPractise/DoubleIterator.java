package com.database.jpa.hibernate.demo.generalPractise;

import java.util.Iterator;
import java.util.List;

public class DoubleIterator<T> implements Iterator<T>
{
    List<List<T>> list = null;

    Iterator<List<T>> parentItr;
    Iterator<T> childItr;

    public DoubleIterator(List<List<T>> list) {
        this.list = list;
        if(list != null)
        {
            parentItr = list.iterator();
        }
    }

    @Override
    public boolean hasNext()
    {
        if(childItr == null || !childItr.hasNext())
        {
            if(parentItr.hasNext())
            {
                childItr = parentItr.next().iterator();
                if(childItr.hasNext())
                {
                    return true;
                }
                else
                {
                    return hasNext();
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public T next()
    {
        if(hasNext())
        {
            return childItr.next();
        }
        return null;
    }
}
