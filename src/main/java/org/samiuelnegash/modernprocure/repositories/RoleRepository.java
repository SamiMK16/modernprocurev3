package org.samiuelnegash.modernprocure.repositories;


import org.samiuelnegash.modernprocure.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
