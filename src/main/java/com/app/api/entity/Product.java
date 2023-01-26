package com.app.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_product")
public class Product implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer productId;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String brand;

    //@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
    //private LocalDate fvencimiento;

    @Column
    private Integer stock;

    @Column
    private boolean status;

    //@ManyToOne
    //@JoinColumn(name = "categoria_id",nullable = false)
    //private Categoria categoria;

    @ManyToMany(mappedBy="itemsProduct")
    private Set<Order> itemsOrder =  new HashSet<>();
}
