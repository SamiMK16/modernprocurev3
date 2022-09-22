package org.samiuelnegash.modernprocure.services;

import org.samiuelnegash.modernprocure.models.PermissionModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by IntelliJ IDEA.
 * User: itinsync-waqas
 * Date: 4/27/21
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PermissionServices {
    Page<PermissionModel> getPermissions(AuthUserInfo user, Long branch, boolean active, String search, Pageable pageable);

    PermissionModel createPermission(AuthUserInfo user, PermissionModel permissionModel);

    PermissionModel updatePermission(AuthUserInfo user, Long userId, PermissionModel permissionModel);

    Boolean deletePermission(AuthUserInfo user, Long userId);
}
