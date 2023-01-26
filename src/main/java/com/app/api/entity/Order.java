package com.app.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="order_details",
            joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private Set<Product> itemsProduct=new HashSet<>();

    @Column(unique = true, nullable = false)
    private String paydocument;

    @Column
    private boolean status;

    public void addProduct(Product product) {
        this.itemsProduct.add(product);
    }
}
