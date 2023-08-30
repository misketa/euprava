package com.licnaDokumenta.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PassportDTO {

    private String jmbg;
    private String name;
    private String lastname;
    private String gender;
    private String citizenship;
    private String address;
    private String cityOfBirth;
    private LocalDate dateOfBirth;
    private String countryOfBirth;
    private Date datumVazenja;
}
