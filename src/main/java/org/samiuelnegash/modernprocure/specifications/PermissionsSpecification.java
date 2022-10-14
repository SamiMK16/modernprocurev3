package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.entities.Permission;
import org.springframework.data.jpa.domain.Specification;


public interface PermissionsSpecification {

    static Specification<Permission> withSearch(String field, String search) {
        return search == null ? null : (root, query, cb) -> cb.like(root.get(field), "%" + search + "%");
    }

    static Specification<Permission> withActive(Boolean active) {
        return (root, query, cb) -> cb.equal(root.get("active"), active);
    }

}
