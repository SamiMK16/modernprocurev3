package org.samiuelnegash.modernprocure.controllers;

import lombok.NonNull;
import org.samiuelnegash.modernprocure.models.RoleModel;
import org.samiuelnegash.modernprocure.models.RolePermissionModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.RoleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    @NonNull
    private final RoleServices roleServices;

    @GetMapping
    private ResponseEntity<Page<RoleModel>> getRoles(@AuthenticationPrincipal AuthUserInfo user,
                                                     @RequestParam(required = false) String search,
                                                     @RequestParam(required = false) Long branch,
                                                     @RequestParam(required = false) boolean active,
                                                     Pageable pageable) {
        return ResponseEntity.ok(roleServices.getRoles(user, branch, active, search, pageable));
    }

    @PostMapping
    private ResponseEntity<RoleModel> createRole(@AuthenticationPrincipal AuthUserInfo user,
                                                 @RequestBody RoleModel roleModel) {
        return ResponseEntity.ok(roleServices.createRole(user, roleModel));
    }

    @PutMapping("{id}")
    private ResponseEntity<RoleModel> updateRole(@AuthenticationPrincipal AuthUserInfo user,
                                                 @PathVariable Long id,
                                                 @RequestBody RoleModel roleModel) {
        return ResponseEntity.ok(roleServices.updateRole(user, id, roleModel));
    }

    @DeleteMapping("{id}")
    private Boolean deleteRole(@AuthenticationPrincipal AuthUserInfo user,
                               @PathVariable Long id) {
        return roleServices.deleteRole(user, id);
    }

    @GetMapping("{id}/permission")
    private ResponseEntity<List<RolePermissionModel>> getRolePermissions(@AuthenticationPrincipal AuthUserInfo userInfo,
                                                                         @PathVariable Long id) {
        return ResponseEntity.ok(roleServices.getRolesAndPermission(userInfo, id));
    }

    @PostMapping("{id}/permission")
    private ResponseEntity<RolePermissionModel> addOrDeleteRolePermissions(@AuthenticationPrincipal AuthUserInfo userInfo,
                                                                           @PathVariable Long id,
                                                                           @RequestBody RolePermissionModel rolePermissionModel) {
        return ResponseEntity.ok(roleServices.addOrDeleteRolePermissions(userInfo, id, rolePermissionModel));
    }
}
