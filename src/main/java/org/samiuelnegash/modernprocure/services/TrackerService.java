package org.samiuelnegash.modernprocure.services;

import org.samiuelnegash.modernprocure.models.TrackerModel;

import java.util.List;

public interface TrackerService {
    TrackerModel addTracker(TrackerModel trackermodel);

    List<TrackerModel> getAllTrackers();

    TrackerModel getTrackerWithId(Long trackerId);

    TrackerModel updateTracker(TrackerModel trackermodel, Long trackerId);

    TrackerModel deleteTracker(Long trackerId);

}
