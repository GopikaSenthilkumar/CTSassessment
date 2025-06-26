package com.example;
public class BankAccount {
	private String Name;
    private double bal;

    public BankAccount(String Name, double bal) {
        this.Name = Name;
        this.bal = bal;
    }

    public void deposit(double amt) {
        if (amt > 0)
            bal += amt;
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= bal)
            bal -= amt;
    }

    public double getBalance() {
        return bal;
    }

    public String getHolderName() {
        return Name;
    }

}
