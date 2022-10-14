package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Data
public class Permission extends BaseEntity {

    @Column(nullable = true, name = "permission_code")
    private String permissionCode;
    @Column(nullable = true, name = "title")
    private String title;
    @Column(nullable = true, name = "description")
    private String description;
    @Column(nullable = true, name = "permission_group_id")
    private Long permissionGroupId;
    @Enumerated(EnumType.STRING)
    @Column(name = "use")
    private PermissionUse use;
    @Column(name = "active")
    private boolean active;
    public enum PermissionUse {
        STAFF, CUSTOMER, ALL
    }
}
