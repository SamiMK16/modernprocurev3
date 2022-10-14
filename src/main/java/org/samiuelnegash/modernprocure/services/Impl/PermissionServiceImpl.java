package org.samiuelnegash.modernprocure.services.Impl;


import org.samiuelnegash.modernprocure.entities.Permission;
import org.samiuelnegash.modernprocure.exceptions.ResourceNotFoundException;
import org.samiuelnegash.modernprocure.models.PermissionModel;
import org.samiuelnegash.modernprocure.repository.PermissionsRepository;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.PermissionServices;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static org.samiuelnegash.modernprocure.common.Constants.RECORD_DOES_NOT_EXIST_FOR_ID;
import static org.samiuelnegash.modernprocure.specifications.PermissionsSpecification.withActive;
import static org.samiuelnegash.modernprocure.specifications.PermissionsSpecification.withSearch;


@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionServices {
    @NonNull PermissionsRepository permissionsRepository;


    @Override
    public Page<PermissionModel> getPermissions(AuthUserInfo user, Long branch, boolean active, String search, Pageable pageable) {
        Specification<Permission> permissionSpecification = Specification.where(withActive(active));
        if (!StringUtils.isEmpty(search)) {
            permissionSpecification = permissionSpecification.and(withSearch("title", search)).or(withSearch("description", search)).or(withSearch("permissionCode", search));
        }
        return permissionsRepository.findAll(permissionSpecification, pageable).map(PermissionModel::new);
    }

    @Override
    public PermissionModel createPermission(AuthUserInfo user, PermissionModel permissionModel) {
        permissionModel.setActive(true);
        permissionModel.setPermissionGroupId(1L);
        return new PermissionModel(permissionsRepository.save(permissionModel.disassemble()));
    }

    @Override
    public PermissionModel updatePermission(AuthUserInfo user, Long webId, PermissionModel permissionModel) {
        return permissionsRepository.findById(webId).map(permission -> {
            permission.setPermissionGroupId(permissionModel.getPermissionGroupId());
            permission.setDescription(permissionModel.getDescription());
            permission.setTitle(permissionModel.getTitle());
            permission.setUse(permissionModel.getUse());
            permission.setPermissionGroupId(1L);
            return new PermissionModel(permissionsRepository.save(permission));
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + user.getWebId()));
    }

    @Override
    public Boolean deletePermission(AuthUserInfo user, Long webId) {
        return permissionsRepository.findById(webId).map(permission -> {
            permissionsRepository.delete(permission);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + webId));
    }
}
