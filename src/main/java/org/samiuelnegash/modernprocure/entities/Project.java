package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "project")
@Data
public class Project extends BaseEntity {
    @Column(name = "projectName", nullable = false, unique = true)
    private String projectName;
    @Column(name = "client")
    private String client;
    @Column(name = "amount")
    private int amount;
}
