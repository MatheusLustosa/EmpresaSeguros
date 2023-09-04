package cesar.next.desafio.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import cesar.next.desafio.spring.demo.dto.InsuranceDTO;
import cesar.next.desafio.spring.demo.dto.InsuranceHouseDTO;
import cesar.next.desafio.spring.demo.dto.InsuranceVehicleDTO;
import cesar.next.desafio.spring.demo.entities.Insurance;
import cesar.next.desafio.spring.demo.services.InsuranceService;

@RestController
@RequestMapping("/insurances")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/auto")
    public ResponseEntity<Insurance> createInsuranVehicle(@RequestBody InsuranceVehicleDTO insuranceVehicleDTO) {
        Insurance insurance = insuranceService.createInsuranVehicle(insuranceVehicleDTO);
        if (insurance != null) {
            return new ResponseEntity<Insurance>(insurance, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/home")
    public ResponseEntity<Insurance> createInsuranHouse(@RequestBody InsuranceHouseDTO insuranceHouseDTO) {
        Insurance insurance = insuranceService.createInsuranHouse(insuranceHouseDTO);
        if (insurance != null) {
            return new ResponseEntity<Insurance>(insurance, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/disability")
    public ResponseEntity<Insurance> createInsuranDisability(@RequestBody InsuranceDTO insuranceDTO) {
        Insurance insurance = insuranceService.createInsuranDisability(insuranceDTO);
        if (insurance != null) {
            return new ResponseEntity<Insurance>(insurance, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/life")
    public ResponseEntity<Insurance> createInsuranLife(@RequestBody InsuranceDTO insuranceDTO) {
        Insurance insurance = insuranceService.createInsuranLife(insuranceDTO);
        if (insurance != null) {
            return new ResponseEntity<Insurance>(insurance, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}