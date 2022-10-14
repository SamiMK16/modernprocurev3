package org.samiuelnegash.modernprocure.controllers;


import org.samiuelnegash.modernprocure.models.ProjectModel;
import org.samiuelnegash.modernprocure.services.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/project")
@RestController
@RequiredArgsConstructor
public class ProjectController {
    @NonNull
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<ProjectModel> createClient(@RequestBody ProjectModel projectmodel) {
        ProjectModel project = projectService.addProject(projectmodel);
        return (new ResponseEntity<>(project, HttpStatus.CREATED));
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProjectModel>> getAllResults() {
        List<ProjectModel> projectmodel = projectService.getAllProjects();
        return new ResponseEntity<>(projectmodel, HttpStatus.OK);
    }

    @GetMapping(path = "getproject/{id}")
    public ResponseEntity<ProjectModel> getUserById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return null;
        }
        ProjectModel projectmodel = this.projectService.getProjectWithId(id);
        return new ResponseEntity<>(projectmodel, HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public ProjectModel updateClient(@RequestBody ProjectModel projectmodel, @PathVariable(value = "id") Long id) {
        ProjectModel updatedProject = this.projectService.updateProject(projectmodel, id);
        return ResponseEntity.ok(updatedProject).getBody();
    }

    @DeleteMapping("delete/{id}")
    public ProjectModel updateClient(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return null;
        }
        ProjectModel updatedProject = this.projectService.deleteProject(id);
        return ResponseEntity.ok(updatedProject).getBody();
    }
}
