package com.database.jpa.hibernate.demo.interest;


import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new ArrayList<>();
    }

    public Double getInterest(Integer duration) {
        Double interest = 0d;
        for (BankAccount bankAccount : bankAccounts) {
            interest += bankAccount.getInterest(duration);
        }
        return interest;
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public static void main(String args[]) {
        Bank bank = new Bank();
        BankAccount saving = new SavingAccount(1000d, 0.05, new Transaction(500d), new Transaction(-500d));
        BankAccount current = new CurrentAccount(1000d, 0.05);
        bank.addBankAccount(saving);
        bank.addBankAccount(current);
        System.out.println(saving.getInterest(1)); // 51.16189788173301
        System.out.println(current.getInterest(1)); // 50.94533691406218
        System.out.println(bank.getInterest(1)); // 102.1072347957952
    }
}
