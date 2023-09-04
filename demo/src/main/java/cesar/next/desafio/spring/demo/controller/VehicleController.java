package cesar.next.desafio.spring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import cesar.next.desafio.spring.demo.dto.VehicleDTO;
import cesar.next.desafio.spring.demo.dto.VehicleUpdateDTO;
import cesar.next.desafio.spring.demo.entities.Vehicle;
import cesar.next.desafio.spring.demo.services.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {
    
    private final VehicleService vehicleService;

    
    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.create(vehicleDTO);
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/clients")
    public ResponseEntity<Vehicle> update(@PathVariable long id, @RequestBody @Valid VehicleUpdateDTO vehicleUpdateDTO) {
        Vehicle vehicle = vehicleService.update(id, vehicleUpdateDTO);
        if (vehicle != null){
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (vehicleService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}