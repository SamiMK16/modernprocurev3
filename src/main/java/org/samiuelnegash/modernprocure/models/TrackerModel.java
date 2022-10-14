package org.samiuelnegash.modernprocure.models;

import lombok.Data;

@Data
public class TrackerModel {
    private Long trackerId;
    private int amount;
    private String title;
    private String user;
    private String startTime;
    private String endTime;
}
