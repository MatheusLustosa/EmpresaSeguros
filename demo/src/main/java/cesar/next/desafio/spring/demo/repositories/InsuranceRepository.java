package cesar.next.desafio.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cesar.next.desafio.spring.demo.entities.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    
}
