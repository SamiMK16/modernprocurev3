package org.samiuelnegash.modernprocure.models;


import org.samiuelnegash.modernprocure.entities.Permission;
import org.samiuelnegash.modernprocure.entities.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class RoleModel {
    private Long webId;
    private String description;
    private String title;
    private Long roleId;
    private String externalKey;
    private String roleCode;
    private List<Permission> permissions;
    private Role.RoleUse use;
    private boolean active;
    private boolean role;
    private String operation;
    private List<Long> permissionId;


    public RoleModel(Role role) {
        this.webId = role.getWebId();
        this.title = role.getTitle();
        this.roleCode = role.getRoleCode();
        this.externalKey = role.getExternalKey();
        this.description = role.getDescription();
        this.use = role.getUse();
    }


    public Role disassemble() {
        var role = new Role();
        role.setTitle(this.title);
        role.setDescription(this.description);
        role.setUse(this.use);
        role.setRoleCode(this.roleCode);
        role.setExternalKey(this.externalKey);
        role.setActive(true);
        return role;
    }

    public RoleModel assemble(Role role) {
        return new RoleModel(role);
    }
}
