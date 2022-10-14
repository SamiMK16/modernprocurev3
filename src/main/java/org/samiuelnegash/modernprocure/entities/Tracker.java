package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tracker")
@Data
public class Tracker extends BaseEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "amount")
    private int amount;
    @Column(name = "participant")
    private String user;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
}
