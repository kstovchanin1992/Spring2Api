package com.example.spring2api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private String passportNumber;
    private String passportSeries;
}
