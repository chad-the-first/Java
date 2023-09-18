package com.shadi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loan loan = new Loan();
        loan.setPrincipal() ;
        loan.setInterest();
        loan.setYears();

        Loan_Calculator loanCalculator = new Loan_Calculator();
        loanCalculator.printMortgage(loan);
        loanCalculator.printPaymentSchedule(loan);
    }
}

