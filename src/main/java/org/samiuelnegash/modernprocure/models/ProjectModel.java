package org.samiuelnegash.modernprocure.models;

import lombok.Data;

@Data
public class ProjectModel {
    private Long projectId;
    private String projectName;
    private int amount;
    private String client;

}
