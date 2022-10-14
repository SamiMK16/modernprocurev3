package org.samiuelnegash.modernprocure.services.Impl;

import org.samiuelnegash.modernprocure.entities.TeamEntity;
import org.samiuelnegash.modernprocure.exceptions.ResourceNotFoundException;
import org.samiuelnegash.modernprocure.models.TeamModel;
import org.samiuelnegash.modernprocure.repository.TeamRepository;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.TeamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.samiuelnegash.modernprocure.common.Constants.RECORD_DOES_NOT_EXIST_FOR_ID;
import static org.samiuelnegash.modernprocure.specifications.TeamSpecification.withActive;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    @NonNull
    private TeamRepository teamRepository;

    @Override
    public TeamModel addAUser(AuthUserInfo user, TeamModel userModel) {
        var team = userModel.disassemble();
        team.setUserPassword(userModel.getUserPassword());
        return new TeamModel(teamRepository.save(team));
    }

    @Override
    public Page<TeamModel> getAllUsers(AuthUserInfo user, Pageable pageable) {
        Specification<TeamEntity> teamEntitySpecification = Specification.where(withActive(true));
        return teamRepository.findAll(teamEntitySpecification, pageable).map(TeamModel::new);
    }

    @Override
    public TeamModel getUserWithId(AuthUserInfo user, Long userId) {
        return teamRepository.findById((userId)).map(TeamModel::new).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + userId));
    }

    @Override
    public TeamModel updateUser(AuthUserInfo user, TeamModel teamModel, Long userId) {
        return teamRepository.findById(userId).map(teamEntity -> {
            teamEntity.setFirstName(teamModel.getFirstName());
            teamEntity.setLastName(teamModel.getLastName());
            teamEntity.setPhoneNumber(teamModel.getPhoneNumber());
            teamEntity.setEmail(teamModel.getEmail());
            teamEntity.setRole(teamModel.getRole());
            teamEntity.setUserAddress(teamModel.getUserAddress());
            teamEntity.setUserPassword(teamModel.getUserPassword());
            teamEntity.setGender(teamModel.getGender());
            teamEntity.setActive(teamModel.isActive());
            return new TeamModel(teamRepository.save(teamEntity));
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + userId));
    }

    @Override
    public Boolean deleteUser(AuthUserInfo user, Long userId) {
        return teamRepository.findById(userId).map(teamEntity -> {
            teamRepository.delete(teamEntity);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException(RECORD_DOES_NOT_EXIST_FOR_ID + userId));
    }
}
