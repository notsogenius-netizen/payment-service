package com.sourabh.payment_service.service;

import com.sourabh.payment_service.AmountMismatchException;
import com.sourabh.payment_service.dto.PaymentDTO;
import com.sourabh.payment_service.entities.Payment;
import com.sourabh.payment_service.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public String confirmPayment(PaymentDTO paymentDTO){
        //check if fare is equal to paid amount.
        if (paymentDTO.getPaidAmount().equals(paymentDTO.getFare())){
            throw new AmountMismatchException("Pay the exact fare:" + paymentDTO.getFare(), HttpStatus.BAD_REQUEST);
        }

        Payment payment = new Payment();
        payment.setFare(paymentDTO.getFare());
        payment.setOriginStationId(paymentDTO.getOriginStationId());
        payment.setDestinationStationId(paymentDTO.getDestinationStationId());
        paymentRepository.save(payment);
        return "Payment is successful";
    }
}
