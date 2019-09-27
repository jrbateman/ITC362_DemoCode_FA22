package com.bateman.autopurchase;

/**
 * Data model for an auto
 */
public class Auto {
    static final double STATE_TAX = .07;
    static final double INTEREST_RATE = .09;


    private double mPrice;
    private double mDownPayment;
    private int mLoanTerm;

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setDownPayment(double down) {
        mDownPayment = down;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setLoanTerm(String term) {
        if (term.contains("2"))
            mLoanTerm = 2;
        else if (term.contains("3"))
            mLoanTerm = 3;
        else
            mLoanTerm = 4;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public double taxAmount() {
        return mPrice * STATE_TAX;
    }

    public double totalCost() {
        return mPrice + taxAmount();
    }

    public double borrowedAmount() {
        return totalCost() - mDownPayment;
    }

    public double interestAmount() {
        return borrowedAmount() * INTEREST_RATE;
    }

    public double monthlyPayment() {
        return borrowedAmount() / (mLoanTerm * 12);
    }

}
