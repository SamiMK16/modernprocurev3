package org.samiuelnegash.modernprocure.controllers;


import org.samiuelnegash.modernprocure.models.TeamModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.TeamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/team/")
@RestController
@RequiredArgsConstructor
public class TeamController {
    @NonNull
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity<TeamModel> createUser(@AuthenticationPrincipal AuthUserInfo user, @RequestBody TeamModel usermodel) {
        return (new ResponseEntity<>(teamService.addAUser(user, usermodel), HttpStatus.CREATED));
    }

    @GetMapping("")
    public ResponseEntity<Page<TeamModel>> getAllResults(@AuthenticationPrincipal AuthUserInfo user, Pageable pageable) {
        return new ResponseEntity<>(teamService.getAllUsers(user, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TeamModel> getUserById(@AuthenticationPrincipal AuthUserInfo user, @PathVariable Long id) {
        return id == null ? null : new ResponseEntity<>(this.teamService.getUserWithId(user, id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeamModel> updateUser(@AuthenticationPrincipal AuthUserInfo user, @RequestBody TeamModel teamModel, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(this.teamService.updateUser(user, teamModel, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> updateUser(@AuthenticationPrincipal AuthUserInfo user, @PathVariable(value = "id") Long id) {
        return id == null ? null : ResponseEntity.ok(teamService.deleteUser(user, id));
    }
}
