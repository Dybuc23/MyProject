package com.app.api.mapper;

import com.app.api.entity.PaymentCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PymtCondMapper {

    private int paymentId;
    private String name;

    public PymtCondMapper(PaymentCondition paymentCondition) {
        this(paymentCondition.getPaymentId(),paymentCondition.getName());
    }
}
