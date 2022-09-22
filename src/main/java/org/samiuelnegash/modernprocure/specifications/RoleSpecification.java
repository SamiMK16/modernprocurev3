package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.domain.Role;
import org.springframework.data.jpa.domain.Specification;


public interface RoleSpecification {

    static Specification<Role> withSearch(String field, String search) {
        if (search == null) {
            return null;
        } else {
            return (root, query, cb) -> cb.like(root.get(field), "%" + search + "%");
        }
    }

}
