package ma.elhajji.nouhaila.examjee.web;

import ma.elhajji.nouhaila.examjee.dto.ClientDTO;
import ma.elhajji.nouhaila.examjee.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/clients")  // mapping de base pour tous les endpoints du client
public class ClientController implements ClientRestApi {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.getClient(id);
        return ResponseEntity.ok(clientDTO);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO savedClient = clientService.saveClient(clientDTO);
        return ResponseEntity.ok(savedClient);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        ClientDTO updatedClient = clientService.saveClient(clientDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
