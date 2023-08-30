package com.licnaDokumenta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class UsersId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jmbg;
    private String name;
    private String lastname;
    private String address;
    private String dateOfBirth;
    private String message;
    private Date datumVazenja;


    public UsersId(String jmbg, String message) {
        this.jmbg = jmbg;
        this.message = message;
    }
}
