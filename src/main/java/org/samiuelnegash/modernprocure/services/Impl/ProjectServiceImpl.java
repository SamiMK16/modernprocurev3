package org.samiuelnegash.modernprocure.services.Impl;

import org.samiuelnegash.modernprocure.entities.Project;
import org.samiuelnegash.modernprocure.exceptions.ResourceNotFoundException;
import org.samiuelnegash.modernprocure.models.ProjectModel;
import org.samiuelnegash.modernprocure.repository.ProjectRepository;
import org.samiuelnegash.modernprocure.services.ProjectService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @NonNull
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectModel addProject(ProjectModel projectmodel) {
        Project client = modeldToEntity(projectmodel);
        Project savedClient = this.projectRepository.save(client);
        return this.entityToModel(savedClient);
    }

    @Override
    public List<ProjectModel> getAllProjects() {
        List<Project> project = this.projectRepository.findAll();
        return project.stream().map(this::entityToModel).collect(Collectors.toList());
    }

    @Override
    public ProjectModel getProjectWithId(Long projectId) {
        Project project = projectRepository.findById((projectId)).orElseThrow(null);
        return entityToModel(project);
    }

    @Override
    public ProjectModel updateProject(ProjectModel projectmodel, Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Resource not exist"));
        project.setProjectName(projectmodel.getProjectName());
        project.setAmount(projectmodel.getAmount());
        project.setClient(projectmodel.getClient());
        Project updatedProject = projectRepository.save(project);
        return this.entityToModel(updatedProject);
    }

    @Override
    public ProjectModel deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(null);
        projectRepository.delete(project);
        return null;
    }

    private Project modeldToEntity(ProjectModel projectmodel) {
        return this.modelMapper.map(projectmodel, Project.class);
    }

    public ProjectModel entityToModel(Project project) {
        return this.modelMapper.map(project, ProjectModel.class);
    }

}
