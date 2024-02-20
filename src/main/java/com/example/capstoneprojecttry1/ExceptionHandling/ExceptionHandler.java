package com.example.capstoneprojecttry1.ExceptionHandling;

import com.example.capstoneprojecttry1.Exceptions.ProductNotFoundException;
import com.example.capstoneprojecttry1.dtos.ArithmeticExceptionDTO;
import com.example.capstoneprojecttry1.dtos.ProductNotFoundExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDTO> handleArithmeticException(ArithmeticException exception) {
        ArithmeticExceptionDTO arithmeticExceptionDTO = new ArithmeticExceptionDTO();
        arithmeticExceptionDTO.setMessage("Something wrong bla bla . . .");
        return new ResponseEntity<>(arithmeticExceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ProductNotFoundExceptionDTO productNotFoundExceptionDTO = new ProductNotFoundExceptionDTO();
        productNotFoundExceptionDTO.setMessage("Product is not found in the DB");

        return new ResponseEntity<>(productNotFoundExceptionDTO, HttpStatus.NOT_FOUND);
    }
}
