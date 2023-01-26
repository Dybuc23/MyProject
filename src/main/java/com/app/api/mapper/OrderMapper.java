package com.app.api.mapper;

import com.app.api.entity.Client;
import com.app.api.entity.Order;
import com.app.api.entity.PaymentCondition;
import com.app.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderMapper {
    private int orderId;
    private String client;
    private String clientbusiness;
    private String paydocument;
    private String businessKind;
    private int pymt;
    private boolean status;

    public OrderMapper(Order order) {
        this(order.getOrderId(),
                order.getClient().getName(),
                order.getClient().getBusinessname(),
                order.getPaydocument(),
                order.getClient().getTypeclient().getName(),
                order.getClient().getTypeclient().getItemsPays().size(),
                order.isStatus());
    }
}
