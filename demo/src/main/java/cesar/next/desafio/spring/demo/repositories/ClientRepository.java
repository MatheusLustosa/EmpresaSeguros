package cesar.next.desafio.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cesar.next.desafio.spring.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
