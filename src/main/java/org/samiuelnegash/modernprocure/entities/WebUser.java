package org.samiuelnegash.modernprocure.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "web_user")
@Data
public class WebUser extends BaseEntity {
    public final static Integer STATUS_ACTIVE = 0;
    public final static Integer STATUS_DISABLED = 1;
    public final static Integer STATUS_DELETED = 2;
    private static final long serialVersionUID = 1L;
    @Column(length = 255)
    private String email;


    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WebUserRole> webUserRoles;

    @OneToMany(mappedBy = "webUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WebUserPermission> webUserPermissions;

    @Column(name = "password", length = 255)
    @JsonIgnore
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "status")
    private Integer status;

    @Column(name = "dob")
    private Date birthday;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private Integer gender;

    public boolean hasStatus(Integer requestedStatus) {
        if (this.status == null) {
            this.status = 0;
        }
        return (this.status & requestedStatus) > 0;
    }

    public void addStatus(Integer requestedStatus) {
        if (this.status == null) {
            this.status = 0;
        }
        this.status |= requestedStatus;
    }

    public void removeStatus(Integer requestedStatus) {
        if (this.status == null) {
            this.status = 0;
        }
        this.status &= ~requestedStatus;
    }
}
