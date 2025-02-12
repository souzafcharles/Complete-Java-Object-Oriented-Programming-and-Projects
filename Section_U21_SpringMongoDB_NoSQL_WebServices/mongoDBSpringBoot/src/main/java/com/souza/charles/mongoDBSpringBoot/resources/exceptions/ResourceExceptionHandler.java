package com.souza.charles.mongoDBSpringBoot.resources.exceptions;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 12, 2025
 */

import com.souza.charles.mongoDBSpringBoot.services.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler({SearchResultNotFoundException.class, ResourceNotFoundException.class, EmailNotFoundException.class})
    public ResponseEntity<StandardError> handleResourceNotFoundException(RuntimeException e, HttpServletRequest request) {
        String error = "Resource not found with the specified identifier or criteria.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> handleDatabaseException(DatabaseException e, HttpServletRequest request) {
        String error = "A database error occurred. Please check the provided data and try again.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmptyTableException.class)
    public ResponseEntity<StandardError> handleEmptyTableException(EmptyTableException e, HttpServletRequest request) {
        String error = "No data found in the requested table. Please verify the table name or check if it contains records.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<StandardError> handleBadRequestException(InvalidDataException e, HttpServletRequest request) {
        String error = "Invalid data provided. Please check the input and try again.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<StandardError> handleDuplicateEmailException(DuplicateEmailException e, HttpServletRequest request) {
        String error = "Email address already in use.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DateRangeInvalidException.class)
    public ResponseEntity<StandardError> handleDateRangeInvalidException(DateRangeInvalidException e, HttpServletRequest request) {
        String error = "Invalid Date Range";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}