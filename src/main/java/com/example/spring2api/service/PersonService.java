package com.example.spring2api.service;



import com.example.spring2api.dto.PersonDto;
import com.example.spring2api.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {
    void savePerson(PersonDto personDTO);

    List<Person> getPersons(int page, int size);

}

