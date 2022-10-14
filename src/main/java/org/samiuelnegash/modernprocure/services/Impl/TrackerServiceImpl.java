package org.samiuelnegash.modernprocure.services.Impl;

import org.samiuelnegash.modernprocure.entities.Tracker;
import org.samiuelnegash.modernprocure.exceptions.ResourceNotFoundException;
import org.samiuelnegash.modernprocure.models.TrackerModel;
import org.samiuelnegash.modernprocure.repository.TrackerRepository;
import org.samiuelnegash.modernprocure.services.TrackerService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackerServiceImpl implements TrackerService {
    @NonNull
    @Autowired
    private TrackerRepository trackerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TrackerModel addTracker(TrackerModel trackermodel) {
        Tracker tracker = modeldToEntity(trackermodel);
        Tracker savedTracker = this.trackerRepository.save(tracker);
        return this.entityToModel(savedTracker);
    }

    @Override
    public List<TrackerModel> getAllTrackers() {
        List<Tracker> tracker = this.trackerRepository.findAll();
        return tracker.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    @Override
    public TrackerModel getTrackerWithId(Long trackerId) {
        Tracker tracker = trackerRepository.findById((trackerId)).orElseThrow(null);
        return entityToModel(tracker);
    }

    @Override
    public TrackerModel updateTracker(TrackerModel trackermodel, Long trackerId) {
        Tracker tracker = trackerRepository.findById(trackerId).orElseThrow(() -> new ResourceNotFoundException("Resource not exist"));
        tracker.setTitle(trackermodel.getTitle());
        tracker.setAmount(trackermodel.getAmount());
        tracker.setUser(trackermodel.getUser());
        tracker.setStartTime(trackermodel.getStartTime());
        tracker.setEndTime(trackermodel.getEndTime());
        Tracker updatedTracker = trackerRepository.save(tracker);
        return this.entityToModel(updatedTracker);
    }

    @Override
    public TrackerModel deleteTracker(Long trackerId) {
        Tracker tracker = trackerRepository.findById(trackerId).orElseThrow(null);
        trackerRepository.delete(tracker);
        return null;
    }

    private Tracker modeldToEntity(TrackerModel trackermodel) {
        return this.modelMapper.map(trackermodel, Tracker.class);
    }

    public TrackerModel entityToModel(Tracker tracker) {
        return this.modelMapper.map(tracker, TrackerModel.class);
    }

}
