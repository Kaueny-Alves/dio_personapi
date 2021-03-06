package com.example.kaueny.personapi.service;

import com.example.kaueny.personapi.dto.request.PersonDTO;
import com.example.kaueny.personapi.dto.response.MessageResponseDTO;
import com.example.kaueny.personapi.entity.Person;
import com.example.kaueny.personapi.exception.PersonNotFoundException;
import com.example.kaueny.personapi.mapper.PersonMapper;
import com.example.kaueny.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    return createdMetodResponse(savedPerson.getId(), "created person");
  }

  public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    return allPeople.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
   Person person = verifyIdExists(id);
    return personMapper.toDTO(person);
  }

  public void delete(Long id) throws PersonNotFoundException {
    verifyIdExists(id);
    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateByID(Long id, PersonDTO personDTO) throws PersonNotFoundException {
    verifyIdExists(id);
    Person personToUpdate = personMapper.toModel(personDTO);
    Person updatePerson = personRepository.save(personToUpdate);

    return createdMetodResponse(updatePerson.getId(), "update person");
  }

  private Person verifyIdExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
  }

  private MessageResponseDTO createdMetodResponse(Long id, String message) {
    return MessageResponseDTO
        .builder()
        .message(message + id)
        .build();
  }
}
