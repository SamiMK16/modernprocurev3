package org.samiuelnegash.modernprocure.models;

import org.samiuelnegash.modernprocure.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    private Long webId;
    private String clientNumber;
    private String clientName;
    private String description;
    private String address;
    private String email;

    public ClientModel(Client entity) {
        this.webId = entity.getWebId();
        this.clientNumber = entity.getClientNumber();
        this.clientName = entity.getClientName();
        this.description = entity.getDescription();
        this.email = entity.getEmail();
        this.address = entity.getAddress();
    }


    public Client disassemble() {
        var entity = new Client();
        entity.setClientName(this.clientName);
        entity.setClientNumber(this.clientNumber == null ? new UUID(9, 0).toString() : this.clientNumber);
        entity.setDescription(this.description == null ? this.clientName : this.description);
        entity.setEmail(this.email);
        entity.setAddress(this.address);
        entity.setActive(true);
        return entity;
    }

    public ClientModel assemble(Client client) {
        return new ClientModel(client);
    }
}
