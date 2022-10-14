package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "team")
public class TeamEntity extends BaseEntity {
    @Column(name = "firstName", nullable = false, length = 65)
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 65)
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "role")
    private String role;
    @Column(name = "age")
    private String age;
    @Column(name = "address")
    private String userAddress;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password")
    private String userPassword;
    @Column(name = "active")
    private boolean active;
}
