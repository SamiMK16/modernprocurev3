package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.domain.Permission;
import org.springframework.data.jpa.domain.Specification;


public interface PermissionsSpecification {

    static Specification<Permission> withSearch(String field, String search) {
        if (search == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.like(root.get(field), "%" + search + "%");
        }
    }

}
