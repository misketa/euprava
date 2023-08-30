package com.licnaDokumenta.dto;

import com.licnaDokumenta.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String name;
    private String lastname;
    private String jmbg;
    private String address;
    private LocalDate dateOfBirth;
    private User.Role role;

    public UserInfo(User user){
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.jmbg = user.getIdentificationNumber();
        this.address = user.getAddress();
        this.dateOfBirth = user.getDateOfBirth();

    }
}
