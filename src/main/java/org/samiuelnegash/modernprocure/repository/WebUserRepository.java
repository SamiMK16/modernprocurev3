package org.samiuelnegash.modernprocure.repository;

import org.samiuelnegash.modernprocure.entities.Permission;
import org.samiuelnegash.modernprocure.entities.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public interface WebUserRepository extends JpaRepository<WebUser, Long>, JpaSpecificationExecutor<WebUser> {
    Optional<WebUser> findByEmailIgnoreCaseAndStatus(String userName, Integer status);

    Optional<WebUser> findByWebIdAndActiveAndStatus(Long webId, boolean active, Integer status);

    @Query("select p from Permission p " +
            " join RolePermission rp on rp.permission.webId = p.webId" +
            " join WebUserRole wur on wur.role.webId = rp.role.webId where wur.webUser=:webUser ")
    List<Permission> getPermissionForWebUser(WebUser webUser);

    int countByEmailIgnoreCaseAndStatus(String userName, Integer status);

//    @Query("select i from File i where i.entityWebId=:userId")
//    ImageModel getFileByUserId(Long userId);
}
