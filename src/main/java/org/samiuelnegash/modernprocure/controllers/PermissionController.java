package org.samiuelnegash.modernprocure.controllers;


import org.samiuelnegash.modernprocure.models.PermissionModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.PermissionServices;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permission")
@RequiredArgsConstructor
public class PermissionController {
    @NonNull
    private final PermissionServices permissionServices;

    @GetMapping
    public ResponseEntity<Page<PermissionModel>> getPermissions(@AuthenticationPrincipal AuthUserInfo user, @RequestParam(required = false) String search, @RequestParam(required = false) Long branch, @RequestParam(required = false, defaultValue = "true") boolean active, Pageable pageable) {
        return ResponseEntity.ok(permissionServices.getPermissions(user, branch, active, search, pageable));
    }

    @PostMapping
    public ResponseEntity<PermissionModel> createPermission(@AuthenticationPrincipal AuthUserInfo user, @RequestBody PermissionModel permissionModel) {
        return ResponseEntity.ok(permissionServices.createPermission(user, permissionModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<PermissionModel> updatePermission(@AuthenticationPrincipal AuthUserInfo user, @PathVariable Long id, @RequestBody PermissionModel permissionModel) {
        return ResponseEntity.ok(permissionServices.updatePermission(user, id, permissionModel));
    }

    @DeleteMapping("{id}")
    public Boolean getPermissions(@AuthenticationPrincipal AuthUserInfo user, @PathVariable Long id) {
        return permissionServices.deletePermission(user, id);
    }

}
