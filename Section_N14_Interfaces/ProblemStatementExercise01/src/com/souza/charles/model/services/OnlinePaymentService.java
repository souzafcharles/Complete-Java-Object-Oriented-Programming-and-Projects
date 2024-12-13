package com.souza.charles.model.services;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Exercise done by: Charles Fernandes de Souza
  Date: December 13, 2024
 */
public interface OnlinePaymentService {
    Double paymentFee(double amount);

    Double interest(double amount, int months);
}
