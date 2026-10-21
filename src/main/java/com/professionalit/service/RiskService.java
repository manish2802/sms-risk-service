package com.professionalit.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.professionalit.model.RiskRequest;
import com.professionalit.model.RiskResponse;

@Service
public class RiskService {

    private static final BigDecimal MAX_ORDER_VALUE =
            new BigDecimal("1000000");

    public RiskResponse validateRisk(RiskRequest request) {

        // Validate quantity
        if (request.getQuantity() == null ||
                request.getQuantity() <= 0) {

            return RiskResponse.builder()
                    .approved(false)
                    .message("Order quantity must be greater than zero")
                    .build();
        }

        // Validate price
        if (request.getPrice() == null ||
                request.getPrice().compareTo(BigDecimal.ZERO) <= 0) {

            return RiskResponse.builder()
                    .approved(false)
                    .message("Order price must be greater than zero")
                    .build();
        }

        // Calculate order value
        BigDecimal orderValue =
                request.getPrice()
                        .multiply(
                                BigDecimal.valueOf(
                                        request.getQuantity()
                                )
                        );

        System.out.println(
                "Risk validation: account="
                        + request.getAccountNumber()
                        + ", symbol="
                        + request.getSymbol()
                        + ", quantity="
                        + request.getQuantity()
                        + ", price="
                        + request.getPrice()
                        + ", orderValue="
                        + orderValue
        );

        // Risk limit validation
        if (orderValue.compareTo(MAX_ORDER_VALUE) > 0) {

            return RiskResponse.builder()
                    .approved(false)
                    .message(
                            "Order rejected: order value ₹"
                                    + orderValue
                                    + " exceeds maximum risk limit of ₹"
                                    + MAX_ORDER_VALUE
                    )
                    .build();
        }

        // Risk approved
        return RiskResponse.builder()
                .approved(true)
                .message(
                        "Risk validation successful for "
                                + request.getSymbol()
                )
                .build();
    }
}