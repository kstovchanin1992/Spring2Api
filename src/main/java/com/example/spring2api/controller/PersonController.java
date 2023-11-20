package com.example.spring2api.controller;

import com.example.spring2api.dto.PersonDto;
import com.example.spring2api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/save")
    public ResponseEntity<String> savePerson(@RequestBody PersonDto personDto) {
        personService.savePerson(personDto);
        return ResponseEntity.ok("Person saved successfully");
    }

}
