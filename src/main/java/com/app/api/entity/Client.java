package com.app.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    @Column(unique = true, nullable = false)
    private String businessname;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private String ruc;
    @Column
    private String address;
    @Column
    private String office;
    @Column
    private String cellnumber;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private String sex;
    @Column
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso= ISO.DATE)
    private LocalDate datebirth;
    @Column(name="status_client")
    private boolean status;
    @OneToOne
    @JoinColumn(name = "business_id",nullable = false,unique = true)
    private BusinessKind businessKind;

    @OneToMany(mappedBy = "client")
    private Collection<Order> itemsOrder = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users portfolio;

}
