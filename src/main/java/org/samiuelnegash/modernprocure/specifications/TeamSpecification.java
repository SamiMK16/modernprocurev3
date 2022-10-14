package org.samiuelnegash.modernprocure.specifications;

import org.samiuelnegash.modernprocure.entities.TeamEntity;
import org.springframework.data.jpa.domain.Specification;


public interface TeamSpecification {

    static Specification<TeamEntity> withActive(Boolean active) {
        return (root, query, cb) -> cb.equal(root.get("active"), active);
    }

}
