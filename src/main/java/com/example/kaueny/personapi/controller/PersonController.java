package com.example.kaueny.personapi.controller;

import com.example.kaueny.personapi.dto.request.PersonDTO;
import com.example.kaueny.personapi.service.PersonService;
import com.example.kaueny.personapi.dto.response.MessageResponseDTO;
import com.example.kaueny.personapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO){
    return personService.createPerson(personDTO);
  }

  @GetMapping
  public List<PersonDTO> listAll(){
    return personService.listAll();
  }
}
