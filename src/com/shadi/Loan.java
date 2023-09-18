package com.shadi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Loan {
    private static Scanner scanner = new Scanner(System.in);
    private int principal = 0;
    private float interest = 0;
    private byte years = 0;

    public void setPrincipal() {
        principal = (int) readNumber("Principal: ", 1000, 1000000);
    }

    public void setInterest() {
        interest = (float) readNumber("Annual Interest Rate: ", 0, 30);
    }

    public void setYears() {
        years = (byte) readNumber("Period (years): ", 0, 50);
    }

    public int getPrincipal() {
        return principal;
    }

    public float getInterest() {
        return interest;
    }

    public byte getYears() {
        return years;
    }

    public double readNumber(String prompt, double min, double max) {
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
}
