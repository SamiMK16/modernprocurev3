package org.samiuelnegash.modernprocure.repositories;

import org.samiuelnegash.modernprocure.domain.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: itinsync-waqas
 * Date: 4/27/21
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long>, JpaSpecificationExecutor<PermissionGroup> {
}
