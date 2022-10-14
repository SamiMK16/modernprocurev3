package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.entities.Role;
import org.springframework.data.jpa.domain.Specification;


public interface RoleSpecification {

    static Specification<Role> withSearch(String field, String search) {
        return search == null ? null : ((root, query, cb) -> cb.like(root.get(field), "%" + search + "%"));
    }

    static Specification<Role> withActive(Boolean active) {
        return (root, query, cb) -> cb.equal(root.get("active"), active);
    }

}
