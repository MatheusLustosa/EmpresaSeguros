package cesar.next.desafio.spring.demo.services;

import cesar.next.desafio.spring.demo.entities.Client;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cesar.next.desafio.spring.demo.dto.VehicleDTO;
import cesar.next.desafio.spring.demo.dto.VehicleUpdateDTO;
import cesar.next.desafio.spring.demo.entities.Vehicle;
import cesar.next.desafio.spring.demo.repositories.ClientRepository;
import cesar.next.desafio.spring.demo.repositories.VehicleRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleService {
    
    private final VehicleRepository vehicleRepository;
    private final ClientRepository clientRepository;

    public Vehicle create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleDTO.toEntity();
        return this.vehicleRepository.save(vehicle);
    }

    public Vehicle update(long id, @Valid VehicleUpdateDTO vehicleUpdateDTO) {
        Vehicle vehicle = this.vehicleRepository.findById(id).orElse(null);
        Client client = this.clientRepository.findById(vehicleUpdateDTO.getClient_id()).orElse(null);
        if (client != null && vehicle != null){
            vehicle.setClient(client);
            return this.vehicleRepository.save(vehicle);
        }
        return null;
    }

    public boolean delete(long id) {
        Vehicle vehicle = this.vehicleRepository.findById(id).orElse(null);
        if (vehicle != null){
            vehicle.getClient().getVehicles().remove(vehicle);
            vehicle.setClient(null);
            vehicleRepository.save(vehicle);
            this.vehicleRepository.delete(vehicle);
            return true;
        }
        return false;
    }
}