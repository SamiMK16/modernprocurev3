package org.samiuelnegash.modernprocure.services;

import org.samiuelnegash.modernprocure.models.ClientModel;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ClientService {
    ClientModel addClient(ClientModel clientmodel);

    Page<ClientModel> getAllClients(Pageable pageable);

    ClientModel getClientWithId(Long clientId);

    ClientModel updateClient(ClientModel clientmodel, Long clientId);

    ClientModel deleteClient(Long clientId);

}
