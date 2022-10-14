package org.samiuelnegash.modernprocure.repository;


import org.samiuelnegash.modernprocure.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionsRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
}
