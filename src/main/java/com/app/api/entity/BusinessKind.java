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
@Table(name = "t_businesskind")
public class BusinessKind implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int businessId;

        @Column(unique = true, nullable = false)
        private String name;

        @OneToOne(mappedBy = "businessKind")
        private Client client;

        @OneToMany(mappedBy = "condition")
        private Collection<PaymentCondition> itemsPays = new ArrayList<>();
}
