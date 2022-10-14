package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.entities.Client;
import org.springframework.data.jpa.domain.Specification;


public interface ClientSpecification {

    static Specification<Client> withSearch(String field, String search) {
        return search == null ? null : ((root, query, cb) -> cb.like(root.get(field), "%" + search + "%"));
    }

    static Specification<Client> withActive(Boolean active) {
        return (root, query, cb) -> cb.equal(root.get("active"), active);
    }

}
