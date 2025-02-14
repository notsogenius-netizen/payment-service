package com.sourabh.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String id;
    private Long originStationId;
    private Long destinationStationId;
    private Double fare;
    private Double paidAmount;
}
