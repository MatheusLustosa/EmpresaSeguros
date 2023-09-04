package cesar.next.desafio.spring.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cesar.next.desafio.spring.demo.dto.ClientDTO;
import cesar.next.desafio.spring.demo.entities.Client;
import cesar.next.desafio.spring.demo.repositories.ClientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {
    
    private final ClientRepository clientRepository;

    public Client create(ClientDTO clientDTO) {
        Client client = clientDTO.toEntity();
        client.setCreatedAt(LocalDate.now());
        client.setUpdatedAt(LocalDate.now());
        return this.clientRepository.save(client);
    }

    public List<Client> listAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .collect(Collectors.toList());
    }

    public Client getById(long id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    public Client update(long id, @Valid ClientDTO clientDTO) {
        Client client = this.clientRepository.findById(id).orElse(null);
        if (client != null){
            Client updateClient = clientDTO.toEntityUpdate(client);
            return this.clientRepository.save(updateClient);
        }
        return null;
    }

    public boolean delete(long id) {
        Client client = this.clientRepository.findById(id).orElse(null);
        if (client != null){
            this.clientRepository.delete(client);
            return true;
        }
        return false;
    }

    
}