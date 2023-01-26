package com.app.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_payment_condition")
public class PaymentCondition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column
    private String name;

    @Column
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private BusinessKind condition;
}
