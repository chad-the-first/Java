package com.shadi;

import java.text.NumberFormat;

public class Loan_Calculator {
    private double calculateMortgage(int principal, float interest, byte years) {
        double monthlyInterest = interest / 100 / 12;
        int months = years * 12;
        double mortgage = principal * ((monthlyInterest * Math.pow((1 + monthlyInterest), months)) / (Math.pow((1 + monthlyInterest), months) - 1));

        return mortgage;
    }

    private double calculateBalance(int principal, float interest, byte years, short numberOfPaymentsMade) {
        double monthlyInterest = interest / 100 / 12;
        int months = years * 12;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, months) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, months) - 1);

        return balance;
    }

    public void printMortgage(Loan loan) {
        int principal = loan.getPrincipal();
        float interest = loan.getInterest();
        byte years = loan.getYears();
        double mortgage = calculateMortgage(principal, interest, years);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println(NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public void printPaymentSchedule(Loan loan) {
        int principal = loan.getPrincipal();
        float interest = loan.getInterest();
        byte years = loan.getYears();
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (short month = 1; month < years * 12; month++){
            double balance = calculateBalance(principal, interest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
