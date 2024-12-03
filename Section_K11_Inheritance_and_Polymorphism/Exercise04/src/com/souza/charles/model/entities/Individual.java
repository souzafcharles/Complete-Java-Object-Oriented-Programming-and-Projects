package com.souza.charles.model.entities;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 27, 2024
 */

import com.souza.charles.model.utils.TaxConstants;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double taxToPay = 0.00;
        if (getAnnualIncome() < 20000.00) {
            if (getHealthExpenditures() > 0.00) {
                taxToPay = (getAnnualIncome() * TaxConstants.TAX_RATE_15) - (getHealthExpenditures() * TaxConstants.TAX_RATE_50);
            } else {
                taxToPay = getAnnualIncome() * TaxConstants.TAX_RATE_15;
            }
        } else {
            if (getHealthExpenditures() > 0.00) {
                taxToPay = (getAnnualIncome() * TaxConstants.TAX_RATE_25) - (getHealthExpenditures() * TaxConstants.TAX_RATE_50);
            } else {
                taxToPay = getAnnualIncome() * TaxConstants.TAX_RATE_25;
            }
        }
        return taxToPay;
    }
}