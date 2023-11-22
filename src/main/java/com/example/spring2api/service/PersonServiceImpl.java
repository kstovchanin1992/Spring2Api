package com.example.spring2api.service;

import com.example.spring2api.dto.PersonDto;
import com.example.spring2api.entity.Person;
import com.example.spring2api.mapper.PersonMapper;
import com.example.spring2api.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Transactional
    @Override
    public void savePerson(PersonDto personDTO) {
        Person person = personMapper.toPerson(personDTO);
        personRepository.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personRepository.findAll(pageable).getContent();
    }
}

