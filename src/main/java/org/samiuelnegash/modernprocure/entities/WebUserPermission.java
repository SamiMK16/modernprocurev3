package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "web_user_permission")
@Data
public class WebUserPermission extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "web_user_id")
    private WebUser webUser;

    @Column(nullable = false, name = "active")
    private Boolean deny = false;
}
