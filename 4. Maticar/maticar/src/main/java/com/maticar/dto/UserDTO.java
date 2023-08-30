package com.maticar.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String identificationNumber;
    private String name;
    private String lastname;
    private String gender;
    private String citizenship;
    private String address;
    private String cityOfBirth;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private String email;
    private String role;
}
