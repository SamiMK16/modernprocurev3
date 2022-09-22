package org.samiuelnegash.modernprocure.models;

import org.samiuelnegash.modernprocure.domain.Permission;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;


@Data
@NoArgsConstructor
public class PermissionModel {
    private Long webId;
    private Boolean editable = true;
    private String code;
    private String title;
    private String description;
    private Long permissionGroupId;
    private boolean active;
    private Type type;
    private Permission.PermissionUse use;
    private String appPermission;


//    public PermissionModel(Permission permission, Customer customer) {
//        this.webId = permission.getWebId();
//        this.code = permission.getPermissionCode();
//        this.title = permission.getTitle();
//        this.description = permission.getDescription();
//        this.permissionGroupId = permission.getPermissionGroupId();
//        this.use = permission.getUse();
//        this.active = permission.getActive();
//        this.type = Type.getTypeFromCode(this.code);
//        if (customer != null) {
//            this.appPermission = "CUSTOMER";
//        } else {
//            this.appPermission = "STAFF";
//        }
//    }

    public PermissionModel(Permission permission) {
        this.webId = permission.getWebId();
        this.code = permission.getPermissionCode();
        this.title = permission.getTitle();
        this.description = permission.getDescription();
        this.permissionGroupId = permission.getPermissionGroupId();
        this.use = permission.getUse();
        this.type = Type.getTypeFromCode(this.code);
    }


    public Permission disassemble() {
        var permission = new Permission();
        permission.setPermissionCode(this.code);
        permission.setTitle(this.title);
        permission.setDescription(this.description);
        permission.setPermissionGroupId(this.permissionGroupId);
        permission.setUse(this.use);
        return permission;
    }
    public PermissionModel(Permission permission, Boolean editable){
        this.webId = permission.getWebId();
        this.code = permission.getPermissionCode();
        this.description = permission.getDescription();
        this.title = permission.getTitle();
        this.type = Type.getTypeFromCode(this.code);
        this.use = permission.getUse();
        this.editable = editable;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    public enum Type {
        CREATE, UPDATE, READ, DELETE, UNKNOWN;

        public static Type getTypeFromCode(String code) {
            if (StringUtils.endsWithIgnoreCase(code, "CREATE")) {
                return CREATE;
            } else if (StringUtils.endsWithIgnoreCase(code, "UPDATE")) {
                return UPDATE;
            } else if (StringUtils.endsWithIgnoreCase(code, "READ")) {
                return READ;
            } else if (StringUtils.endsWithIgnoreCase(code, "READ")) {
                return READ;
            } else if (StringUtils.endsWithIgnoreCase(code, "DELETE")) {
                return DELETE;
            } else {
                return UNKNOWN;
            }
        }
    }

    public PermissionModel assemble(Permission permission) {
        return new PermissionModel(permission);
    }
}
