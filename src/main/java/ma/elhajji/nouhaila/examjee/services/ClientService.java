package ma.elhajji.nouhaila.examjee.services;


import ma.elhajji.nouhaila.examjee.dto.ClientDTO;
import ma.elhajji.nouhaila.examjee.entities.Client;
import ma.elhajji.nouhaila.examjee.mappers.EntityMapperImpl;
import ma.elhajji.nouhaila.examjee.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final EntityMapperImpl mapper;

    public ClientService(ClientRepository clientRepository, EntityMapperImpl mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'id : " + id));
        return mapper.fromClient(client);
    }

    public ClientDTO saveClient(ClientDTO dto) {
        Client client = mapper.fromClientDTO(dto);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
