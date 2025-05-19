package ma.elhajji.nouhaila.examjee.web;


import ma.elhajji.nouhaila.examjee.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clients")
public interface ClientRestApi {

    @GetMapping
    List<ClientDTO> getAllClients();

    @GetMapping("/{id}")
    ResponseEntity<ClientDTO> getClient(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO);

    @PutMapping("/{id}")
    ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id);
}
