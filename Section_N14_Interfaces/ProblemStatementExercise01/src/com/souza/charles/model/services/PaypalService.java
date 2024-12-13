package com.souza.charles.model.services;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 13, 2024
 */

import com.souza.charles.model.utils.TaxConstants;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double paymentFee(double amount) {
        return amount * TaxConstants.TAX_RATE_FEE_PERCENTAGE;
    }

    @Override
    public Double interest(double amount, int months) {
        return amount * TaxConstants.TAX_RATE_MONTHLY_INTEREST * months;
    }
}
