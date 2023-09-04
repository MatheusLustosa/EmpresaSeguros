package cesar.next.desafio.spring.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ownership_status;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String zipcode;
    
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    @JsonBackReference
    //^Ela é usada para resolver problemas de referência circular ao serializar objetos Java em formato JSON
    private Client client;
}