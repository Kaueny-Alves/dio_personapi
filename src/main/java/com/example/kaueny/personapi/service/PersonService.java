package com.example.kaueny.personapi.service;

import com.example.kaueny.personapi.dto.request.PersonDTO;
import com.example.kaueny.personapi.dto.response.MessageResponseDTO;
import com.example.kaueny.personapi.entity.Person;
import com.example.kaueny.personapi.mapper.PersonMapper;
import com.example.kaueny.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private PersonRepository personRepository;
  private final PersonMapper personMapper = PersonMapper.INSTANCE;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public MessageResponseDTO createPerson(PersonDTO personDTO){
    Person personToSave = personMapper.toModel(personDTO);

    Person savedPerson = personRepository.save(personToSave);

    return MessageResponseDTO
        .builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
  }
}
