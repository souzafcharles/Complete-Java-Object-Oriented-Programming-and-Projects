package com.souza.charles.model.entities;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 27, 2024
 */
import com.souza.charles.model.utils.TaxConstants;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double taxToPay = 0.00;
        if (getNumberOfEmployees() > 10) {
            taxToPay = getAnnualIncome() * TaxConstants.TAX_RATE_14;
        } else {
            taxToPay = getAnnualIncome() * TaxConstants.TAX_RATE_16;
        }
        return taxToPay;
    }
}