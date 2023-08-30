package com.licnaDokumenta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UverenjeOKaznjavanjuDTO {

    @NotNull
    @NotBlank
    @Size(min=13, max=13)
    private String jmbg;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String drzavaRodjenja;



    private Date datumRodjenja;
}
