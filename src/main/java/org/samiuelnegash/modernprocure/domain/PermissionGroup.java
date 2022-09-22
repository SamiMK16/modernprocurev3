package org.samiuelnegash.modernprocure.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "permission_group")
@Data
public class PermissionGroup extends BaseEntity
{

    @Column(nullable = true, name = "parent_web_id")
    private Long parentWebId;

    @Column(nullable = true, name = "description")
    private String description;

    @Column(nullable = true, name = "group_code")
    private String groupCode;
}
