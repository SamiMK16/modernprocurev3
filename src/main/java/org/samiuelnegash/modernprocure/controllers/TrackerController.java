package org.samiuelnegash.modernprocure.controllers;


import org.samiuelnegash.modernprocure.models.TrackerModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.TrackerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/tracker")
@RestController
@RequiredArgsConstructor
public class TrackerController {
    @NonNull
    private TrackerService trackerService;

    @PostMapping("/add")
    public ResponseEntity<TrackerModel> createTracker(@AuthenticationPrincipal AuthUserInfo user, @RequestBody TrackerModel trackermodel) {
        return (new ResponseEntity<>(trackerService.addTracker(trackermodel), HttpStatus.CREATED));
    }

    @GetMapping("/get")
    public ResponseEntity<List<TrackerModel>> getAllResults(@AuthenticationPrincipal AuthUserInfo user) {
        return new ResponseEntity<>(trackerService.getAllTrackers(), HttpStatus.OK);
    }

    @GetMapping(path = "gettracker/{id}")
    public ResponseEntity<TrackerModel> getTrackerById(@AuthenticationPrincipal AuthUserInfo user, @PathVariable(value = "id") Long id) {
        return id == null ? null : new ResponseEntity<>(trackerService.getTrackerWithId(id), HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public TrackerModel updateTracker(@AuthenticationPrincipal AuthUserInfo user, @RequestBody TrackerModel trackermodel, @PathVariable Long id) {
        return ResponseEntity.ok(trackerService.updateTracker(trackermodel, id)).getBody();
    }

    @DeleteMapping("delete/{id}")
    public TrackerModel DeleteClient(@AuthenticationPrincipal AuthUserInfo user, @PathVariable(value = "id") Long id) {
        return id == null ? null : ResponseEntity.ok(trackerService.deleteTracker(id)).getBody();
    }
}
