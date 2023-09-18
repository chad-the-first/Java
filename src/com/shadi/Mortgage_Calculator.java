package com.shadi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage_Calculator {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1000000);
        float interest = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) readNumber("Period (years): ", 0, 50);

        printMortgage(principal, interest, years);
        printPaymentSchedule(years, principal, interest);
    }

    private static void printMortgage(int principal, float interest, byte years) {
        double mortgage = calculateMortgage(principal, interest, years);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println(NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(byte years, int principal, float interest) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (short month = 1; month < years * 12; month++){
            double balance = calculateBalance(principal, interest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value <= min || value > max){
                System.out.println("Enter a value between " + min + " and " + max);
                continue;
            }
            break;
        }
        return value;
    }
    public static double calculateBalance(int principal, float interest, byte years, short numberOfPaymentsMade) {
        double monthlyInterest = interest / 100 / 12;
        int months = years * 12;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, months) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, months) - 1);

        return balance;
    }
    public static double calculateMortgage(int principal, float interest, byte years) {
        double monthlyInterest = interest / 100 / 12;
        int months = years * 12;
        double mortgage = principal * ((monthlyInterest * Math.pow((1 + monthlyInterest), months)) / (Math.pow((1 + monthlyInterest), months) - 1));

        return mortgage;
    }
}
