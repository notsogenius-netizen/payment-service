package com.sourabh.payment_service.controller;

import com.sourabh.payment_service.dto.PaymentDTO;
import com.sourabh.payment_service.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping
    public ResponseEntity<String> confirmPayment(PaymentDTO paymentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.confirmPayment(paymentDTO));
    }
}
