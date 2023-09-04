package cesar.next.desafio.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cesar.next.desafio.spring.demo.entities.House;

public interface HouseRepository extends JpaRepository<House, Long>{
    List<House> findByZipcode(String zipcode);
}