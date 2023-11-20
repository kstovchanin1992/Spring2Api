package com.example.spring2api.service;



import com.example.spring2api.dto.PersonDto;
import com.example.spring2api.entity.Person;
import com.example.spring2api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(PersonDto personDTO) {
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setMiddleName(personDTO.getMiddleName());
        person.setPassportNumber(personDTO.getPassportNumber());
        person.setPassportSeries(personDTO.getPassportSeries());

        personRepository.save(person);
    }

    @Override
    public List<Person> getPersons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personRepository.findAll(pageable).getContent();
    }


}

