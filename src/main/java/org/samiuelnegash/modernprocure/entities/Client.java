package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@Data
public class Client extends BaseEntity {
    @Column(name = "clientname")
    private String clientName;
    @Column(name = "client_number")
    private String clientNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private boolean active;
    @Column(name = "address")
    private String address;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
