package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistration(){

        List<RegistrationDto>dtos = registrationService.getRegistration();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRegistration //when returning different types of data use "?" means the return type will be dependent on which return statement runs
            (
            @Valid @RequestBody RegistrationDto registrationDto,
            BindingResult result
    ){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
        }
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);

    }


    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable long id,
            @RequestBody Registration registration
    ){

        Registration updateReg = registrationService.updateRegistration(id,registration);

        return new ResponseEntity<>(updateReg,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationBtId(
            @PathVariable long id
    ){

       RegistrationDto dto =  registrationService.getRegistrationById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
