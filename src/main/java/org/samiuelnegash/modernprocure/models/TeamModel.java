package org.samiuelnegash.modernprocure.models;

import org.samiuelnegash.modernprocure.entities.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {
    private Long webId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String role;
    private String userAddress;
    private String email;
    private String userPassword;
    private boolean active;
    private String age;

    public TeamModel(TeamEntity entity) {
        this.webId = entity.getWebId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.role = entity.getRole();
        this.userAddress = entity.getUserAddress();
        this.gender = entity.getGender();
        this.active = entity.isActive();
    }


    public TeamEntity disassemble() {
        var entity = new TeamEntity();
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setEmail(this.email);
        entity.setRole(this.role);
        entity.setGender(this.gender);
        entity.setAge(this.age == null ? "0" : this.age);
        entity.setUserAddress(this.userAddress);
        entity.setActive(this.active);
        return entity;
    }

    public TeamModel assemble(TeamEntity user) {
        return new TeamModel(user);
    }
}
