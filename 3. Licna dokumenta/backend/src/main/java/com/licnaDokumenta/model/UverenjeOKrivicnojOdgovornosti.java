package com.licnaDokumenta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UverenjeOKrivicnojOdgovornosti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jmbg;

    private String name;


    private String lastName;


    private String drzavaRodjenja;



    private Date datumRodjenja;
}
