package cesar.next.desafio.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cesar.next.desafio.spring.demo.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
}
