package ma.elhajji.nouhaila.examjee.web;


import ma.elhajji.nouhaila.examjee.dto.ClientDTO;
import ma.elhajji.nouhaila.examjee.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientRestApi {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @Override
    public ResponseEntity<ClientDTO> getClient(Long id) {
        ClientDTO clientDTO = clientService.getClient(id);
        return ResponseEntity.ok(clientDTO);
    }

    @Override
    public ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO) {
        ClientDTO savedClient = clientService.saveClient(clientDTO);
        return ResponseEntity.ok(savedClient);
    }

    @Override
    public ResponseEntity<ClientDTO> updateClient(Long id, ClientDTO clientDTO) {
        clientDTO.setId(id);
        ClientDTO updatedClient = clientService.saveClient(clientDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
