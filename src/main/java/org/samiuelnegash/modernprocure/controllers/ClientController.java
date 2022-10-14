package org.samiuelnegash.modernprocure.controllers;


import org.samiuelnegash.modernprocure.models.ClientModel;
import org.samiuelnegash.modernprocure.services.ClientService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/client")
@RestController
@RequiredArgsConstructor
public class ClientController {
    @NonNull
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<ClientModel> createClient(@RequestBody ClientModel clientmodel) {
        ClientModel client = clientService.addClient(clientmodel);
        return (new ResponseEntity<>(client, HttpStatus.CREATED));
    }

    @GetMapping("/get")
    public ResponseEntity<Page<ClientModel>> getAllResults(Pageable pageable) {
        return new ResponseEntity<>(clientService.getAllClients(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "getclient/{id}")
    public ResponseEntity<ClientModel> getUserById(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return null;
        }
        ClientModel clientmodel = this.clientService.getClientWithId(id);
        return new ResponseEntity<>(clientmodel, HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public ClientModel updateClient(@RequestBody ClientModel clientmodel, @PathVariable(value = "id") Long id) {
        ClientModel updatedclient = this.clientService.updateClient(clientmodel, id);
        return ResponseEntity.ok(updatedclient).getBody();
    }

    @DeleteMapping("delete/{id}")
    public ClientModel updateClient(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return null;
        }
        ClientModel updatedclient = this.clientService.deleteClient(id);
        return ResponseEntity.ok(updatedclient).getBody();
    }
}
