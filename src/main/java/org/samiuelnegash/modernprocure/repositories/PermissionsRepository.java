package org.samiuelnegash.modernprocure.repositories;


import org.samiuelnegash.modernprocure.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionsRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission>
{
}
