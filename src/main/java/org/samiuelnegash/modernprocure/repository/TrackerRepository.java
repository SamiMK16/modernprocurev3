package org.samiuelnegash.modernprocure.repository;

import org.samiuelnegash.modernprocure.entities.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {

}