package cesar.next.desafio.spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cesar.next.desafio.spring.demo.dto.HouseDTO;
import cesar.next.desafio.spring.demo.dto.HouseUpdateDTO;
import cesar.next.desafio.spring.demo.entities.Client;
import cesar.next.desafio.spring.demo.entities.House;
import cesar.next.desafio.spring.demo.repositories.ClientRepository;
import cesar.next.desafio.spring.demo.repositories.HouseRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HouseService {
    
    private final HouseRepository houseRepository;
    private final ClientRepository clientRepository;

    public House create(HouseDTO houseDTO) {
        Client client = this.clientRepository.findById(houseDTO.getClient_id()).orElse(null);
        if (client != null){
            House house = houseDTO.toEntity(client);
            return this.houseRepository.save(house);
        }
        return null;
    }

    public List<House> listAll(Optional<String> zipcode) {
        if (!zipcode.isPresent()){
            return houseRepository.findAll();
        } else {
            return houseRepository.findByZipcode(zipcode.get());
        }
    }

    public House getById(long id) {
        return this.houseRepository.findById(id).orElse(null);
    }

    public House update(long id, @Valid HouseUpdateDTO houseUpdateDTO) {
        House house = this.houseRepository.findById(id).orElse(null);
        Client client = this.clientRepository.findById(houseUpdateDTO.getClient_id()).orElse(null);
        if (client != null && house != null){
            house.setClient(client);
            house = houseUpdateDTO.toEntity(house, client);
            return this.houseRepository.save(house);
        }
        return null;
    }

    public boolean delete(long id) {
        House house = this.houseRepository.findById(id).orElse(null);
        if (house != null){
            this.houseRepository.delete(house);
            return true;
        }
        return false;
    }
}