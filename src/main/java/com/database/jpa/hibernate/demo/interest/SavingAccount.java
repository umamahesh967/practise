package com.database.jpa.hibernate.demo.interest;


import java.util.Arrays;

public class SavingAccount extends BankAccount {

    public SavingAccount(Double amount, Double rate, Transaction... transactions) {
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
    public Double getInterest(Integer duration) {
        // TODO

        double initialValue = getAmount();
        double compoundValue = initialValue * Math.pow(1 + getRateOfInterest()/12, 12 * duration);
//        setAmount(compoundValue);
        return compoundValue - initialValue;

    }

}

