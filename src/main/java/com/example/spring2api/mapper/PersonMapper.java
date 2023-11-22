package com.example.spring2api.mapper;

import com.example.spring2api.dto.PersonDto;
import com.example.spring2api.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDto personDto);
}
