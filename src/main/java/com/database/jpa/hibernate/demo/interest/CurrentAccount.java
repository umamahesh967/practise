package com.database.jpa.hibernate.demo.interest;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(Double amount, Double rate, Transaction... transactions)
    {
        super(amount, rate, Arrays.asList(transactions));

        double finalAmount = getAmount();
//        if(transactions.length > 0)
//        {
            for(Transaction transaction: transactions)
            {
                finalAmount = finalAmount - transaction.getAmount();
            }
            setAmount(finalAmount);
//        }
    }

    @Override
    public Double getInterest(Integer duration)
    {
        double initialValue = getAmount();
        double compoundValue = initialValue * Math.pow(1 + getRateOfInterest()/4, 4 * duration);
//        setAmount(compoundValue);
        return compoundValue - initialValue;
    }
}
