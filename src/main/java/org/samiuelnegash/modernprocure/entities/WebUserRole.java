package org.samiuelnegash.modernprocure.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "web_user_role")
@Data
public class WebUserRole extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "web_user_id")
    private WebUser webUser;
}

