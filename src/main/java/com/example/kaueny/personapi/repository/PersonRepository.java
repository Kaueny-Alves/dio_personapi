package com.example.kaueny.personapi.repository;

import com.example.kaueny.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
