package com.licnaDokumenta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public enum Role {
        SLUZBENIK(0), GRADJANIN(1);

        private int value;
        private static Map map = new HashMap<>();

        private Role(int value) {
            this.value = value;
        }

        static {
            for (Role role : Role.values()) {
                map.put(role.value, role);
            }
        }

        public static Role valueOf(int tip) {
            return (Role) map.get(tip);
        }

        public int getValue() {
            return value;
        }
    }


}