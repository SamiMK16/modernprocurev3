package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "role_permission")
@Data
public class RolePermission extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private Permission permission;
}

