package org.samiuelnegash.modernprocure.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity
{
    public enum RoleUse
    {
        STAFF, CUSTOMER
    }

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String title;

    @Column(name = "external_key", length = 255)
    private String externalKey;

    @Column(name = "role_code")
    private String roleCode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission", joinColumns =
            {
                    @JoinColumn(name = "role_id")
            }, inverseJoinColumns =
            {
                    @JoinColumn(name = "permission_id")
            })
    private List<Permission> permissions;

    @Enumerated(EnumType.STRING)
    @Column(name = "use")
    private RoleUse use;
}
