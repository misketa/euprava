package com.licnaDokumenta.controller;

import com.licnaDokumenta.dto.PassportDTO;
import com.licnaDokumenta.dto.UpdatePassportDto;
import com.licnaDokumenta.model.Passport;
import com.licnaDokumenta.repository.PassportRepository;
import com.licnaDokumenta.service.PassportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @Autowired
    private PassportRepository passportRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Passport> findOne(@PathVariable Long id) {
        Passport passport =  passportService.findOne(id);

        return new ResponseEntity<>(passport, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Passport> save(@RequestBody Passport passport) {
        passportService.save(passport);
        return new ResponseEntity<>(passport, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Passport> update(@PathVariable("id") Long id,
                                                @Valid @RequestBody UpdatePassportDto passportDTO) {
        Passport update = passportService.update(id, passportDTO);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

}
