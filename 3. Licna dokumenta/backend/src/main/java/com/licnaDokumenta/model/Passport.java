package com.licnaDokumenta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
