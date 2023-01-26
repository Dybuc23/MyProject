package com.app.api.mapper;

import com.app.api.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientMapper {
    private int clientId;
    private String businessname;
    private String name;
    private String lastname;
    private String ruc;
    private String address;
    private String office;
    private String number;
    private String telephone;
    private String email;
    private String sex;
    private LocalDate datebirth;
    private boolean status;
    private String typeclient;

    public ClientMapper(Client client) {
        this(client.getClientId(),
                client.getBusinessname(),
                client.getName(),
                client.getLastname(),
                client.getRuc(),
                client.getAddress(),
                client.getOffice(),
                client.getNumber(),
                client.getTelephone(),
                client.getEmail(),
                client.getSex(),
                client.getDatebirth(),
                client.isStatus(),
                client.getTypeclient().getName());
    }
}
