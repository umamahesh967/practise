package com.database.jpa.hibernate.demo.interest;


import java.util.List;

public abstract class BankAccount {
    private Double amount;
    private Double rateOfInterest;
    private List<Transaction> transactions;

    public BankAccount(Double amount, Double rateOfInterest, List<Transaction> transactions) {
        super();
        this.amount = amount;
        this.rateOfInterest = rateOfInterest;
        this.transactions = transactions;
    }

    public abstract Double getInterest(Integer duration);

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
